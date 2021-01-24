package poll.decorator;

import poll.Poll;
import poll.observers.PollObserver;

public abstract class PollDecoratorAbstract implements PollObserver {

	protected PollObserver pollObserver;

	public PollDecoratorAbstract(PollObserver pollObserver) {
		this.pollObserver = pollObserver;
	}

	@Override
	public void update(Poll poll) {
		if (abstractCondicion(poll))
			this.pollObserver.update(poll);
	}

	abstract boolean abstractCondicion(Poll poll);
}
