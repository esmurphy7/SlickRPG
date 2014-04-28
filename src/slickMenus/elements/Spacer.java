package slickMenus.elements;

/**
 * A Spacer is used in a menu to create an empty space of the desired 
 * size. While you can set a background image and add action listeners
 * to this element, its primary purpose is to assist in organizing a menu.
 */
public class Spacer extends Element {

	/**
	 * Constructs a Spacer with the given width and height
	 * @param width width of space
	 * @param height height of space
	 */
	public Spacer(float width, float height) {
		_width = width;
		_height = height;
	}
	
}
