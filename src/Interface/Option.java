
package Interface;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.UnicodeFont;

public class Option extends UIComponent{

    private UIComponent result;
    private UnicodeFont font;
    private String name;
    
    public Option(Image img, UnicodeFont font, String name){
        setImage(img);
        this.font=font;
        this.name=name;
    }
    
    public void draw(float x, float y){
        getImage().draw(x, y);
        font.drawString(x, y, this.name, Color.red);
    }
    
    public void proceed(){
        
    }
}
