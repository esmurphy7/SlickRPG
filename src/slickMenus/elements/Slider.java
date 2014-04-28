package slickMenus.elements;

import org.newdawn.slick.Image;

import slickMenus.listeners.ActionListener;

/**
 * A slider switch that 
 */
public class Slider extends ImageLabel {

	/**
	 * The handle that displays the current value of the slider
	 */
	private ImageLabel _handle;
	
	/**
	 * The current value of the slider, a float between 0 and 1.
	 */
	private float _val;
	
	/**
	 * Tracks whether the handle has been pressed
	 */
	private boolean _isPressed;
	
	/**
	 * Constructs a new slider
	 * @param bgImage 
	 * @param handleImage
	 * @param initVal
	 */
	public Slider(Image bgImage, Image handleImage, float initVal) {
		super(bgImage);
		_handle = new ImageLabel(handleImage);
		_handle.setPosY(_height / 2 - _handle.getHeight() / 2);
		if (initVal >= 0f && initVal <= 1f) _val = initVal;
		else if (initVal < 0) _val = 0f;
		else if (initVal > 1) _val = 1f;
		_handle.setPosX(_width * _val - _handle.getWidth() / 2);
		addActionListener(new SliderListener(this));
	}
	
	/**
	 * Draw the background image and then the handle
	 * @param frameX x coordinate of containing frame
	 * @param frameY y coordinate of containing frame
	 */
	@Override
	public void draw(float frameX, float frameY) {
		super.draw(frameX, frameY);
		_handle.draw(frameX + _xPos, frameY + _yPos);
	}
	
	private void setVal(float val) {
		_val = val;
		_handle.setPosX(_width * _val - _handle.getWidth() / 2);
	}
	
	public float getVal() {
		return _val;
	}
	
	public boolean isPressed() {
		return _isPressed;
	}

	public void setIsPressed(boolean isPressed) {
		_isPressed = isPressed;
	}

	private class SliderListener implements ActionListener {
		
		private Slider _slider;
		
		public SliderListener(Slider s) {
			_slider = s;
		}

		@Override
		public void mousePressed(int button, int x, int y, Element e) {
			if (_slider.inRect(x, y)) {
				_slider.setVal(x / _slider.getWidth());
				_slider.setIsPressed(true);
			}
		}

		@Override
		public void mouseReleased(int button, int x, int y, Element e) {
			_slider.setIsPressed(false);
		}

		@Override
		public void mouseMoved(int oldX, int oldY, int newX, int newY, Element e) {
			if (_slider.isPressed()) _slider.setVal(newX / _slider.getWidth());
		}

		@Override
		public void update(int delta, Element e) {
		}
		
	}
}
