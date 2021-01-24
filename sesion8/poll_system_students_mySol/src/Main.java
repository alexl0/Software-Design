import java.io.*;

import poll.*;
import poll.observers.BarChartObserver;
import poll.observers.LineaEstadoObserver;
import poll.observers.PieChartObserver;
import ui.Interviewer;

public class Main {
	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");

		poll.addObserver(new BarChartObserver());
		poll.addObserver(new LineaEstadoObserver());
		poll.addObserver(new PieChartObserver());

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}
}
