
package Interface;

import Managers.BattleManager;
import Managers.ResourceManager;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.util.Log;


/*
 * Represents the overlay in battle scenes where the user chooses which enemy/friendly they choose to target
 */
public class TargetOverlay extends Panel{
    
    private Image enemyIndicator;
    private Image friendlyIndicator;
    
    private static final float charAreaWidth = 70;
    private static final float charAreaHeight = 40;
    private ArrayList<Ellipse> enemyAreas = new ArrayList<Ellipse>();
    private ArrayList<Ellipse> friendlyAreas = new ArrayList<Ellipse>();
    
    private Point currentPoint;
    
    private int totalEnemies;
    private int totalFriendlies;
    
    private ArrayList<Point> enemyPoints = new ArrayList();
    private ArrayList<Point> friendlyPoints = new ArrayList();
    
    /* Hardcoded points on enemy grid (left half)*/
    /*
    private final Point CENTER = new Point(getContainer().getWidth()/4, getContainer().getHeight()/4);
    private final Point TOP_MID = new Point();
    private final Point BTM_MID = new Point();
    
    private final Point TOP_MID = new Point();
    private final Point TOP_LEFT = new Point();
    private final Point TOP_RIGHT = new Point();
    
    private final Point TOP_MID = new Point();
    private final Point TOP_MID = new Point();
    private final Point TOP_MID = new Point();
    * */
    
    
    
    
    public TargetOverlay(GameContainer gc) throws SlickException{
        super(gc);
        setParent(ResourceManager.getInstance().actionPanel);
        //find total enemies and friendlies
        //throw error if either is greater than 6 or less than 1
        //initialize enemy and friendly points
        //initFriendlyPoints();
    }
    
    
    
    @Override
    public void MoveUp(){
        
    }
    @Override
    public void MoveDown(){
        
    }
    @Override
    public void MoveLeft(){
        
    }
    @Override
    public void MoveRight(){
        
    }
    public void Select(){
        
    }
    public Panel returnToActionPanel(){
        return ResourceManager.getInstance().actionPanel;
    }
    
    
    @Override
    public void update(){
        /* 
         * update points and indicators.
         * scale each indicator.
         */
        totalEnemies = BattleManager.getInstance().getEnemies().size();
        totalFriendlies = BattleManager.getInstance().getFriendlies().size();
        updateEnemyPoints();
    }
    
    
    /* Define the points on the enemy side (left half) of the battlescene where the enemies will be located */
    private void updateEnemyPoints(){
        /* For every enemy
         *    commit the first point to the center
         *    generate random point until it is acceptable then commit the point
         */
        int i=0;
        while(i<totalEnemies){
            if(i==0){
                commitEnemyPoints(new Point(getContainer().getWidth()/4, getContainer().getHeight()/4));
            }else {
                Point randomPoint = null;
                do {
                    randomPoint = generateRandomEnemyPoint();
                }while(!isAcceptable(randomPoint));
                commitEnemyPoints(randomPoint);
            }
            i++;
        }
    }
    /* Add the point to the set, add its corresponding area shape to the set */
    private void commitEnemyPoints(Point point){
        enemyPoints.add(point);
        enemyAreas.add(new Ellipse(point.getCenterX(), point.getCenterY(), charAreaWidth, charAreaHeight));
    }
    /* Generate random point within enemy half of the battle scene (left half)*/
    private Point generateRandomEnemyPoint(){
        float x = (float) Math.random() * getContainer().getWidth()/2;
        float y = (float)Math.random() * getContainer().getHeight()/4;
        return new Point(x,y);
    }
    /* False if given Point intersects with another charArea or is offscreen*/
    private boolean isAcceptable(Point point){
        /*if intersects charAreas or borders  return false*/
        Ellipse borderTest = new Ellipse(point.getCenterX(), point.getCenterY(), this.charAreaWidth, this.charAreaHeight);
        for(Ellipse area : enemyAreas){
            if(point.intersects(area)){
                return false;
            }
            //if part of borderTest is offscreen then return false
        }
        return true;
    }
    
    @Override
    public void render(float x, float y){
        /* render the entire overlay at x and y.
         * render each indicator at it's point.
         */
        //getContainer().getGraphics().drawString("RENDERING TARGETOVERLAY", x, y);
        for(Ellipse enemyArea : enemyAreas){
            ResourceManager.getInstance().targetIndicator.draw(enemyArea.getMinX(), enemyArea.getMinY());
            //getContainer().getGraphics().draw(enemyArea);
        }
    }

    
}
