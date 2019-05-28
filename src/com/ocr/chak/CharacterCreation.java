package com.ocr.chak;

import java.util.Scanner;

public class CharacterCreation {

    public static int AskSomething(String asking, int numberOfChoices) {
        boolean goodAnswer;
        Scanner sc = new Scanner(System.in);
        int answer;

        do {
            System.out.println(asking);
            answer = sc.nextInt();
            sc.nextLine();
            goodAnswer = (0 <= answer && answer <= numberOfChoices );
            if (!goodAnswer)
                System.out.println("Vous avez choisis un chiffre trop petit ou trop grand");
        }while(!goodAnswer);
        return answer;
    }

    public static Character CharacterCreation(int playerNumber) {
        int characterClass, level, life, strenght, agility, intelligence, nbStatsPointsAvailble;
        boolean goodAnswer;
        Scanner sc = new Scanner(System.in);
        Character character = null;
        String asking;

        System.out.println("Création du personnage du Joueur " + playerNumber);

        characterClass = AskSomething("Veuilliez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", 3);
        System.out.println(characterClass);

        level = AskSomething("Choix du niveau du champion : ", 100); //A verifier si le niv max est à 100
        life = level * 5;

        nbStatsPointsAvailble = level;
        strenght = AskSomething("Choix de la force :", nbStatsPointsAvailble);

        nbStatsPointsAvailble = level - strenght;
        agility = AskSomething("Choix de l'agilité :", nbStatsPointsAvailble);

        nbStatsPointsAvailble = level - strenght - agility;
        intelligence = AskSomething("Choix de l'intelligence :", nbStatsPointsAvailble);

        switch (characterClass) {
            case 1 :
                character = new Warrior(playerNumber, characterClass, level, life, strenght, intelligence, agility);
                break;
            case 2 :
                character = new Rogue(playerNumber, characterClass, level, life, strenght, intelligence, agility);
                break;
            case 3 :
                character = new Mage(playerNumber, characterClass, level, life, strenght, intelligence, agility);
                break;
            default :
                System.out.println("La classe du personnage a mal été choisie !");
                break;
        }
        return character;
    }


}
