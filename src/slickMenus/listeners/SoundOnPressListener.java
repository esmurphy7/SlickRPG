package slickMenus.listeners;

import org.newdawn.slick.Sound;

import slickMenus.elements.Element;

/**
 * Listener used to play a sound every time an element is pressed on
 */
public class SoundOnPressListener implements ActionListener {

	/** 
	 * Sound to play when element is pressed
	 */
	private Sound _sound;
	
	/**
	 * SoundOnPressListener constructor specifying the sound to play
	 * @param s slick sound object to play when element is pressed
	 */
	public SoundOnPressListener(Sound s) {
		_sound = s;
	}
	
	@Override
	public void mousePressed(int button, int x, int y, Element e) {
		if (e.inRect(x, y)) _sound.play();
	}

	@Override
	public void mouseReleased(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseMoved(int oldX, int oldY, int newX, int newY, Element e) {
	}

	@Override
	public void update(int delta, Element e) {
	}

}
