
package Interface;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Selector extends UIComponent{

    public Selector() throws SlickException{
         setImage(new Image("data/interface/selector.png"));
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(float x, float y) {
        getImage().draw(x, y);
    }

}
