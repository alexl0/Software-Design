package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import actions.Action;
import actions.CompositeAction;
import actions.NoActionButton;
import actions.airConditioner_actions.SetAirConditionerMode;
import actions.lamp_actions.TurnOffLamp;
import actions.lamp_actions.TurnOnLamp;
import actions.tv_actions.SwitchTVChannel;
import actions.tv_actions.TVVolumeDown;
import actions.tv_actions.TVVolumeUp;
import actions.tv_actions.TurnOnOffTV;
// dispositivos
import airconditioning.AirConditioner;
import airconditioning.AirConditioner.Mode;
import lamp.Lamp;
import remote.Remote;
import remote.ui.ButtonController;
import tv.TV;

public class Main 
{		
	private Remote remote = new Remote();
	private ButtonController controller = new ButtonController(remote);
	
	// los distintos dispositivos con los que interactúa el mando
	private Lamp lamp = new Lamp();
	private AirConditioner airConditioner = new AirConditioner();
	private TV tv = new TV();
		
	public static void main(String[] args) throws IOException
	{
		new Main().run();
	}
	
	private void run() throws IOException
	{
		
		//config1();
		//config2();
		config3();
		
		controller.run();
		
		// al terminar muestra el estado de los distintos dispositivos
		printDeviceStatus();
	}	
	
	private void config1()
	{
		List<Action> buttons = new ArrayList<Action>();
		buttons.add(new TurnOnOffTV(tv));
		buttons.add(new SwitchTVChannel(tv, 1));
		buttons.add(new SwitchTVChannel(tv, 3));
		buttons.add(new SwitchTVChannel(tv, 15));
		buttons.add(new TVVolumeUp(tv));
		buttons.add(new TVVolumeDown(tv));
		remote = new Remote(buttons);
		controller.setRemote(remote);
		/*
		 	1. Encender/apagar el televisor
		 	2. Poner el canal 1 del televisor
		 	3. Poner el canal 3 del televisor
		 	4. Poner el canal 15 del televisor
		 	5. Subir el volumen del televisor
		 	6. Bajar el volumen del televisor
		 */
	}
	
	private void config2()
	{
		List<Action> buttons = new ArrayList<Action>();
		buttons.add(new TurnOnLamp(lamp));
		buttons.add(new SetAirConditionerMode(airConditioner, Mode.OFF));
		buttons.add(new SwitchTVChannel(tv, 1));
		buttons.add(new SetAirConditionerMode(airConditioner, Mode.LOW));
		buttons.add(new NoActionButton());
		buttons.add(new SetAirConditionerMode(airConditioner, Mode.HIGH));
		remote.setButtons(buttons);
		/*
		 	1. Encender la luz
		 	2. Apagar el aire acondicionado
		 	3. Poner el canal 1 del televisor
		 	4. Poner el aire acondicionado a baja potencia
		 	5. --
		 	6. Poner el aire acondicionado a alta potencia
		 */
	}
	
	private void config3()
	{
		config2();
		List<Action> acciones = new ArrayList<Action>();
		acciones.add(new TVVolumeDown(tv));
		acciones.add(new TVVolumeDown(tv));
		acciones.add(new SetAirConditionerMode(airConditioner,Mode.OFF));
		acciones.add(new TurnOffLamp(lamp));
		Action a = new CompositeAction("Noche", acciones);
		remote.addAction(5, a);
		controller.setRemote(remote);
	}
	
	private void printDeviceStatus()
	{
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println(tv);
		System.out.println(lamp);
		System.out.println(airConditioner);
		System.out.println("---------------------------------");
	}
}
