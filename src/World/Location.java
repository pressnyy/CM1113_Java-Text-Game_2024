package World;
import java.util.ArrayList;
import Character.Player;

public abstract class Location {
    
    Player player;

    int x1 = 0;
    int y1 = 0;
    int x2 = 5;
    int y2 = 5;

    public Location(Player player, int x1,int y1,int x2,int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.player = player;
    }

    public boolean inLocation(int x,int y){
        return player.getX() >= Math.min(x1,x2) && player.getX() <= Math.max(x1,x2) && player.getY() >= Math.min(y1,y2) && player.getY() <= Math.max(y1,y2);
    }

    public void searchAllChests(ArrayList<Chest> chest) {
        for (int i = 0; i < chest.size();i++) {
            nearChest(chest.get(i).getX(), chest.get(i).getY());
        }
    }

    public boolean nearChest(int chestX, int chestY){
        return player.getX() == chestX && player.getY() == chestY;
    }
}
