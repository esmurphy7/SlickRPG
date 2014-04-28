
package RPG.Items;

import org.newdawn.slick.SlickException;

public class MainHand extends MyItem{

    private int damage;
    private int str, intel, dex, hp, mp;
    
    public MainHand() throws SlickException{
        super();
    }
    
    
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getStr() {
        return str;
    }
    public void setStr(int str) {
        this.str = str;
    }
    public int getIntel() {
        return intel;
    }
    public void setIntel(int intel) {
        this.intel = intel;
    }
    public int getDex() {
        return dex;
    }
    public void setDex(int dex) {
        this.dex = dex;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getMp() {
        return mp;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }
    
}
