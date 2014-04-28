package slickMenus.layouts;

import java.util.LinkedList;
import slickMenus.elements.Element;

/**
 * This LayoutManager organizes elements in a horizontal row
 */
public class HorizontalLayout implements LayoutManager {

	/**
	 * Updates the position of all elements passed to this manager.
	 * @param list List of elements
	 * @param x X coordinate of top left corner
	 * @param y Y coordinate of top let corner
	 * @return Returns the width and height of this layout.
	 */
	@Override
	public float[] updateLayout(LinkedList<Element> list) {
		float width = 0f;
		float height = 0f;
		for (Element e : list) {
			e.setPosX(width + e.getPadX());
			width += e.getWidth() + 2 * e.getPadX();
			float tempHeight = e.getHeight() + 2 * e.getPadY();
			if (tempHeight > height) height = tempHeight;
		}
		for (Element e : list) {
			e.setPosY((height - e.getHeight()) / 2);
		}
		return  new float[] {width, height};
	}

}
