
package RPG;

import Interface.Option;
import Managers.ResourceManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ForestScene extends BattleScene{
    
    public ForestScene(int id) throws SlickException{
        stateID=id;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        //System.out.println("FOREST SCENE INIT");
        background = ResourceManager.getInstance().forestSceneBackground;
        super.abstractInit(gc, sbg);
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs){
        super.abstractRender(gc, sbg, grphcs);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        super.abstractUpdate(gc, sbg, delta);
    }

    @Override
    public void enter(GameContainer gc, StateBasedGame sbg){
        //System.out.println("FOREST SCENE ENTERED");
    }
    
}
