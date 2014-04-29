
package RPG;

import EntitySystem.Entity;
import FactorySystem.GuardFactory;
import FactorySystem.ShortSwordFactory;
import Managers.ResourceManager;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

public class Level110 extends Level{

    public Level110(int id, int battlesceneid){
        stateID=id;
        battlesceneID=battlesceneid;
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        this.map = ResourceManager.getInstance().level110Map;
        user=null;
        super.abstractInit(gc, sbg);
        initCharacters();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        super.abstractUpdate(gc, sbg, delta);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) {
        super.abstractRender(gc, sbg, grphcs);
    }

    @Override
    public void initCharacters() {
        try {
            Entity guard = new GuardFactory(200,100).createEntity();
            Entity shortsword = new ShortSwordFactory(200,160).createEntity();
            
            localEntities.add(guard);
            localEntities.add(shortsword);
        } catch (SlickException ex) {
            Logger.getLogger(Level010.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyPressed(int key, char c){
        if(input.isKeyDown(Input.KEY_B)){
            game.enterState(battlesceneID, new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
        }
    }
    
}
