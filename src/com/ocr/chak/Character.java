package com.ocr.chak;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Character {
    protected int playerNumber, characterClass, level, life, strenght, agility, intelligence;
    protected boolean alive ;
    protected int action, damage;
    String attackName;
    Scanner scann = new Scanner(System.in);
    protected boolean goodAnswer;

    public Character(int playerNumber, int characterClass, int level, int life, int strenght, int agility,  int intelligence) {
    }

    /**
     * Partie commune de l'attaque de tous les champions, soit la prise du type d'attaque.
     */

    public void Attacks(Character victim){

        do {
            try {
                System.out.println("Joueur " + playerNumber + " (" + life + " Vitalité) veuillez choisir votre action (1 : Attaque basique, 2 : Attaque Spéciale)");
                action = scann.nextInt();
                scann.nextLine();
                goodAnswer = (action == 1 || action == 2);
            } catch (InputMismatchException e) {
                goodAnswer = false;
            }
        }while(!goodAnswer);
    }

    public abstract void Presentation();

    /**
     * Permet simplement de definir si le champion est encore en vie.
     */

    public void Alive() {
        if (life > 0)
            alive = (true);
        else {
            alive = (false);
            System.out.println("Joueur " + playerNumber + " est mort");
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

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strengh) {
        this.strenght = strengh;
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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }


}