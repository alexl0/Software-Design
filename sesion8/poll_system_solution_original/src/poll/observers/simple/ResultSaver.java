package poll.observers.simple;

import poll.Poll;
import poll.observers.PollObserver;

public class ResultSaver implements PollObserver
{
	@Override
	public void update(Poll poll) 
	{
		System.out.println("Guardando resultados...");
	}
}
