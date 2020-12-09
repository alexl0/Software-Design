import java.io.IOException;

import poll.Poll;
import poll.decorator.APartirDeTalVoto;
import poll.observers.LineaEstadoObserver;
import poll.observers.PieChartObserver;
import ui.Interviewer;

public class Main3 {

	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");

		poll.addObserver(new LineaEstadoObserver());
		poll.addObserver(new APartirDeTalVoto(new PieChartObserver(),4));

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}

}
