
package EntitySystem;

import java.util.ArrayList;
import org.newdawn.slick.util.Log;

public class Entity {

    private ArrayList<EntityComponent> Components;
    
    public Entity(EntityComponent...component){
        Components = new ArrayList();
        if(component.length>0){
            for(EntityComponent comp : component){
                Components.add(comp);
            }
        }
    }
    
    public ArrayList<EntityComponent> getComponents(){
        return this.Components;
    }
    public void setComponents(ArrayList<EntityComponent> components){
        this.Components = components;
    }

    
    public <T extends EntityComponent> T getComponent(Class<? extends EntityComponent> classType){
        if(this.hasComponents(classType)){
            for(EntityComponent comp : this.Components){
                if(comp.getClass() == classType){
                    return (T)comp;
                }
            }
        }
        Log.error("Attempted to get non-existant component: "+classType);
        return null;
    }
    
    public void addComponents(EntityComponent...component){
        for(EntityComponent comp : component){
            this.Components.add(comp);
        }
    }
    
    public void removeComponents(Class<? extends EntityComponent>...component){
        for(Class<? extends EntityComponent> comp : component){
            for(EntityComponent c : Components){
                if(comp == c.getClass()){
                    Components.remove(c);
                }
            }
        }
    }
    
    public void replaceComponent(EntityComponent...component){
        for(EntityComponent comp : component){
            for(EntityComponent c : Components){
                if(comp.getClass() == c.getClass()){
                    Components.remove(c);
                    Components.add(comp);
                }
            }
        }
    }
    
    public boolean hasComponents(Class<? extends EntityComponent>...classType){
        int tobefound = classType.length;
        int found = 0;
        for(EntityComponent component : this.Components){
            for(Class<? extends EntityComponent> compclass : classType){
                if(component.getClass() == compclass){
                    found++;
                }
            }
        }
        if(found == tobefound){
            return true;
        }
        return false;
    }    
    
    
}
