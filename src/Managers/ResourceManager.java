
package Managers;

import Interface.ActionPanelFactory;
import Interface.MainMenuPanelFactory;
import Interface.Panel;
import Interface.TargetOverlay;
import java.awt.Font;
import java.io.InputStream;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.ResourceLoader;

public class ResourceManager {

    private static final ResourceManager INSTANCE = new ResourceManager();
    
    /*===============
     * Maps
     ===============*/
    public TiledMap level010Map;
    public TiledMap level110Map;
    
    /*=============== 
     * Images
     ===============*/
    /* Interface Images*/
    public Image panelBackground;
    public Image forestSceneBackground;
    public Image targetIndicator;
    
    /*===============
     * SpriteSheets
     ===============*/
    /*User sheets*/
    public SpriteSheet userSheet;
    public SpriteSheet userWeaponAttackSheet;
    /*Enemy sheets*/
    public SpriteSheet guardSheet;
    /*Other sheets*/
    public SpriteSheet itemSheet;
        
    /*===============
     * Fonts
     ===============*/
    public TrueTypeFont eightBitWonder;  
    
    /*===============
     * Panels
     ===============*/
    public Panel mainMenuPanel;
    public Panel actionPanel;
    public Panel targetOverlay;
    
    
    private ResourceManager(){
        
    }
    
    public static ResourceManager getInstance(){
        return INSTANCE;
    }
    
    public void loadResources(GameContainer gc) throws SlickException{
        /*Fonts and Images must be loaded before Panels*/
        loadImages();
        loadSpriteSheets();
        loadMaps();
        loadFonts();
        loadPanels(gc);
       
    }   
    
    private void loadImages() throws SlickException{
        panelBackground = new Image("data/interface/panel.png");
        forestSceneBackground = new Image("data/battlescenes/forest.png");
        targetIndicator = new Image("data/interface/arrow_up.png");
    }
    
    private void loadSpriteSheets() throws SlickException{
        userSheet = new SpriteSheet(new Image("data/images/overworldsheet.png"), 15, 24, 2, 1);
        userWeaponAttackSheet = new SpriteSheet(new Image("data/images/userweaponattacksheet.png"), 23, 17, 6);
        
        guardSheet = new SpriteSheet(new Image("data/images/guardsheet.png"), 32,32,6,0);
        
        itemSheet = new SpriteSheet(new Image("data/images/item_sheet.png"), 32, 32, 2, 3);
    }
    
    private void loadMaps() throws SlickException{
        level010Map = new TiledMap("data/maps/level010.tmx");
        level110Map = new TiledMap("data/maps/level110.tmx");
    }
    
    private void loadPanels(GameContainer gc) throws SlickException{
        mainMenuPanel = new MainMenuPanelFactory().createPanel(gc);
        /* actionPanel requires targetOverlay to be loaded first */
        targetOverlay = new TargetOverlay(gc);
        actionPanel = new ActionPanelFactory().createPanel(gc);
        
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
