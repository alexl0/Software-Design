package views.adapters;

import components.Coordinates;
import model.Photo;
import views.MapElement;

public class PhotoMapElement implements MapElement {
	private Photo photo;

	public PhotoMapElement(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String getTitle() {
		return "Foto: " + photo.getDescription();
	}

	@Override
	public Coordinates getCoordinates() {
		return photo.getCoordinates();
	}

	@Override
	public String getHTMLInfo() {
		return photo.getDescription() + " (foto de " + photo.getUser() + ")";
	}

	@Override
	public void open() {
		photo.show();
	}
}
