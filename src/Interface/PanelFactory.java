
package Interface;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.HieroSettings;

public interface PanelFactory {
    
    
    public Panel createPanel(GameContainer gc) throws SlickException;
    
    
}
