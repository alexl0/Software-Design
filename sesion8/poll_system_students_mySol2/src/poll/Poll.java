package poll;

import java.util.ArrayList;
import java.util.List;

import poll.observer.Observer;

public class Poll {
	private int yeses, nos;
	private String question;

	private List<Observer> observers;

	public Poll(String question) {
		this.question = question;
		this.observers = new ArrayList<Observer>();
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
		updateObservers();
	}

	public void incrementNos() {
		nos++;
		updateObservers();
	}

	private void updateObservers() {
		for (Observer o : observers)
			o.update(this);
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

}
