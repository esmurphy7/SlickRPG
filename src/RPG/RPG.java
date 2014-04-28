
package RPG;

import EntitySystem.Entity;
import java.io.IOException;
import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ClasspathLocation;
import org.newdawn.slick.util.FileSystemLocation;
import org.newdawn.slick.util.ResourceLoader;


public class RPG extends StateBasedGame{
  
    private static final String TITLE = "RPG";
    private static final int SCREEN_SIZE = 750;
    
    private static final int FOREST_SCENE = 9;
    private static final int LEVEL010 = 010;
    private static final int LEVEL110 = 110;
    
    public ArrayList<Entity> globalEntities = new ArrayList();
        
    public RPG() throws SlickException, IOException{
        super(TITLE);
        addState(new Level010(LEVEL010, FOREST_SCENE));
        addState(new Level110(LEVEL110, FOREST_SCENE));
        addState(new ForestScene(FOREST_SCENE));
    }

    public static void main(String[] args) throws IOException{
        
        try{
            AppGameContainer app = new AppGameContainer(new RPG());
            app.setDisplayMode(SCREEN_SIZE, SCREEN_SIZE, false);
            app.start();
        }catch (SlickException e){
            e.printStackTrace();
        }
    }

   @Override
    public void initStatesList(GameContainer gc) throws SlickException {
       getState(LEVEL010).init(gc, this);
       getState(LEVEL110).init(gc, this);
       enterState(LEVEL010);
    }
 
}
