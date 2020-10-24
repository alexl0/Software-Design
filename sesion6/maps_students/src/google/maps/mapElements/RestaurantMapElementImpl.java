package google.maps.mapElements;
import google.maps.GPS;
import model.Restaurant;

public class RestaurantMapElementImpl extends AbstractMapElementImpl {

	Restaurant restaurant;
	
	public RestaurantMapElementImpl(Restaurant restaurant) {
		super(restaurant.getName(), GPS.getCoordinates(restaurant.getAddress()), restaurant.getName());
		this.restaurant=restaurant;
	}

	@Override
	public void open() {
		System.out.println("Llamando a "+super.getTitle()+": "+restaurant.getPhone());
	}

}
