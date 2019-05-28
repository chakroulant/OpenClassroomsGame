package com.ocr.chak;

public class Mage extends Character {

    public Mage(int playerNumber, int characterClass, int level, int life, int strenght, int agility, int intelligence) {
        super(playerNumber, characterClass, level, life, strenght, agility, intelligence);
        this.playerNumber = playerNumber;
        this.characterClass = characterClass;
        this.level = level;
        this.life = life;
        this.strenght = strenght;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    @Override
    public void Attacks(Character victim) {
        switch (action) {
            case 1 :
                attackName = "Boule de feu";
                damage = intelligence;
                victim.setLife(victim.getLife() - damage);
                System.out.println("Le Joueur " + playerNumber + " utilise " + attackName + " et inflige " + damage + " de dommages.");
                System.out.println("Le Joueur " + victim.getPlayerNumber() + " perd " + damage + " points de vie");
                Alive(victim);
                break;
            case 2 :
                attackName = "Soin";
                int heal = intelligence * 2;
                boolean toohigh = ((heal + life ) > (level * 5) );
                if (!toohigh) {
                    life += heal;
                    System.out.println("Le Joueur " + playerNumber + " utilise " + attackName + " et gagne " + heal + " en vitalité.");
                }else{
                    heal = (level * 5) - life;
                    System.out.println("Le Joueur " + playerNumber + " utilise " + attackName + " et gagne " + heal + " en vitalité.");
                    life = level*5;
                }
                break;
            default :
                System.out.println("Vous n'avez pas choisi parmis les 2 attaques proposées ");
                break;
        }
    }

    @Override
    public void Presentation() {

    }

    @Override
    public void Alive(Character character) {

    }
}
