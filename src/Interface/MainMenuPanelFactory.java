
package Interface;

import Managers.ResourceManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class MainMenuPanelFactory implements PanelFactory{

    private TrueTypeFont mainMenuPanelFont;
    
    public MainMenuPanelFactory(){
        mainMenuPanelFont = ResourceManager.getInstance().eightBitWonder;
    }
    
    @Override
    public Panel createPanel(GameContainer gc) throws SlickException {
        Panel testPanel = new TestPanelFactory().createPanel(gc);
        int width = gc.getWidth()/5;
        int height = gc.getHeight()/3;
        Panel mainMenuPanel = new Panel(gc,
                                        gc.getWidth()/5, 
                                        gc.getHeight()/8, 
                                        height, 
                                        width,
                                        15,
                                        new Option(mainMenuPanelFont, testPanel, "Sample1"),
                                        new Option(mainMenuPanelFont, testPanel, "Sample2"), 
                                        new Option(mainMenuPanelFont, testPanel, "Sample3"),
                                        new Option(mainMenuPanelFont, testPanel, "Sample4"),
                                        new Option(mainMenuPanelFont, testPanel, "Sample5"),
                                        new Option(mainMenuPanelFont, testPanel, "Sample6"),
                                        new Option(mainMenuPanelFont, testPanel, "Sample7")
                                      //new Option(new Image("data/interface/sampleoption.png"))
                );
        testPanel.setParent(mainMenuPanel);
        return mainMenuPanel;
    }

}
