import java.io.IOException;

import poll.Poll;
import poll.observers.LineaEstadoObserver;
import poll.observers.PieChartObserver;
import ui.Interviewer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");

		poll.addObserver(new LineaEstadoObserver());
		poll.addObserver(new PieChartObserver());

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}
}
