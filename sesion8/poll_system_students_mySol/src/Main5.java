import java.io.IOException;

import poll.Poll;
import poll.decorator.APartirDeTalVoto;
import poll.decorator.CadaXVotos;
import poll.observers.BarChartObserver;
import poll.observers.LineaEstadoObserver;
import poll.observers.PieChartObserver;
import ui.Interviewer;

public class Main5 {
	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");

		poll.addObserver(new BarChartObserver());
		poll.addObserver(new APartirDeTalVoto(new CadaXVotos(new LineaEstadoObserver(),2),4));
		//Tambien valdria:
		//poll.addObserver(new CadaXVotos(new APartirDeTalVoto(new LineaEstadoObserver(),4),2));
		poll.addObserver(new PieChartObserver());

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}
}
