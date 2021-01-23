/*    */ package photos;
/*    */ 
/*    */ import java.io.FileNotFoundException;

/*    */ import photos.model.Editor;
/*    */ import photos.model.Photo;
import photos.model.adjustment.AdjustmentFactory;
/*    */ import photos.ui.Menu;
/*    */ 
/*    */ public class PhotosApp
/*    */ {
/*    */   private Editor editor;
/*    */   private Photo toranda;
/*    */   private Photo bodegon;
/*    */   private Photo helado;
/*    */   private Photo retrato;
/*    */   private Photo urriellu;
/*    */   
/*    */   public static void main(String[] args) throws FileNotFoundException, java.io.IOException
/*    */   {
/* 20 */     new PhotosApp().run();
/*    */   }
/*    */   
/*    */   public void run() throws FileNotFoundException, java.io.IOException
/*    */   {
/* 25 */     setUp();
/*    */     
/* 27 */     registerAdjustments();
/*    */     
/*    */ 
/* 30 */     new Menu(this.editor).run();
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
/*    */   private void registerAdjustments()
/*    */   {
/* 43 */     AdjustmentFactory.getInstance().addAdjustment(new photos.standard.adjustments.Brightness());
/* 44 */     AdjustmentFactory.getInstance().addAdjustment(new photos.standard.adjustments.Contrast());
/* 45 */     AdjustmentFactory.getInstance().addAdjustment(new photos.extensions.adjustments.Sharpness());
/* 46 */     AdjustmentFactory.getInstance().addAdjustment(new photos.extensions.adjustments.Vignette());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void setUp()
/*    */   {
/* 55 */     this.editor = new Editor();
/*    */     
/* 57 */     this.toranda = new Photo("toranda.jpg");
/* 58 */     this.bodegon = new Photo("bodegon.jpg");
/* 59 */     this.helado = new Photo("helado.tiff");
/* 60 */     this.retrato = new Photo("retrato.tiff");
/* 61 */     this.urriellu = new Photo("urriellu.jpg");
/*    */     
/* 63 */     this.editor.addPhoto(this.toranda);
/* 64 */     this.editor.addPhoto(this.bodegon);
/* 65 */     this.editor.addPhoto(this.helado);
/* 66 */     this.editor.addPhoto(this.retrato);
/* 67 */     this.editor.addPhoto(this.urriellu);
/*    */   }
/*    */ }


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\PhotosApp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */