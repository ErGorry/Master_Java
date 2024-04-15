package semana1.enumerados1;

public class EnumDemo {

	public static void main(String[] args) {
		  Tutoriales t1, t2, t3;
          t1 = Tutoriales.JAVA; 
          t2 = Tutoriales.HTML; 
          t3 = Tutoriales.MYSQL; 
        
          System.out.print("Programando en " + t1);      
          System.out.println(", Valor = " + Tutoriales.valueOf("JAVA")); 
          System.out.print("Programando en  " + t2);  
          System.out.println(", Valor = " + Tutoriales.valueOf("HTML")); 
          System.out.print("Programando en  " + t3);  
          System.out.println(", Valor = " + Tutoriales.valueOf("MYSQL"));               
       

         for(Tutoriales tuto : Tutoriales.values()) { 
             System.out.println(tuto + " tutorial. " );
         }
	}

}
