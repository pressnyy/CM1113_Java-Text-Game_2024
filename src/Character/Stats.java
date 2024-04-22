package Character;
public class Stats {
    int xp = 0;
    int xpToLevel;
    int level;
    int startingStat = 10;
    int maxHealth = startingStat;
    int currentHealth = startingStat;
    int strength = startingStat;
    int dexterity = startingStat;
    int intelligence = startingStat;
    int charisma = startingStat;
    int occupationID;
    Occupation occupation;

    // Done
    public Stats(int level, int occupationID) {
        this.level = level;
        this.xpToLevel = findXpForLevel(level);
        this.occupationID = occupationID;
        occupation = new Occupation(occupationID);
        autoXp();

        updateStats();
    }

    // Done
    public void updateOccupation() {
        occupation = new Occupation(occupationID);
        updateStats();
    }

    // Untested, unfinished
    public void levelUp() {
        if (xp == findXpForLevel(level)) {
            level += 1;
        }
        xpToLevel = findXpForLevel(level);
    }

    // Done
    public int findXpForLevel(int inputLevel) {
        return (int) (Math.pow(inputLevel * 4, 1.8));
    }

    // Done
    public void changeXp(int addXp) {
        xp += addXp;
    }

    // Done
    public int getCharisma() {
        return charisma;
    }

    // Done
    public int getDexterity() {
        return dexterity;
    }

    // Done
    public int getIntelligence() {
        return intelligence;
    }

    // Done
    public int getStrength() {
        return strength;
    }

    // Done
    public int getXp() {
        return xp;
    }

    // Done
    public void updateStats() {
        maxHealth = (int) (Math.pow(level + 
                                startingStat,
                                occupation.hpMult));
        currentHealth = (int) (Math.pow(level + 
                                startingStat,
                                occupation.hpMult));
        strength = (int) (Math.pow(level + 
                                startingStat,
                                occupation.strMult));
        dexterity = (int) (Math.pow(level + 
                                startingStat,
                                occupation.dexMult));
        intelligence = (int) (Math.pow(level + 
                                startingStat,
                                occupation.intMult));
        charisma = (int) (Math.pow(level + 
                                startingStat,
                                occupation.chrMult));
    }

    // Done
    public int getLevel() {
        return level;
    }

    // Done
    public String getOccupation() {
        return occupation.getOccupationName();
    }

    // Done
    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public String toString() {
        String output = "";
        output += "Health: " + getMaxHealth() + "/" + getCurrentHealth() + "\n";
        output += "Strength: " + getStrength() + "\n";
        output += "Intelligence: " + getIntelligence() + "\n";
        output += "Dexterity: " + getDexterity() + "\n";
        output += "Charisma: " + getCharisma() + "\n";
        return output;
    }

    public void autoXp() {
        int minXp = findXpForLevel(level - 1);
        if (xp < minXp) {
            xp = minXp;
        }
    }

    public int getXpToLevel() {
        return xpToLevel;
    }
}
