
package Interface;

import Managers.ResourceManager;
import java.awt.Font;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.HieroSettings;
import org.newdawn.slick.util.ResourceLoader;

public class TestPanelFactory implements PanelFactory{

   private TrueTypeFont testPanelFont;
    
    @Override
    public Panel createPanel(GameContainer gc) throws SlickException {
        testPanelFont = ResourceManager.getInstance().eightBitWonder;
        Panel testPanel = new Panel(gc, 
                                    10,
                                    10,
                                    200,
                                    200,
                                    0
                                    );
        testPanel.setOptions(new ArrayList<Option>(Arrays.asList(new Option(testPanel, testPanelFont),
                                                                new Option(testPanel, testPanelFont),
                                                                new Option(testPanel, testPanelFont)
                                                                )
                                                    )
                            );
        testPanel.initPanel();
        return testPanel;
    }

}
