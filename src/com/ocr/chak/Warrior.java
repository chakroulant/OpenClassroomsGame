package com.ocr.chak;

public class Warrior extends Character {

    public Warrior(int playerNumber, int characterClass, int level, int life, int strenght, int agility, int intelligence) {
        super(playerNumber, characterClass, level, life, strenght, agility, intelligence);
        this.playerNumber = playerNumber;
        this.characterClass = characterClass;
        this.level = level;
        this.life = life;
        this.strenght = strenght;
        this.agility = agility;
        this.intelligence = intelligence;
    }


    public void Attacks(Character victim) {
        super.Attacks(victim);

        switch (action) {

            case 1:
                attackName = "Coup d'épée";
                damage = strenght;

                victim.setLife(victim.getLife() - damage);
                System.out.println("Joueur " + playerNumber + " utilise " + attackName + " et inflige " + damage + " de dommages.");
                System.out.println("Joueur " + victim.getPlayerNumber() + " perd " + damage + " points de vie");
                Alive(victim);
                break;
            case 2:
                attackName = "Coup de rage";
                damage = 2 * strenght;
                victim.setLife(victim.getLife() - damage);
                life = (life - (damage / 4));

                System.out.println("Joueur " + playerNumber + " utilise " + attackName + " et inflige " + damage + " de dommages.");
                System.out.println("Joueur " + victim.getPlayerNumber() + " perd " + damage + " points de vie");
                Alive(victim);
                System.out.println("Joueur " + playerNumber + " perd " + damage / 4 + " points de vie");
                break;
            default:
                System.out.println("Vous n'avez pas choisi parmis les 2 attaques proposées ");
                break;
        }
    }

    @Override
    public void Presentation() {
        System.out.println("Waarg Joueur " + playerNumber + " niveau " + level + " je possède " + life + " de vitalité " + strenght + " de force " + agility + " d'aglité  " + intelligence + " d'intelligence !");
    }

}
