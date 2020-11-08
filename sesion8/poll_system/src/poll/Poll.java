package poll;

public class Poll implements PollInterface
{
	private int yeses, nos;
	private String question;
	private boolean barChart;
	private boolean pieChart;
	private boolean lineState;

	/**
	 * Se le pasa en el constructor los graficos que quiere que salgan
	 * @param question
	 * @param barChart
	 * @param pieChart
	 * @param lineState
	 */
	public Poll(String question, boolean barChart, boolean pieChart, boolean lineState) 
	{
		this.question = question;
		this.barChart=barChart;
		this.pieChart=pieChart;
		this.lineState=lineState;
	}
	public Poll(String question) 
	{
		this(question,true,true,false);
	}

	public String getQuestion() 
	{
		return question;
	}
	public int getYeses() 
	{
		return yeses;
	}
	public int getNos() 
	{
		return nos;
	}
	
	public void incrementYeses() 
	{
		yeses++;
		updateAndSave();
	}
	public void incrementNos() 
	{
		nos++;
		updateAndSave();
	}

	private void updateAndSave() {
		if(pieChart)
			updatePieChart();
		if(barChart)
			updateBarChart();
		if(lineState)
			updateLineState();
		saveResults();
	}
	
	private void updateBarChart() 
	{
		System.out.println("Dibujando un gráfico de barras...");
	}
	private void updatePieChart() 
	{
		System.out.println("Dibujando un gráfico circular...");
	}
	private void updateLineState() 
	{
		System.out.println("nº de votos SI = "+ getYeses() +". nº de votos NO = "+getNos());
	}
	private void saveResults() 
	{
		System.out.println("Guardando los resultados...");
	}

}
