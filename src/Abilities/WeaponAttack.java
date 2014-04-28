
package Abilities;

import EntitySystem.Entity;
import org.newdawn.slick.Animation;

public class WeaponAttack extends Ability{

    public WeaponAttack(Animation anim){
        animation=anim;
        friendly=false;
        name="WeaponAttack";
    }
    
    @Override
    public void animate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void affect(Entity target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
