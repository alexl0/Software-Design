package poll.decorator;

import poll.Poll;
import poll.observers.PollObserver;

public class CadaXVotos extends PollDecoratorAbstract {

	private int counter=0, frequency=0;

	public CadaXVotos(PollObserver pollObserver, int xVotos) {
		super(pollObserver);
		this.frequency=xVotos;
	}

	@Override
	boolean abstractCondicion(Poll poll) {
		if (counter == frequency) {
			counter = 1;
			System.out.println(counter+", "+frequency+"true");
			return true;
		}else {
			counter++;
			System.out.println(counter+", "+frequency+"false");
			return false;
		}
	}

}
