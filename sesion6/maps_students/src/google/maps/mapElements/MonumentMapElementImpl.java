package google.maps.mapElements;

import google.maps.GPS;
import model.Monument;

public class MonumentMapElementImpl extends AbstractMapElementImpl {

	Monument monument;
	
	public MonumentMapElementImpl(Monument monument) {
		super(monument.getName(), GPS.getCoordinates(monument.getAddress()), (monument.getName()+", "+monument.getAuthor()));
		this.monument=monument;
	}

	@Override
	public void open() {
		GPS.getDirectionsTo(monument.getAddress());
		
	}


}
