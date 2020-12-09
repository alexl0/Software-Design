import java.io.IOException;

import poll.Poll;
import poll.decorator.APartirDeTalVoto;
import poll.observers.BarChartObserver;
import poll.observers.LineaEstadoObserver;
import poll.observers.PieChartObserver;
import ui.Interviewer;

public class Main4 {
	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");

		poll.addObserver(new APartirDeTalVoto(new BarChartObserver(),3));
		//poll.addObserver(new LineaEstadoObserver());
		//poll.addObserver(new APartirDeTalVoto(new PieChartObserver(),1));

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}
}
