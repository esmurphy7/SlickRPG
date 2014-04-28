/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Evan Murphy
 */
public class TestUser{
    
    private int duration = 150;
    private Animation sprite, up, down, left, right;
    private float xpos = 32f, ypos = 32f;
    private SpriteSheet testsheet; 
    
    
    public TestUser() throws SlickException{
        testsheet = new SpriteSheet("C:/Users/Evan Murphy/Dropbox/Slick2DTest/data/testsheet.png", 32, 32, Color.black );
        up = new Animation(testsheet, 0, 0, 0, 0, true, duration, false);
        down = new Animation(testsheet, 0, 0, 0, 0, true, duration, false);
        left = new Animation(testsheet, 0, 0, 0, 0, true, duration, false);
        right = new Animation(testsheet, 0, 0, 0, 0, true, duration, false);
    }

public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public Animation getSprite() {
        return sprite;
    }
    public void setSprite(Animation sprite) {
        this.sprite = sprite;
    }
    public Animation getUp() {
        return up;
    }
    public void setUp(Animation up) {
        this.up = up;
    }
    public Animation getDown() {
        return down;
    }
    public void setDown(Animation down) {
        this.down = down;
    }
    public Animation getLeft() {
        return left;
    }
    public void setLeft(Animation left) {
        this.left = left;
    }
    public Animation getRight() {
        return right;
    }
    public void setRight(Animation right) {
        this.right = right;
    }
    public float getXpos() {
        return xpos;
    }
    public void setXpos(float xpos) {
        this.xpos = xpos;
    }
    public float getYpos() {
        return ypos;
    }
    public void setYpos(float ypos) {
        this.ypos = ypos;
    }

}
