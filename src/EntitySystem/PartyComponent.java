
package EntitySystem;

import java.util.ArrayList;

public class PartyComponent extends EntityComponent{

    private ArrayList<Entity> party;
    
    public PartyComponent(Entity...entities){
        party = new ArrayList();
        for(Entity entity : entities){
            party.add(entity);
        }
    }

    public void removeMember(Entity entity){
        for(Entity ent : party){
            if(ent == entity){
                party.remove(ent);
            }
        }
    }
    
    public void addMember(Entity entity){
        for(Entity ent : party){
            if(ent == entity){
                return;
            }
        }
        party.add(entity);
    }
    
    public ArrayList<Entity> getParty() {
        return party;
    }
    public void setParty(ArrayList<Entity> party) {
        this.party = party;
    }
    
}
