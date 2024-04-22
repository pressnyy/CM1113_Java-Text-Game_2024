package World;
import Character.Player;
import Character.Enemy.Dragon;
import Character.Enemy.Goblin;
import Character.Enemy.Dark_Lord;

public class Dungeon extends Location {
    Goblin goblin;
    Dragon dragon;
    Dark_Lord dark_lord;
    boolean dragonAlive = true;
    
    public Dungeon(Player player, int x1,int y1,int x2,int y2){

        super(player, x1, y1, x2, y2); 

        //goblin = new Goblin(player, "Tunbar", 0, y1, 25, 25, "You can’t just walk past me, give me everything you’ve got!");
        //System.out.println(goblin.toString());

        dragon = new Dragon(player, "Mefistofel", 0, x1, 26, 26, "How dare such a small commoner enter my territory?! You will not escape here alive...");

        //dark_lord = new Dark_Lord(player, "Dark_Lord", 0, y1, 27, 27, "I knew you’d come to me... you’ll never defeat me, my army has destroyed almost every settlement in this territory, you have nowhere to run. Beg for mercy");
        //System.out.println(dark_lord.toString());
    }

    public int dragonX() {
        return dragon.getX();
    }

    public int dragonY() {
        return dragon.getY();
    }

    public void dragonText() {
        System.out.println(dragon.toString());
    }

    public int dragonDistance() {
        if (dragonAlive == true){
            int distanceToDragon = Math.max(Math.abs(dragonX() - player.getX()), Math.abs(dragonY() - player.getY()));
            return distanceToDragon;
        }
        else {
            return 6;
        }
        
    }

    public void killDragon() {
        dragonAlive = false;
    }
}