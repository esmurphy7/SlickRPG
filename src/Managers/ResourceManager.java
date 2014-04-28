
package Managers;

import Interface.MainMenuPanelFactory;
import Interface.Panel;
import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class ResourceManager {

    private static final ResourceManager INSTANCE = new ResourceManager();
    
    /*
     * Fonts
     */
    public TrueTypeFont eightBitWonder;   
    /*
     * Panels
     */
    public Panel mainMenuPanel;
    
    private ResourceManager(){
        
    }
    
    public static ResourceManager getInstance(){
        return INSTANCE;
    }
    
    public void loadResources(GameContainer gc) throws SlickException{
        loadSpriteSheets();
        loadMaps();
        /*Fonts must be loaded before Panels*/
        loadFonts();
        loadPanels(gc);
       
    }   
    
    private void loadSpriteSheets(){
        
    }
    private void loadMaps(){
        
    }
    private void loadPanels(GameContainer gc) throws SlickException{
        mainMenuPanel = new MainMenuPanelFactory().createPanel(gc);
    }
    private void loadFonts(){
        try {
		InputStream inputStream	= ResourceLoader.getResourceAsStream("data/8-BIT WONDER.ttf");
		Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
                
		awtFont = awtFont.deriveFont(12f); // set font size
		eightBitWonder = new TrueTypeFont(awtFont, false);
 
	} catch (Exception e) {
		e.printStackTrace();
	}
    }

}
