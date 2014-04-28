
package Interface;

import java.awt.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;

public class TestPanelFactory implements PanelFactory{

   private final UnicodeFont actionPanelFont = new UnicodeFont(new Font("Dialog", Font.PLAIN, 16));
    
    @Override
    public Panel createPanel(GameContainer gc) throws SlickException {
        Image optionBackground = new Image("data/interface/optionbackground.png");
        Panel testPanel = new Panel(10,10,200,200,0, new Option(optionBackground, this.actionPanelFont, "Sample"),
                                                    new Option(optionBackground, this.actionPanelFont, "Sample"),
                                                    new Option(optionBackground, this.actionPanelFont, "Sample"));
        return testPanel;
    }

}
