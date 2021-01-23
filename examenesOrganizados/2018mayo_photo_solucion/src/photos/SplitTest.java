/*    */ package photos;
/*    */ 
/*    */ public class SplitTest {
/*    */   public static void main(String[] args) {
/*  7 */     new SplitTest().run();
/*    */   }
/*    */   
/*    */   private void run()
/*    */   {
/* 12 */     split("abrir 1");
/* 13 */     split("copiar_ajustes");
/* 14 */     split("seleccionar 2, 4, 5");
/* 15 */     split("");
/* 16 */     split("  esto     es   una prueba");
/*    */   }
/*    */   
/*    */   private void split(String s)
/*    */   {
/* 21 */     String[] parts = s.trim().split("[ ]", 2);
/* 22 */     switch (parts.length) {
/* 23 */     case 1:  System.out.printf("[\"%s\"]\n", new Object[] { parts[0] }); break;
/* 24 */     case 2:  System.out.printf("[\"%s\", \"%s\"]\n", new Object[] { parts[0], parts[1] }); break;
/* 25 */     default:  throw new AssertionError("Se supone que sólo podía tener uno o dos elementos: " + parts.length);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\SplitTest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */