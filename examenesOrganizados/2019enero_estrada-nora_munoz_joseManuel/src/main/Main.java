package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import actions.Action;
import actions.DoNothingAction;
import actions.EmergencyAction;
import actions.MeteorologyAction;
import actions.OrderCoffeeAction;
import actions.OrderGilletteAction;
import actions.TellHourAction;
import config.Configurator;
import dash.Dash;
import simulator.Simulator;

/*
 * Cambios realizados: 
 * 		-Creada la lista de acciones disponibles y pasada por el constructor
 * 		al configurador
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Dash dash = new Dash(new Action[] { new OrderCoffeeAction(), new DoNothingAction(), new TellHourAction()});
        menu(dash);
    }

    public static void menu(Dash dash) throws IOException {
    	List<Action> availableActions = new ArrayList<Action>();
    	availableActions.add(new OrderCoffeeAction());
    	availableActions.add(new OrderGilletteAction());
    	availableActions.add(new TellHourAction());
    	availableActions.add(new EmergencyAction());
    	availableActions.add(new MeteorologyAction());
    	
        Simulator simulator = new Simulator();
        Configurator configurator = new Configurator(availableActions);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("\n===========================");
            System.out.println("MENU PRINCIPAL. Elija opción:");
            System.out.println("    1. Simular Dash");
            System.out.println("    2. Reprogramar botón del Dash");
            System.out.println("    S. Salir");
            System.out.print("> ");

            String line = in.readLine();
            if (line.equals("1"))
                simulator.simulate(dash);
            else if (line.equals("2"))
                configurator.configure(dash);
            else if (line.toUpperCase().equals("S"))
                return;
            else
                System.out.println("Opción desconocida");

        } while (true);
    }

}
