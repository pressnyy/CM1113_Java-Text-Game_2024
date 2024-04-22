package Character.NPC;
// Default Java stuff to import
import java.util.Scanner;
// Importing other classes
import Character.Character;
import Character.Player;

public class NPC extends Character {
    Scanner sc = new Scanner(System.in);
    Player player;

    public NPC(Player player, String name, int occupationID, int level, int x, int y){
        super(name, occupationID, level, x, y);
    }

    public void prompt(String input) {
        System.out.println(input);
    }

    public String playerInputString() {
        String choice;
        choice = sc.nextLine();
        
        return choice;
    }

    public char playerInputChar() {
        char choice;
        choice = sc.next().charAt(0);
        boolean inputChar = true;

        while (inputChar == true) {
            if (choice != 'y' && choice != 'n') {
                invalidInput();
                prompt("so is it, or not?");
            }
            else {
                inputChar = false;
            }
        }

        return choice;
    }

    public void invalidInput() {
        System.out.println("...what?");
    }

    public int playerInputInt() {
        int choice = 0;
        try {
            choice = sc.nextInt();
        } catch (Exception e) {
            invalidInput();
            choice = -1;
        }

        return choice;
    }

    public String YNResponse(char choice, String yes, String no) {
        String output = "";
        if (choice == 'y') {
            output += yes;
        }
        else if (choice == 'n'){
            output += no;
        }
        return output;
    }

}

