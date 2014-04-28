
package FactorySystem;

import EntitySystem.Entity;
import EntitySystem.ExitComponent;
import EntitySystem.PhysicalComponent;
import org.newdawn.slick.geom.Rectangle;

public class ExitFactory implements EntityFactory{

    private Rectangle boundingbox;
    private int targetID;
    
    public ExitFactory(Rectangle rect, int id){
        this.boundingbox=rect;
        this.targetID=id;
        
    }
    
    @Override
    public Entity createEntity() {
        Entity exit = new Entity(new PhysicalComponent(boundingbox), new ExitComponent(targetID));
        return exit;
    }

}
