
package Interface;

import java.awt.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;

public class MainMenuPanelFactory implements PanelFactory{

    private final UnicodeFont mainMenuPanelFont = new UnicodeFont(new Font("Dialog", Font.PLAIN, 16));
    
    @Override
    public Panel createPanel(GameContainer gc) throws SlickException {
        Image optionBackground = new Image("data/interface/optionbackground.png");
        Panel mainMenuPanel = new Panel(gc.getWidth()/3, gc.getHeight()/4, 
                                      gc.getHeight()*2/3, 
                                      gc.getWidth()/3,
                                      15,
                                      new Option(optionBackground, this.mainMenuPanelFont, "Sample"),
                                      new Option(optionBackground, this.mainMenuPanelFont, "Sample"), 
                                      new Option(optionBackground, this.mainMenuPanelFont, "Sample")
                                      //new Option(new Image("data/interface/sampleoption.png"))
                );
        return mainMenuPanel;
    }

}
