
package EntitySystem;

import org.newdawn.slick.geom.Rectangle;

public class PhysicalComponent extends EntityComponent{

    /*The position of the topleft of the bounding box*/
    private float xpos,ypos;
    private Rectangle boundingbox;
    
    public PhysicalComponent(Rectangle bb){
        boundingbox=bb;
        xpos=bb.getX();
        ypos=bb.getY();
    }

    public float getXpos() {
        return xpos;
    }

    public void setXpos(float xpos) {
        this.xpos = xpos;
        boundingbox.setX(xpos);
    }

    public float getYpos() {
        return ypos;
    }

    public void setYpos(float ypos) {
        this.ypos = ypos;
        boundingbox.setY(ypos);
    }

    public Rectangle getBoundingbox() {
        return boundingbox;
    }

    public void setBoundingbox(Rectangle boundingbox) {
        this.boundingbox = boundingbox;
    }
    
}
