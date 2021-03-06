package com.ocr.chak;

public class Mage extends Character {
    protected int heal;

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

    /**
     *This is the description for the Mage attacks and their effects.
     * @param victim the character object receiving the attack
     */

    public void Attacks(Character victim) {
        super.Attacks(victim);
        switch (action) {
            case 1 :
                attackName = "Boule de feu";
                damage = intelligence;

                victim.setLife(victim.getLife() - damage);
                System.out.println("Le Joueur " + playerNumber + " utilise " + attackName + " et inflige " + damage + " de dommages.");
                System.out.println("Le Joueur " + victim.getPlayerNumber() + " perd " + damage + " points de vie");
                victim.Alive();
                break;
            case 2 :
                attackName = "Soin";
                heal = intelligence * 2;
                boolean toohigh = ((heal + life ) > (level * 5) );

                if (!toohigh) {
                    this.life += heal;
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
        System.out.println("Abracadabra Joueur " + playerNumber + " niveau " + level + " je possède " + life + " de vitalité " + strenght + " de force " + agility + " d'aglité  " + intelligence + " d'intelligence !");
    }


}