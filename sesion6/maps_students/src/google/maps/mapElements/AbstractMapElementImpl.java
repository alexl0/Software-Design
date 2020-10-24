package google.maps.mapElements;

import google.maps.Coordinates;
import google.maps.MapElement;

public abstract class AbstractMapElementImpl implements MapElement {

	String title;
	Coordinates coordinates;
	String htmlInfo;
	
	public AbstractMapElementImpl(String title, Coordinates coordinates, String htmlInfo) {
		this.title=title;
		this.coordinates=coordinates;
		this.htmlInfo=htmlInfo;
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public Coordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public String getHTMLInfo() {
		return htmlInfo;
	}

	@Override
	public abstract void open();

}
