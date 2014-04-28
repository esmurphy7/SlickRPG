
package Interface;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;

public abstract class UIComponent {

    private int x, y, height, width;
    private Image image;
    private TrueTypeFont font;
    private GameContainer container;
    private UIComponent parent;
    private UIComponent child;
 
    public abstract void update();
    public abstract void render(float x, float y);

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return the font
     */
    public TrueTypeFont getFont() {
        return font;
    }

    /**
     * @param font the font to set
     */
    public void setFont(TrueTypeFont font) {
        this.font = font;
    }

    /**
     * @return the container
     */
    public GameContainer getContainer() {
        return container;
    }

    /**
     * @param container the container to set
     */
    public void setContainer(GameContainer container) {
        this.container = container;
    }

    /**
     * @return the parent
     */
    public UIComponent getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(UIComponent parent) {
        this.parent = parent;
    }

    /**
     * @return the child
     */
    public UIComponent getChild() {
        return child;
    }

    /**
     * @param child the child to set
     */
    public void setChild(UIComponent child) {
        this.child = child;
    }
    
}
