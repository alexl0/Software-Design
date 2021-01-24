package slides.layout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import slides.content.Placeholder;

public class Layout implements Cloneable {
	// asocia los marcadores de posición de esta disposición con la posición
	// que ocupan en el mismo (simulada aquí mediante una simple cadena de texto
	// como "CENTER", "TOP", "BOTTOM_LEFT" o similares; en un caso real sería
	// un objeto con toda la información necesaria para cada tipo de layout)
	private Map<Placeholder, String> positions = new LinkedHashMap<>();
	// los marcadores de posición (títulos, listas, imágenes...) de este layout
	private List<Placeholder> placeholders = new ArrayList<>();

	private LayoutType type;

	public Layout(LayoutType type) {
		this.type = type;
	}

	public LayoutType getType() {
		return type;
	}

	public void addPlaceholder(String position, Placeholder placeholder) {
		placeholders.add(placeholder);
		positions.put(placeholder, position);
	}

	public List<Placeholder> getPlaceholders() {
		return Collections.unmodifiableList(placeholders);
	}

	public String getPosition(Placeholder placeholder) {
		if (!positions.containsKey(placeholder))
			throw new IllegalArgumentException("Este layout no contiene ese marcador: " + placeholder);
		return positions.get(placeholder);
	}

	@Override
	public String toString() {
		return type.getText();
	}

//    public Layout clone() {
//    	try {
//    		//Layout layout = (Layout) super.clone();
//    		//layout.positions = new LinkedHashMap<>();
//    		//layout.positions.forEach((k,v) -> layout.positions.put(layou, value));
//    		
//		} catch (CloneNotSupportedException e) {
//			throw new RuntimeException(e);
//		}
//    }
}