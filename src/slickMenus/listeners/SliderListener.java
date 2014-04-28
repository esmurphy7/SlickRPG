package slickMenus.listeners;
import slickMenus.elements.Slider;

/**
 * An ActionListener intended to only be used by a Slider. This should be
 * implemented by reading the value of the specified slider using the getVal
 * method and then using that to carry out the desired action. The value is 
 * automatically set by the built in ActionListener of a Slider, so that 
 * should not be done by this class.
 */
public abstract class SliderListener implements ActionListener {

	/**
	 * Slider that this listener will read the state from
	 */
	@SuppressWarnings("unused")
	private Slider _slider;

	/**
	 * Constructs a SliderListener with a specified slider to read the
	 * value from
	 * @param s The Slider this listener will read the value from
	 */
	public SliderListener(Slider s) {
		_slider = s;
	}
	
}
