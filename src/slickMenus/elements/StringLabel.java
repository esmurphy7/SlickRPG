package slickMenus.elements;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.UnicodeFont;

/**
 * A label which can draw a string with a given font
 */
public class StringLabel extends Element {
	
	/**
	 * String to be drawn
	 */
	private String _string;

	/**
	 * Font to draw string with
	 */
	private UnicodeFont _font;
	
	/**
	 * Color string is drawn in
	 */
	private Color _color;
	
	/**
	 * StringLabel constructor
	 * @param string String to be drawn
	 * @param font Font to draw string with
	 * @param color color string is drawn in
	 */
	public StringLabel(String string, UnicodeFont font, Color color) {
		_string = string;
		_font = font;
		_color = color;
		_width = _font.getWidth(_string);
		_height = _font.getHeight(_string);
	}
	
	/**
	 * StringLabel constructor with a background image
	 * @param string String to be drawn
	 * @param font Font to draw string with
	 * @param color Color string is drawn in
	 * @param image Background image
	 */
	public StringLabel(String string, UnicodeFont font, Color color, Image image) {
		_string = string;
		_font = font;
		_color = color;
		_backgroundImage = image;
		_width = _backgroundImage.getWidth();
		_height = _backgroundImage.getHeight();
	}

	/**
	 * Draw this StringLabel to the window
	 */
	@Override
	public void draw(float frameX, float frameY) {
		super.draw(frameX, frameY);
		_font.drawString(frameX + _xPos, frameY + _yPos, _string, _color);
	}
	
	public void setString(String string) {
		_string = string;
	}

}
