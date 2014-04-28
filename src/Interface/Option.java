
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

    private UIComponent result;
    private String name;
    private int margin = 2;
    
    /*Constructor to test with dead end options*/
    public Option(TrueTypeFont font){
        setFont(font);
        name="DEAD END";
    }
    /*Constructor to give text-only options*/
    public Option(TrueTypeFont font, UIComponent child, String name){
        setFont(font);
        setChild(child);
        this.name = name;
    }
    
    public Option(TrueTypeFont font, UIComponent child, Image img, String name){
        setFont(font);
        setChild(child);
        setImage(img);
        this.name=name;
        
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
    
    /* Called when the panel containing this option invokes Select()
     @return: The panel that the focus will be passed to*/
    public Panel Select(){
        if(getChild() instanceof Panel){
            return (Panel)getChild();
        }else{
            Log.error("Option Attempted to select non-panel child");
            return null;
        }
    }
    /*Called when this option's Panel is done initializing*/
    public void Scale(){
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
