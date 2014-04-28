
package EntitySystem;

public class NPCComponent extends InteractableComponent{

    public void NPCComponent(Entity e){
        setEntity(e);
    }
    
    @Override
    public void Interact(Entity source) {
        System.out.println("HI IM AN NPC");
    }

}
