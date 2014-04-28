
package Interface;

import java.awt.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;

public class ActionPanelFactory implements PanelFactory{

    private final UnicodeFont actionPanelFont;

    public ActionPanelFactory() {
        this.actionPanelFont = new UnicodeFont(new Font("Dialog", Font.PLAIN, 12));
    }
    
    @Override
    public Panel createPanel(GameContainer gc) throws SlickException{
        Image optionBackground = new Image("data/interface/optionbackground.png");
        Panel actionPanel = new Panel(gc.getWidth()-gc.getWidth()/3, 
                                      gc.getHeight()/2, 
                                      gc.getHeight()/2, 
                                      gc.getWidth()/3,
                                      15,
                                      new Option(optionBackground, this.actionPanelFont, "Attack"),
                                      new Option(optionBackground, this.actionPanelFont, "Spell"),
                                      new Option(optionBackground,this.actionPanelFont, "Item"),
                                      new Option(optionBackground, this.actionPanelFont, "Wait"),
                                      new Option(optionBackground, this.actionPanelFont, "Sample"),
                                      new Option(optionBackground, this.actionPanelFont, "Sample"), 
                                      new Option(optionBackground, this.actionPanelFont, "Sample")
                                      //new Option(new Image("data/interface/sampleoption.png"))
                                      );
        return actionPanel;
    }
    
}
