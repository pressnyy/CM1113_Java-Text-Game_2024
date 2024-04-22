package Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Authors Notes:
// I am dreading documenting this
// I should have done it the moment I finished it

// I NEED TO MARK DOWN IN THE SPREADSHEET WHAT HAS
// BEEN DONE HERE AND ALSO MARK ALL OF IT DOWN HERE

public class Item {

    // Item Properties
    String itemID;
    String itemName;
    int itemType;

    Boolean canWear;
    Boolean canAttack;
    Boolean canShield;
    Boolean canConsume;

    // Weapon Stats
    double critChance;
    int physicalDamage;
    int magicDamage;
    int iceDamage;
    int fireDamage;
    int poisonDamage;

    // Defense Stats
    int physicalResist;
    int magicResist;
    int iceResist;
    int fireResist;
    int poisonResist;

    // Consumable Stats
    int healthRegen;
    boolean healthRegenOverTime;
    int staminaRegen;
    boolean staminaRegenOverTime;
    int magicRegen;
    boolean magicRegenOverTime;

    // The amount of gold the item is worth
    int value;

    // Done
    // Runs when class Item is created
    // Takes the itemID and imports the item with that ID
    public Item(String itemID) {
        this.itemID = itemID;
        importItem();
    }

    // Done
    // Imports an item using an ID given and sets all of the properties required
    public void importItem() {
        // Error catching for if the file fails to import
        try {
            // Import the file
            File itemCSV = new File("items.csv");
            // Create a scanner
            Scanner csvReader = new Scanner(itemCSV);
            // Iterate through all lines of the file
            while (csvReader.hasNextLine()) {
                // Take the data from the line
                String data = csvReader.nextLine();
                // Split data for up to 10 commas deep
                // No items have enough properties to go past that
                // Therefore this shouldn't be an issue for now
                String[] split = data.split(",",10);
                // Get the itemType of the current item
                int scanType = Integer.parseInt(split[2]);

                // The check:
                // itemID.contentEquals(split[0]))
                // Makes sure to only start checking for the type
                // after finding out it's the correct item
                if (itemID.contentEquals(split[0])) {

                    // WEAPON       = 0
                    // ARMOUR       = 1
                    // SHIELD       = 2
                    // CONSUMABLE   = 3
                    // GOLD         = 4

                    // Sets properties only if it's of the corresponding type
                    // WEAPON
                    if (scanType == 0) {
                        itemName = split[1];
                        itemType = Integer.parseInt(split[2]);
                        canWear = false;
                        canAttack = true;
                        canShield = false;
                        canConsume = false;
                        critChance = Double.parseDouble(split[3]);
                        physicalDamage = Integer.parseInt(split[4]);
                        magicDamage = Integer.parseInt(split[5]);
                        iceDamage = Integer.parseInt(split[6]);
                        fireDamage = Integer.parseInt(split[7]);
                        poisonDamage = Integer.parseInt(split[8]);
                        value = Integer.parseInt(split[9]);
                    }
                    // ARMOUR
                    else if (scanType == 1) {
                        itemName = split[1];
                        itemType = Integer.parseInt(split[2]);
                        canWear = true;
                        canAttack = false;
                        canShield = false;
                        canConsume = false;
                        physicalResist = Integer.parseInt(split[3]);
                        magicResist = Integer.parseInt(split[4]);
                        iceResist = Integer.parseInt(split[5]);
                        fireResist = Integer.parseInt(split[6]);
                        poisonResist = Integer.parseInt(split[7]);
                        value = Integer.parseInt(split[8]);
                    }
                    // SHIELD
                    else if (scanType == 2) {
                        itemName = split[1];
                        itemType = Integer.parseInt(split[2]);
                        canWear = false;
                        canAttack = false;
                        canShield = true;
                        canConsume = false;
                        physicalResist = Integer.parseInt(split[3]);
                        magicResist = Integer.parseInt(split[4]);
                        iceResist = Integer.parseInt(split[5]);
                        fireResist = Integer.parseInt(split[6]);
                        poisonResist = Integer.parseInt(split[7]);
                        value = Integer.parseInt(split[8]);
                    }
                    // CONSUMABLE
                    else if (scanType == 3) {
                        itemName = split[1];
                        itemType = Integer.parseInt(split[2]);
                        canWear = false;
                        canAttack = false;
                        canShield = false;
                        canConsume = true;
                        healthRegen = Integer.parseInt(split[3]);
                        healthRegenOverTime = Boolean.parseBoolean(split[4]);
                        staminaRegen = Integer.parseInt(split[5]);
                        staminaRegenOverTime = Boolean.parseBoolean(split[6]);
                        magicRegen = Integer.parseInt(split[7]);
                        magicRegenOverTime = Boolean.parseBoolean(split[8]);
                        value = Integer.parseInt(split[9]);
                    }
                    // GOLD
                    else if (scanType == 4) {
                        itemName = split[1];
                        itemType = Integer.parseInt(split[2]);
                        canWear = false;
                        canAttack = false;
                        canShield = false;
                        canConsume = false;
                        value = Integer.parseInt(split[3]);
                    }
                    else {
                        System.out.println("ITEM SKIPPED");
                    }
                }
            }
            // Close the Scanner
            // Good practice
            csvReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ITEM IMPORT ERROR");
        }
    }

    // Done
    public String getItemID() {
        return itemID;
    }

    // Done
    public String getItemName() {
        return itemName;
    }

    // Done
    public int getItemType() {
        return itemType;
    }

    // Done
    // Gets the item name with some slight formatting changes
    // I should have just used getItemName but I was running
    // short on time and made some mistakes
    @Override
    public String toString() {
        String output = "";
        //output += getItemID() + " ";
        output += getItemName() + " ";
        output += "\n";
        return output;
    }
}
