package com.ocr.chak;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CharacterCreation {

    /**
     *Ask a number and catch exception
     * @param asking sentence to be displayed
     * @param numberOfChoices setting the number of possibility
     * @return
     */

    public static int AskNumber(String asking, int numberOfChoices, boolean zeroAllowed) {
        boolean goodAnswer = false;
        Scanner scann = new Scanner(System.in);
        int answer;

        do {
            answer = 0; // initialisation nécessaire pour les messages d'erreur de saisie.
            boolean isNumber = true;
            System.out.println(asking);
            try {
                answer = scann.nextInt();
                goodAnswer = (0 <= answer && answer <= numberOfChoices);
            } catch (InputMismatchException e) {
                scann.nextLine();
                goodAnswer = false;
                isNumber = false;
                System.out.println("Vous n'avez même pas saisi un chiffre !");
            }
            if (numberOfChoices < answer || answer < 0) {
                System.out.println("Vous avez saisi un chiffre trop petit ou trop grand ");
                goodAnswer = false;
            }else if (!zeroAllowed && answer == 0 ) {
                if (isNumber) // Condition nécessaire pour éviter un cumul d'erreur de message du à l'initialisation et le catch d'exception
                    System.out.println("Vous ne pouvez pas choisir de valeur nulle !");
                goodAnswer = false;
            } else
                goodAnswer = true;
        }while(!goodAnswer);
        return answer;
    }

    /**
     *Asking and setting all the different stats then creating the object Character with all the settings.
     * @param playerNumber set the player order
     * @return the object Character
     */

    public static Character CharacterCreation(int playerNumber) {
        int characterClass, level, life, strenght, agility, intelligence, nbStatsPointsAvailble;
        Character character = null;

        System.out.println("Création du personnage du Joueur " + playerNumber);

        characterClass = AskNumber("Veuilliez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", 3, false);

        level = AskNumber("Choix du niveau du champion : ", 100, false); //A verifier si le niv max est à 100
        life = level * 5;

        do {
            nbStatsPointsAvailble = level;
            strenght = AskNumber("Choix de la force :", nbStatsPointsAvailble, true);

            nbStatsPointsAvailble -= strenght;
            agility = AskNumber("Choix de l'agilité :", nbStatsPointsAvailble, true);

            nbStatsPointsAvailble -= agility;
            intelligence = AskNumber("Choix de l'intelligence :", nbStatsPointsAvailble, (nbStatsPointsAvailble == 0));

            if (intelligence != nbStatsPointsAvailble)
                System.out.println("La somme de vos statistiques doit correspondre à votre niveau, veuillez recommencer ");
        }while(intelligence != nbStatsPointsAvailble);

        switch (characterClass) {
            case 1 :
                character = new Warrior(playerNumber, characterClass, level, life, strenght, agility, intelligence);
                break;
            case 2 :
                character = new Rogue(playerNumber, characterClass, level, life, strenght, agility, intelligence);
                break;
            case 3 :
                character = new Mage(playerNumber, characterClass, level, life, strenght, agility, intelligence);
                break;
            default :
                System.out.println("La classe du personnage a mal été choisie !");
                break;
        }
        return character;
    }
}