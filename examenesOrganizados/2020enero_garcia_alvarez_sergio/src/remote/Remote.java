package remote;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import actions.Action;
import tv.TV;

/**
 * 
 * @author UO240230
 * El mando ya no funciona con un enumerado, ahora contiene una lista de Action, 
 * en el metodo buttonPressed ya no hay sentencias condicioneles para que cada boton
 * efectue la accion correspondiente. Ahora solo llamammos al boton que nos pasen por
 * parametro.Hemos encapsulado los comportamientos en clases que saben como ejecutarse
 * y saben el icono que tienen
 *
 */
public class Remote 
{
	
	private List<Action> buttons = new ArrayList<Action>();
	
	public Remote() {
		// TODO Auto-generated constructor stub
	}
	
	public Remote(List<Action> buttons) {
		this.buttons = buttons;
	}
		
	private TV tv = new TV();
	
	public void buttonPressed(int button)
	{
		buttons.get(button - 1).execute();
	}
	
	public void show(PrintStream output)
	{
		output.println();
		output.println("Botones:");
		int buttonNumber = 1;
		for (Action each : buttons) {
			output.printf("  %d. %s\n", buttonNumber, each.getButtonIcon());
			buttonNumber++;
		}
		output.println();
	}
	
	public void addAction(int pos, Action a) {
		this.buttons.remove(pos - 1);
		this.buttons.add(pos-1, a);
	}
	
	public void setButtons(List<Action> buttons) {
		this.buttons = buttons;
	}

}
