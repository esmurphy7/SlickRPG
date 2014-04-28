package slickMenus;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

/**
 * A menu which can hold elements and responds to user input. Creating a 
 * MenuContainer also creates a MouseListener which is added to the game 
 * container. The enter and leave method should be called in the enter and 
 * leave method of the state the menu is in in order to begin receiving 
 * input when the state is entered and to stop when the program leaves 
 * the state.
 */
public class MenuContainer extends slickMenus.elements.Frame{
	
	/**
	 * determines if this menu should be updated
	 */
	private boolean _acceptingInput;
	
	/**
	 * GameContainer that this menu belongs to
	 */
	private GameContainer _gc;
	
	/**
	 * Constructs a new menu container at the specified position
	 * @param x x coordinate of top left corner
	 * @param y y coordinate of top left corner 
	 */
	public MenuContainer(float x, float y, GameContainer gc) {
		_xPos = x;
		_yPos = y;
		_gc = gc;
		_gc.getInput().addMouseListener(new MenuListener(this));
	}
	
	/**
	 * Sets MouseListener to accept input. Call when entering a state
	 * containing this menu.
	 */
	public void enter() {
		_acceptingInput = true;
	}
	
	/**
	 * Sets MouseListener to not accept input. Call when leaving a state
	 * containing this menu.
	 */
	public void leave() {
		_acceptingInput = false;
	}
	
	/**
	 * Draw the contents of the menu
	 */
	public void draw() {
		super.draw(0, 0);
	}
	
	/**
	 * MouseListener for this MenuConainer. Notifies the elements in this 
	 * MenuContainer of mouse input.
	 */
	private class MenuListener implements MouseListener {

		private MenuContainer _container;
		
		public MenuListener(MenuContainer mc) {
			_container = mc;
		}
		
		@Override
		public void inputEnded() {
		}

		@Override
		public void inputStarted() {
		}

		@Override
		public boolean isAcceptingInput() {
			return _acceptingInput;
		}

		@Override
		public void setInput(Input arg0) {
		}

		@Override
		public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		}

		@Override
		public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		}

		@Override
		public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
			_container.mouseMoved(arg0, arg1, arg2, arg3);
		}

		@Override
		public void mousePressed(int arg0, int arg1, int arg2) {
			_container.mousePressed(arg0, arg1, arg2);
		}

		@Override
		public void mouseReleased(int arg0, int arg1, int arg2) {
			_container.mouseReleased(arg0, arg1, arg2);
		}

		@Override
		public void mouseWheelMoved(int arg0) {
		}
		
	}
	
}

