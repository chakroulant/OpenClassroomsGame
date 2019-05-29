package com.ocr.chak;

public class Rogue extends Character {

    public Rogue(int playerNumber, int characterClass, int level, int life, int strenght, int agility, int intelligence) {
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
            case 1 :
                attackName = "Tir à l'Arc";
                damage = agility;

                victim.setLife(victim.getLife() - damage);
                System.out.println("Le Joueur " + playerNumber + " utilise " + attackName + " et inflige " + damage + " de dommages.");
                System.out.println("Le Joueur " + victim.getPlayerNumber() + " perd " + damage + " points de vie");
                Alive(victim);
                break;
            case 2 :
                attackName = "Concentration";
                damage = level;
                agility += damage;

                System.out.println("Le Joueur " + playerNumber + " utilise " + attackName + " et gagne " + damage + " d'agilité.");
                break;
            default :
                System.out.println("Vous n'avez pas choisi parmis les 2 attaques proposées ");
                break;

        }
    }

    @Override
    public void Presentation() {
        System.out.println("Houhou Joueur " + playerNumber + " niveau " + level + " je possède " + life + " de vitalité " + strenght + " de force " + agility + " d'aglité  " + intelligence + " d'intelligence !");
    }


}