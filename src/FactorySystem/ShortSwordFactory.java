
package FactorySystem;

import EntitySystem.Entity;
import EntitySystem.ItemComponent;
import EntitySystem.PhysicalComponent;
import EntitySystem.VisibleComponent;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class ShortSwordFactory extends ItemFactory{

    private String name = "Shortsword";
    private Image icon;
    
    public ShortSwordFactory(float x, float y) throws SlickException{
        super(x,y);
        icon = getItemsheet().getSubImage(0, 5);
    }
    
    @Override
    public Entity createEntity() {
        Image[] image = {icon};
        int[] duration = {150};
        Entity shortsword = new Entity(new PhysicalComponent(new Rectangle(getXpos(), getYpos(),icon.getWidth(), icon.getHeight())), 
                new VisibleComponent(new Animation(image,duration)));
        shortsword.addComponents(new ItemComponent(shortsword));
        return shortsword;
        
    }

}
