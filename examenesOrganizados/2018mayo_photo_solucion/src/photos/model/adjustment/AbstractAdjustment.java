/*    */ package photos.model.adjustment;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractAdjustment
/*    */   implements Adjustment
/*    */ {
/*    */   private String name;
/*    */   
/*    */   private int value;
/*    */   
/*    */ 
/*    */   public AbstractAdjustment(String name, int value)
/*    */   {
/* 15 */     this.name = name;
/* 16 */     this.value = value;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getName()
/*    */   {
/* 22 */     return this.name;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getValue()
/*    */   {
/* 28 */     return this.value;
/*    */   }
/*    */   
/*    */ 
/*    */   public Adjustment setValue(int value)
/*    */   {
/* 34 */     this.value = value;
/* 35 */     return this;
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
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean equals(Object o)
/*    */   {
/* 52 */     if (!(o instanceof Adjustment))
/* 53 */       return false;
/* 54 */     Adjustment other = (Adjustment)o;
/* 55 */     return other.getName().equals(this.name);
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 61 */     return this.name.hashCode();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String toString()
/*    */   {
/* 68 */     return String.format("%s = %+d", new Object[] { this.name, Integer.valueOf(this.value) });
/*    */   }
/*    */ }


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\model\adjustment\AbstractAdjustment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */