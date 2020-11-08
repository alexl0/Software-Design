import java.io.IOException;

import poll.Poll;
import poll.PollInterface;
import ui.Interviewer;

public class Programa3 {

	public static void main(String[] args) throws IOException {
		
		/**
		 * Hay que encontrar dónde poner el:
		 * 		if(n>3 && n%3==0)
		 * 			updatePieChart();
		 */
		
		PollInterface poll = new Poll("¿Está a favor de la energia nuclear?", false, true, true);

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}

}
