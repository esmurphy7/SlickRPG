
package FactorySystem;

import EntitySystem.Entity;
import EntitySystem.PhysicalComponent;
import FactorySystem.EntityFactory;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class ItemFactory implements EntityFactory{

    private SpriteSheet itemsheet;
    private float xpos, ypos;
    
    public ItemFactory(float x, float y) throws SlickException{
       itemsheet = new SpriteSheet(new Image("data/images/item_sheet.png"), 32, 32, 2, 3);
       xpos=x;
       ypos=y;
       
    }
    
    @Override
    public Entity createEntity() {
        Entity entity = new Entity(new PhysicalComponent(new Rectangle(xpos,ypos,0,0)));
        return entity;
    }

    public SpriteSheet getItemsheet() {
        return itemsheet;
    }

    public void setItemsheet(SpriteSheet itemsheet) {
        this.itemsheet = itemsheet;
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
