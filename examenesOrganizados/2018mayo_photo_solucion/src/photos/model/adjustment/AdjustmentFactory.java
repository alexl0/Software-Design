/*    */ package photos.model.adjustment;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdjustmentFactory
/*    */ {
/* 31 */   private static AdjustmentFactory instance = new AdjustmentFactory();
/*    */   
/*    */ 
/*    */   public static AdjustmentFactory getInstance()
/*    */   {
/* 36 */     return instance;
/*    */   }
/*    */   
/* 39 */   private Map<String, Adjustment> adjustments = new HashMap<String, Adjustment>();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean hasAdjustment(String name)
/*    */   {
/* 51 */     return this.adjustments.containsKey(name.toUpperCase());
/*    */   }
/*    */   
/*    */   public void addAdjustment(Adjustment adjustment)
/*    */   {
/* 56 */     if (hasAdjustment(adjustment.getName()))
/* 57 */       throw new IllegalArgumentException("Ya hay un ajuste registrado con ese nombre: " + adjustment.getName().toLowerCase());
/* 58 */     this.adjustments.put(adjustment.getName().toUpperCase(), adjustment);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Adjustment getAdjustment(String name)
/*    */   {
/* 72 */     if (!hasAdjustment(name))
/* 73 */       throw new IllegalArgumentException("No hay ningún ajuste con ese nombre: " + name);
/* 74 */     return ((Adjustment)this.adjustments.get(name.toUpperCase())).duplicate();
/*    */   }
/*    */ }


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\model\adjustment\AdjustmentFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */