package poll.observer.decorator;

import poll.Poll;
import poll.observer.Observer;

public class APartirDeTalVoto implements Observer {

	Observer observer;
	int talVoto;
	
	public APartirDeTalVoto(Observer observer, int talVoto) {
		this.observer=observer;
		this.talVoto=talVoto;
	}
	
	@Override
	public void update(Poll poll) {
		if(poll.getYeses()+poll.getNos()>=talVoto)
			observer.update(poll);
	}

}
