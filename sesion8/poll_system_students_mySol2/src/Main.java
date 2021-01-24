import java.io.*;

import poll.*;
import poll.observer.BarChart;
import poll.observer.LineaEstado;
import poll.observer.PieChart;
import poll.observer.decorator.APartirDeTalVoto;
import poll.observer.decorator.CadaXVotos;
import ui.Interviewer;

public class Main {
	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");

		poll.addObserver(new BarChart());
		poll.addObserver(new LineaEstado());
		//poll.addObserver(new APartirDeTalVoto(new PieChart(), 3) );
		poll.addObserver(new APartirDeTalVoto(new CadaXVotos(new PieChart(), 2), 4 ));
		
		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}
}
