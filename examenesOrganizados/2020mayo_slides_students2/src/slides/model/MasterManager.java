package slides.model;

import java.util.HashMap;
import java.util.Map;

public class MasterManager {

	private Map<String, Slide> maestras;

	public MasterManager() {
		maestras = new HashMap<String, Slide>();
	}

	public void createMaster(String name, Slide slide) {
		maestras.put(name, slide);
	}

	public Slide getMaster(String name) {
		return maestras.get(name).clone();
	}
}
