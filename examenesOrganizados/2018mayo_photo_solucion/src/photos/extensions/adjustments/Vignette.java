/*    */ package photos.extensions.adjustments;
import photos.model.adjustment.Adjustment;
/*    */ 
/*    */ public class Vignette extends photos.model.adjustment.AbstractAdjustment implements Adjustment
/*    */ {
/*    */   @SuppressWarnings("unused")
			private static final int DEFAULT = 10;
/*    */   
/*    */   public Vignette()
/*    */   {
/* 11 */     super("Degradado", 10);
/*    */   }
/*    */   
/*    */ 
/*    */   public String apply(String image)
/*    */   {
/* 17 */     return image + String.format("\nDegradado: %+d", new Object[] { Integer.valueOf(getValue()) });
/*    */   }
/*    */   
/*    */ 
/*    */   public Adjustment duplicate()
/*    */   {
/* 23 */     return new Vignette().setValue(getValue());
/*    */   }
/*    */ }


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\extensions\adjustments\Vignette.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */