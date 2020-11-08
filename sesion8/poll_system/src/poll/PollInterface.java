package poll;

public interface PollInterface {

	public String getQuestion();
	public int getYeses();
	public int getNos();
	public void incrementYeses();
	public void incrementNos();
	
}
