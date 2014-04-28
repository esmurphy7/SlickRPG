
package Interface;

import Managers.ResourceManager;
import java.awt.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;

public class MainMenuPanelFactory implements PanelFactory{

    private TrueTypeFont mainMenuPanelFont;
    public MainMenuPanelFactory(){
        mainMenuPanelFont = ResourceManager.getInstance().eightBitWonder;
    }
    @Override
    public Panel createPanel(GameContainer gc) throws SlickException {
        Panel testPanel = new TestPanelFactory().createPanel(gc);
        Panel mainMenuPanel = new Panel(gc,
                                        gc.getWidth()/3, 
                                        gc.getHeight()/4, 
                                        gc.getHeight()*2/3, 
                                        gc.getWidth()/3,
                                        15,
                                        new Option(mainMenuPanelFont, testPanel, "Sample"),
                                        new Option(mainMenuPanelFont, testPanel, "Sample"), 
                                        new Option(mainMenuPanelFont, testPanel, "Sample")
                                      //new Option(new Image("data/interface/sampleoption.png"))
                );
        return mainMenuPanel;
    }

}
