package slickMenus.layouts;

import java.util.LinkedList;
import slickMenus.elements.Element;

/**
 * This LayoutManager organizes elements in a vertical column. If the
 * layout is set to have a fixed width and the maximum width
 * of an element in the frame using this layout is greater than this 
 * value, than the width of the element will be returned as the width
 * of the layout when updateLyout is called. If the layout is set to have
 * a fixed height which is greater than the total height, all elements 
 * will be centered in the fixed height with the space between them remaining
 * unchanged.
 */
public class VerticalLayout implements LayoutManager {

	/**
	 * Value which indicates left alignment
	 */
	public static final int LEFT = 0;
	
	/**
	 * Value which indicates center alignment
	 */
	public static final int CENTER = 1;
	
	/**
	 * Value which indicates right alignment
	 */
	public static final int RIGHT = 2;
	
	/**
	 * Fixed width of the frame using this layout. If the maximum width
	 * of an element in the frame using this layout is greater than this 
	 * value, than the width of the element will be returned as the width
	 * of the layout when updateLyout is called.
	 */
	private float _width;
	
	/**
	 * Fixed height of the frame using this layout. If the total height
	 * of the layout is greater than this value, the total height will be 
	 * returned as the height when updateLayout is called.
	 */
	private float _height;
	
	/**
	 * Determines alignment of this layout. A value of 0 is left aligned, a 
	 * value of 1 is centered, a value of 2 is right aligned.
	 */
	private int _alignment;
	
	/**
	 * VerticalLayout constructor with a default alignment of CENTER
	 */
	public VerticalLayout() {
		this(1);
	}
	
	/**
	 * VerticalLayout constructor with a specified alignment value
	 * @param alignment Alignment to use. A value of 0 is left aligned, a 
	 * value of 1 is centered, a value of 2 is right aligned. If the given 
	 * alignment is not one of these values, this layout manager will not 
	 * adjust the position of any elements.
	 */
	public VerticalLayout(int alignment) {
		this(alignment, 0, 0);
	}
	
	/**
	 * VerticalLayout constructor with a specified alignment and a fixed
	 * width and height. If you do not want either width or height to be 
	 * fixed, set their value to zero.
	 * @param alignmentAlignment to use. A value of 0 is left aligned, a 
	 * value of 1 is centered, a value of 2 is right aligned. If the given 
	 * alignment is not one of these values, this layout manager will not 
	 * adjust the position of any elements.
	 * @param width Desired fixed width. If this value is less than the width
	 * maximum width of an element, that maximum width will be used.
	 * @param height Desired fixed height. If this value is less than the 
	 * total height of the elements in the frame using this layout, the total
	 * height will be used.
	 */
	public VerticalLayout(int alignment, float width, float height) {
		_alignment = alignment;
		_width = width;
		_height = height;
	}
	
	/**
	 * Set the new alignment for this VerticalLayout
	 * @param alignment Alignment to use. A value of 0 is left aligned, a 
	 * value of 1 is centered, a value of 2 is right aligned.
	 */
	public void setAlignment(int alignment) {
		_alignment = alignment;
	}
	
	/**
	 * Update the position of all elements passed to this manager.
	 * @param list List of elements
	 * @param x X coordinate of top left corner
	 * @param y Y coordinate of top let corner
	 * @return Returns the width and height of this layout
	 */
	@Override
	public float[] updateLayout(LinkedList<Element> list) {
		float width = 0f;
		float height = 0f;
		switch(_alignment) {
		case LEFT: 
			for (Element e: list) {
				e.setPosY(height + e.getPadY());
				height += e.getHeight() + 2 * e.getPadY();
				e.setPosX(e.getPadX());
				float tempWidth = e.getWidth() + 2 * e.getPadX();
				if (tempWidth > width) width = tempWidth;
			}
			width = (_width < width) ? width : _width;
		break;
		case CENTER: 
			for (Element e : list) {
				e.setPosY(height + e.getPadY());
				height += e.getHeight() + 2 * e.getPadY();
				float tempWidth = e.getWidth() + 2 * e.getPadX();
				if (tempWidth > width) width = tempWidth;
			}
			width = (_width < width) ? width : _width;
			for (Element e : list) {
				e.setPosX((width - e.getWidth()) / 2);
			}
			break;
		case RIGHT: 
			for (Element e : list) {
				e.setPosY(height + e.getPadY());
				height += e.getHeight() + 2 * e.getPadY();
				float tempWidth = e.getWidth() + 2 * e.getPadX();
				if (tempWidth > width) width = tempWidth;
			}
			width = (_width < width) ? width : _width;
			for (Element e : list) {
				e.setPosX(width - (e.getWidth() + e.getPadX()));
			}
			break;
		default: break;
		}
		if (_height > height) {
			float yDiff = (_height - height) / 2;
			for (Element e : list) {
				e.setPosY(e.getPosY() + yDiff);
			}
			height = _height;
		}
		return new float[] {width, height};
	}

}
