package views.adapters;

import model.Monument;
import views.MapElement;
import components.*;

public class MonumentMapElement implements MapElement {
	private Monument monument;
	private GPS gps = new GPS();

	public MonumentMapElement(Monument monument) {
		this.monument = monument;
	}

	@Override
	public String getTitle() {
		return "Monumento: " + monument.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return gps.getCoordinates(monument.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return monument.getName() + ". Creado por " + monument.getAuthor() + "\n" + monument.getAddress();
	}

	@Override
	public void open() {
		gps.navigateTo(monument.getAddress());
	}
}
