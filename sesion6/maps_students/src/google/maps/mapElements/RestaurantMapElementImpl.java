package google.maps.mapElements;
import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Restaurant;

public class RestaurantMapElementImpl implements MapElement {

	Restaurant restaurant;

	public RestaurantMapElementImpl(Restaurant restaurant) {
		this.restaurant=restaurant;
	}

	@Override
	public String getTitle() {
		return restaurant.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return GPS.getCoordinates(restaurant.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return restaurant.getName();
	}

	@Override
	public void open() {
		System.out.println("Llamando a "+restaurant.getName()+": "+restaurant.getPhone());
	}


}
