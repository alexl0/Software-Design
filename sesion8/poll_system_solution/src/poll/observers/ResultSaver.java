package poll.observers;

import poll.Poll;

public class ResultSaver implements PollObserver
{
	@Override
	public void update(Poll poll) 
	{
		System.out.println("Guardando resultados...");
	}
}
