package slickMenus.listeners;

import slickMenus.elements.Toggle;

/**
 * An ActionListener intended to only by used by a Toggle. This should be 
 * implemented by reading the state of the specified toggle using the getState
 * method and then using that to carry out the desired action. The state is 
 * automatically toggled by the built in ActionListener of a Toggle, so that 
 * should not be done with this class.
 */
public abstract class ToggleListener implements ActionListener {

	/**
	 * Toggle that this listener will read the state from
	 */
	private Toggle _toggle;
	
	/**
	 * Constructs a ToggleListener with a specified toggle to read the 
	 * state from
	 * @param t The Toggle this listener will read the state from.
	 */
	public ToggleListener(Toggle t) {
		_toggle = t;
	}

}
