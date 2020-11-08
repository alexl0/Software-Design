import java.io.IOException;

import poll.Poll;
import ui.Interviewer;

public class Programa1 {
	
	public static void main(String[] args) throws IOException{
		Poll poll = new Poll("¿Está a favor de la energia nuclear?", true, true, true);

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}

}
