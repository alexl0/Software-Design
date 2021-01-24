package poll.observers;

import poll.Poll;

public class BarChartObserver implements PollObserver {

	@Override
	public void update(Poll poll) {
		System.out.println("Dibujando un gráfico de barras...");
	}

}
