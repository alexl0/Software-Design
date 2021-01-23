/*    */ package photos.extensions.adjustments;
import photos.model.adjustment.Adjustment;
/*    */ 
/*    */ public class Sharpness extends photos.model.adjustment.AbstractAdjustment implements Adjustment
/*    */ {
/*    */   @SuppressWarnings("unused")
			private static final int DEFAULT = 22;
/*    */   
/*    */   public Sharpness()
/*    */   {
/* 11 */     super("Nitidez", 22);
/*    */   }
/*    */   
/*    */ 
/*    */   public String apply(String image)
/*    */   {
/* 17 */     return image + String.format("\nNitidez: %+d", new Object[] { Integer.valueOf(getValue()) });
/*    */   }
/*    */   
/*    */ 
/*    */   public Adjustment duplicate()
/*    */   {
/* 23 */     return new Sharpness().setValue(getValue());
/*    */   }
/*    */ }


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\extensions\adjustments\Sharpness.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */