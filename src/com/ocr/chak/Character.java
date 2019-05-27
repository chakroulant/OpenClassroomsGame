package com.ocr.chak;

public abstract class Character {
    protected int playerNumber, characterClass, level, life, strengh, agility, intelligence;
    protected static boolean alive;

    public Character(int playerNumber, int characterClass, int level, int life, int strenght, int agility,  int intelligence) {
    }

    public abstract void Attacks(Character victim);

    public abstract void Presentation();

    public void Alive(Character character) {
        if (character.getLife() > 0)
            character.setAlive(true);
        else {
            character.setAlive(false);
            System.out.println("Joueur " + character.getPlayerNumber() + " est mort");
        }
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(int characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrengh() {
        return strengh;
    }

    public void setStrengh(int strengh) {
        this.strengh = strengh;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public static boolean isAlive() {
        return alive;
    }

    public static void setAlive(boolean alive) {
        Character.alive = alive;
    }
}
