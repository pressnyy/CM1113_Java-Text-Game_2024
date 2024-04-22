package Character;
public class Occupation {
    int occupationID;
    String occupationName = "null";

    int health = 0;
    int strength = 0;
    int dexterity = 0;
    int intelligence = 0;
    int charisma = 0;

    double hpMult;
    double strMult;
    double dexMult;
    double intMult;
    double chrMult;

    // Done
    public Occupation(int occupationID) {
        this.occupationID = occupationID;
        statChange();
    }

    // Done
    // Checks the occupationID and
    // assigns the relevant stats
    public void statChange() {
        if (occupationID == 0) {
            occupationName = "Knight";
            health = 2;
            strength = 6;
            dexterity = 2;
            intelligence = -5;
            charisma = -5;
        }
        else if (occupationID == 1) {
            occupationName = "Archer";
            health = -4;
            strength = -2;
            dexterity = 6;
            intelligence = 2;
            charisma = -2;
        }

        // Couldn't come up with a nicer way to do this
        // Maybe an array?
        // Calculates the stat multiplier for each stat
        hpMult = calculateMultiplier(health);
        strMult = calculateMultiplier(strength);
        dexMult = calculateMultiplier(dexterity);
        intMult = calculateMultiplier(intelligence);
        chrMult = calculateMultiplier(charisma);
    }

    // Done
    // The formula for the multiplier
    // It was written like this to prevent the numbers
    // from going too high, but still enough to make
    // a noticable difference to each stat
    public double calculateMultiplier(int change) {
        return 1.005 + ((double) change / 100);
    }

    // Done
    public double getHpMult() {
        return hpMult;
    }

    // Done
    public double getStrMult() {
        return strMult;
    }

    // Done
    public double getIntMult() {
        return intMult;
    }

    // Done
    public double getDexMult() {
        return dexMult;
    }

    // Done
    public double getChrMult() {
        return chrMult;
    }

    // Done
    // Calculates the total change in the stats
    // If the output is 0, it is balanced
    // Any other value means the occupation needs rebalancing
    public int delta() {
        int delta = 0;
        delta += health;
        delta += strength;
        delta += intelligence;
        delta += dexterity;
        delta += charisma;
        return delta;
    }

    // Done
    public String getOccupationName() {
        return occupationName;
    }
}
