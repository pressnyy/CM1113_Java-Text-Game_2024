/**
 *
 * @author Alex Zuiev
 */

package Character.Enemy;

import Character.Character;
import Character.Player;

public abstract class Enemy extends Character {

    // Done
    private String message;
    Player player;

    // Done
    public Enemy (Player player, String name, int occupationID, int level, int x, int y, String message) {
        super(name, occupationID, level, x, y);
        this.player = player;
        this.message = message;
    }

    // Done
    public String getMessage() {
        return message;
    }

    // Done
    public void setMessage(String message) {
        this.message = message;
    }

    // Done
    @Override
    public String toString() {
        String output = "";
        output += "Message:" + getMessage();
        return output;
    }
    
}
