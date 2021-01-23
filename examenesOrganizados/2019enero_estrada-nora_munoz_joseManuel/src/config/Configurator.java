package config;

import java.io.*;
import java.util.List;

import actions.Action;
import actions.DoNothingAction;
import dash.*;

/*
 * Cambios realizados:
 * 		-Añadido constructor que recibe la lista de acciones disponibles
 * 		-Añadido atributo que guarda dicha lista
 * 		configure():
 * 			-Cambiada la asignacion de null por DoNothingAction
 * 			-Eliminados los if/else para asociar la acción a cada botón
 * 		printActions():
 * 			-Pasa a ser dinámico dependiendo de las acciones disponibles
 */
public class Configurator {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private List<Action> availableActions;
	
	public Configurator(List<Action> availableActions) {
    	this.availableActions = availableActions;
	}
	
    public void configure(Dash dash) throws IOException {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("CONFIGURADOR");
        System.out.println(dash);

        try {
            System.out.println("Escriba el número de botón a cambiar:");
            int button = Integer.parseInt(in.readLine());
            if (button < 0 || button >= dash.buttonsCount()) {
                System.out.println("No es un número de botón válido: operación cancelada");
                return;
            }

            System.out.println("Escriba el número de acción a asignar al botón de entre las siguientes (o 'N' para ninguna):");
            printActions();
            System.out.print("> ");
            String line = in.readLine();

            // Comprueba primero si la opción escogida para ese botón es no hacer nada 
            if (line.toUpperCase().equals("N")) {
                dash.changeButton(button, new DoNothingAction());
                return;
            }
            else {
            	// Si no, es que tiene que tratarse de una acción existente
                int actionNumber = Integer.parseInt(line);
                if (actionNumber < 0 || actionNumber >= availableActions.size()) {
                    System.out.println("No es una acción válida: operación cancelada");
                    return;
                }
                dash.changeButton(button, availableActions.get(actionNumber));
            }  
            System.out.println("Botón asignado");            

        } catch (NumberFormatException e) {
            System.out.println("Se esperaba un número");
        }
    }

    private void printActions() {
        System.out.println("  N. No hacer nada");
        for(int i=0; i<availableActions.size(); i++) {
            System.out.println("  " + i + ". " + availableActions.get(i).getDescription());
        }
    }

}
