
package Interface;

import java.awt.Font;
import java.io.InputStream;
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
        try {
		InputStream inputStream	= ResourceLoader.getResourceAsStream("data/8-BIT WONDER.ttf");
 
		Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
		awtFont = awtFont.deriveFont(12f); // set font size
		testPanelFont = new TrueTypeFont(awtFont, false);
 
	} catch (Exception e) {
		e.printStackTrace();
	}
        Panel testPanel = new Panel(gc, 10,10,200,200,0, new Option(testPanelFont),
                                                    new Option(testPanelFont),
                                                    new Option(testPanelFont));
        return testPanel;
    }

}
