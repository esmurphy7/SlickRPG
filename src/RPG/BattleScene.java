
package RPG;

import EntitySystem.Entity;
import EntitySystem.User;
import Interface.TargetOverlay;
import Managers.BattleManager;
import Managers.ResourceManager;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public abstract class BattleScene extends RPGState{
    /*The static landscape image for the battle, drawn to top half of container*/
    Image background;
    
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
        scaleBackgrounds(gc);
        
        currentPanel = ResourceManager.getInstance().actionPanel;
        
    }

    @Override
    public void abstractUpdate(GameContainer gc, StateBasedGame sbg, int i){
        /* Update BattleManager */
        BattleManager.getInstance().update();
        /* Update interface components */
        currentPanel.update();
        updatePanelInput();

    }
    private void updatePanelInput(){
        if(input.isKeyPressed(SELECT) || input.isKeyPressed(ENTER)){
            currentPanel = currentPanel.selectCurrentOption();
        }else if(input.isKeyPressed(BACK) || input.isKeyPressed(ESCAPE)){
            /* If the currentPanel isn't the actionPanel (root panel) then go to parent.
               Otherwise, do nothing and carry on*/
            if(currentPanel != ResourceManager.getInstance().actionPanel){
                currentPanel = currentPanel.getParent();
            }
        }else if(input.isKeyPressed(UP)){
            currentPanel.MoveUp();
        }else if(input.isKeyPressed(DOWN)){
            currentPanel.MoveDown();
        }else if(input.isKeyPressed(LEFT)){
            currentPanel.MoveLeft();
        }else if(input.isKeyPressed(RIGHT)){
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
