package World;
import java.util.ArrayList;
import Character.Player;

public class World {
    ArrayList<Object> locationList = new ArrayList<Object>();
    Player player;
    boolean dragonHasSpoken = false;

    public World(Player player) {
        // Locations made from the world class
        // can be static because they won't be
        // changing their position. This will
        // Make it easier for us to quickly
        // add new locations without spending
        // a ton of time making it dynamic.
        this.player = player;
        locationList.add(new Dungeon(player, 16,16,30,30));
        locationList.add(new Village(player, 0,0,15,15));
    }

    public void runChecks() {
        searchAllLocations();

        int distanceFromDragon = ((Dungeon) locationList.get(0)).dragonDistance();


        if (distanceFromDragon == 5 && distanceFromDragon == 4) {
            System.out.println("You are nearing the dragon");
        }
        else if (distanceFromDragon == 3 && distanceFromDragon == 2) {
            System.out.println("It is very close");
        }
        else if (distanceFromDragon == 1) {
            System.out.println("You can see the dragon");
        }
        else if (distanceFromDragon == 0) {
            ((Dungeon) locationList.get(0)).killDragon();
            System.out.println("You have slain the dragon");
        }
    }

    public void searchAllLocations() {
        boolean isInVillage = false;
        boolean isInDungeon = false;
        boolean noWhere = false;
        for (Object locationObject : locationList){

            Location location = (Location) locationObject;

            if (location instanceof Village && location.inLocation(player.getX(), player.getY())){
                isInVillage = true;

            } else if(location instanceof Dungeon && location.inLocation(player.getX(), player.getY())){
                isInDungeon =true;

            } else{
                noWhere = true;
            }

        }

        if (isInDungeon){
            System.out.println("You are in a dungeon");
            if (dragonHasSpoken == false) {
                ((Dungeon) locationList.get(0)).dragonText();
                dragonHasSpoken = true;
            }

        } else if(isInVillage){
            System.out.println("You are in a village");
            
        } else if (noWhere){
            System.out.println("You are lost");
        }
    }
}
