
package EntitySystem;

import java.util.ArrayList;

public class ItemBearerComponent extends EntityComponent {

    private ArrayList<Entity> inventory;
    
    public ItemBearerComponent(){
        inventory=new ArrayList();
    }
    public ItemBearerComponent(ArrayList<Entity> inv){
        inventory=inv;
    }

    public ArrayList<Entity> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Entity> inventory) {
        this.inventory = inventory;
    }
    
    public void Aquire(Entity item){
        //if inventory not full
        this.inventory.add(item);
        item.removeComponents(VisibleComponent.class, PhysicalComponent.class);
    }
    public boolean ownsA(Class<Entity> theItem){
        return true;
    }
}
