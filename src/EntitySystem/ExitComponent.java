
package EntitySystem;

public class ExitComponent extends EntityComponent{

    /*The ID of the state that the exit leads to*/
    private int targetID;
    
    public ExitComponent(int id){
        targetID=id;
    }

    public int getTargetID() {
        return targetID;
    }

    public void setTargetID(int targetID) {
        this.targetID = targetID;
    }
    
}
