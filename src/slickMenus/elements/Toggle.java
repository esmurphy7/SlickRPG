package slickMenus.elements;

import org.newdawn.slick.Image;

import slickMenus.listeners.ActionListener;

/**
 * A toggle switch that can have a true or false state. Creating 
 * a toggle automatically creates an ActionListener that changes the 
 * state of the toggle when it is pressed. In order to change a setting 
 * with a Toggle, you should add a ToggleListener.
 */
public class Toggle extends Element {
	
	/**
	 * Image to be shown when the state of this toggle is true
	 */
	private Image _trueImage;
	
	/**
	 * Image to be shown when the state of this toggle is false
	 */
	private Image _falseImage;
	
	/**
	 * Current state of the toggle
	 */
	private boolean _state;

	/**
	 * Constructs a Toggle
	 * @param trueImage Image to draw when the state is true
	 * @param falseImage Image to draw when the state is false
	 * @param initState the initial state of the toggle
	 */
	public Toggle(Image trueImage, Image falseImage, boolean initState) {
		_trueImage = trueImage;
		_falseImage = falseImage;
		_state = initState;
		if (_state) {
			_width = _trueImage.getWidth();
			_height = _trueImage.getHeight();
		}
		else {
			_width = _falseImage.getWidth();
			_height = _falseImage.getHeight();
		}
		
		addActionListener(new ToggleListener(this));
	}
	
	/**
	 * Draws the backgroundImage, and the draws the correct image based on
	 * the state of the toggle.
	 */
	@Override
	public void draw(float frameX, float frameY) {
		super.draw(frameX, frameY);
		if (_state) _trueImage.draw(frameX + _xPos, frameY +_yPos);
		else _falseImage.draw(frameX + _xPos, frameY + _yPos);
	}
	
	/**
	 * Negates the state of this toggle
	 */
	private void toggle() {
		_state = !_state;
	}
	
	/**
	 * Returns the state of this toggle
	 * @return The state of this toggle
	 */
	public boolean getState() {
		return _state;
	}
	
	private class ToggleListener implements ActionListener {

		private Toggle _toggle;
		
		public ToggleListener(Toggle t) {
			_toggle = t;
		}
		
		@Override
		public void mousePressed(int button, int x, int y, Element e) {
		}

		@Override
		public void mouseReleased(int button, int x, int y, Element e) {
			if (e.inRect(x, y)) _toggle.toggle();
		}

		@Override
		public void mouseMoved(int oldX, int oldY, int newX, int newY, Element e) {
		}

		@Override
		public void update(int delta, Element e) {
		}
		
	}

}
