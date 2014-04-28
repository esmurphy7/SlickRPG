
package EntitySystem;

public class EnemyComponent extends EntityComponent{

    private float sightrange;
    
    public EnemyComponent(float sr){
        sightrange=sr;
    }

    public float getSightrange() {
        return sightrange;
    }

    public void setSightrange(float sightrange) {
        this.sightrange = sightrange;
    }
    
}
