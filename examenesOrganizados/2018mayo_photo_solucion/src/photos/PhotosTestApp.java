/*     */ package photos;
/*     */ 
/*     */ import photos.model.Editor;
/*     */ 
/*     */ public class PhotosTestApp
/*     */ {
/*     */   private Editor editor;
/*     */   private photos.model.Photo toranda;
/*     */   private photos.model.Photo bodegon;
/*     */   private photos.model.Photo helado;
/*     */   private photos.model.Photo retrato;
/*     */   private photos.model.Photo urriellu;
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/*  16 */     new PhotosTestApp().run();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setUp()
/*     */   {
/*  24 */     this.editor = new Editor();
/*     */     
/*  26 */     this.toranda = new photos.model.Photo("toranda.jpg");
/*  27 */     this.bodegon = new photos.model.Photo("bodegon.jpg");
/*  28 */     this.helado = new photos.model.Photo("helado.tiff");
/*  29 */     this.retrato = new photos.model.Photo("retrato.tiff");
/*  30 */     this.urriellu = new photos.model.Photo("urriellu.jpg");
/*     */     
/*  32 */     this.editor.addPhoto(this.toranda);
/*  33 */     this.editor.addPhoto(this.bodegon);
/*  34 */     this.editor.addPhoto(this.helado);
/*  35 */     this.editor.addPhoto(this.retrato);
/*  36 */     this.editor.addPhoto(this.urriellu);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void registerAdjustments()
/*     */   {
/*  44 */     photos.model.adjustment.AdjustmentFactory.getInstance().addAdjustment(new photos.standard.adjustments.Brightness());
/*  45 */     photos.model.adjustment.AdjustmentFactory.getInstance().addAdjustment(new photos.standard.adjustments.Contrast());
/*  46 */     photos.model.adjustment.AdjustmentFactory.getInstance().addAdjustment(new photos.extensions.adjustments.Sharpness());
/*  47 */     photos.model.adjustment.AdjustmentFactory.getInstance().addAdjustment(new photos.extensions.adjustments.Vignette());
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/*  52 */     setUp();
/*     */     
/*  54 */     registerAdjustments();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */     runTest2();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void runTest2()
/*     */   {
/*  70 */     this.editor.open(1);
/*     */     
/*     */ 
/*  73 */     this.editor.setAdjustment("brillo", 8);
/*  74 */     this.editor.setAdjustment("contraste", -6);
/*     */     
/*     */ 
/*  77 */     this.editor.addAdjustment("degradado");
/*     */     
/*  79 */     this.editor.removeAdjustment("brillo");
/*     */     
/*  81 */     this.editor.copyAdjustments();
/*     */     
/*  83 */     this.editor.setAdjustment("degradado", 33);
/*     */     
/*  85 */     this.editor.addAdjustment("brillo");
/*     */     
/*  87 */     this.editor.removeAdjustment("contraste");
/*     */     
/*  89 */     this.editor.open(4);
/*     */     
/*  91 */     this.editor.pasteAdjustments();
/*     */     
/*  93 */     this.editor.open(2);
/*     */     
/*  95 */     this.editor.setAdjustment("brillo", 17);
/*     */     
/*  97 */     this.editor.removeAdjustment("contraste");
/*     */     
/*  99 */     this.editor.open(1);
/*     */     
/* 101 */     this.editor.addAdjustment("nitidez");
/*     */     
/* 103 */     showAllPhotos();
/*     */     
/*     */ 
/* 106 */     this.editor.resetAdjustments();
/*     */     
/* 108 */     showCurrentPhoto();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SuppressWarnings("unused")
			private void runTest1()
/*     */   {
/* 115 */     System.out.println("Abrimos una foto...");
/* 116 */     this.editor.open(1);
/* 117 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */     System.out.println("Le aplicamos una serie de ajustes...");
/*     */     
/* 125 */     this.editor.setAdjustment("brillo", 8);
/* 126 */     this.editor.setAdjustment("contraste", -6);
/*     */     
/*     */ 
/* 129 */     this.editor.addAdjustment("degradado");
/* 130 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 139 */     System.out.println("Desactivamos el brillo...");
/* 140 */     this.editor.removeAdjustment("brillo");
/* 141 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 149 */     System.out.println("Copiamos los ajustes\n");
/* 150 */     this.editor.copyAdjustments();
/*     */     
/* 152 */     System.out.println("Cambiamos el degradado a 33...");
/* 153 */     this.editor.setAdjustment("degradado", 33);
/* 154 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 162 */     System.out.println("Volvemos a activar el brillo...");
/* 163 */     this.editor.addAdjustment("brillo");
/* 164 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 173 */     System.out.println("Desactivamos el contraste...");
/* 174 */     this.editor.removeAdjustment("contraste");
/* 175 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 183 */     System.out.println("Abrimos la foto 4...");
/* 184 */     this.editor.open(4);
/* 185 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 191 */     System.out.println("Pegamos los ajustes...");
/* 192 */     this.editor.pasteAdjustments();
/* 193 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 201 */     System.out.println("Abrimos la foto 2...");
/* 202 */     this.editor.open(2);
/* 203 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 209 */     System.out.println("Le aplicamos un valor de brillo de +17...");
/* 210 */     this.editor.setAdjustment("brillo", 17);
/* 211 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 218 */     System.out.println("Desactivamos el contraste...");
/* 219 */     this.editor.removeAdjustment("contraste");
/* 220 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 226 */     System.out.println("Abrimos la foto 1...");
/* 227 */     this.editor.open(1);
/* 228 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 236 */     System.out.println("Activamos la nitidez...");
/* 237 */     this.editor.addAdjustment("nitidez");
/* 238 */     showCurrentPhoto();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 247 */     System.out.println("Restablecemos los ajustes...");
/* 248 */     this.editor.resetAdjustments();
/* 249 */     showCurrentPhoto();
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
/*     */   private void showCurrentPhoto()
/*     */   {
/* 262 */     System.out.println(this.editor.getCurrentPhoto().outputImage());
/* 263 */     System.out.println();
/*     */   }
/*     */   
/*     */   private void showAllPhotos()
/*     */   {
/* 268 */     for (photos.model.Photo each : this.editor.getAllPhotos()) {
/* 269 */       System.out.println(each.outputImage());
/* 270 */       System.out.println("----------------");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\PhotosTestApp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */