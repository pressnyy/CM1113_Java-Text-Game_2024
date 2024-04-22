package World;
import Character.Item;
import java.util.ArrayList;

// None of this has been tested yet
// I'm pretty sure it isn't even finished

public class Chest {

    int x;
    int y;

    public Chest(int x, int y) {
        this.x = x;
        this.y = y;
    }

    ArrayList<Item> item = new ArrayList<Item>();

    public void addItem(String id) {
        item.add(new Item(id));
    }
/* 
    public void createChest() {
        addItem("basic_sword");
        addItem("poop");
        addItem("healing_potion");
        addItem("skibidi_helmet");
        addItem("super_coin");
    }
*/
    public String getItems() {
        String output = "";
        for (int i = 0; i < item.size(); i++) {
            output += "\n" + "Item " + (i + 1) + " - " + item.get(i).getItemID() + "\n";
            output += item.get(i).toString();
        }
        return output;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
