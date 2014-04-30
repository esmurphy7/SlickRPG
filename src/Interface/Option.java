
package Interface;

import Managers.ResourceManager;
import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

/*UIComponent that is displayed by its Panel
 * An Option consists of an icon (Image), a text (name), and possibly a statistic
 */
public class Option extends UIComponent{

    private Panel containingPanel;
    private Panel destination;
    private String name;
    private int margin = 2;
    
    /*Constructor to test with dead end options*/
    public Option(Panel containing, TrueTypeFont font){
        this.containingPanel=containing;
        setFont(font);
        this.destination=containing;
        this.destination.setParent(containing);
        name="DEAD END";
    }
    /*Constructor to give text-only options*/
    public Option(Panel containing, Panel destination, TrueTypeFont font, String name){
        this.containingPanel=containing;
        this.destination=destination;
        this.destination.setParent(containing);
        setFont(font);
        this.name = name;
    }
    /* Constructor for options with an icon */
    public Option(Panel containing, Panel destination, TrueTypeFont font, Image img, String name){
        this.containingPanel=containing;
        this.destination=destination;
        this.destination.setParent(containing);
        setFont(font);
        setImage(img);
        this.name=name;
        
    }
    
    public Panel getDestination() {
        return destination;
    }
    public void setDestination(Panel Destination) {
        this.destination = Destination;
    }
    public Panel getContainingPanel() {
        return containingPanel;
    }
    public void setContainingPanel(Panel containingPanel) {
        this.containingPanel = containingPanel;
    }
    
    @Override
    public void render(float x, float y){
        if(getImage() != null){
            getImage().draw(x+margin, y+margin);
        
        /* Draw the name of the option using the container's font
         * Fonts are state specific*/
            getFont().drawString(x+margin+getImage().getWidth()+margin, y+margin+getImage().getHeight()/4, name, Color.white);
        } else {
            getFont().drawString(x+margin, y+margin, name);
        }
        
    }

    
    /*Called when this option's Panel is done initializing
      Inflates the option's icon and string to fit the options available space which is defined by containing Panel*/
    public void inflate(){
        if(getImage() != null){
            setImage(getImage().getScaledCopy(getWidth()/5, getWidth()/5));
        }
        /* Inflate font size
        int fontSize = getFont().getHeight();
        while(fontSize < getHeight()-2*margin){
            fontSize++;
            * //do something with new fontsize
        }*/
        
    }
    
    
    @Override
    public void update() {
        
        
    }
    

}
