
package Abilities;

import EntitySystem.Entity;
import org.newdawn.slick.Animation;

public abstract class Ability {

    String name;
    Animation animation;
    boolean friendly;
    
    public abstract void animate();
    public abstract void affect(Entity target);
    
}
