package poll.observers;

import java.util.Observable;
import java.util.Observer;

public class SaveResultsObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Guardando los resultados...");
	}

}
