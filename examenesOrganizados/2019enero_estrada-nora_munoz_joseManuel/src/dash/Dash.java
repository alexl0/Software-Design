package dash;

import actions.Action;

/*
 * Cambios realizados:
 * 		pressButton():
 * 			-Eliminada toda la lógica condicional, 
 * 			ahora simplemente se comprueba si el botón
 * 			es válido y se ejecuta la acción asociada
 * 		toString():
 * 			-También eliminada toda la lógica condicional, 
 * 			para imprimir las descripciones itera por la lista
 * 			de acciones que tenemos en el Dash.
 */
public class Dash {

    private Action[] actions;
    private int buttonsCount;
    
    public Dash(Action... actions) {
        this.actions = actions;
        buttonsCount = actions.length;
    }

    public int buttonsCount() {
        return buttonsCount;
    }

    public void changeButton(int button, Action action) {
    	checkIsValidButton(button);
        actions[button] = action;
    }

    public void pressButton(int button) {
    	checkIsValidButton(button);
        actions[button].execute();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("-----------------------\n");
        buffer.append("Dash. Botones actuales:\n");
        for (int button = 0; button < buttonsCount; button++)
            buffer.append(button + ": " + actions[button].getDescription() + '\n');
        return buffer.toString();
    }

    private void checkIsValidButton(int button) {
    	if (button < 0 || button >= buttonsCount)
    		throw new IllegalArgumentException("¡" + button + " no es un número de botón válido!");
    }
}
