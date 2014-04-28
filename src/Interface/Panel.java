
package Interface;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * A panel that holds any number of options.
 * If there are more options than fit on the panel, the panel acts as a scrolling panel.
 * The panel also formats the options based on how many and their size.
 */
public class Panel extends UIComponent{

    private static final int MIN_OPTION_HEIGHT = 50;
    private static final int MAX_OPTION_HEIGHT = 128;
    private static final int DEFAULT_OPTION_HEIGHT = 64;
    private int MARGIN;
    /*Id that represents the current option highlighted.
      Indices of "options" correspond to Ids*/
    private int currentOptionId;
    private int optionsAllowed;
    private List<Option> options;
    private List<Integer> visibleOptionIds;
    /*Points on the panel where options will be located (topleft corner) if they're to be visible*/
    private List<Point> displayPoints;
    private Selector selector;
    
    /* The panel's image is scaled based on the height and width parameters
     * @param x: X position of panel on game container
     * @param y: Y position of panel on game container
     * @param h: height of the panel
     * @param w: width of panel
     * @param marg: padding for panel's options
     */
    public Panel(int x, int y, int h, int w, int marg, Option...opts) throws SlickException{
        setX(x);
        setY(y);
        setHeight(h);
        setWidth(w);
        MARGIN = marg;
        setImage(new Image("data/interface/panel.png").getScaledCopy(w, h));
        options=new ArrayList();
        options.addAll(Arrays.asList(opts));
        if(!options.isEmpty()){
            visibleOptionIds = new ArrayList();
            displayPoints = new ArrayList();
            optionsAllowed = 0;
            currentOptionId = 0;
            selector = new Selector();
        }    
        
        decideOptionHeight();
    }
    
    public void Select(){
        
    }
    public void Deselect(){
        
    }
    
    public void MoveUp(){
        System.out.println("CURRENT ID BEFORE: "+currentOptionId);
        if(currentOptionId == 0){ // We're currently at top of all options
            // Do nothing 
        } else { // We're not currently at top of all options
            if(currentOptionId == visibleOptionIds.get(0)){ // We're currently at top of visible options
                currentOptionId = currentOptionId - 1;
                for(int i=0; i<visibleOptionIds.size(); i++){
                    visibleOptionIds.set(i, visibleOptionIds.get(i)-1);
                }
            } else { // We're not currently at top of visible options
                currentOptionId = currentOptionId - 1;
            }
        }
        
        System.out.println("CURRENT ID AFTER: "+currentOptionId); 
        //System.out.println("SELECTOR x,y: "+selector.getX()+", "+selector.getY());
        System.out.println();
    }
    
    public void MoveDown(){
        System.out.println("CURRENT ID BEFORE: "+currentOptionId);
        if(currentOptionId == options.size()-1){ // We're currently at bottom of all options
            // Do nothing 
        } else { // We're not currently at bottom of all options
            if(currentOptionId == visibleOptionIds.get(visibleOptionIds.size()-1)){ // We're currently at bottom of visible options
                currentOptionId = currentOptionId + 1;
                for(int i=0; i<visibleOptionIds.size(); i++){
                    visibleOptionIds.set(i, visibleOptionIds.get(i)+1);
                }
            } else { // We're not currently at bottom of visible options
                currentOptionId = currentOptionId + 1;
            }
        }
        
        System.out.println("CURRENT ID AFTER: "+currentOptionId);
        //System.out.println("SELECTOR x,y: "+selector.getX()+", "+selector.getY());
        System.out.println();
    }
    public void MoveLeft(){
        System.out.println("TODO: Build 2d option system");
    }
    public void MoveRight(){
        System.out.println("TODO: Build 2d option system");
    }
    public int getCurrentOption(){
        return currentOptionId;
    }
    public void setCurrentId(int id){
        currentOptionId=id;
    }

    public void decideOptionHeight(){
        int heightAvailable = getHeight()-2*MARGIN;
        int widthAvailable = getWidth()-2*MARGIN;
        int optionHeight = heightAvailable/options.size();
                
        if(optionHeight >= MIN_OPTION_HEIGHT && optionHeight <= MAX_OPTION_HEIGHT){
            System.out.println("TREAT AS STATIC OPTION PANEL");
            for(int i=0; i<options.size(); i++){                
                options.get(i).setX(getX() + MARGIN);
                options.get(i).setY(getY()+ MARGIN + i*optionHeight);
                options.get(i).setHeight(optionHeight);
                options.get(i).setWidth(widthAvailable);
                optionsAllowed = options.size();
                visibleOptionIds.add(i);
                displayPoints.add(new Point(getX() + MARGIN, getY() + MARGIN + i*optionHeight));
            }
        }else if(optionHeight < MIN_OPTION_HEIGHT){
            optionHeight = DEFAULT_OPTION_HEIGHT;
            System.out.println("TREAT AS SCROLLING OPTIONS PANEL");
            int heightTally=0;
            //System.out.println("\nHEIGHT AVAILABLE: "+heightAvailable);
            //System.out.println("OPTIONS ALLOWED: "+optionsAllowed);
            for(Option option : options){
                optionsAllowed++;
                heightTally=heightTally+optionHeight;
                //System.out.println("HEIGHT TALLY: "+heightTally);
                if(heightTally+optionHeight > heightAvailable){
                    break;
                }
                //System.out.println("OPTIONS ALLOWED: "+optionsAllowed);
            }

            displayPoints = new ArrayList();
            //System.out.println("visID SIZE: "+visableOptionIds.size()+" disPoints SIZE: "+displayPoints.size());
            for(int i=0; i<optionsAllowed; i++){
                displayPoints.add(new Point(getX() + MARGIN, getY() + MARGIN + i*optionHeight));
                visibleOptionIds.add(i);
                //System.out.println("visID SIZE: "+visableOptionIds.size()+"\ndisPoints SIZE: "+displayPoints.size());
            }
        }else if(optionHeight > MAX_OPTION_HEIGHT){
            //System.out.println("TREAT AS INSUFFICIENT OPTION PANEL");
            optionHeight = DEFAULT_OPTION_HEIGHT;
            for(int i=0; i<options.size(); i++){
                options.get(i).setX(getX() + MARGIN);
                options.get(i).setY(getY()+ MARGIN + i*optionHeight);
                options.get(i).setHeight(optionHeight);
                options.get(i).setWidth(widthAvailable);
                optionsAllowed = options.size();
                visibleOptionIds.add(i);
                displayPoints.add(new Point(getX() + MARGIN, getY() + MARGIN + i*optionHeight));
            }
        }
    }

    @Override
    public void update(){
        /*for(Option option : options){
            option.update();
        }*/
        if(currentOptionId <= visibleOptionIds.get(0)){ // currently at top or above visible options
            selector.setImage(selector.getImage().getScaledCopy(options.get(currentOptionId).getImage().getWidth(), options.get(currentOptionId).getImage().getHeight()));
            selector.setX((int)displayPoints.get(0).getX());
            selector.setY((int)displayPoints.get(0).getY());
        } else if(currentOptionId >= visibleOptionIds.get(visibleOptionIds.size()-1)){ // currently at bottom or below above visible options
            selector.setImage(selector.getImage().getScaledCopy(options.get(currentOptionId).getImage().getWidth(), options.get(currentOptionId).getImage().getHeight()));
            selector.setX((int)displayPoints.get(displayPoints.size()-1).getX());
            selector.setY(((int)displayPoints.get(displayPoints.size()-1).getY()));
        } else { // currently within visible options
            selector.setImage(selector.getImage().getScaledCopy(options.get(currentOptionId).getImage().getWidth(), options.get(currentOptionId).getImage().getHeight()));
            int visibleOptionId = visibleOptionIds.indexOf(currentOptionId);
            selector.setX((int)displayPoints.get(visibleOptionId).getX());
            selector.setY((int)displayPoints.get(visibleOptionId).getY());
        }
    }
    
    @Override
    public void render(){
        getImage().draw(getX(), getY());
        /*for(int i=0; i<visibleOptionIds.size(); i++){
            options.get(visibleOptionIds.get(i)).getImage()
                    .draw((float)displayPoints.get(i).getX(), (float)displayPoints.get(i).getY());
        }*/
        for(int i=0; i<visibleOptionIds.size(); i++){
            options.get(visibleOptionIds.get(i)).draw((float)displayPoints.get(i).getX(), (float)displayPoints.get(i).getY());
        }
        selector.render();
    }
}
