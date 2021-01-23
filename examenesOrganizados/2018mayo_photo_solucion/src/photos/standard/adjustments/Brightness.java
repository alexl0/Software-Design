/*    */ package photos.standard.adjustments;
import photos.model.adjustment.Adjustment;
/*    */ 
/*    */ public class Brightness extends photos.model.adjustment.AbstractAdjustment implements Adjustment
/*    */ {
/*    */   @SuppressWarnings("unused")
			private static final int DEFAULT = 0;
/*    */   
/*    */   public Brightness()
/*    */   {
/* 11 */     super("Brillo", 0);
/*    */   }
/*    */   
/*    */ 
/*    */   public String apply(String image)
/*    */   {
/* 17 */     return image + String.format("\nBrillo: %+d", new Object[] { Integer.valueOf(getValue()) });
/*    */   }
/*    */   
/*    */ 
/*    */   public Adjustment duplicate()
/*    */   {
/* 23 */     return new Brightness().setValue(getValue());
/*    */   }
/*    */ }


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\standard\adjustments\Brightness.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */