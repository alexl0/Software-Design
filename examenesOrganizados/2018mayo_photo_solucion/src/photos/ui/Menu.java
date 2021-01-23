/*     */ package photos.ui;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;

/*     */ import photos.model.Editor;
/*     */ import photos.model.Photo;
import photos.model.adjustment.AdjustmentFactory;
/*     */ 
/*     */ public class Menu
/*     */ {
/*     */   private Editor editor;
/*     */   private BufferedReader input;
/*     */   private PrintWriter output;
/*     */   private boolean exit;
/*     */   private boolean interactive;
/*     */   
/*     */   public Menu(Editor editor)
/*     */   {
/*  23 */     this(editor, new java.io.InputStreamReader(System.in), new PrintWriter(System.out, true));
/*  24 */     this.interactive = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Menu(Editor editor, String inputFileName, String outputFileName)
/*     */     throws java.io.FileNotFoundException, IOException
/*     */   {
/*  36 */     this(editor, new java.io.FileReader(inputFileName), new FileWriter(outputFileName));
/*     */   }
/*     */   
/*     */   public Menu(Editor editor, Reader input, Writer output)
/*     */   {
/*  41 */     if (editor == null)
/*  42 */       throw new NullPointerException("Se necesita una referencia no nula al editor");
/*  43 */     this.input = new BufferedReader(input);
/*  44 */     this.output = new PrintWriter(output, true);
/*  45 */     this.editor = editor;
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
/*     */   private void showCurrentPhoto()
/*     */   {
/*  59 */     this.output.println(this.editor.getCurrentPhoto().outputImage());
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/*  64 */     showHelp();
/*  65 */     while (!this.exit) {
/*     */       try {
/*  67 */         menu(askUser());
/*     */       } catch (Exception e) {
/*  69 */         this.output.println(e.getMessage());
/*     */       }
/*     */     }
/*  72 */     this.output.println("¡Adios!");
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private void menu(String[] userInput)
/*     */     throws UserInputException
/*     */   {
/*  91 */     String option = userInput[0];
/*  92 */     if (option.equals("salir")) {
/*  93 */       this.exit = true;
/*  94 */     } else if (option.equals("ayuda")) {
/*  95 */       showHelp();
/*  96 */     } else if (option.equals("todas")) {
/*  97 */       showAll();
/*  98 */     } else if (option.equals("abrir")) {
/*  99 */       checkHasArguments(userInput, "Se debe indicar el número de la foto a abrir");
/* 100 */       open(userInput[1]);
/* 101 */     } else if (option.equals("copiar_ajustes")) {
/* 102 */       this.editor.copyAdjustments();
/* 103 */     } else if (option.equals("pegar_ajustes")) {
/* 104 */       this.editor.pasteAdjustments();
/* 105 */       showCurrentPhoto();
/* 106 */     } else if (option.equals("activar")) {
/* 107 */       checkHasArguments(userInput, "Se necesita el nombre del ajuste a añadir a la foto");
/* 108 */       addAdjustment(userInput[1]);
/* 109 */     } else if (option.equals("desactivar")) {
/* 110 */       checkHasArguments(userInput, "Se necesita el nombre del ajuste a eliminar");
/* 111 */       removeAdjustment(userInput[1]);
/* 112 */     } else if (option.equals("restablecer")) {
/* 113 */       this.editor.resetAdjustments();
/* 114 */       showCurrentPhoto();
/*     */     }
/*     */     else {
/* 117 */       if (!isAdjustment(option))
/* 118 */         throw new UserInputException("Acción o nombre de ajuste desconocido");
/* 119 */       checkHasArguments(userInput, "Se necesita el valor a aplicar al ajuste");
/* 120 */       setAdjustment(option, userInput[1]);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkHasArguments(String[] userInput, String message)
/*     */     throws UserInputException
/*     */   {
/* 130 */     if (userInput.length < 2) {
/* 131 */       throw new UserInputException(message);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String[] askUser()
/*     */   {
/* 153 */     this.output.print("> ");
/* 154 */     this.output.flush();
/*     */     try {
/* 156 */       String userInput = this.input.readLine();
/*     */       
/*     */ 
/*     */ 
/* 160 */       if (!this.interactive) {
/* 161 */         this.output.println(userInput);
/*     */       }
/* 163 */       return userInput.trim().toLowerCase().split("[ ]", 2);
/*     */     } catch (IOException e) {
/* 165 */       System.out.println("No se pudo leer la entrada del usuario: el programa debe finalizar");
/* 166 */       System.exit(1);
/* 167 */       throw new AssertionError("No debería estar aquí, el programa ya ha finalizado");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void showHelp()
/*     */   {
/* 177 */     this.output.println("General: todas - abrir <nº de foto>");
/* 178 */     this.output.println("Ajustes: <ajuste> <valor> - activar <ajuste> - desactivar <ajuste> - restablecer");
/* 179 */     this.output.println("         copiar_ajustes - pegar_ajustes");
/* 180 */     this.output.println("Otras acciones: salir - ayuda");
/* 181 */     this.output.println("--------------------------------------------------------------------------------");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void showAll()
/*     */   {
/* 191 */     int index = 1;
/* 192 */     for (Photo each : this.editor.getAllPhotos()) {
/* 193 */       this.output.printf("%2d - %s\n", new Object[] { Integer.valueOf(index), each });
/* 194 */       index++;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void open(String args)
/*     */     throws UserInputException
/*     */   {
/*     */     try
/*     */     {
/* 208 */       int index = Integer.valueOf(args).intValue();
/* 209 */       this.editor.open(index);
/* 210 */       showCurrentPhoto();
/*     */     } catch (NumberFormatException e) {
/* 212 */       throw new UserInputException("Se esperaba un número de foto: " + args);
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
/*     */   private boolean isAdjustment(String name)
/*     */   {
/* 225 */     AdjustmentFactory registry = AdjustmentFactory.getInstance();
/* 226 */     return registry.hasAdjustment(name);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setAdjustment(String name, String args)
/*     */     throws UserInputException
/*     */   {
/*     */     try
/*     */     {
/* 241 */       int value = Integer.valueOf(args).intValue();
/* 242 */       this.editor.setAdjustment(name, value);
/* 243 */       showCurrentPhoto();
/*     */     } catch (NumberFormatException e) {
/* 245 */       throw new UserInputException("Se esperaba un valor numérico para el ajuste: " + args);
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
/*     */ 
/*     */ 
/*     */   private void addAdjustment(String name)
/*     */   {
/* 261 */     this.editor.addAdjustment(name);
/* 262 */     showCurrentPhoto();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void removeAdjustment(String name)
/*     */   {
/* 274 */     this.editor.removeAdjustment(name);
/* 275 */     showCurrentPhoto();
/*     */   }
/*     */ }
