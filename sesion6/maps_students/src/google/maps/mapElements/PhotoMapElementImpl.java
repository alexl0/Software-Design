package google.maps.mapElements;
import model.Photo;

public class PhotoMapElementImpl extends AbstractMapElementImpl {

	public PhotoMapElementImpl(Photo photo) {
		super(photo.getDescription(), photo.getCoordinates(), photo.getDescription()+", Foto de: "+photo.getUser());
	}

	@Override
	public void open() {
		System.out.println("Abriendo la foto: "+super.getTitle());
	}

}
