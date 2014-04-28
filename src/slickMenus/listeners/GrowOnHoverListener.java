package slickMenus.listeners;

import slickMenus.elements.Element;

/**
 * Listener used to increase the scale of an element when the mouse hovers
 * over it
 */
public class GrowOnHoverListener implements ActionListener {

	/**
	 * The max scale for the element to be drawn at. The element will
	 * continue growing until its scale reaches this value.
	 */
	private float _maxScale;
	
	/**
	 * The amount to increase scale by every millisecond
	 */
	private float _scaleStep;
	
	/**
	 * GrowOnHoverListener constructor specifying the max scale and scale step
	 * @param maxScale The max scale for the element to be drawn at. The element will
	 * @param scaleStep The amount to increase scale by every millisecond
	 */
	public GrowOnHoverListener(float maxScale, float scaleStep) {
		_maxScale = maxScale;
		_scaleStep = scaleStep;
	}
	
	@Override
	public void mousePressed(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseReleased(int button, int x, int y, Element e) {
	}

	@Override
	public void mouseMoved(int oldX, int oldY, int newX, int newY, Element e) {
	}

	@Override
	public void update(int delta, Element e) {
		float scale = e.getScale();
		if (scale > 1.0f && !e.isOver()) {
			e.setScale(scale - _scaleStep * delta);
			if (e.getScale() < 1.0f) e.setScale(1.0f);
		}
		else if (e.isOver() && scale < _maxScale) {
			e.setScale(scale + _scaleStep * delta);
			if (e.getScale() > _maxScale) e.setScale(_maxScale);
		}
	}

}
