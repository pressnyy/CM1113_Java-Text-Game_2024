package Character;
import java.util.ArrayList;

public abstract class Character {
    ArrayList<Item> items;
    int x;
    int y;
    Stats stats;
    String name;
    int occupationID;
    int xp;
    int level;
    int gold;

    // Default to showing all information
    // It was done like this so the values
    // didn't need set every test file
    boolean showStats = true;
    boolean showName = true;
    boolean showOccupation = true;
    boolean showCoordinates = true;
    boolean showLevel = true;
    boolean showGold = true;
    boolean showStatDelta = true;
    boolean showItems = true;

    // Done
    public Character(String name, int occupationID, int level, int x, int y) {
        this.name = name;
        this.occupationID = occupationID;
        this.x = x;
        this.y = y;
        this.level = level;
        items = new ArrayList<Item>();
        
        stats = new Stats(level, occupationID);
    }

    // Done
    // The input for this one looks ugly
    // It was the most convenient way to keep adding without having it scroll endlessly
    public void infoToggle(boolean showStats,
                            boolean showName,boolean showOccupation,
                            boolean showCoordinates,boolean showLevel,
                            boolean showGold, boolean showStatDelta,
                            boolean showItems) {
        this.showStats = showStats;
        this.showName = showName;
        this.showOccupation = showOccupation;
        this.showCoordinates = showCoordinates;
        this.showLevel = showLevel;
        this.showGold = showGold;
        this.showStatDelta = showStatDelta;
    }

    // Done
    @Override
    public String toString() {
        // Creates an empty space 
        String output = "\n";
        // Writing "\n" was getting annoying so I'm using newLine instead
        String newLine = "\n";
        // Checks if the information is to be showed
        if (showName == true) {
            output += "Name: " + name + newLine;
            output += newLine;
        }
        if (showLevel == true) {
            output += "Level: " + stats.getLevel() + newLine;
            output += "Xp: " + stats.getXp() + newLine;
            output += "Xp to level: " + stats.getXpToLevel() + newLine;
            output += newLine;
        }
        if (showOccupation == true) {
            output += "Occupation: " + stats.getOccupation() + newLine;
            output += newLine;
        }
        if (showStats == true) {
            output += stats.toString();
            if (showStatDelta == true) {
                output += "Stat Delta: " + stats.occupation.delta() + newLine;
            }
            output += newLine;
        }
        if (showGold == true) {
            output += "Gold: " + gold + newLine;
            output += newLine;
        }
        if (showCoordinates == true) {
            output += "x: " + x + newLine;
            output += "y: " + y + newLine;
            output += newLine;
        }
        if (showItems == true) {
            output += getItems() + newLine;
        }
        
        return output;
    }

    // Done
    public String getItems() {
        // Create an empty String
        String output = "";
        // Iterates through every item
        for (int i = 0; i < items.size(); i++) {
            // Prints an output like:
            //
            // Item - ItemID
            // Item Info
            ////////////////////////
            output += "\n" + "Item " + (i + 1) + " - " + items.get(i).getItemID() + "\n";
            output += items.get(i).toString();
        }
        // This will return an empty output if it can't get any item information
        return output;
    }

    // Done
    public void addItem(String id) {
        // Creates a new item
        items.add(new Item(id));
        // Checks if it is gold
        // There's definitely a better way to do this
        addGold();
    }

    // Done
    public void removeItem(int position) {
        // Removes an item at position
        items.remove(position);
    }

    // Done
    public void addGold() {
        // Iterates through every item
        for (int i = 0; i < items.size(); i++) {
            // Checks if it's itemType 4 (A coin)
            if ((items.get(i).getItemType() == 4)) {
                // Adds gold to the players fancy variable wallet
                gold += items.get(i).value;
                // Removes the coin
                removeItem(i);
            }
        }
    }

    // Done
    // This was supposed to be in the Item class
    // I accidentally put it here instead
    public String getItemInfo(String id) {
        // This will create a string "output" with all the information about the item
        // It takes the type and then produces the information from there
        // If a value is 0, skip it
        Item item = new Item(id);
        String output = "";
        String newline = "\n";

        // Item properties
        output += "Item Name: " + item.itemName + newline;
        output += "Item Type: " + "Weapon" + newline;
        output += newline;
        output += "Can be worn: " + item.canWear + newline;
        output += "Can attack: " + item.canAttack + newline;
        output += "Can shield: " + item.canShield + newline;
        output += "Can consume: " + item.canConsume + newline;
        output += newline;
        // Item Value
        output += "Item Value: " + item.value + newline;
        output += newline;
        
        if (item.canAttack == true) {
            // Damage values
            output += "Crit Chance: " + item.critChance + "%" + newline;
            output += "Physical Damage: " + item.physicalDamage + newline;
            output += "Magic Damage: " + item.magicDamage + newline;
            output += "Ice Damage: " + item.iceDamage + newline;
            output += "Fire Damage: " + item.fireDamage + newline;
            output += "Poison Damage: " + item.poisonDamage + newline;
            output += newline;
            
        } 
        // ARMOUR & Shield
        else if (item.canWear == true || item.canShield == true) {
            // Defense values
            output += "Crit Chance: " + item.physicalResist + "%" + newline;
            output += "Physical Damage: " + item.magicResist + newline;
            output += "Magic Damage: " + item.iceResist + newline;
            output += "Ice Damage: " + item.fireResist + newline;
            output += "Fire Damage: " + item.fireDamage + newline;
            output += "Poison Damage: " + item.poisonResist + newline;
            output += newline;
        }
        
        else if (item.canConsume == true) {
            // Regeneration Values
            output += "Health Regen: " + item.healthRegen + newline;
            output += "Stamina Regen: " + item.staminaRegen + newline;
            output += "Magic Regen: " + item.magicRegen + newline;

            // Regeneration Properties
            output += "Health Over Time: " + item.healthRegenOverTime + newline;
            output += "Stamina Over Time: " + item.staminaRegenOverTime + newline;
            output += "Magic Over Time: " + item.magicRegenOverTime + newline;
            output += newline;
        }
        
        else {
            output += "Item has no extra properties" + newline;
        }

        return output;
    }

    // Done
    public int getRandom(int randomMax) {
        // Uses the random method we had done in the labs
        return (int) ((Math.random()*randomMax) + 1);
    }

    // Done
    public void changeCoords(int x, int y) {
        // Sets coordinates
        this.x = x;
        this.y = y;
    }

    // Done
    public int getX() {
        return x;
    }
    
    // Done
    public int getY() {
        return y;
    }
}