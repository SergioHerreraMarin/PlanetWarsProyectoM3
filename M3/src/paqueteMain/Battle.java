package paqueteMain;
import java.util.ArrayList;
import java.util.Random;

public class Battle {

	private enum Atacante {PLANET, ENEMY};
	private int currentNumBattle = 0; //N�mero de batalla actual. 
	private ArrayList<MilitaryUnit>[] planetArmy; //Almacena flota de nuestro planeta.
	private ArrayList<MilitaryUnit>[] enemyArmy; //Almacena la flota enemiga. 	
	
	//Fila[0] unidades planeta, fila[1] unidades enemigas
	private ArrayList<MilitaryUnit>[][] armies = new ArrayList[2][7]; //Array de 2row 7column. Almacena nuestro ej�rcito y ej�rcito enemigo. 
	
	private String[] battleDevelopment = new String[5]; //Contiene el desarrollo de la batalla paso a paso. N�mero de batallas que se pueden guardar. 
	
	//Fila[0] coste unidades planeta [0][0] metal, [0][1] deuterio..
	private int[][] initialCostFleet; //Almacena el coste inicial de metal y deuterio de las flotas. Para saber las p�rdidas en materiales de cada flota. 
	
	
	private int initialNumberUnitsPlanet, initialNumberUnitsEnemy; //N�mero de unidades iniciales de cada equipo. 
	private int currentNumberUnitsPlanet, currentNumberUnitsEnemy;
	
	private int[] wasteMetalDeuterium; //Num de residuos generados en la batalla, [0]metal, [1]deuterium

	//Unidades perdidas de cada equipo
	private int[] enemyDrops;
	private int[] planetDrops;
	
	
	private int[][] resourcesLooses = new int[2][3]; //2Filas, 3Columnas, 
	
	private int[][] initialArmies = new int[2][7]; //Array de 2row 7column. Almacena la cantidad de cada tipo de flota del ejercito planeta y el ejercito enemigo al INICIO. 
	
	
	private int[] actualNumberUnitsPlanet = new int[7]; //Almacena la cantidad de cada tipo de flota del ejercito planeta y el ejercito enemigo ACTUAL.  
	private int[] actualNumberUnitsEnemy = new int[4];
	
	
	
