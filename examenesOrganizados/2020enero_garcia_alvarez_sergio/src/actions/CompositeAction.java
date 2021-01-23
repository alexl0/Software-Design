package actions;

import java.util.List;

public class CompositeAction implements Action{

	private List<Action> actions;
	private String name;
	
	public CompositeAction(String name, List<Action> actions) {
		this.name = name;
		this.actions = actions;
	}
	
	@Override
	public void execute() {
		for(Action a: actions) {
			a.execute();
		}
	}
	
	public void add(Action a) {
		actions.add(a);
	}
	
	public void remove(Action a) {
		actions.remove(a);
	}

	@Override
	public String getButtonIcon() {
		return name;
	}

}
