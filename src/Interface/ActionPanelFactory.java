
package Interface;

import Managers.ResourceManager;
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
        Panel actionPanel = new Panel(gc,
                                      gc.getWidth()-gc.getWidth()/3, 
                                      gc.getHeight()/2, 
                                      gc.getHeight()/2, 
                                      gc.getWidth()/3,
                                      15,
                                      new Option(actionPanelFont, testPanel,   "Attack"),
                                      new Option(actionPanelFont, testPanel,  "Spell"),
                                      new Option(actionPanelFont, testPanel, "Item"),
                                      new Option(actionPanelFont, testPanel, "Wait"),
                                      new Option(actionPanelFont, testPanel, "Sample"),
                                      new Option(actionPanelFont, testPanel, "Sample"), 
                                      new Option(actionPanelFont, testPanel,  "Sample")
                                      );
        return actionPanel;
    }
    
}
