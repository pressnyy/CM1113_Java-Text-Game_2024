package Character.NPC;
import Character.Player;
import Character.Item;
import java.util.ArrayList;

public class NPC_ShopKeep extends NPC {
    Player player;

    // Create a shop ArrayList
    ArrayList<Item> shopList = new ArrayList<Item>();

    public NPC_ShopKeep(Player player, String name, int occupationID, int level, int x, int y){
        super(player, name, occupationID, level, x, y);
        this.player = player;
        createShop();
    }

    public void addToShop(String id) {
        shopList.add(new Item(id));
    }

    public void buyItem(int pos) {
        player.addItem(shopList.get(pos).getItemID());
        shopList.remove(pos);
    }

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

    public String getShopList() {
        String output = "";
        output += "(enter any other value to close shop)" + "\n";
        for (int i = 0; i < shopList.size(); i++) {
            output += "[" + i + "] ";
            output += shopList.get(i).getItemName();
            if (i != (shopList.size() - 1)) {
                output += "\n";
            }
        }
        return output;
    }

    public void buying() {
        boolean shopping = true;
        while (shopping == true) {
            prompt(getShopList());
            int input = playerInputInt();
            if (input >= shopList.size() || input < 0) {
                shopping = false;
            }
            if (input >= 0 && input < shopList.size()) {
                buyItem(input);
                if (shopList.size() == 0) {
                    shopping = false;
                }
            }
            // This is to add an extra space
            // A bad but quick solution
            prompt("");
        }
    }

    public void shopping() {
        prompt("\nGreetings kind sir! Is there anything you fancy from my store?" + "\n");
        buying();
        prompt("Thank you for shopping!");
        prompt("You now have: ");
        prompt(player.getItems());
    }
}
