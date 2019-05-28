package com.ocr.chak;


public class Fight {

    public Fight(Character player1, Character player2) {
        do {
            player1.Attacks(player2);
            if (player2.isAlive())
                player2.Attacks(player1);

        }while(player1.isAlive() || player2.isAlive());

        if (!player1.isAlive())
            System.out.println("Joueur 2 a perdu !");
        else
            System.out.println("Joueur 1 a perdu !");
    }
}