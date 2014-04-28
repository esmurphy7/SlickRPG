package slickMenus.listeners;

import slickMenus.elements.Element;

/** 
 * The listener interface for receiving action events
 */
public interface ActionListener {

	/**
	 * Action taken when mouse is pressed
	 * @param button button which is pressed
	 * @param x x position
	 * @param y y position
	 * @param e Element which is calling this method on this ActionListener
	 */
	public void mousePressed(int button, int x, int y, Element e);
	
	/**
	 * Action taken when mouse is released
	 * @param button button which is pressed
	 * @param x x position
	 * @param y y position
	 * @param e Element which is calling this method on this ActionListener
	 */
	public void mouseReleased(int button, int x, int y, Element e);
	
	/**
	 * Action performed when mouse is hovering over element. 
	 * @param oldX previous x position
	 * @param oldY previous y position
	 * @param newX new x position
	 * @param newY new y position
	 * @param e Element which is calling this method on this ActionListener
	 */
	public void mouseMoved(int oldX, int oldY, int newX, int newY, Element e);
	
	/**
	 * Updates to make once per frame
	 * @param delta time passed since last frame in milliseconds
	 * @param e Element which is calling this method on this ActionListener
	 */
	public void update(int delta, Element e);
}
