package google.maps.mapElements;

import google.maps.Coordinates;
import google.maps.MapElement;
import model.Photo;

public class PhotoMapElementImpl implements MapElement {

	public Photo photo;

	public PhotoMapElementImpl(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String getTitle() {
		return photo.getDescription();
	}

	@Override
	public Coordinates getCoordinates() {
		return photo.getCoordinates();
	}

	@Override
	public String getHTMLInfo() {
		return photo.getDescription() + ", Foto de: " + photo.getUser();
	}

	@Override
	public void open() {
		System.out.println("Abriendo la foto: " + photo.getDescription());
	}

}
