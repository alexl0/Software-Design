package poll.observers.simple;

import poll.*;
import poll.observers.PollObserver;

public class BarChart implements PollObserver
{
	@Override
	public void update(Poll poll) 
	{
		System.out.println("Dibujando gráfico de barras...");
	}
}
