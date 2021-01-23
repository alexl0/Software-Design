/*     */ package photos.model;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;

import photos.model.adjustment.Adjustment;
import photos.model.adjustment.AdjustmentFactory;
/*     */ 
/*     */ public class Editor
/*     */ {
/*  10 */   private List<Photo> library = new java.util.ArrayList<Photo>();
/*     */   
/*     */   private Photo current;
/*     */   private List<Adjustment> copiedAdjustments;
/*     */   
/*     */   public void addPhoto(Photo photo)
/*     */   {
/*  17 */     this.library.add(photo);
/*     */   }
/*     */   
/*     */   public void open(int index)
/*     */   {
/*  22 */     this.current = getPhoto(index);
/*     */   }
/*     */   
/*     */   public Photo getCurrentPhoto()
/*     */   {
/*  27 */     return this.current;
/*     */   }
/*     */   
/*     */   public List<Photo> getAllPhotos()
/*     */   {
/*  32 */     return Collections.unmodifiableList(this.library);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addAdjustment(String name)
/*     */   {
/*  40 */     Photo current = currentPhoto();
/*  41 */     Adjustment adjustment = createAdjustment(name);
/*  42 */     current.addAdjustment(adjustment);
/*     */   }
/*     */   
/*     */   public void setAdjustment(String name, int value)
/*     */   {
/*  47 */     Adjustment adjustment = currentPhoto().getAdjustment(name);
/*  48 */     if (adjustment == null)
/*     */     {
/*  50 */       adjustment = createAdjustment(name);
/*  51 */       this.current.addAdjustment(adjustment);
/*     */     }
/*  53 */     adjustment.setValue(value);
/*     */   }
/*     */   
/*     */   public void removeAdjustment(String name)
/*     */   {
/*  58 */     currentPhoto().removeAdjustment(name);
/*     */   }
/*     */   
/*     */   public void resetAdjustments()
/*     */   {
/*  63 */     currentPhoto().resetAdjustments();
/*     */   }
/*     */   
/*     */   public void copyAdjustments()
/*     */   {
/*  68 */     if (getCurrentPhoto() == null)
/*  69 */       throw new IllegalStateException("No hay ninguna foto abierta de la que copiar ajustes");
/*  70 */     this.copiedAdjustments = getCurrentPhoto().copyAdjustments();
/*     */   }
/*     */   
/*     */   public void pasteAdjustments()
/*     */   {
/*  75 */     if (this.copiedAdjustments == null)
/*  76 */       throw new IllegalStateException("No hay ajustes copiados que pegar");
/*  77 */     if (this.current == null)
/*  78 */       throw new IllegalStateException("No hay ninguna foto abierta en la que pegar los ajustes");
/*  79 */     this.current.pasteAdjustments(this.copiedAdjustments);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private Photo getPhoto(int index)
/*     */   {
/*  87 */     checkPhotoIndex(index);
/*  88 */     return (Photo)this.library.get(index - 1);
/*     */   }
/*     */   
/*     */   private void checkPhotoIndex(int index)
/*     */   {
/*  93 */     if ((index < 1) || (index > this.library.size())) {
/*  94 */       throw new IllegalArgumentException(String.format(
/*  95 */         "%d no es un número de foto válido: (%d-%d)", new Object[] { Integer.valueOf(index), Integer.valueOf(1), Integer.valueOf(this.library.size()) }));
/*     */     }
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
/*     */   private Photo currentPhoto()
/*     */   {
/* 109 */     Photo result = getCurrentPhoto();
/* 110 */     if (result == null)
/* 111 */       throw new IllegalStateException("No hay ninguna foto abierta en el editor");
/* 112 */     return result;
/*     */   }
/*     */   
/*     */   private Adjustment createAdjustment(String name)
/*     */   {
/* 117 */     checkAdjustmentName(name);
/* 118 */     return this.adjustmentFactory.getAdjustment(name);
/*     */   }
/*     */   
/*     */   private void checkAdjustmentName(String name)
/*     */   {
/* 123 */     if (!this.adjustmentFactory.hasAdjustment(name))
/* 124 */       throw new IllegalArgumentException("No hay ningún ajuste con ese nombre: " + name);
/*     */   }
/*     */   
/* 127 */   private AdjustmentFactory adjustmentFactory = AdjustmentFactory.getInstance();
/*     */ }


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\model\Editor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */