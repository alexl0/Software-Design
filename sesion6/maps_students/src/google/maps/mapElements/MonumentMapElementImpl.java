package google.maps.mapElements;

import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Monument;

public class MonumentMapElementImpl implements MapElement {

	Monument monument;

	public MonumentMapElementImpl(Monument monument) {
		this.monument=monument;
	}

	@Override
	public String getTitle() {
		return monument.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return GPS.getCoordinates(monument.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return (monument.getName()+", "+monument.getAuthor());
	}

	@Override
	public void open() {
		GPS.getDirectionsTo(monument.getAddress());

	}


}
