
package EntitySystem;

import java.util.ArrayList;

public class ItemWearerComponent extends EntityComponent{

    private ArrayList<Entity> equipped;
    
    public ItemWearerComponent(){
        
    }
    public ItemWearerComponent(ArrayList<Entity> eq){
        equipped=eq;
    }

    public ArrayList<Entity> getEquipped() {
        return equipped;
    }

    public void setEquipped(ArrayList<Entity> equipped) {
        this.equipped = equipped;
    }
    
    public void equip(Entity item){
        
    }
}
