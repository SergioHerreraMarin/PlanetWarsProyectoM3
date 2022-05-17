package paqueteMain;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import gui.IG;
import gui.Main_window;

public class Main {
	
	static ArrayList<MilitaryUnit>[] enemyArmy = new ArrayList[4];
	static ArrayList<Battle> battles = new ArrayList<Battle>();
	static int enemyMetal = Variables.METAL_BASE_ENEMY_ARMY, enemyDeuterium = Variables.DEUTERIUM_BASE_ENEMY_ARMY;	
	static boolean startGame = false;
	

	public static void main(String[] args) {
		
		//LO PRIMERO
		ConnectionBBDD connection = new ConnectionBBDD("alumnoAMS20", "alumnoAMS20");
		
		//Main_window mainWindow = new Main_window();
		
		
		enemyArmy[0] = new ArrayList<MilitaryUnit>();
		enemyArmy[1] = new ArrayList<MilitaryUnit>();
		enemyArmy[2] = new ArrayList<MilitaryUnit>();
		enemyArmy[3] = new ArrayList<MilitaryUnit>();
		
		//VENTANA REGISTRAR/LOGIN
		IG ig = new IG();
		ig.startWindow();
		//Main_window ps = new Main_window();

		
		Planet planet = new Planet("wefwe");
		
		
		//Llamar ventana principal 
		
		//Planet planet = new Planet();
		//createEnemyArmy(enemyArmy);
		
		try {
			
			planet.newLigthHunter(17);
			planet.newHeavyHunter(8);
			planet.newBattleShip(1);
			planet.newArmoredShip(5);
			
		} catch (ResourceException e) {

			e.printStackTrace();
		}
		
		//viewThread();
		
		//Battle battle = new Battle(planet.getArmy(), enemyArmy);
		
		//battle.startBattle(planet);
		//System.out.println(battle.getBattleReportStepByStep());
		//System.out.println(battle.getBattleReportGeneral());
		
		
		
//		Timer timer = new Timer();
//	    TimerTask task = new TimerTask() {
//
//			@Override
//			public void run() {
//				
//				if(startGame) {
//				
//					createEnemyArmy(enemyArmy);
//					Battle battle = new Battle(planet.getArmy(), enemyArmy, planet);
//					battles.add(battle);
//					
//				}		
//			}    	
//	    };
//		
//	    timer.schedule(task, 180000);

		
	}//main
		

		
	/**GENERA UNA FLOTA ENEMIGA*/
	public static void createEnemyArmy(ArrayList<MilitaryUnit>[] enemyArmy) {
			
		Random random = new Random();
		int numRandom = 0, suma = 0, total = 0;
		int[] probabilidades = {35, 25, 20, 20};
			
		//Total
		for(int i = 0; i < probabilidades.length; i++) {
			total += probabilidades[i];
		}
		
		while(enemyMetal >= Variables.METAL_COST_LIGTHHUNTER && enemyDeuterium >= Variables.DEUTERIUM_COST_LIGTHHUNTER) {
			
			numRandom = random.nextInt(0, total + 1); //Num random 
			//System.out.println("Random: " + numRandom + ", Metal: " + enemyMetal + ", Deuterium: " + enemyDeuterium);
			
			if(numRandom <= 35) {
				
				//System.out.println("LightHunter, Metal: " + Variables.METAL_COST_LIGTHHUNTER + " Deuteriuim: " + Variables.DEUTERIUM_COST_LIGTHHUNTER );
				if(enemyMetal >= Variables.METAL_COST_LIGTHHUNTER && enemyDeuterium >= Variables.DEUTERIUM_COST_LIGTHHUNTER) {				
					enemyArmy[0].add(new LightHunter(Variables.ARMOR_LIGTHHUNTER,Variables.BASE_DAMAGE_LIGTHHUNTER));
					enemyMetal -= Variables.METAL_COST_LIGTHHUNTER;
					enemyDeuterium -= Variables.DEUTERIUM_COST_LIGTHHUNTER;	
					//System.out.println("LightHunter");
				}
			
			}else if(numRandom <= 60) {
				//System.out.println("HeavyHunter, Metal: " + Variables.METAL_COST_HEAVYHUNTER + " Deuteriuim: " + Variables.DEUTERIUM_COST_HEAVYHUNTER );
				if(enemyMetal >= Variables.METAL_COST_HEAVYHUNTER && enemyDeuterium >= Variables.DEUTERIUM_COST_HEAVYHUNTER) {
					
					enemyArmy[1].add(new HeavyHunter(Variables.ARMOR_HEAVYHUNTER,Variables.BASE_DAMAGE_HEAVYHUNTER));
					enemyMetal -= Variables.METAL_COST_HEAVYHUNTER;
					enemyDeuterium -= Variables.DEUTERIUM_COST_HEAVYHUNTER;	
					//System.out.println("HeavyHunter");
					
				}
		
			}else if(numRandom <= 80) {
				//System.out.println("Battleship, Metal: " + Variables.METAL_COST_BATTLESHIP + " Deuteriuim: " + Variables.DEUTERIUM_COST_BATTLESHIP );
				if(enemyMetal >= Variables.METAL_COST_BATTLESHIP && enemyDeuterium >= Variables.DEUTERIUM_COST_BATTLESHIP) {
					
					enemyArmy[2].add(new BattleShip(Variables.ARMOR_BATTLESHIP,Variables.BASE_DAMAGE_BATTLESHIP));	
					enemyMetal -= Variables.METAL_COST_BATTLESHIP;
					enemyDeuterium -= Variables.DEUTERIUM_COST_BATTLESHIP;
					//System.out.println("BattleShip");
				}
					
			}else if(numRandom <= 100) {
				
				//System.out.println("ArmoredShip, Metal: " + Variables.METAL_COST_ARMOREDSHIP + " Deuteriuim: " + Variables.METAL_COST_ARMOREDSHIP );
				if(enemyMetal >= Variables.METAL_COST_ARMOREDSHIP && enemyDeuterium >= Variables.DEUTERIUM_COST_ARMOREDSHIP) {
					
					enemyArmy[3].add(new ArmoredShip(Variables.ARMOR_ARMOREDSHIP,Variables.BASE_DAMAGE_ARMOREDSHIP));
					enemyMetal -= Variables.METAL_COST_ARMOREDSHIP;
					enemyDeuterium -= Variables.DEUTERIUM_COST_ARMOREDSHIP;	
					//System.out.println("ArmoredShip");
				}		
			}			
		}					
	}
		
		
	/**MUESTRA QUE TIPO DE EJERCITO NOS VIENE A ATACAR*/
	public static void viewThread() {
		
		int numLigthHunter = 0, numHeavyHunter = 0, numBattleShip = 0, numArmoredShip = 0;
		
		for(int i = 0; i < enemyArmy.length; i++) {
			
			switch(i) {
			
			case 0: numLigthHunter = enemyArmy[i].size(); break;
			case 1: numHeavyHunter = enemyArmy[i].size(); break;
			case 2: numBattleShip = enemyArmy[i].size(); break;
			case 3: numArmoredShip = enemyArmy[i].size(); break;
			}		
		}
		
		System.out.println("\nNEW THREAD COMMING\nLigth Hunter: " + numLigthHunter +
				"\nHeavy Hunter: " + numHeavyHunter + "\nBattleShip: " + numBattleShip + 
				"\nArmored Ship: " + numArmoredShip);		
	}
		

	
	

	
	

	
}
		



