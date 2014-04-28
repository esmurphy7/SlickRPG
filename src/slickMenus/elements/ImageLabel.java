package slickMenus.elements;

import org.newdawn.slick.Image;

/**
 * A label which can draw an image
 */
public class ImageLabel extends Element {

	/**
	 * Label constructor specifying an image to use
	 * @param image A slick2d Image
	 */
	public ImageLabel(Image image) {
		_backgroundImage = image;
		_width = _backgroundImage.getWidth();
		_height = _backgroundImage.getHeight();
	}
	
	/**
	 * Set the image for this label
	 * @param image image that the label will contain
	 */
	public void setImage(Image image) {
		_backgroundImage = image;
		_width = _backgroundImage.getWidth();
		_height = _backgroundImage.getHeight();
	}

}
