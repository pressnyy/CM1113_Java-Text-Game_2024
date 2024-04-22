package Character.NPC;
import Character.Player;

public class NPC_NiceDay extends NPC {
    Player player;

    public NPC_NiceDay(Player player, String name, int occupationID, int level, int x, int y){
        super(player, name, occupationID, level, x, y);
        this.player = player;
    }

    @Override
    public String toString() {
        String input = "Nice day out don't you think?" + "\n" + "(y/n)" + "\n";

        System.out.println(prompt(input));

        char choice = playerInputChar();
        
        String yes = "I know right? Have a good day sir!";

        String no = "Wrong >:(";

        System.out.println(YNResponse(choice, yes, no));

        return yes;
    }

}