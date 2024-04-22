package Character;
import java.util.Scanner;
import World.World;

public class Player extends Character {
    Scanner sc = new Scanner(System.in);

    // Done
    public Player(String name, int occupationID, int level, int x, int y) {
        super(name, occupationID, level, x, y);
    }

    // Done
    @Override
    public String toString() {
        String output = super.toString();
        return output;
    }
    
    // Done
    public void inputName() {
        System.out.println("Enter name please");

        String userName = sc.nextLine();
        super.name = userName;
    }

    // Done
    public void inputOccupation() {
        
        System.out.println("Choose Occupation: \n[0] Knight\n[1] Archer");

        int changeOccupation = sc.nextInt();
        stats.occupationID = changeOccupation;
        stats.updateOccupation();
    }

    public void playerInput(char inputChar) {
        // change the player position
        switch (inputChar) {
            // UP
            case 'w':
                // if a move upwards is in bounds, move up
                // else output that the move is not possible.
                if (y < 30) {
                    y++;
                } else {
                    System.out.println("The road is closed, you can't move further!!");
                }
                break;

            case 's':
                // if a move down is in bounds, move down
                // else output that the move is not possible.
                if (y >= 1) {
                    y--;
                } else {
                    System.out.println("The road is closed, you can't move further!!");
                }
                break;

            case 'a':
                // if a move left is in bounds, move left
                // else output that the move is not possible.
                if (x >= 1) {
                    x--;
                } else {
                    System.out.println("The road is closed, you can't move further!!");
                }
                break;

            case 'd':
                // if a move right is in bounds, move right
                // else output that the move is not possible.
                if (x < 30) {
                    x++;
                } else {
                    System.out.println("The road is closed, you can't move further!!");
                }
                break;

            default:
                System.out.println("Not a valid direction! ");
        }
    }

    public void move(World world) {
        boolean running = true;
        while (running) {
            // get input from user
            System.out.println("Input a direction using w,a,s,d \n");
            char inputChar = sc.next().toLowerCase().charAt(0);
            
            playerInput(inputChar);

            // give feedback to the player
            System.out.println("New position is (" + x + ", " + y + ")");

            world.runChecks();
        }
    }
}