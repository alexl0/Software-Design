/*     */ package photos.model;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

import photos.model.adjustment.Adjustment;
/*     */ 
/*     */ public class Photo
/*     */ {
/*     */   private String image;
/*  10 */   private List<Adjustment> adjustments = new ArrayList<Adjustment>();
/*     */   
/*     */   public Photo(String filename)
/*     */   {
/*  14 */     this.image = new String(filename);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String outputImage()
/*     */   {
/*  29 */     String result = new String(this.image);
/*  30 */     for (Adjustment each : this.adjustments) {
/*  31 */       result = each.apply(result);
/*     */     }
/*  33 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addAdjustment(Adjustment adjustment)
/*     */   {
/*  41 */     if (this.adjustments.contains(adjustment))
/*  42 */       throw new IllegalArgumentException("Ya se había añadido dicho ajuste a esta foto");
/*  43 */     this.adjustments.add(adjustment);
/*     */   }
/*     */   
/*     */   public Adjustment getAdjustment(String name)
/*     */   {
/*  48 */     for (Adjustment each : this.adjustments) {
/*  49 */       if (each.getName().equalsIgnoreCase(name))
/*  50 */         return each;
/*     */     }
/*  52 */     return null;
/*     */   }
/*     */   
/*     */   public boolean hasAdjustment(String name)
/*     */   {
/*  57 */     for (Adjustment each : this.adjustments) {
/*  58 */       if (each.getName().equalsIgnoreCase(name))
/*  59 */         return true;
/*     */     }
/*  61 */     return false;
/*     */   }
/*     */   
/*     */   public boolean removeAdjustment(String name)
/*     */   {
/*  66 */     if (hasAdjustment(name)) {
/*  67 */       this.adjustments.remove(getAdjustment(name));
/*  68 */       return true;
/*     */     }
/*  70 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Adjustment> copyAdjustments()
/*     */   {
/*  77 */     List<Adjustment> result = new ArrayList<Adjustment>(this.adjustments.size());
/*  78 */     for (Adjustment each : this.adjustments) {
/*  79 */       result.add(each.duplicate());
/*     */     }
/*  81 */     return result;
/*     */   }
/*     */   
/*     */   public void pasteAdjustments(List<Adjustment> copiedAdjustments)
/*     */   {
/*  86 */     this.adjustments = new ArrayList<Adjustment>(copiedAdjustments.size());
/*  87 */     for (Adjustment each : copiedAdjustments) {
/*  88 */       this.adjustments.add(each);
/*     */     }
/*     */   }
/*     */   
/*     */   public void resetAdjustments()
/*     */   {
/*  94 */     this.adjustments.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 102 */     return String.format(this.image, new Object[0]);
/*     */   }
/*     */ }


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\model\Photo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */