
package EntitySystem;

public class ItemComponent extends InteractableComponent{

    public ItemComponent(Entity e){
        setEntity(e);
    }
    
    @Override
    public void Interact(Entity source) {
       System.out.println("IM AN ITEM HERE ARE MY STATS");
       if(source.hasComponents(ItemBearerComponent.class)){
           ItemBearerComponent inventory = source.getComponent(ItemBearerComponent.class);
           if(getEntity().hasComponents(ItemComponent.class)){
            inventory.Aquire(getEntity());
           }
       }
    }

}
