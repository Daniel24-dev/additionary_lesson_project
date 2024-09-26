package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Ludoman extends Hero {
    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.LUD);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int gamecube1 = RPG_Game.random.nextInt(6) + 1;
        int gamecube2 = RPG_Game.random.nextInt(6) + 1;
        if (gamecube1 == gamecube2) {
            int damageBoss = gamecube1 * gamecube2;
            boss.setHealth(boss.getHealth() - damageBoss);
            System.out.println("LUDOMAN STEAL A BOSS HEALTH ----------" +damageBoss +"POINTS");
            System.out.println("Boss left health with stealed points--------" +boss.getHealth());
        } else {
            Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            if (randomHero.getHealth() > 0){
                int damageHero = gamecube1*gamecube2;
                randomHero.setHealth(randomHero.getHealth()-damageHero);
                System.out.println("LUDOMAN MAKED HIT A HERO--------" +randomHero.getName()+" to "+damageHero +"POINTS");
            }
            
        }
    }
}