package paqueteMain;
import java.util.ArrayList;

public class Battle {

	
	private ArrayList<MilitaryUnit>[] planetArmy; //Almacena flota de nuestro planeta.
	private ArrayList<MilitaryUnit>[] enemyArmy; //Almacena la flota enemiga. 	
	
	//Fila[0] unidades planeta, fila[1] unidades enemigas
	private ArrayList<MilitaryUnit>[][] armies = new ArrayList[2][7]; //Array de 2row 7column. Almacena nuestro ej�rcito y ej�rcito enemigo. 
	
	private String battleDevelopment; //Contiene el desarrollo de la batalla paso a paso. 
	
	//Fila[0] coste unidades planeta [0][0] metal, [0][1] deuterio..
	private int[][] initialCostFleet; //Almacena el coste inicial de metal y deuterio de las flotas. Para saber las p�rdidas en materiales de cada flota. 
	
	
	private int initialNumberUnitsPlanet, initialNumberUnitsEnemy; //N�mero de unidades iniciales de cada equipo. 
	
	private int[] wasteMetalDeuterium; //Num de residuos generados en la batalla, [0]metal, [1]deuterium

	
	private int[] enemyDrops; //Para generar reporte de batalla y calcular p�rdida de material de cada equipo. 
	private int[] planetDrops;
	
	
	private int[][] resourcesLooses = new int[2][3]; //2Filas, 3Columnas, 
	
	private int[][] initialArmies = new int[2][7]; //Array de 2row 7column. Almacena la cantidad de cada tipo de flota del ejercito planeta y el ejercito enemigo al INICIO. 
	
	
	private int[] actualNumberUnitsPlanet; //Almacena la cantidad de cada tipo de flota del ejercito planeta y el ejercito enemigo ACTUAL.  
	private int[] actualNumberUnitsEnemy;
	
	
	
	//Por par�metro se pasar�n las unidades del planeta y las unidades enemigas para iniciar los atributos y poder hacer la batalla. 
	public Battle(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
		
		this.planetArmy = planetArmy;
		this.enemyArmy = enemyArmy;
		
		
		//A�adir flotas a array bidimensional: 
		for(int i = 0; i < 2; i++) {
			
			for(int j = 0; j < 7; j++) {
				
				switch(i) {
				
				case 0: //Unidades planeta
					
					armies[i][j].add(this.planetArmy[j]);
					
					break;
				
				case 1: //Unidades enemigo
					
					armies[i][j].add(this.enemyArmy[j]);
					
					break;		
				}			
			}	
		}	
		
		
		//N�mero de unidades iniciales de cada equipo:
		initialNumberUnitsPlanet = initialFleetNumber(planetArmy);
		initialNumberUnitsEnemy = initialFleetNumber(enemyArmy);
		
		
		//Coste de metal y deuterio de cada ejercito: 
		initialCostFleet[0][0] = fleetResourceCost(planetArmy)[0]; //Total metal
		initialCostFleet[0][1] = fleetResourceCost(planetArmy)[1]; //Total deuterium
		initialCostFleet[1][0] = fleetResourceCost(enemyArmy)[0]; //Total metal
		initialCostFleet[1][1] = fleetResourceCost(enemyArmy)[1]; //Total deuterium
		
		
		initialArmies(); //Inicializa el array InitialArmies, para saber el n�mero de cada tipo de flota al inicio del planeta y enemigo. 
	}	
		
		
		
	
	/**M�todo para empezar batalla.  */
	public void startBattle() {
		

		

	}
	
	
	
	/**Inicializa el array InitialArmies, para saber el n�mero de cada tipo de flota al inicio del planeta y enemigo*/
	private void initialArmies() {
			
		for(int i = 0; i < initialArmies.length; i++) {
			
			for(int j = 0; j < initialArmies[i].length; j++) {
				
				initialArmies[i][j] = armies[i][j].size();		
			}		
		}		
	}
	
	
	private void updateResourcesLooses() {
		
		
		
		
	}
	
	
	/**Devuelve un array con el coste total de metal y deuterium de la flota que pasemos por par�metro. [0] = metal, [1] = deuterium*/
	private int[] fleetResourceCost(ArrayList<MilitaryUnit>[] army) {
		
		
		//[0] = LigthHunter, [1] = HeavyHunter, [2] = BattleShip, [3] = ArmoredShip, [4] = MissileLauncher, [5] = IonCannon, [6] = PlasmaCannon
		
		int[] costeMetalDeuterio = new int[2]; //[0] = metal, [1] = deuterio
		
		for(int i = 0; i < army.length; i++) {
			
			for(int j = 0; j < army[i].size(); j++) {
				
				switch(i) {
				
				case 0:
					costeMetalDeuterio[0] += Variables.METAL_COST_LIGTHHUNTER;
					costeMetalDeuterio[1] += Variables.DEUTERIUM_COST_LIGTHHUNTER;
					break;
				
				case 1:
					costeMetalDeuterio[0] += Variables.METAL_COST_HEAVYHUNTER;
					costeMetalDeuterio[1] += Variables.DEUTERIUM_COST_HEAVYHUNTER;
					break;
				
				case 2:
					costeMetalDeuterio[0] += Variables.METAL_COST_BATTLESHIP;
					costeMetalDeuterio[1] += Variables.DEUTERIUM_COST_BATTLESHIP;
					break;
					
				case 3:
					costeMetalDeuterio[0] += Variables.METAL_COST_ARMOREDSHIP;
					costeMetalDeuterio[1] += Variables.DEUTERIUM_COST_ARMOREDSHIP;
					break;
				
				case 4:
					costeMetalDeuterio[0] += Variables.METAL_COST_MISSILELAUNCHER;
					costeMetalDeuterio[1] += Variables.DEUTERIUM_COST_MISSILELAUNCHER;
					break;
				
				case 5:
					costeMetalDeuterio[0] += Variables.METAL_COST_IONCANNON;
					costeMetalDeuterio[1] += Variables.DEUTERIUM_COST_IONCANNON;
					break;
				
				case 6:
					costeMetalDeuterio[0] += Variables.METAL_COST_PLASMACANNON;
					costeMetalDeuterio[1] += Variables.DEUTERIUM_COST_PLASMACANNON;
					break;
					
				}	
			}		
		}		
		return costeMetalDeuterio;
	}
	
	
	
	/** Almacenar n�mero de unidades iniciales de cada equipo:*/
	private int initialFleetNumber(ArrayList<MilitaryUnit>[] army) {
		
		int initialNum = 0;
		 
		for(int i = 0; i < army.length; i++) {
			
			for(int j = 0; j < army[i].size(); j++) {
				
				initialNum++;		
			}			
		}	
				
		return initialNum;	
	}
	
	
	
	private int remainderPercentageFleet(ArrayList<MilitaryUnit>[] army) {
		
		
		
		return 0;
	}
	
	
	
	private int getGroupDefender(ArrayList<MilitaryUnit>[] army) {
		
		
		
		return 0;
	}
	
	
	
	private int getPlanetGroupAttacker() {
		
		
		
		return 0;
	}
	
	
	private int getEnemyGroupAttacker() {
		
		
		
		return 0;
	}
	
	
	
	private void resetArmyArmor() {
		
			
	}
	
	
}
