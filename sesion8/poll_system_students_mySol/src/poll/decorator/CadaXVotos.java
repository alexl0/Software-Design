package poll.decorator;

import poll.Poll;
import poll.observers.PollObserver;

public class CadaXVotos extends PollDecoratorAbstract {

	private int counter = 0, frequency = 0;

	public CadaXVotos(PollObserver pollObserver, int xVotos) {
		super(pollObserver);
		this.frequency = xVotos;
		this.counter = xVotos;
	}

	@Override
	boolean abstractCondicion(Poll poll) {
		if (counter == frequency) {
			counter = 1;
			return true;
		} else {
			counter++;
			return false;
		}
	}

}
