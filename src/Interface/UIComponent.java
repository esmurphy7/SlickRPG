
package Interface;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.TrueTypeFont;

public abstract class UIComponent {

    private int x, y, height, width;
    private Image image;
    private TrueTypeFont font;
    private GameContainer container;
    
 
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
    public TrueTypeFont getFont() {
        return font;
    }
    public void setFont(TrueTypeFont font) {
        this.font = font;
    }
    public GameContainer getContainer() {
        return container;
    }
    public void setContainer(GameContainer container) {
        this.container = container;
    }
    
}
