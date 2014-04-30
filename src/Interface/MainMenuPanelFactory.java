
package Interface;

import Managers.ResourceManager;
import java.util.ArrayList;
import java.util.Arrays;
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
                                        15
                                        );
        mainMenuPanel.setOptions(new ArrayList<Option>(Arrays.asList(new Option(mainMenuPanel, testPanel, mainMenuPanelFont, "Sample1"),
                                                                    new Option(mainMenuPanel, testPanel, mainMenuPanelFont, "Sample2"), 
                                                                    new Option(mainMenuPanel, testPanel, mainMenuPanelFont, "Sample3"),
                                                                    new Option(mainMenuPanel, testPanel, mainMenuPanelFont, "Sample4"),
                                                                    new Option(mainMenuPanel, testPanel, mainMenuPanelFont, "Sample5"),
                                                                    new Option(mainMenuPanel, testPanel, mainMenuPanelFont, "Sample6"),
                                                                    new Option(mainMenuPanel, testPanel, mainMenuPanelFont, "Sample7")
                                                                    )
                                                        )
                                );
        mainMenuPanel.initPanel();
        testPanel.setParent(mainMenuPanel);
        return mainMenuPanel;
    }

}
