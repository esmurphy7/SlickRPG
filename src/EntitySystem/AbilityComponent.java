
package EntitySystem;

import Abilities.Ability;
import java.util.ArrayList;

public class AbilityComponent extends EntityComponent{

    private ArrayList<Ability> abilities;
    
    public AbilityComponent(Ability...abils){
        abilities = new ArrayList();
        for(Ability ability : abils){
            abilities.add(ability);
        }
    }


    public ArrayList<Ability> getAbilities() {
        return abilities;
    }
    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }
    
}
