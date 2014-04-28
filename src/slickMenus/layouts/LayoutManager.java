package slickMenus.layouts;

import java.util.LinkedList;
import slickMenus.elements.Element;

/**
 * The interface for layout managers, which control the organization 
 * of elements in a frame.	
 */
public interface LayoutManager {
	
	/**
	 * Updates the position of all elements
	 * @param list List of elements
	 * @param x X coordinate of top left corner
	 * @param y Y coordinate of top let corner
	 * @return Returns the width and height of this layout
	 */
	public float[] updateLayout(LinkedList<Element> list);

}
