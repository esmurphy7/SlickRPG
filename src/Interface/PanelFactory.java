
package Interface;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public interface PanelFactory {
    
    public Panel createPanel(GameContainer gc) throws SlickException;
    
    
}
