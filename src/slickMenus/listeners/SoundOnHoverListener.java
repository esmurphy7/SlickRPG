package slickMenus.listeners;

import org.newdawn.slick.Sound;

import slickMenus.elements.Element;

/**
 * Listener used to play a sound every time an element is hovered over.
 * Sound is only played when the mouse moves from a position outside the
 * element to a position inside the element. 
 */
public class SoundOnHoverListener implements ActionListener {

	/** 
	 * Sound to play when element is pressed
	 */
	private Sound _sound;
	
	/**
	 * SoundOnHoverListener constructor specifying the sound to play
	 * @param s slick sound object to play when element is hovered over
	 */
	public SoundOnHoverListener(Sound s) {
		_sound = s;
	}
	
	@Override
	public void mousePressed(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseReleased(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseMoved(int oldX, int oldY, int newX, int newY, Element e) {
		if (!e.inRect(oldX, oldY) && e.inRect(newX, newY)) _sound.play();
	}

	@Override
	public void update(int delta, Element e) {
	}

}
