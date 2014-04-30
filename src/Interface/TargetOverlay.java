
package Interface;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.util.Log;


/*
 * Represents the overlay in battle scenes where the user chooses which enemy/friendly they choose to target
 */
public class TargetOverlay extends UIComponent{
    
    private Image enemyIndicator;
    private Image friendlyIndicator;
    
    private static final float charAreaWidth = 70;
    private static final float charAreaHeight = 40;
    private ArrayList<Ellipse> enemyAreas = new ArrayList<Ellipse>();
    private ArrayList<Ellipse> friendlyAreas = new ArrayList<Ellipse>();
    
    private Point currentPoint;
    
    private int totalEnemies;
    private int totalFriendlies;
    
    private ArrayList<Point> enemyPoints = new ArrayList();;
    private ArrayList<Point> friendlyPoints = new ArrayList();;
    
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
    
    
    
    
    public TargetOverlay(GameContainer gc){
        setContainer(gc);
        //find total enemies and friendlies
        //throw error if either is greater than 6 or less than 1
        //initialize enemy and friendly points
        initEnemyPoints();
        //initFriendlyPoints();
    }
    
    private void initEnemyPoints(){
        /* For eveery enemy
         *    commit the first point to the center
         *    generate random point until it is acceptable then commit the point
         */
        int i=0;
        while(i<totalEnemies){
            if(i==0){
                commitPoint(new Point(getContainer().getWidth()/4, getContainer().getHeight()/4));
            }else {
                Point randomPoint = null;
                do {
                    randomPoint = generateRandomEnemyPoint();
                }while(!isAcceptable(randomPoint));
                commitPoint(randomPoint);
            }
            i++;
        }
    }
    /* Add the point to the set, add its corresponding area shape to the set */
    private void commitPoint(Point point){
        enemyPoints.add(point);
        enemyAreas.add(new Ellipse(point.getCenterX(), point.getCenterY(), charAreaWidth, charAreaHeight));
    }
    /* Generate random point within enemy half of the battle scene (left half)*/
    private Point generateRandomEnemyPoint(){
        float x = (float) Math.random() * getContainer().getWidth()/2;
        float y = (float)Math.random() * getContainer().getHeight()/4;
        return new Point(x,y);
    }
    /* False if given Point intersects with another area or is offscreen*/
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
    
    
    public void MoveUp(){
        
    }
    public void MoveDown(){
        
    }
    public void MoveLeft(){
        
    }
    public void MoveRight(){
        
    }
    public void Select(){
        
    }
    public void Deselect(){
        
    }
    
    
    public void update(){
        /* 
         * update points and indicators.
         * scale each indicator.
         */
    }
    @Override
    public void render(float x, float y){
        /* render the entire overlay at x and y.
         * render each indicator at it's point.
         */
        for(Ellipse enemyArea : enemyAreas){
            getContainer().getGraphics().draw(enemyArea);
        }
    }

    
}
