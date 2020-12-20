package poll.observers.simple;

import poll.*;
import poll.observers.PollObserver;

public class StatusBar implements PollObserver
{
	@Override
	public void update(Poll poll)
	{
		System.out.printf("Barra de estado: número de síes: %d, número de noes: %d\n",
				poll.getYeses(), poll.getNos());
	}
}
