
package EntitySystem;

import FactorySystem.UserFactory;
import org.newdawn.slick.SlickException;

public class User extends Entity{

    private static volatile Entity user = null;
    
    private User() throws SlickException{
        user = new UserFactory(100, 100).createEntity();
    }
    
    public static Entity getUser() throws SlickException{
        if(user == null){
            user = new UserFactory(100, 100).createEntity();
        }
        return user;
    }
    
}
