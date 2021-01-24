package poll.observer.decorator;

import poll.Poll;
import poll.observer.Observer;

public class CadaXVotos implements Observer {

	Observer observer;
	int xVotos;
	
	public CadaXVotos(Observer observer, int xVotos) {
		this.observer=observer;
		this.xVotos=xVotos;
	}
	
	@Override
	public void update(Poll poll) {
		if( (poll.getYeses()+poll.getNos()) % xVotos ==0)
			observer.update(poll);
	}

}
