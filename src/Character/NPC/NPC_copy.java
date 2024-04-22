package Character.NPC;
// Default Java stuff to import
import java.util.Scanner;
import java.util.ArrayList;
// Importing other classes
import Character.Character;
import Character.Item;
import Character.Player;

public class NPC_copy extends Character {
    Scanner sc = new Scanner(System.in);
    Player player;

    // Create a shop ArrayList
    ArrayList<Item> shopList = new ArrayList<Item>();

    public NPC(Player player,String name, int occupationID, int level, int x, int y) {
        super(name, occupationID, level, x, y);
        this.player = player;
        createShop();
    }

    // Allows items to be added to the shop
    public void addToShop(String id) {
        shopList.add(new Item(id));
    }

    public boolean removeFromShop(int position) {
    // Removes an item from shop
        try {
            shopList.remove(position);
            return true;
        }

        catch(Exception e) {
            System.out.println("You have left the shop :3");
            return false;
        }
    }

    // Adds a bunch of items to the shop on NPC creation
    // (Only an example - should be changed or moved into specific NPC classes)
    public void createShop() {
        addToShop("basic_sword");
        addToShop("poop");

        // I need to add a function to sort out item quantities
        //
        // Currently you can have only 1 of an item in a slot
        // but you have an infinite number of slots
        addToShop("healing_potion");
        addToShop("healing_potion");
        addToShop("healing_potion");
    }

    @Override
    public String toString() {
        String output = super.toString();
        return output;
    }

    public String getNpcNiceDay() {
        // Create an empty String
        String output = "";
        // Add to the output
        output += "Nice day out don't you think?" + "\n" + "(y/n)" + "\n"; {
        }
        return output;
    }

    public String inputInteraction() {

        char choice;
        String output = "";
        System.out.println(getNpcNiceDay());
        choice = sc.next().charAt(0);

        if (choice == 'y') {
            output += "I know right? Have a good day sir!";
        }
        else if (choice == 'n'){
            output += "Wrong >:(";
        }
        return output;
    }
    

    public String getShopText() {
        // Create an empty String
        String output = "";
        // Add to the output
        output += "Greetings kind sir! Is there anything you fancy from my store?" + "\n" + "(enter any other value to close shop)" + "\n";
        // Iterate through the shop inventory
        for (int i = 0; i < shopList.size(); i++) {
            // Add every item name to the list
            output += "[" + i + "] ";
            output += shopList.get(i).getItemName() + "\n";
        }

        return output;
    }

    public void inputShop() {
        // player to do player.addItem();
        boolean shopping = true;
        int item;
        while (shopping == true) {
            System.out.println(getShopText());
            try {
                item = sc.nextInt();
            }
            catch (Exception e) {
                break;
            }
            player.addItem(shopList.get(item).getItemID());
            shopping = removeFromShop(item);
        }
        System.out.println(player.getItems());
    }
}