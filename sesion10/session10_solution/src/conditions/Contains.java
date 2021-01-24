package conditions;

public class Contains implements Condition {
	private String match;
	private int beginIndex, endIndex;

	public Contains(String match, int beginIndex, int endIndex) {
		this.match = match;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}

	@Override
	public boolean isTrue(String value) {
		return value.substring(beginIndex, endIndex).contains(match);
	}
}
