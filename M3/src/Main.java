
public class Main {

	
	public static void main(String[] args) {
		
		
		Planet planet = new Planet();
		try {
			
			planet.newLigthHunter(5);
			
		} catch (ResourceException e) {

			e.printStackTrace();
		}
		
		planet.printStats();
			
		
	
		
		
		
	}
	
}
