
package RPG;

import EntitySystem.Entity;
import EntitySystem.User;
import Interface.ActionPanelFactory;
import Interface.Panel;
import Interface.TestPanelFactory;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public abstract class BattleScene extends RPGState{
    /*The static landscape image for the battle, drawn to top half of container*/
    Image background;
    /*The entity that is currently taking its turn*/
    Entity currentEntity;
    //TrueTypeFont battleSceneFont;
    
    @Override
    public abstract void init(GameContainer gc, StateBasedGame sbg) throws SlickException;
    @Override
    public abstract void update(GameContainer gc, StateBasedGame sbg, int i);
    @Override
    public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs);
    
    
    @Override
    public void abstractInit(GameContainer gc, StateBasedGame sbg) throws SlickException{
        
        
        game=sbg;
        input=gc.getInput();
        localEntities=new ArrayList();
        this.user=User.getUser();
        scaleBackgrounds(gc);
        
        currentPanel = new ActionPanelFactory().createPanel(gc);
        //testPanel = new TestPanelFactory().createPanel(gc);
    }
    
    @Override
    public void abstractUpdate(GameContainer gc, StateBasedGame sbg, int i){
        currentPanel.update();
        
        if(input.isKeyPressed(Input.KEY_X)){
            currentPanel = currentPanel.Select();
        }else if(input.isKeyPressed(Input.KEY_Z)){
            
        }else if(input.isKeyPressed(Input.KEY_UP)){
            currentPanel.MoveUp();
        }else if(input.isKeyPressed(Input.KEY_DOWN)){
            currentPanel.MoveDown();
        }else if(input.isKeyPressed(Input.KEY_LEFT)){
            currentPanel.MoveLeft();
        }else if(input.isKeyPressed(Input.KEY_RIGHT)){
            currentPanel.MoveRight();
        }
    }
    
    @Override
    public void abstractRender(GameContainer gc, StateBasedGame sbg, Graphics grphcs){
        background.draw(0, 0);
        currentPanel.render(0,0);
        //testPanel.render(0,0);
    }
    
    @Override
    public void enter(GameContainer gc, StateBasedGame sbg){
        //gc.setDefaultFont(battleSceneFont);
    }
    
    /*Scales the background and UIbackground images*/
    public void scaleBackgrounds(GameContainer gc){
        background = background.getScaledCopy(gc.getWidth(), gc.getHeight()/2);
    }
}
