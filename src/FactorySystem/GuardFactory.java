
package FactorySystem;

import EntitySystem.Entity;
import EntitySystem.*;
import Managers.ResourceManager;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class GuardFactory implements EntityFactory{

    private float xpos;
    private float ypos;
    private Animation sprite, up, down, left, right;
    private SpriteSheet spritesheet;
    
    public GuardFactory(float x, float y) throws SlickException{
        xpos=x;
        ypos=y;
        spritesheet = ResourceManager.getInstance().guardSheet;
        int duration = 150;
        up=new Animation(spritesheet, 0, 1, 2, 1, true, duration, false);
        down=new Animation(spritesheet, 0, 0, 2, 0, true, duration, false);
        left=new Animation(spritesheet, 0, 2, 2, 2, true, duration, false);
        right=new Animation(spritesheet, 0, 3, 2, 3, true, duration, false);
        sprite=down;
    }
    
    @Override
    public Entity createEntity() {
        Entity guard = new Entity(new PhysicalComponent(new Rectangle( getXpos(), getYpos(), getSprite().getWidth(), getSprite().getHeight())), 
                                new StatsComponent(),
                                new VisibleComponent(getSpritesheet(), getSprite(), getUp(), getDown(), getLeft(), getRight()), 
                                new EnemyComponent(100),
                                new AbilityComponent());
        guard.addComponents(new PartyComponent(guard));
        return guard;
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

    public SpriteSheet getSpritesheet() {
        return spritesheet;
    }

    public void setSpritesheet(SpriteSheet spritesheet) {
        this.spritesheet = spritesheet;
    }

}
