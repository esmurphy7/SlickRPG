package slickMenus.listeners;

import org.newdawn.slick.state.StateBasedGame;

import slickMenus.elements.Element;

/**
 * ActionListener which enters a given state. 
 */
public class EnterStateListener implements ActionListener {

	/**
	 * State ID which will be entered on action performed
	 */
	private int _state;
	
	/**
	 * StateBasedGame to change state of
	 */
	private StateBasedGame _sbg;
	
	/**
	 * EnterStateListener constructor
	 * @param state State ID which will be entered on action performed
	 * @param sbg StateBasedGame to change state of
	 */
	public EnterStateListener(int state, StateBasedGame sbg) {
		_state = state;
		_sbg = sbg;
	}

	@Override
	public void mousePressed(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseReleased(int button, int x, int y, Element e) {
		if (e.inRect(x, y)) _sbg.enterState(_state);
	}

	@Override
	public void mouseMoved(int oldX, int oldY, int newX, int newY, Element e) {
	}

	@Override
	public void update(int delta, Element e) {
	}

}
