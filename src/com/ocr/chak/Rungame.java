package com.ocr.chak;

public class Rungame {

    /**
     * Creating the two Characters by the method from the CharacterCreation
     */

    public Rungame() {

        Character player1 = CharacterCreation.CharacterCreation(1);// CharacterCreation is static for easier code, because it is static i don't need to instantiate the class CharacterCreation
        player1.Presentation();

        Character player2 = CharacterCreation.CharacterCreation(2);
        player2.Presentation();

        new Fight(player1, player2);

    }
}
