package poll.decorator;

import poll.Poll;
import poll.observers.PollObserver;

public class APartirDeTalVoto extends PollDecoratorAbstract {

	private int talVoto;

	public APartirDeTalVoto(PollObserver pollObserver, int talVoto) {
		super(pollObserver);
		this.talVoto = talVoto;
	}

	@Override
	boolean abstractCondicion(Poll poll) {
		if (poll.getNos() + poll.getYeses() >= talVoto)
			return true;
		return false;
	}

}
