
package Interface;

import Managers.ResourceManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class ActionPanelFactory implements PanelFactory{

    private TrueTypeFont actionPanelFont;

    public ActionPanelFactory() {
        actionPanelFont = ResourceManager.getInstance().eightBitWonder;
    }
    
    @Override
    public Panel createPanel(GameContainer gc) throws SlickException{
        Panel testPanel = new TestPanelFactory().createPanel(gc);
        Panel actionPanel = new Panel(  gc,
                                        gc.getWidth()-gc.getWidth()/3, 
                                        gc.getHeight()/2, 
                                        gc.getHeight()/2, 
                                        gc.getWidth()/3,
                                        15
                                      );
        actionPanel.setOptions(new ArrayList<Option>(Arrays.asList(new Option(actionPanel, testPanel,  actionPanelFont, "Attack"),
                                                                    new Option(actionPanel, testPanel,  actionPanelFont, "Spell"),
                                                                    new Option(actionPanel, testPanel,  actionPanelFont, "Item"),
                                                                    new Option(actionPanel, testPanel,  actionPanelFont, "Wait"),
                                                                    new Option(actionPanel, testPanel,  actionPanelFont, "Sample"),
                                                                    new Option(actionPanel, testPanel,  actionPanelFont, "Sample"), 
                                                                    new Option(actionPanel, testPanel,  actionPanelFont, "Sample")
                                                                   )
                                                    )
                                );
        actionPanel.initPanel();
        testPanel.setParent(actionPanel);
        return actionPanel;
    }
    
}
