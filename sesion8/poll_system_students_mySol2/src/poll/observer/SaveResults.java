package poll.observer;

import poll.Poll;

public class SaveResults implements Observer {

	@Override
	public void update(Poll poll) {
		System.out.println("Guardando los resultados...");
	}

}
