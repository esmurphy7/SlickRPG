
package FactorySystem;

import EntitySystem.Entity;
import EntitySystem.PhysicalComponent;
import org.newdawn.slick.geom.Rectangle;

public class TerrainFactory implements EntityFactory{

    private Rectangle boundingbox;
    
    public TerrainFactory(Rectangle rect){
        boundingbox=rect;
    }
    
    @Override
    public Entity createEntity() {
        Entity terrain = new Entity(new PhysicalComponent(boundingbox));
        return terrain;
    }

}
