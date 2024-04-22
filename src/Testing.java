import Character.Player;
import World.World;
import java.util.Scanner;
import Character.NPC.NPC_ShopKeep;

/*
 * 1. ALEX ZUIEV (2319670)
 * 2. BRENDAN SCOTT (2309224)
 * 3. JOAO NETO SAMPAIO (2311553)
 * 4. MYKYTA KAKARANZA (2326297)
 * During our work we created several superclasses , subclasses and  classes which interact with each other and can be used later on for developing a full rpg based game with such features like fighting different enemies like goblins and dragons, creating  your own build as a knight or an archer , travel through the Village and interact with npc’s or go to a dungeon to find chests with loot and face different dangerous enemies. The testing was performed through implementing features of superclasses into other classes or subclasses or extending them with additional coding.
 * 
 */

public class Testing {
    public static void main(String[] args) {
        Player player = new Player("Tomithy",0,37, 15, 15);
        World world = new World(player);
        NPC_ShopKeep npc_ShopKeep = new NPC_ShopKeep(player, "Bobby",0,1, 0, 0);
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        // We ran out of time before we could finalise everything
        // To counter this issue, we created a few independent tests
        // to show each system working independently
        System.out.println("Choose which test to run: ");
        String output = "";
        output += "[1]: " + "Movement Test" + "\n";
        output += "[2]: " + "Inventory Test" + "\n";
        output += "[3]: " + "Location Test" + "\n";
        output += "[4]: " + "Item Info Test" + "\n";
        output += "[5]: " + "Player Info Test" + "\n";
        output += "[6]: " + "Player Input Test" + "\n";
        output += "[7]: " + "Player Info Control Test" + "\n";
        output += "[8]: " + "Shop Keeper Test" + "\n";
        output += "[9]: " + "Random Function" + "\n";
        System.out.println(output);
        int input = 0;
        try {
            input = sc.nextInt();
        }
        catch (Exception e) {
            System.out.println("");
        }
        
        if (input == 1) {
            player.move(world);
        }
        if (input == 2) {
            player.addItem("basic_sword");
            player.addItem("skibidi_helmet");

            System.out.println(player.getItems());
        }
        if (input == 3) {
            player.addItem("basic_sword");
            player.addItem("skibidi_helmet");

            world.searchAllLocations();
        }
        if (input == 4) {
            System.out.println(player.getItemInfo("basic_sword"));
        }
        if (input == 5) {
            player.addItem("basic_sword");
            player.addItem("poop");

            System.out.println(player.toString());
        }
        if (input == 6) {
            player.inputName();

            player.inputOccupation();

            System.out.println(player.toString());
        }
        if (input == 7) {
            System.out.println("The controls are only in the code currently");
            boolean showName = true;
            boolean showOccupation = true;
            boolean showLevel = false;
            boolean showStats = false;
            boolean showStatDelta = false;
            boolean showCoordinates = true;
            boolean showGold = true;
            // This one doesn't work
            boolean showItems = true;

            player.addItem("basic_sword");
            player.addItem("basic_sword");
            player.addItem("basic_sword");
            player.addItem("poop");
            player.addItem("super_coin");

            player.infoToggle(showStats, showName, showOccupation, showCoordinates, showLevel, showGold, showStatDelta, showItems);

            System.out.println(player.toString());
        }
        if (input == 8) {
            npc_ShopKeep.shopping();
        }
        if (input == 9) {
            int random = 0;
            try {
                System.out.println("Please input a maximum: ");
                random = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("Invalid Input");
            }
            System.out.println(player.getRandom(random));
        }
        else {
            System.out.println("Not an option");
        }
    
    }
}
