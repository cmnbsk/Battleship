
public class ShootsSupport {
	public static void generateTextLog(int wynik, String nazwa){
			switch(wynik){
				case -1: System.out.println(nazwa+": b��d podczas strzalu.");
						break;
				case 0: System.out.println(nazwa+": pud�o.");
						break;
				case 1: System.out.println(nazwa+": trafiony."); 
						break;
				case 2: System.out.println(nazwa+": trafiony i zatopiony."); 
						break;			
			}
	}
}
