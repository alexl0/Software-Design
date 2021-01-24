package poll.observers;

import poll.Poll;

public class LineaEstadoObserver implements PollObserver {

	@Override
	public void update(Poll poll) {
		System.out.println("nº de votos SI = " + poll.getYeses() + "   nº de votos NO = " + poll.getNos());
	}

}
