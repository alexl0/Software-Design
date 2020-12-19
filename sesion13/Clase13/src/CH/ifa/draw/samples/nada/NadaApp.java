/*
 * @(#)NothingApp.java 5.1
 *
 */

package CH.ifa.draw.samples.nada;

import java.awt.*;
import java.util.*;
import java.io.*;
import CH.ifa.draw.framework.*;
import CH.ifa.draw.standard.*;
import CH.ifa.draw.figures.*;
import CH.ifa.draw.contrib.*;
import CH.ifa.draw.util.*;
import CH.ifa.draw.application.*;

public  class NadaApp extends DrawApplication {

	NadaApp() {
		super("Nothing");
	}

	//-- main -----------------------------------------------------------

	public static void main(String[] args) {
		DrawApplication window = new NadaApp();
		window.open();
	}

	protected void createTools(Panel palette) { 
		super.createTools(palette); 
		Tool herramienta = new EjemploTool(view());
		palette.add(createToolButton(IMAGES + "RECT", "Ejemplo Tool", herramienta)); 
		// Alternativa:
		// Tool herramienta = new CreationTool(view(), new EjemploFigure());
	}
}




