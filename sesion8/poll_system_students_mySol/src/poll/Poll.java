package poll;

import java.util.ArrayList;
import java.util.List;

import poll.observers.PollObserver;

public class Poll {
	private int yeses, nos;
	private String question;
	private List<PollObserver> observers = new ArrayList<PollObserver>();

	public Poll(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public int getYeses() {
		return yeses;
	}

	public int getNos() {
		return nos;
	}

	public void incrementYeses() {
		yeses++;
		updateObservers(this);
	}

	public void incrementNos() {
		nos++;
		updateObservers(this);
	}

	public void addObserver(PollObserver pollObserver) {
		observers.add(pollObserver);
	}

	private void updateObservers(Poll poll) {
		for (PollObserver each : observers)
			each.update(poll);
	}
}
