
package RPG;

import EntitySystem.*;
import FactorySystem.*;
import Interface.MainMenuPanelFactory;
import Managers.BattleManager;
import Managers.ResourceManager;
import java.awt.Font;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

public abstract class Level extends RPGState{

    TiledMap map;
    int battlesceneID;
    static final int SIZE = 32;
    static final float ZOOM_FACTOR = 1.75f;
    ArrayList<Entity> exits;
    
    
    
    
    @Override
    public abstract void init(GameContainer gc, StateBasedGame sbg) throws SlickException;
    @Override
    public abstract void update(GameContainer gc, StateBasedGame sbg, int i);
    @Override
    public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs);
    
    public abstract void initCharacters();
    
    @Override
    public void abstractInit(GameContainer gc, StateBasedGame sbg) throws SlickException {
        //System.out.println("INIT ABSTRACT LVL");
        currentPanel = null;
        this.game = sbg;
        this.localEntities = new ArrayList();
        this.exits = new ArrayList();
        this.input = gc.getInput();
        initEntities();
        
        
        
    }
    
    @Override
    public void abstractUpdate(GameContainer gc, StateBasedGame sbg, int delta) {
        float fdelta = delta*0.1f;
        
        if(interfaceIsRendering()){
            currentPanel.update();
            updateInterfaceInput(input, delta);

        } else {
            updateLevelInput(input, delta);
            //updateAI();
        }
    }
    
    @Override
    public void abstractRender(GameContainer gc, StateBasedGame sbg, Graphics grphcs) {
        grphcs.scale(ZOOM_FACTOR, ZOOM_FACTOR);
        map.render(0,0);

        for(Entity entity : localEntities){
            checkLOS(entity, grphcs);
            if(entity.hasComponents(VisibleComponent.class) && entity.hasComponents(PhysicalComponent.class)){
                VisibleComponent viscomp = entity.getComponent(VisibleComponent.class);
                PhysicalComponent physcomp = entity.getComponent(PhysicalComponent.class);
                viscomp.getSprite().draw(physcomp.getXpos(), physcomp.getYpos());
            }
            /* Draw rectangles around physical components for testing purposes*/
            /*
            if(entity.hasComponents(PhysicalComponent.class)){
                PhysicalComponent physcomp = entity.getComponent(PhysicalComponent.class);
                float x = physcomp.getBoundingbox().getX();
                float y = physcomp.getBoundingbox().getY();
                float w = physcomp.getBoundingbox().getWidth();
                float h = physcomp.getBoundingbox().getHeight();
                grphcs.drawRect(x, y, w, h);
            }      */          
        }
        
        if(currentPanel != null){
            currentPanel.render(currentPanel.getX(), currentPanel.getHeight());
        }
    }
    
    /* 
     * Handles input to update the level
        Called when no interface is rendering*/
    private void updateLevelInput(Input input, int delta){ 
        for(Entity entity : localEntities){
            if(entity.hasComponents(InputComponent.class)){
                if(entity.hasComponents(VisibleComponent.class) && entity.hasComponents(PhysicalComponent.class)){
                    VisibleComponent viscomp = entity.getComponent(VisibleComponent.class);
                    PhysicalComponent physcomp = entity.getComponent(PhysicalComponent.class);
                    float fdelta = delta*0.1f;
                    
                    if(input.isKeyDown(UP)){
                            viscomp.setSprite(viscomp.getUp());
                            physcomp.getBoundingbox().setY(physcomp.getYpos() - fdelta);
                            if(IntersectsBlockable(entity) || physcomp.getBoundingbox().getY() < 0){
                                physcomp.getBoundingbox().setY(physcomp.getBoundingbox().getY() + fdelta);
                            }else{
                                viscomp.getSprite().update(delta);
                                physcomp.setYpos(physcomp.getYpos() - fdelta);
                            }

                    }else if(input.isKeyDown(DOWN)){
                        viscomp.setSprite(viscomp.getDown());
                        physcomp.getBoundingbox().setY(physcomp.getBoundingbox().getY() + fdelta);
                        if(IntersectsBlockable(entity) || physcomp.getYpos() > map.getHeight()*SIZE-viscomp.getSprite().getHeight()){
                            physcomp.getBoundingbox().setY(physcomp.getBoundingbox().getY() - fdelta);
                        }else{
                            viscomp.getSprite().update(delta);
                            physcomp.setYpos(physcomp.getYpos() + fdelta);
                        }

                    }else if(input.isKeyDown(LEFT)){
                        viscomp.setSprite(viscomp.getLeft());
                        physcomp.getBoundingbox().setX(physcomp.getBoundingbox().getX() - fdelta);
                        if(IntersectsBlockable(entity) || physcomp.getXpos() < 0){
                            physcomp.getBoundingbox().setX(physcomp.getBoundingbox().getX() + fdelta);
                        }else{
                                viscomp.getSprite().update(delta);
                                physcomp.setXpos(physcomp.getXpos() - fdelta);
                        }

                    }else if(input.isKeyDown(RIGHT)){
                        viscomp.setSprite(viscomp.getRight());
                        physcomp.getBoundingbox().setX(physcomp.getBoundingbox().getX() + fdelta);
                        if(IntersectsBlockable(entity) || physcomp.getXpos() > map.getWidth()*SIZE-viscomp.getSprite().getWidth()){
                            physcomp.getBoundingbox().setX(physcomp.getBoundingbox().getX() - fdelta);
                        }else{
                            viscomp.getSprite().update(delta);
                            physcomp.setXpos(physcomp.getXpos() + fdelta);
                        }
                    }else if(input.isKeyPressed(SELECT)){
                        ArrayList<Entity> touching = getTouching(entity);
                        Entity interactable = null;
                        for(Entity ent : touching){
                            PhysicalComponent entphyscomp = ent.getComponent(PhysicalComponent.class);
                            if(viscomp.getSprite() == viscomp.getUp()){
                                System.out.println("FACING UP");
                                if(entphyscomp.getYpos() < physcomp.getYpos()){
                                    interactable = ent;
                                }
                            }else if(viscomp.getSprite() == viscomp.getDown()){
                                System.out.println("FACING DOWN");
                                if(entphyscomp.getYpos() > physcomp.getYpos()){
                                    System.out.println("INTERACTABLE SET");
                                    interactable = ent;
                                }
                            }else if(viscomp.getSprite() == viscomp.getLeft()){
                                System.out.println("FACING LEFT");
                                if(entphyscomp.getXpos() < physcomp.getXpos()){
                                    interactable = ent;
                                }
                            }else if(viscomp.getSprite() == viscomp.getRight()){
                                System.out.println("FACING RIGHT");
                                if(entphyscomp.getXpos() > physcomp.getXpos()){
                                    interactable = ent;
                                }
                            }
                            if(interactable != null){
                                if(interactable.hasComponents(ItemComponent.class)){
                                    ItemComponent intercomp = interactable.getComponent(ItemComponent.class);
                                    System.out.println("INTERACT");
                                    intercomp.Interact(entity);
                                }
                            }    
                        }
                    } else if(input.isKeyPressed(ENTER)){
                        currentPanel = ResourceManager.getInstance().mainMenuPanel;
                    }
                    Entity exit = getIntersectingExit(entity);
                    changeMap(exit); // If exit is null then map is not changed
                }
            }
        }
    }
    
    /*
     * Handles input to update the interface if any interface is being rendered
     */
    private void updateInterfaceInput(Input input, int delta){
        
        if(input.isKeyPressed(SELECT) || input.isKeyPressed(ENTER)){
            currentPanel = currentPanel.selectCurrentOption();
        } else if(input.isKeyPressed(BACK) || input.isKeyPressed(ESCAPE)){
            /* If the currentPanel is the main menu, release it to switch to handling level input. 
             Otherwise, return to the currentPanel's parent Panel */
            if(currentPanel == ResourceManager.getInstance().mainMenuPanel){
                currentPanel = null;
            }else{
                currentPanel = currentPanel.getParent();
            }

        } else if(input.isKeyPressed(UP)){
            currentPanel.MoveUp();
        } else if(input.isKeyPressed(DOWN)){
            currentPanel.MoveDown();
        } else if(input.isKeyPressed(LEFT)){
            currentPanel.MoveLeft();
        } else if(input.isKeyPressed(RIGHT)){
            currentPanel.MoveRight();
        }
    }
    
    /*Returns true if "entity" is currently intersecting something that blocks movement*/
    private boolean IntersectsBlockable(Entity entity){
        for(Entity ent : localEntities){
            if(ent.hasComponents(PhysicalComponent.class)){
                PhysicalComponent sourcephyscomp = entity.getComponent(PhysicalComponent.class);
                PhysicalComponent destphyscomp = ent.getComponent(PhysicalComponent.class);
                if(ent != entity){
                    if(sourcephyscomp.getBoundingbox().intersects(destphyscomp.getBoundingbox())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /*Returns all entities that are intersecting "entity"*/
    private ArrayList<Entity> getIntersecting(Entity entity){
        ArrayList<Entity> intersecting = new ArrayList();
        for(Entity ent : localEntities){
            if(ent.hasComponents(PhysicalComponent.class)){
                PhysicalComponent sourcephyscomp = entity.getComponent(PhysicalComponent.class);
                PhysicalComponent destphyscomp = ent.getComponent(PhysicalComponent.class);
                if(ent != entity){
                    if(sourcephyscomp.getBoundingbox().intersects(destphyscomp.getBoundingbox())){
                        intersecting.add(ent);
                    }
                }
            }
        }
        return intersecting;
    }
    
    /*Returns all entities that are touching "entity"*/
    private ArrayList<Entity> getTouching(Entity entity){
        ArrayList<Entity> touching = new ArrayList();
        for(Entity ent : localEntities){
            if(ent.hasComponents(PhysicalComponent.class)){
                PhysicalComponent sourcephyscomp = entity.getComponent(PhysicalComponent.class);
                PhysicalComponent destphyscomp = ent.getComponent(PhysicalComponent.class);
                if(ent != entity){
                    sourcephyscomp.getBoundingbox().grow(1, 1);
                    if(sourcephyscomp.getBoundingbox().intersects(destphyscomp.getBoundingbox())){
                        System.out.println("FOUND TOUCHING");
                        touching.add(ent);
                    }
                    sourcephyscomp.getBoundingbox().grow(-1, -1);
                }
            }
        }
        return touching;
    }
    
    /*Returns the entity in "targets" that is closest to the "source" entity*/
    private Entity getClosest(Entity source, ArrayList<Entity> targets){
        PhysicalComponent physcomp = source.getComponent(PhysicalComponent.class);
        float sourcex = physcomp.getBoundingbox().getCenterX();
        float sourcey = physcomp.getBoundingbox().getCenterY();
        float mindistance = 1000000;
        Entity closest = null;
        
        for(Entity target : targets){
            PhysicalComponent pc = target.getComponent(PhysicalComponent.class);
            float targetx = pc.getBoundingbox().getCenterX();
            float targety = pc.getBoundingbox().getCenterY();
            float vertdist = sourcey-targety;
            float horizdist = sourcex-targetx;
            double hypotenuse = Math.sqrt(Math.pow((double)vertdist,2) + Math.pow((double)horizdist,2));
            if(hypotenuse < mindistance){
                mindistance = (float)hypotenuse;
                closest = target;
            }
        }
        
        if(closest != null){
            return closest;
        }
        return source;
    }
    
    /* Add all objects created in the map editor to their corresponding set of entities*/
    private void initEntities(){
        detectTerrain();
        detectExits();
        localEntities.add(User.getInstance());
    }

    private void detectTerrain(){
        for(int collisionLayerID=0; collisionLayerID<map.getObjectGroupCount(); collisionLayerID++){
            for(int objectID=0; objectID<map.getObjectCount(collisionLayerID); objectID++){
                if(map.getObjectProperty(collisionLayerID, objectID, "blockable", "false").equals("true")){
                    int boxX = map.getObjectX(collisionLayerID, objectID);
                    int boxY = map.getObjectY(collisionLayerID, objectID);
                    int boxW = map.getObjectWidth(collisionLayerID, objectID);
                    int boxH = map.getObjectHeight(collisionLayerID, objectID);
                    Rectangle box = new Rectangle(boxX, boxY, boxW, boxH);

                    TerrainFactory terrainFactory = new TerrainFactory(box);
                    Entity terrainEntity = terrainFactory.createEntity();
                    localEntities.add(terrainEntity);
                }
            }
        }
    }
    
    private void detectExits(){
        for(int collisionLayerID=0; collisionLayerID<map.getObjectGroupCount(); collisionLayerID++){
            for(int objectID=0; objectID<map.getObjectCount(collisionLayerID); objectID++){
                Rectangle box = null;
                int targetID = 0;
                if(map.getObjectProperty(collisionLayerID, objectID, "exit", "false").equals("true")){
                            int boxX = map.getObjectX(collisionLayerID, objectID);
                            int boxY = map.getObjectY(collisionLayerID, objectID);
                            int boxW = map.getObjectWidth(collisionLayerID, objectID);
                            int boxH = map.getObjectHeight(collisionLayerID, objectID);
                            box = new Rectangle(boxX, boxY, boxW, boxH);
                }
                if(!map.getObjectProperty(collisionLayerID, objectID, "targetID", "DNE").equals("DNE")){
                    String IDstr = map.getObjectProperty(collisionLayerID, objectID, "targetID", "DNE");
                    targetID = Integer.parseInt(IDstr);
                }
                if(box != null && targetID != 0){
                    Entity exit = new ExitFactory(box, targetID).createEntity();
                    exits.add(exit);
                }
            }
        }
    }
    
    /*Check to see if entity "user" is in the line of sight of any enemy entity*/
    private void checkLOS(Entity user, Graphics g){
        ArrayList<Entity> inLOS = new ArrayList(); //hold entities in the line of sight
        ArrayList<Entity> intersecting; //hold entities that intersect the line of sight box
        for(Entity enemy : localEntities){
            if(enemy.hasComponents(EnemyComponent.class, VisibleComponent.class, PhysicalComponent.class)){
                /*Get the entity's components*/
                VisibleComponent viscomp = enemy.getComponent(VisibleComponent.class);
                PhysicalComponent physcomp = enemy.getComponent(PhysicalComponent.class);
                EnemyComponent encomp = enemy.getComponent(EnemyComponent.class);
                float range = encomp.getSightrange();
                Rectangle LOSbox; //line of sight rectangle
                boolean verticalLOS = true; //is the line of sight vertical or horizontal
                float vertadjust=0; //vertical adjustment for line of sight box
                float horizadjust=0; //horizontal adjustment for line of sight box
                float width=physcomp.getBoundingbox().getWidth();
                float height=physcomp.getBoundingbox().getHeight();
                if(viscomp.getSprite() == viscomp.getUp()){
                    vertadjust = -range-1;
                    verticalLOS = true;
                    height = range;                    
                }else if(viscomp.getSprite() == viscomp.getDown()){
                    vertadjust = physcomp.getBoundingbox().getHeight()+1;
                    verticalLOS = true;
                    height = range;
                }else if(viscomp.getSprite() == viscomp.getLeft()){
                    horizadjust = -range-1;
                    verticalLOS = false;
                    width = range;
                }else if(viscomp.getSprite() == viscomp.getRight()){
                    horizadjust = physcomp.getBoundingbox().getWidth()+1;
                    verticalLOS = false;
                    width = range;
                }
                
                LOSbox = new Rectangle(physcomp.getBoundingbox().getX()+horizadjust, physcomp.getBoundingbox().getY()+vertadjust, width, height);
                Entity LOSentity = new Entity(new PhysicalComponent(LOSbox), new VisibleComponent()); //temporary entity representing line of sight
                intersecting = getIntersecting(LOSentity); //get all entities that intersect the line of sight entity
                float x = LOSbox.getX();
                float y = LOSbox.getY();
                float w = LOSbox.getWidth();
                float h = LOSbox.getHeight();
                g.drawRect(x,y,w,h); //draw the line of sight box

                float boxcenterx = LOSbox.getCenterX();
                float boxcentery = LOSbox.getCenterY();
                float interval = range/5;
                for(Entity ent : intersecting){
                    PhysicalComponent pc = ent.getComponent(PhysicalComponent.class);
                    float centerx = pc.getBoundingbox().getCenterX();
                    float centery = pc.getBoundingbox().getCenterY();
                    if(verticalLOS){
                        if(centerx >= boxcenterx-interval/2 && centerx <= boxcenterx+interval/2){
                            inLOS.add(ent);
                            //System.out.println("IN VERTICAL LOS");
                            Entity closest = getClosest(enemy, inLOS);
                            if(closest != enemy){
                                if(closest.hasComponents(InputComponent.class)){
                                    System.out.println("USER IN LOS");
                                    enterBattle(enemy);
                                }
                            }
                        }
                    }else if(centery >= boxcentery-interval/2 && centery <= boxcentery+interval/2){
                        inLOS.add(ent);
                        //System.out.println("IN HORIZONTAL LOS");
                        Entity closest = getClosest(enemy, inLOS);
                        if(closest != enemy){
                            if(closest.hasComponents(InputComponent.class)){
                                System.out.println("USER IN LOS");
                                enterBattle(enemy);
                            }
                        }
                    }
                }
            }
        }
    }
    
    /*Returns the exit entity that "entity" intersects*/
    private Entity getIntersectingExit(Entity entity){
        PhysicalComponent pc = entity.getComponent(PhysicalComponent.class);
        Rectangle box = pc.getBoundingbox();
        float xpos = box.getCenterX();
        float ypos = box.getCenterY();
        for(Entity exit : exits){
            PhysicalComponent exitpc = exit.getComponent(PhysicalComponent.class);
            Rectangle exitbox = exitpc.getBoundingbox();
            float exitxpos = exitbox.getCenterX();
            float exitypos = exitbox.getCenterY();
            if(box.intersects(exitbox)){
                if(Math.abs(exitxpos - xpos)<1 || Math.abs(exitypos - ypos)<1){
                    return exit;
                }
            }
        }
        return null;
    }    
    
    @Override
    public void enter(GameContainer gc, StateBasedGame sbg){
        //currentPanel = ResourceManager.getInstance().mainMenuPanel;
    }
    /* Enter battle with enemy*/
    private void enterBattle(Entity enemy){
        PartyComponent EPc = enemy.getComponent(PartyComponent.class);
        PartyComponent UPc = User.getInstance().getComponent(PartyComponent.class);
        BattleManager.getINSTANCE().Reset(EPc.getParty(), UPc.getParty());
        game.enterState(battlesceneID);
  
    }
    
    /*
     * Transitions the map to another map based on the exit that the user took
     *  Change the game state based on the exit passed
     *  Handle the direction the user is facing
     *      Update the user's position to the target gamestate as if the user walked through the exit
     */
    private void changeMap(Entity exit){
        if(exit != null){
            ExitComponent ec = exit.getComponent(ExitComponent.class);
            VisibleComponent uvc = User.getInstance().getComponent(VisibleComponent.class);
            PhysicalComponent upc = User.getInstance().getComponent(PhysicalComponent.class);
            if(uvc.getSprite() == uvc.getUp()){
                upc.setYpos(map.getHeight()*SIZE-SIZE);
            }else if(uvc.getSprite() == uvc.getDown()){
                upc.setYpos(SIZE);
            }else if(uvc.getSprite() == uvc.getLeft()){
                upc.setXpos(map.getWidth()*SIZE-SIZE);
            }else if(uvc.getSprite() == uvc.getRight()){
                System.out.println("RIGHT EXIT ENTERED");
                upc.setXpos(SIZE);
            }
            System.out.println("MAP CHANGED");
            game.enterState(ec.getTargetID(), new FadeOutTransition(Color.black, 1000), new FadeInTransition(Color.black, 1000));
        }
    }

    private boolean interfaceIsRendering() {
        if(currentPanel != null){
            return true;
        } else {
            return false;
        }
    }
        
}
