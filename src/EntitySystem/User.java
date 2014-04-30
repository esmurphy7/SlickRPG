
package EntitySystem;

import FactorySystem.UserFactory;

public class User extends Entity{

    private static volatile Entity INSTANCE = null;
    
    private User(){
        INSTANCE = new UserFactory(100, 100).createEntity();
    }
    
    public static Entity getInstance() {
        if(INSTANCE == null){
            INSTANCE = new UserFactory(100, 100).createEntity();
        }
        return INSTANCE;
    }
    

    
}