	public Battle(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
		
		this.planetArmy = planetArmy;
		this.enemyArmy = enemyArmy;

				
		//A�adir flotas a array bidimensional: 
		for(int i = 0; i < 2; i++) {
			
			for(int j = 0; j < 7; j++) {
				
				switch(i) {
				
				case 0: //Unidades planeta
					
					armies[i][j] = this.planetArmy[j];
					
					break;
				
				case 1: //Unidades enemigo
					
					armies[i][j] = this.enemyArmy[j];
					
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
		
		
	
	
	/**Metodo para empezar batalla. */
	public void startBattle(Planet planet) { //Objeto planet para llevarse el metal y deuterio en caso de ganar. 
		
		Atacante atacante = null;
		boolean generaResiduos = false;
		Random random = new Random();
		int grupoAtacanteIndex = 0, grupoDefensaIndex = 0; //Indice del array del "grupo" que ataca. 
		boolean continueBattle = false, repetirAtaque = false, inicio = true; //Inicio es true solo la primera ronda. 
		int tipoInstanciaActual = 0; 
		int residuosMetal, residuosDeuterium;
		int eleccionAtacante = 0;
		
		MilitaryUnit unidadAtacante = null;
		MilitaryUnit unidadDefensa = null;
		
		
		//Al inicio se eleige equipo atacante 0 = planeta, 1 = enemigo:
		currentNumBattle++;
		eleccionAtacante = random.nextInt(0, 2);

			
		do {
			
			//Si el ataque no se repite se cambia el orden, si se repite no se cambia. Si el inicio es true esto no se ejecuta.  
			if(repetirAtaque == false && inicio == false) {
				
				if(eleccionAtacante == 0) {
					eleccionAtacante = 1;
				}else if(eleccionAtacante == 1) {
					eleccionAtacante = 0;
				}		
				
			}
			
			switch(eleccionAtacante) {
			
			case 0:
				atacante = Atacante.PLANET;
			
				//Elección "grupo" del atacante:
				grupoAtacanteIndex = chooseAttackGroup(Variables.CHANCE_ATTACK_PLANET_UNITS);
				//Seleccionar nave al azar del "grupo" atacante: 	
				unidadAtacante = planetArmy[grupoAtacanteIndex].get(random.nextInt(0,actualNumberUnitsPlanet[grupoAtacanteIndex]));
					
				//Elección "grupo" del defensa:
				grupoDefensaIndex = chooseDefenseGroup(actualNumberUnitsEnemy);
				//Seleccionar nave al azar del "grupo" del defensa: 
				unidadDefensa = enemyArmy[grupoDefensaIndex].get(random.nextInt(0,actualNumberUnitsEnemy[grupoAtacanteIndex]));
						
				break;
				
			case 1:
				atacante = Atacante.ENEMY;
				
				//Elección "grupo" del atacante:
				grupoAtacanteIndex = chooseAttackGroup(Variables.CHANCE_ATTACK_ENEMY_UNITS);
				//Seleccionar nave al azar del "grupo" atacante: 	
				unidadAtacante = enemyArmy[grupoAtacanteIndex].get(random.nextInt(0,actualNumberUnitsEnemy[grupoAtacanteIndex]));
					
				//Elección "grupo" del defensa:
				grupoDefensaIndex = chooseDefenseGroup(actualNumberUnitsPlanet);
				//Seleccionar nave al azar del "grupo" del defensa: 
				unidadDefensa = planetArmy[grupoDefensaIndex].get(random.nextInt(0,actualNumberUnitsPlanet[grupoAtacanteIndex]));	
				break;
				
			default:
				System.out.println("ERROR: No deber�as de ver esto.");
				break;
			}
			
			
			//Ataque 
			unidadDefensa.tekeDamage(unidadAtacante.attack());
			
			
			//Comprobar armadura. 
			if(unidadDefensa.getActualArmor() <= 0) {
				
				//Comprobar si genera residuos: 
				tipoInstanciaActual = typeInstance(unidadDefensa);
				switch(tipoInstanciaActual) {
				
				case 0:
					generaResiduos = generaResidus(Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER);
					break;
				case 1:
					generaResiduos = generaResidus(Variables.CHANCE_GENERATNG_WASTE_HEAVYHUNTER);
					break;
				case 2:
					generaResiduos = generaResidus(Variables.CHANCE_GENERATNG_WASTE_BATTLESHIP);
					break;
				case 3:
					generaResiduos = generaResidus(Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP);
					break;
				case 4:
					generaResiduos = generaResidus(Variables.CHANCE_GENERATNG_WASTE_MISSILELAUNCHER);
					break;
				case 5:
					generaResiduos = generaResidus(Variables.CHANCE_GENERATNG_WASTE_IONCANNON);
					break;
				case 6:
					generaResiduos = generaResidus(Variables.CHANCE_GENERATNG_WASTE_PLASMACANNON);
					break;		
				}
				
				
				if(generaResiduos) { //Si genera residuos
					
					generarResiduos(tipoInstanciaActual, atacante);	//Generar residuos			
				}
			
				//Delete unidad 
				deleteUnit(atacante, unidadDefensa, grupoDefensaIndex);
				updateUnits(); //Actualiza 
			}
			
			
			repetirAtaque = isRepeatAttack(tipoInstanciaActual);
			
			continueBattle = currentNumberUnitsPlanet >= (int)(initialNumberUnitsPlanet * 0.2) && currentNumberUnitsEnemy >= (int)(initialNumberUnitsEnemy * 0.2);
	
		}while(continueBattle); 
		
		
		//MIRAR
		if(resourcesLooses[0][2] < resourcesLooses[1][2]) { //Perdidas ponderadas
			
			System.out.println("Gana el planeta!");
			planet.setMetal(planet.getMetal() + wasteMetalDeuterium[0]);
			planet.setDeuterium(planet.getDeuterium() + wasteMetalDeuterium[1]);
			
		}else {
			
			System.out.println("Gana el enemigo!");
		}
			
	}
	
	
	
	/**Inicializa el array InitialArmies, para saber el n�mero de cada tipo de flota al inicio del planeta y enemigo*/
	private void initialArmies() {
			
		for(int i = 0; i < initialArmies.length; i++) {
			
			for(int j = 0; j < initialArmies[i].length; j++) {
				
				initialArmies[i][j] = armies[i][j].size();		
			}		
		}		
	}
	
	
	
	/**Devuelve un array con el coste total de metal y deuterium de la flota que pasemos por par�metro. [0] = metal, [1] = deuterium*/
	private int[] fleetResourceCost(ArrayList<MilitaryUnit>[] army) {
		
		
		//[0] = LigthHunter, [1] = HeavyHunter, [2] = BattleShip, [3] = ArmoredShip, [4] = MissileLauncher, [5] = IonCannon, [6] = PlasmaCannon
		
		int[] costeMetalDeuterio = new int[2]; //[0] = metal, [1] = deuterio
		
		for(int i = 0; i < army.length; i++) {
			
			for(int j = 0; j < army[i].size(); j++) {
				
				switch(j) {
				
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
	
	

	/**Devuelve el ejercito que empieza a atacar 0 = ejercito plaeta, 1 = ejercito enemigo*/
	private int chooseTeam() {
		
		if(Math.random() > 0.5) {		
			return 0;		
		}else {		
			return 1;
		}	
	}
	
	
	/**Escoger el grupo que ataca del ejercito. Devuelve el índice del array del grupo qur atacará*/
	private int chooseAttackGroup(int[] porcentajes) {
	
		int total = 0,	randomNum = 0, indice = 0;
		
		total = porcentajes.length;	
		randomNum = (int)(Math.random() * total);
		
		for(int i = 0, suma = 0; i < porcentajes.length; i++) {
			
			suma += porcentajes[i];
			
			if(suma > randomNum) {
				indice = i;
				break;
			}
		}	
		return indice;	
	}
		
	
	/**Escoger el grupo que defiende del ejercito. Devuelve el índice del array del grupo que atacará*/
	private int chooseDefenseGroup(int[] numberUnits) {
		
		int[] probabilidades = new int[numberUnits.length]; //Array probabilidades según número de unidades
		int totalUnidades = 0;
		
		//total unidades
		for(int i = 0; i < numberUnits.length; i++) {
			totalUnidades += numberUnits[i];
		}
					
		for(int i = 0; i < numberUnits.length; i++) {
			
			probabilidades[i] = 100 * numberUnits[i] / totalUnidades;		
		}
		
		//A partir de aquí la formula es igual a la de este método. 
		return chooseAttackGroup(probabilidades);		
	}
	
	
	/**Devuelve el índice del array equivalente a la instancia del objeto*/
	private int typeInstance(MilitaryUnit o) {
		
		if(o instanceof LightHunter) {
			
			return 0;	
		}else if(o instanceof HeavyHunter) {
			
			return 1;	
		}else if(o instanceof BattleShip) {
			
			return 2;
		}else if(o instanceof ArmoredShip) {
			
			return 3;
		}else if(o instanceof MissileLauncher) {
			
			return 4;
		}else if(o instanceof IonCannon) {
			
			return 5;
		}else if(o instanceof PlasmaCannon) {
			
			return 6;
			
		}else {
			return -1;
		}		
	}
	
	/**Devuelve true o false según si se cumple la probabilidad o no*/
	public boolean generaResidus(int probabilidad) {
		
		Random random = new Random();
		int randomNum;
		
		randomNum = random.nextInt(0, 100);
		
		if(randomNum <= probabilidad) {
			
			return true;
		}else {
			return false;
		}
	}
	
	/**Pasamos el tipo de instancia y genera los residuos de esa instancia. */
	public void generarResiduos(int tipoInstanciaActual, Atacante atacante) {
		
		//Si ataca el enemigo los residuos son del planeta, si ataca el planeta los residuos son del enemigo
		if(atacante == Atacante.PLANET) {
			
			switch(tipoInstanciaActual) {
			
			case 0:
				resourcesLooses[1][0] += Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][1] += Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 1:
				resourcesLooses[1][0] += Variables.METAL_COST_HEAVYHUNTER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][1] += Variables.DEUTERIUM_COST_HEAVYHUNTER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 2:
				resourcesLooses[1][0] += Variables.METAL_COST_BATTLESHIP * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][1] += Variables.DEUTERIUM_COST_BATTLESHIP * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 3:
				resourcesLooses[1][0] += Variables.METAL_COST_ARMOREDSHIP * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][1] += Variables.DEUTERIUM_COST_ARMOREDSHIP * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 4:
				resourcesLooses[1][0] += Variables.METAL_COST_MISSILELAUNCHER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][1] += Variables.DEUTERIUM_COST_MISSILELAUNCHER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 5:
				resourcesLooses[1][0] += Variables.METAL_COST_IONCANNON * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][1] += Variables.DEUTERIUM_COST_IONCANNON * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 6:
				resourcesLooses[1][0] += Variables.METAL_COST_PLASMACANNON * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][1] += Variables.DEUTERIUM_COST_PLASMACANNON * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[1][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;		
			}
					
		}else if(atacante == Atacante.ENEMY) {
			
			switch(tipoInstanciaActual) {
			
			case 0:
				resourcesLooses[0][0] += Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][1] += Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 1:
				resourcesLooses[0][0] += Variables.METAL_COST_HEAVYHUNTER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][1] += Variables.DEUTERIUM_COST_HEAVYHUNTER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 2:
				resourcesLooses[0][0] += Variables.METAL_COST_BATTLESHIP * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][1] += Variables.DEUTERIUM_COST_BATTLESHIP * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 3:
				resourcesLooses[0][0] += Variables.METAL_COST_ARMOREDSHIP * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][1] += Variables.DEUTERIUM_COST_ARMOREDSHIP * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 4:
				resourcesLooses[0][0] += Variables.METAL_COST_MISSILELAUNCHER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][1] += Variables.DEUTERIUM_COST_MISSILELAUNCHER * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 5:
				resourcesLooses[0][0] += Variables.METAL_COST_IONCANNON * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][1] += Variables.DEUTERIUM_COST_IONCANNON * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;
			case 6:
				resourcesLooses[0][0] += Variables.METAL_COST_PLASMACANNON * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][1] += Variables.DEUTERIUM_COST_PLASMACANNON * (Variables.PERCENTATGE_WASTE / 100);
				resourcesLooses[0][2] += (Variables.METAL_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100)) + 5 
										* (Variables.DEUTERIUM_COST_LIGTHHUNTER * (Variables.PERCENTATGE_WASTE / 100));
				break;		
			}				
		}
		
		wasteMetalDeuterium[0] = resourcesLooses[0][0] + resourcesLooses[1][0]; //Perdidas totales metal planeta + enemigo
		wasteMetalDeuterium[1] = resourcesLooses[0][1] + resourcesLooses[1][1];	//Perdidas totales deuterium planeta + enemigo
		
	}
		
		
	public boolean isRepeatAttack(int tipoInstanciaActual) {
			
		Random random = new Random();
		int numRandom;
		
		numRandom = random.nextInt(0, 100);
		
		switch(tipoInstanciaActual) {
		
		case 0:
			
			if(Variables.CHANCE_ATTACK_AGAIN_LIGTHHUNTER <= numRandom) {
				return true;
			}else {
				return false;
			}
			
		case 1:
			if(Variables.CHANCE_ATTACK_AGAIN_HEAVYHUNTER <= numRandom) {
				return true;
			}else {
				return false;
			}
		case 2:
			if(Variables.CHANCE_ATTACK_AGAIN_BATTLESHIP <= numRandom) {
				return true;
			}else {
				return false;
			}
		case 3:
			if(Variables.CHANCE_ATTACK_AGAIN_ARMOREDSHIP <= numRandom) {
				return true;
			}else {
				return false;
			}
		case 4:
			if(Variables.CHANCE_ATTACK_AGAIN_MISSILELAUNCHER <= numRandom) {
				return true;
			}else {
				return false;
			}
		case 5:
			if(Variables.CHANCE_ATTACK_AGAIN_IONCANNON <= numRandom) {
				return true;
			}else {
				return false;
			}
		case 6:
			if(Variables.CHANCE_ATTACK_AGAIN_PLASMACANNON <= numRandom) {
				return true;
			}else {
				return false;
			}	
		default:
			System.out.println("ERROR: No deberías de ver esto.");
			return false;
		}	
	}
		
		
	public void deleteUnit(Atacante atacante, MilitaryUnit o, int grupoDefensaIndex) {
		
		if(atacante == Atacante.PLANET) {
			
			enemyArmy[grupoDefensaIndex].remove(o);
			enemyDrops[grupoDefensaIndex] += 1; //Sumamos una perdida en el array drops. 
			
		}else if(atacante == Atacante.PLANET) {
						
			planetArmy[grupoDefensaIndex].remove(o);
			planetDrops[grupoDefensaIndex] += 1; //Sumamos una perdida en el array drops. 
			
		}	
	}
	
	
	/**Updatea los arrays de actualNumberUnitsPlanet y actualNumberUnitsEnemy*/
	public void updateUnits() {
				
		for(int i = 0; i < planetArmy.length; i++) {

			actualNumberUnitsPlanet[i] += planetArmy[i].size();		
			currentNumberUnitsPlanet += planetArmy[i].size();	
		}
		
		for(int i = 0; i < enemyArmy.length; i++) {

			actualNumberUnitsEnemy[i] += enemyArmy[i].size();	
			currentNumberUnitsEnemy += enemyArmy[i].size();	
		}
		
	}
	
	
	
	String getBattleReport(int battles) {
		
		
		return "";
	}
	
	
	
	
}
