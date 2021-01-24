package slides.layout;

import slides.ui.Canvas;

public interface LayoutType {
	void show(Canvas canvas, Layout layout);

	String getText();
}