
package EntitySystem;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class VisibleComponent extends EntityComponent{

    private SpriteSheet spritesheet;
    private Animation sprite,up,down,left,right;
    
 
    public VisibleComponent(SpriteSheet spritesheet, Animation sprite, Animation up, Animation down, Animation left, Animation right){
        this.spritesheet=spritesheet;
        this.sprite=sprite;
        this.up=up;
        this.down=down;
        this.left=left;
        this.right=right;
    }
    public VisibleComponent(Animation icon){
        sprite=icon;
    }
    public VisibleComponent(){
        
    }

    public SpriteSheet getSpritesheet() {
        return spritesheet;
    }

    public void setSpritesheet(SpriteSheet spritesheet) {
        this.spritesheet = spritesheet;
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

}
