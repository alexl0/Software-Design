package slides.model;

import static slides.layout.LayoutType.*;

import slides.content.Placeholder;
import slides.layout.Layout;
import slides.ui.Canvas;

public class Slide 
{
    private Layout layout;

    public Slide(Layout layout)
    {
        if (layout == null)
            throw new NullPointerException("¡Se necesita un layout para crear la diapositiva!");
        this.layout = layout;
    }
    
    public Layout getLayout()
    {
    	return layout;
    }
 
    public void show(Canvas canvas)
    {
        if (layout.getType() == NORMAL) {
            layoutNormal(canvas);
        } else if (layout.getType() == COLUMNS) {
            layoutColumns(canvas);
        } else if (layout.getType() == GRID) {
            layoutGrid(canvas);
        } else {
            throw new AssertionError("Layout no implementado: " + layout.getType());
        }
    }

    // NOTA: Téngase en cuenta que aunque, por ahora y para simplificar la
    //       implementación, los tres tipos de layout se limitan a mostrar por
    //       pantalla los distintos marcadores y la posición que ocupa cada uno
    //       como una cadena de texto, en un caso real esto no sería así, y 
    //       tendrían implementaciones muy distintas. Es lo que se está
    //       tratando de simular con esa especie de representación de la
    //       diapositiva que se imita en modo texto. El bucle que va a 
    //       continuación de ella dibujaría efectivamente en un caso real el
    //       contenido de cada marcador de posición, para los que a su vez
    //       previamente habría calculado su posición, dimensiones, forma de
    //       ajustarse al redimensionar la pantalla, etcétera).
    //
    //       (Esto mismo habría de tenerse en cuenta a la hora de la 
    //       exportación: en la mayoría de los casos no tendrá nada que ver la
    //       forma de generar los distintos formatos dependiendo del tipo de
    //       layout de la diapositiva.)
    //       
    private void layoutNormal(Canvas canvas)
    {
        canvas.drawLine("┌─────────────────┐");
        canvas.drawLine("│                 │");
        canvas.drawLine("├─────────────────│");
        canvas.drawLine("        ...        ");
        canvas.drawLine("│                 │");
        canvas.drawLine("└─────────────────┘");
        for (Placeholder each : layout.getPlaceholders()) {
            canvas.drawLine("Dibujando en: " + layout.getPosition(each) + "...");
            each.paint(canvas);
        }
    }

    private void layoutColumns(Canvas canvas)
    {
        canvas.drawLine("┌────┬────┬─   ───┐");
        canvas.drawLine("│    │    │       │");
        canvas.drawLine("│    │    │  ...  │");
        canvas.drawLine("│    │    │       │");
        canvas.drawLine("│    │    │       │");
        canvas.drawLine("└────┴────┴─   ───┘");        
        for (Placeholder each : layout.getPlaceholders()) {
            canvas.drawLine("Dibujando en: " + layout.getPosition(each) + "...");
            each.paint(canvas);
        }
    }

    private void layoutGrid(Canvas canvas)
    {
        canvas.drawLine("┌────┬────┬─   ───┐");
        canvas.drawLine("│    │    │       │");
        canvas.drawLine("├────┴────┼─   ───┤");
        canvas.drawLine("             ...  ");
        canvas.drawLine("├─────────┤       │");
        canvas.drawLine("└─────────┴─   ───┘");        
        for (Placeholder each : layout.getPlaceholders()) {
            canvas.drawLine("Dibujando en: " + layout.getPosition(each) + "...");
            each.paint(canvas);
        }
    }

    public void edit(Canvas canvas)
    {
        for (Placeholder each : layout.getPlaceholders()) {
            each.edit(canvas);
        }
    }
    
    @Override
    public String toString()
    {
        return String.format("Diapositiva con %d marcadores de posición%n  => %s",
                layout.getPlaceholders().size(), layout);
    }
}