package slickMenus.elements;

import java.util.LinkedList;
import slickMenus.layouts.LayoutManager;
import slickMenus.layouts.ManualLayout;
import slickMenus.listeners.ActionListener;

/**
 * A frame which can contain other elements. Organization of elements
 * in the frame is controlled by the layout manager. The default layout 
 * manager is the manualLayout. A frame can hold other frames inside.
 */
public class Frame extends Element {
	
	/**
	 * List of all elements contained in frame
	 */
	private LinkedList<Element> _list = new LinkedList<Element>();
	
	/**
	 * Active LayoutManager for this frame
	 */
	private LayoutManager _layoutManager = new ManualLayout();
	
	/**
	 * Draw this frame and its contents to the window.
	 */
	public void draw() {
		super.draw(this._xPos, this._yPos);
		for (Element e : _list) {
			e.draw(this._xPos, this._yPos);
		}
	}

	/**
	 * Sets the active LayoutManager and updates layout
	 */
	public void setLayoutManager(LayoutManager layoutManager) {
		_layoutManager = layoutManager;
		updateLayout();
	}
	
	/**
	 * Add an element to this frame
	 * @param e Element to add
	 */
	public void add(Element e) {
		getList().add(e);
		updateLayout();
	}
	
	/**
	 * Updates the layout of elements
	 */
	public void updateLayout() {
		float[] dimensions = _layoutManager.updateLayout(getList());
		_width = dimensions[0];
		_height = dimensions[1];
	}

	public LinkedList<Element> getList() {
		return _list;
	}
	
	/**
	 * Adds an ActionListener to all elements contained in this frame, 
	 * but not to this frame itself.
	 * @param listener ActionListener to add
	 */
	public void addActionListenerAll(ActionListener listener) {
		for (Element e : _list) {
			e.addActionListener(listener);
		}
	}
	
	/**
	 * Calls mousePressed on each of this frame's actionListener and 
	 * each element in this frame
	 * @param button button which is pressed
	 * @param x x position
	 * @param y y position
	 */
	public void mousePressed(int button, int x, int y) {
		super.mousePressed(button, x, y);
		for (Element e : _list) {
			e.mousePressed(button, x, y);
		}
	}
	
	/**
	 * Calls mouseReleased on each of this frame's actionListeners and 
	 * each element in this frame
	 * @param button button which is pressed
	 * @param x x position
	 * @param y y position
	 */
	public void mouseReleased(int button, int x, int y) {
		super.mouseReleased(button, x, y);
		for (Element e : _list) {
			e.mouseReleased(button, x, y);
		}
	}
	
	/**
	 * Calls mouseHover on each of this frame's actionListeners and 
	 * each element in this frame
	 * @param oldX
	 * @param oldY
	 * @param newX
	 * @param newY
	 */
	public void mouseMoved(int oldX, int oldY, int newX, int newY) {
		super.mouseMoved(oldX, oldY, newX, newY);
		for (Element e : _list) {
			e.mouseMoved(oldX, oldY, newX, newY);
		}
	}
	
	/**
	 * Calls update on each of this frame's actionListeners and 
	 * each element in this frame
	 * @param delta Time since last frame
	 */
	public void update(int delta) {
		super.update(delta);
		for (Element e : _list) {
			e.update(delta);
		}
	}

}
