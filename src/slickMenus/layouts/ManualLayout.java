package slickMenus.layouts;

import java.util.LinkedList;

import slickMenus.elements.Element;

/**
 * LayoutManager that does not change the position of elements. If using this
 * manager, the position of each element must be set manually. SThe dimensions 
 * of a frame using this layout are set to (0, 0) because the dimensions can 
 * not be meaningfully determined. For this reason, you should be careful in 
 * using this on a frame that is within another frame.
 */
public class ManualLayout implements LayoutManager {

	/**
	 * Does not change position of elements.
	 * @param list List of elements
	 * @param x X coordinate of top left corner
	 * @param y Y coordinate of top let corner
	 * @return Returns 0 as the width and height of the element.
	 */
	@Override
	public float[] updateLayout(LinkedList<Element> list) {
		return new float[] {0, 0};
	}

}
