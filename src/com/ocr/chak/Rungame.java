package com.ocr.chak;

public class Rungame {
    public Rungame() {

        Character player1 = CharacterCreation.CharacterCreation(1);
        player1.Presentation();
        Character player2 = CharacterCreation.CharacterCreation(2);
        player2.Presentation();
        System.out.println(player1.getCharacterClass() + player2.getCharacterClass());
        new Fight(player1, player2);

    }
}
