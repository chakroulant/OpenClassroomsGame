package com.ocr.chak;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Character {
    protected int playerNumber, characterClass, level, life, strenght, agility, intelligence;
    protected static boolean alive;
    protected int action, damage;
    String attackName;
    Scanner scann = new Scanner(System.in);
    protected boolean goodAnswer;
    protected String presentation = "Joueur " + playerNumber + " niveau " + level + " je possède " + life + " de vitalité " + strenght + " de force " + agility + " d'aglité  " + intelligence + " d'intelligence !";

    public Character(int playerNumber, int characterClass, int level, int life, int strenght, int agility,  int intelligence) {
    }

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

    public static boolean isAlive() {
        return alive;
    }

    public static void setAlive(boolean alive) {
        Character.alive = alive;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }
}