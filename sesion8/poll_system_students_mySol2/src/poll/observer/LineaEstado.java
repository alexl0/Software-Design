package poll.observer;

import poll.Poll;

public class LineaEstado implements Observer {

	@Override
	public void update(Poll poll) {
		System.out.println("Si: " + poll.getYeses() + ", No: " + poll.getNos());
	}

}
