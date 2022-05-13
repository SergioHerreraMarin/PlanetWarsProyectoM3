package paqueteMain;
import java.util.ArrayList;
import java.util.Random;

public class Battle {

	private enum Atacante {PLANET, ENEMY}; //INDICA LA FLOTA ATACANTE 
	String winner; //STRING CON EL GANADOR
	
	//FLOTAS
	private ArrayList<MilitaryUnit>[] planetArmy = new ArrayList[7];  //ALMACENA LOS OBJETOS DE LA FLOTA DEL PLANETA
	private ArrayList<MilitaryUnit>[] enemyArmy = new ArrayList[4];   //ALMACENA LOS OBJETOS DE LA FLOTA DEL ENEMIGO	
	private ArrayList<MilitaryUnit>[][] armies = new ArrayList[2][7]; //ALMACENA LOS OBJETOS DE LA FLOTA DEL PLANETA[0] Y DE LA FLOTA DEL ENEMIGO[1]
	//REPORTE
	private String battleDevelopment; //REPORTE DE LA BATALLA 		
	//AL INICIO 
	private int[][] initialArmies = new int[2][7]; //CANTIDAD DE UNIDADES DE CADA GRUPO DEL PLANETA[0] Y DEL ENEMIGO[1] AL INICIO  
	private int initialNumberUnitsPlanet; //CANTIDAD TOTAL DE UNIDADES DE LA FLOTA DEL PLANETA AL INICIO DEL COMBATE AL INICIO
	private int initialNumberUnitsEnemy;  //CANTIDAD TOTAL DE UNIDADES DE LA FLOTA DEL ENEMIGO AL INICIO DEL COMBATE AL INICIO
	//ACTUALIZA
	private int[] actualNumberUnitsPlanet = new int[7]; //CANTIDAD ACTUAL DE UNIDADES DE CADA "GRUPO" DEL PLANETA ACTUALMENTE
	private int[] actualNumberUnitsEnemy = new int[4];  //CANTIDAD ACTUAL DE UNIDADES DE CADA "GRUPO" DEL ENEMIGO ACTUALMENTE
	private int currentNumberUnitsTotalPlanet; //CANTIDAD TOTAL DE UNIDADES DE LA FLOTA DEL PLANETA ACTUALMENTE
	private int currentNumberUnitsTotalEnemy; //CANTIDAD TOTAL DE UNIDADES DE LA FLOTA DEL ENEMIGO ACTUALMENTE
	//RESIDUOS
	private int[][] initialCostFleet = new int[2][2]; //ALMACENA EL COSTE INICIAL DE METAL[0] Y DEUTERIO[1] DE LA FLOTA PLANETA[0] Y LA FLOTA ENEMIGA[1]
	private int[][] resourcesLooses = new int[2][3]; //PERDIDAS DE RESIDUOS DEL PLANETA[0] Y DEL ENEMIGO [1] 
	private int[] wasteMetalDeuterium = new int[2]; //CANTIDAD DE RESIDUOS TOTALES GENERADOS EN LA BATALLA, [0]METAL, [1]DEUTERIUM
	//UNIDADES PERDIDAS
	private int[] planetDrops = new int[7]; //CANTIDAD DE UNIDADES PERDIDAS DEL PLANETA EN CADA "GRUPO" 
	private int[] enemyDrops = new int[4]; //CANTIDAD DE UNIDADES PERDIDAS DEL ENEMIGO EN CADA "GRUPO" 
	//OBJETOS DE UNIDAD ATACANTE Y DEFENSA 
	MilitaryUnit unidadAtacante = null;
	MilitaryUnit unidadDefensa = null;
	
	
	public Battle(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
		
		this.planetArmy = planetArmy;
		this.enemyArmy = enemyArmy;

		//INICIALIZAR ARRAY ENEMIES 	
		for(int i = 0; i < armies.length; i++) {
			
			for(int j = 0; j < armies[i].length; j++) {
				
				armies[i][j] = new ArrayList<MilitaryUnit>();
			}	
		}
		
		//ADD FLOTAS DEL PLANETAY ENEMIGO AL ARRAY ENEMIES
		for(int i = 0; i < armies.length; i++) {
			
			switch(i) {
			case 0:		
				for(int j = 0; j < planetArmy.length; j++) {
					armies[i][j] = planetArmy[j];
				}	
				break;
			
			case 1:
				for(int j = 0; j < enemyArmy.length; j++) {
					armies[i][j] = enemyArmy[j];
				}
				break;	
			}				
		}	
				
		//ALMACENTA NUMERO DE UNIDADES TOTALES DE CADA FLOTA 
		initialNumberUnitsPlanet = totalUnitsArmy(planetArmy);
		initialNumberUnitsEnemy = totalUnitsArmy(enemyArmy);
				
		//ALMACENA COSTE TOTAL INICIAL DE METAL Y DEUTERIO DE CADA EJERCITO  
		initialCostFleet[0][0] = fleetResourceCost(planetArmy)[0]; //TOTAL METAL PLANETA
		initialCostFleet[0][1] = fleetResourceCost(planetArmy)[1]; //TOTAL DEUTERIO PLANETA
		initialCostFleet[1][0] = fleetResourceCost(enemyArmy)[0];  //TOTAL METAL ENEMIGO
		initialCostFleet[1][1] = fleetResourceCost(enemyArmy)[1];  //TOTAL DEUTERIUM ENEMIGO
		
		initialArmies(); //ACTUALIZA EL ARRAY DE INITIAL_ARMIES, PARA SABER LA CANTIDAD DE CADA TIPO DE UNIDAD DE LA FLOTA DEL PLANETA Y DEL ENEMIGO 
	}	
		
		
	
	
	/**EMPEZAR UNA BATALLA*/
	public void startBattle(Planet planet) { //OBJETO PLANETA PARA RECOGER LOS RESTOS DE METAL Y DEUTERIO EN CASO DE GANAR  
		
		Atacante atacante = null; //PARA SABER QUIEN ATACA Y QUIEN DEFIENDE
		boolean generaResiduos = false; //PARA SABER SI SE GENERAN RESIDUOS
		Random random = new Random();
		int grupoAtacanteIndex = 0, grupoDefensaIndex = 0; //INDICE DEL ARRAY PARA SABER EL GRUPO ATACANTE Y EL GRUPO DEFENSA  
		boolean continueBattle = false, repetirAtaque = false, inicio = true; //INICIO ES TRUE SOLO LA PRIMERA RONDA 
		int tipoInstanciaActual = 0; 
		int eleccionAtacante = 0; 
		

		//AL INICIO SE ELIGE EL ATACANTE Y DEFENSOR: 0 = ATACANTE, 1 = DEFENSOR
		eleccionAtacante = random.nextInt(0, 2);
			
		do {
			
			//SI EL ATAQUE NO SE REPITA SE CAMBIA EL ORDEN, SI SE REPITE NO SE CAMBIA. SI EL INICIO ES TRUE ESTO NO SE EJECUTA
			if(repetirAtaque == false && inicio == false) {
				
				if(eleccionAtacante == 0) {
					eleccionAtacante = 1;
				}else if(eleccionAtacante == 1) {
					eleccionAtacante = 0;
				}		
				battleDevelopment += "\n\n********************CHANGE ATTACKER********************";
			}
			
			updateUnitsGroup(); //ACTUALIZA LA CANTIDAD TOTAL DE UNIDADES DE CADA GRUPO DE LA FLOTA PLANETA Y ENEMIGA 
			
			switch(eleccionAtacante) {
			
			case 0:
				atacante = Atacante.PLANET;
			
				//ELECCION "GRUPO" DEL ATACANTE: 
				grupoAtacanteIndex = chooseAttackGroup(Variables.CHANCE_ATTACK_PLANET_UNITS,planetArmy); //ELECCION DEL GRUPO 
				System.out.println("index grupo planeta atacante: " + grupoAtacanteIndex);
				//SELECCIONAR UNIDAD AL AZAR DEL "GRUPO" ELEGIDO DE ATAQUE:  	
				System.out.println("Num unidades: " + actualNumberUnitsPlanet[grupoAtacanteIndex]);
				unidadAtacante = planetArmy[grupoAtacanteIndex].get(random.nextInt(0,actualNumberUnitsPlanet[grupoAtacanteIndex]));
					
				//ELECCION "GRUPO" DEL DEFENSA:
				grupoDefensaIndex = chooseDefenseGroup(actualNumberUnitsEnemy,enemyArmy);
				System.out.println("index grupo enemigo defensa: " + grupoDefensaIndex);
				//SELECCIONAR UNIDAD AL AZAR DEL "GRUPO" ELEGIDO DE DEFENSA:   
				unidadDefensa = enemyArmy[grupoDefensaIndex].get(random.nextInt(0,actualNumberUnitsEnemy[grupoDefensaIndex]));
				//REPORTE:
				battleDevelopment += "\nAttacks Planet:" + typeInstanceName(unidadAtacante) + " attacks " + typeInstanceName(unidadDefensa);				
				break;
				
			case 1:
				atacante = Atacante.ENEMY;
				
				//ELECCION "GRUPO" DEL ATACANTE: 
				grupoAtacanteIndex = chooseAttackGroup(Variables.CHANCE_ATTACK_ENEMY_UNITS, enemyArmy);
				System.out.println("index grupo planeta enemigo: " + grupoAtacanteIndex);
				//SELECCIONAR UNIDAD AL AZAR DEL "GRUPO" ELEGIDO DE ATAQUE:	
				unidadAtacante = enemyArmy[grupoAtacanteIndex].get(random.nextInt(0,actualNumberUnitsEnemy[grupoAtacanteIndex]));
					
				//ELECCION "GRUPO" DEL DEFENSA:
				grupoDefensaIndex = chooseDefenseGroup(actualNumberUnitsPlanet, planetArmy);
				System.out.println("index grupo planeta defensa: " + grupoDefensaIndex);
				//SELECCIONAR UNIDAD AL AZAR DEL "GRUPO" ELEGIDO DE DEFENSA:
				unidadDefensa = planetArmy[grupoDefensaIndex].get(random.nextInt(0,actualNumberUnitsPlanet[grupoDefensaIndex]));	
				//REPORTE:
				battleDevelopment += "\nAttacks fleet Enemy:" + typeInstanceName(unidadAtacante) + " attacks " + typeInstanceName(unidadDefensa);	
				break;
				
			default:
				System.out.println("ERROR: No deber�as de ver esto.");
				break;
			}
			
			//PRUEBA, BORRAR:
			System.out.println("PRUEBA:" + unidadDefensa.getMetalCost() * Variables.PERCENTATGE_WASTE / 100); //???
			System.out.println("PRUEBA2: " + unidadDefensa.getMetalCost());
			
			
			//ATAQUE: 
			unidadDefensa.tekeDamage(unidadAtacante.attack());
			battleDevelopment += "\n" + typeInstanceName(unidadAtacante) + " generates the damage = " + unidadAtacante.attack();
			battleDevelopment += "\n" + typeInstanceName(unidadDefensa) + " stays with armor = " + unidadDefensa.getActualArmor();
			
			//COMPROBAR ESTADO DE ARMADURA:  
			if(unidadDefensa.getActualArmor() <= 0) {
				
				//COMPROBAR SI GENERA RESIDUOS: 
				generaResiduos = generaResidus(unidadDefensa.getChanceGeneratinWaste());
					
				//SI GENERA RESIDUOS: 
				if(generaResiduos) { 
					
					generarResiduos(atacante);	//GENERAR RESIDUOS: 		
				}
			
				//ELIMINAR UNIDAD: 
				deleteUnit(atacante, unidadDefensa, grupoDefensaIndex);
				 
				if(atacante == Atacante.PLANET) {	
					battleDevelopment += "\nWe eliminate " + typeInstanceName(unidadDefensa); 
				
				}else if(atacante == Atacante.ENEMY) {	
					battleDevelopment += "\nEnemy eliminate " + typeInstanceName(unidadDefensa);
				}				
			}
			
			//CALCULAR SI SE REPITE EL ATAQUE: 
			repetirAtaque = isRepeatAttack();
			
			//DESPUES DEL ATAQUE SE CALCULA EL NUMERO ACTUAL DE UNIDADES DE LA FLOTA PLANETA Y ENEMIGO: 
			currentNumberUnitsTotalPlanet = totalUnitsArmy(planetArmy);
			currentNumberUnitsTotalEnemy = totalUnitsArmy(enemyArmy);
				
			//CALCULAMOS SI SE CONTINUA LA BATALLA O NO SEGUN EL TOTAL DE UNIDADES ACTUALES DE CADA FLOTA:
			continueBattle = currentNumberUnitsTotalPlanet >= (int)(initialNumberUnitsPlanet * 0.2) && currentNumberUnitsTotalEnemy >= (int)(initialNumberUnitsEnemy * 0.2);
			
			inicio = false;
			//System.out.println("Current units planet: " + currentNumberUnitsTotalPlanet + " > 20% inicial: " + (int)(initialNumberUnitsPlanet * 0.2) + "\nCurrent units enemy: " + currentNumberUnitsTotalEnemy + " > 20% inicial: " + (int)(initialNumberUnitsEnemy * 0.2));
			
			
		}while(continueBattle); 
		
		
		//SI SE TERMINA LA BATALLA, DECIDIR QUIEN GANA SEGUN LOS RESIDUOS: 
		if((resourcesLooses[0][0] + resourcesLooses[0][1] * 5) < (resourcesLooses[1][0] + resourcesLooses[1][1] * 5)) { 
			
			System.out.println("GANA EL PLANETA");
			planet.setMetal(planet.getMetal() + wasteMetalDeuterium[0]);
			planet.setDeuterium(planet.getDeuterium() + wasteMetalDeuterium[1]);
			winner = "Planet";
			
		}else {
			
			System.out.println("GANA EL ENEMIGO");
			winner = "Enemy";
		}
			
	}
	
	
	/**ACTUALIZA EL ARRAY DE INITIAL_ARMIES QUE CONTIENE LA CANTIDAD TOTAL DE UNIDADES DE CADA GRUPO DE LA FLOTA DEL
	 * PLANETA Y LA DEL ENEMIGO*/
	private void initialArmies() {
			
		for(int i = 0; i < armies.length; i++) {
			
			for(int j = 0; j < armies[i].length; j++) {
				
				initialArmies[i][j] = armies[i][j].size();			
			}		
		}				
	}
	
	
	/**DEVUELVE UN ARRAY CON EL COSTE TOTAL DE METAL Y DEUTERIUM QUE CONTIENE UNA FLOTA. [0] = METAL, [1] = DEUTERIUM*/
	private int[] fleetResourceCost(ArrayList<MilitaryUnit>[] army) {
					
		int[] costeMetalDeuterio = new int[2]; //[0] = METAL, [1] = DEUTERIO
			
		for(int i = 0; i < army.length; i++) {
			
			for(MilitaryUnit u : army[i]) {
				
				costeMetalDeuterio[0] += u.getMetalCost();
				costeMetalDeuterio[1] += u.getDeuteriumCost();
			}		
		}
		
		return costeMetalDeuterio;
	}
	
	
	/**DEVUELVE EL NUMERO DE UNIDADES TOTALES QUE CONTIENE UNA FLOTA*/
	private int totalUnitsArmy(ArrayList<MilitaryUnit>[] army) {
		
		int initialNum = 0;
		 
		for(int i = 0; i < army.length; i++) {
			
			for(int j = 0; j < army[i].size(); j++) {			
				initialNum++;		
			}			
		}				
		return initialNum;	
	}
	
	
	/**ESCOGER EL GRUPO QUE ATACA DE LA FLOTA. DEVUELVE EL INDICE DEL ARRAY DEL GRUPO QUE ATACA*/
	private int chooseAttackGroup(int[] porcentajes,  ArrayList<MilitaryUnit>[] army) {
	
		Random random = new Random();
		int total = 0,	randomNum = 0, indice = 0;
		
		do {
			total = 0;
			//Calcular total porcentaje: 
			for(int i = 0; i < porcentajes.length; i++) {		
				total += porcentajes[i];		
			}
			
			//Genera num Random 
			//System.out.println("POR SI PETA, TOTAL: " + total);
			randomNum = random.nextInt(0, total); //Peta porque el total no puede ser 0..
			//System.out.println("POR SI PETA, RANDOM NUM: " + randomNum);
			for(int i = 0, suma = 0; i < porcentajes.length; i++) {
				
				suma += porcentajes[i];
				
				if(randomNum <= suma) {
					indice = i;
					break;
				}
			}
					
		}while(army[indice].size() == 0);
		
			
		return indice;	
	}
		
	
	/**ESCOGER EL GRUPO QUE DEFIENDE DE LA FLOTA. DEVUELVE EL INDICE DEL ARRAY DEL GRUPO QUE DEFIENDE*/
	private int chooseDefenseGroup(int[] numberUnits,  ArrayList<MilitaryUnit>[] army) {
		
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
		return chooseAttackGroup(probabilidades,army);		
	}
	
		
	/**DEVUELVE EL NOMBRE DEL TIPO DE INSTANCIA, SE USA PARA LOS REPORTES*/
	private String typeInstanceName(MilitaryUnit o) {
		
		if(o instanceof LightHunter) {
			
			return "Ligth Hunter";	
		}else if(o instanceof HeavyHunter) {
			
			return "Heavy Hunter";	
		}else if(o instanceof BattleShip) {
			
			return "Battle Ship";
		}else if(o instanceof ArmoredShip) {
			
			return "Armored Ship";
		}else if(o instanceof MissileLauncher) {
			
			return "Missile Launcher";
		}else if(o instanceof IonCannon) {
			
			return "Ion Cannon";
		}else if(o instanceof PlasmaCannon) {
			
			return "Plasma Cannon";
			
		}else {
			return "ERROR: Instancia no válida";
		}		
	}
		
	
	/**DEVUELVE TRUE O FALSE SEGUN DE CUMPLE UNA PROBABILIDAD O NO*/
	private boolean generaResidus(int probabilidad) {
		
		Random random = new Random();
		int randomNum;
		
		randomNum = random.nextInt(0, 100);
		
		if(randomNum <= probabilidad) {			
			return true;
		}else {
			return false;
		}
	}
	
	
	/**SE GENERAN LOS RESIDUOS DE LA UNIDAD DE DEFENSA CORRESPONDIENTE*/
	private void generarResiduos(Atacante atacante) {
		
		//System.out.println("GENERA RESIDUOS");
		//SI ATACA EL PLANETA LOS RESIDUOS LOS GENERA EL ENEMIGO[1], SI ATACA EL ENEMIGO LOS GENERA EL PLANETA[0]
		if(atacante == Atacante.PLANET) {
			
			resourcesLooses[1][0] += unidadDefensa.getMetalCost() * Variables.PERCENTATGE_WASTE / 100;
			resourcesLooses[1][1] += unidadDefensa.getDeuteriumCost() * Variables.PERCENTATGE_WASTE / 100;
			resourcesLooses[1][2] += (unidadDefensa.getMetalCost() * Variables.PERCENTATGE_WASTE / 100) + 5 * (unidadDefensa.getDeuteriumCost() * Variables.PERCENTATGE_WASTE / 100);
							
		}else if(atacante == Atacante.ENEMY) {
			
			resourcesLooses[0][0] += unidadDefensa.getMetalCost() * Variables.PERCENTATGE_WASTE / 100;
			resourcesLooses[0][1] += unidadDefensa.getDeuteriumCost() * Variables.PERCENTATGE_WASTE / 100;
			resourcesLooses[0][2] += (unidadDefensa.getMetalCost() * Variables.PERCENTATGE_WASTE / 100) + 5 * (unidadDefensa.getDeuteriumCost() * Variables.PERCENTATGE_WASTE / 100);		
		}
		
		wasteMetalDeuterium[0] += resourcesLooses[0][0] + resourcesLooses[1][0]; //RESIDUOS TOTALES DE METAL DEL PLANETA + ENEMIGO
		wasteMetalDeuterium[1] += resourcesLooses[0][1] + resourcesLooses[1][1];	//RESIDUOS TOTALES DE DEUTERIUM DEL PLANETA + ENEMIGO 	
	}
		
	
	/**DEVUELVE TRUE O FALSE DEPENDIENDO DE SI SE REPITE EL ATAQUE O NO, SEGUN LA PROBABILIDAD DEL GRUPO DE UNIDAD QUE ESTE ATACANDO*/
	private boolean isRepeatAttack() {
			
		Random random = new Random();
		int numRandom;
		
		numRandom = random.nextInt(0, 100);
			
		if(unidadAtacante.getChanceAttackAgain() <= numRandom) {		
			return true;
		}else {	
			return false;
		}
	}
		
	
	/**ELIMINA EL OBJETO DE LA UNIDAD DE DEFENSA QUE LE PASEMOS*/
	public void deleteUnit(Atacante atacante, MilitaryUnit o, int grupoDefensaIndex) {
		
		if(atacante == Atacante.PLANET) {
			//System.out.println("WOLOLO 1");
			enemyArmy[grupoDefensaIndex].remove(o);
			enemyDrops[grupoDefensaIndex] += 1; //Sumamos una perdida en el array drops. 
			
		}else if(atacante == Atacante.ENEMY) {
			//System.out.println("WOLOLO 2");
			planetArmy[grupoDefensaIndex].remove(o);
			planetDrops[grupoDefensaIndex] += 1; //Sumamos una perdida en el array drops. 			
		}			
	}
	
	
	/**UPDATEA LOS ARRAYS DE ACTUAL_NUMBER_UNITS_PLANET Y ACTUAL_NUMBER_UNITS_ENEMY CON EL TOTAL DE UNIDADES DE CADA GRUPO DE LA FLOTA
	 * DEL PLANETA Y LA FLOTA ENEMIGA  */
	private void updateUnitsGroup() {
				
		for(int i = 0; i < planetArmy.length; i++) {

			actualNumberUnitsPlanet[i] = planetArmy[i].size(); //ARRAY CON EL TOTAL DE UNIDADES DE CADA GRUPO DEL PLANETA
			//System.out.println("Unidades planeta pos " + i + ": " + actualNumberUnitsPlanet[i]);
		}
		
		for(int i = 0; i < enemyArmy.length; i++) {

			actualNumberUnitsEnemy[i] = enemyArmy[i].size(); //ARRAY CON EL TOTAL DE UNIDADES DE CADA GRUPO DEL ENEMIGO
			//System.out.println("Unidades enemigo pos " + i + ": " + actualNumberUnitsEnemy[i]);
		}	
	}
	
	
	/**MOSTRAR REPORTE DE LA BATALLA PASO A PASO*/
	public String getBattleReportStepByStep() {
							
		return battleDevelopment;
	}
	
	
	/**MOSTRAR REPORTE GENERAL DE LA BATALLA*/
	public String getBattleReportGeneral() {
		
		String megaReporte = "";
		megaReporte += "\nBATTLE STATISTICS";		
		
		megaReporte += "\n\nARMY PLANET              UNITS     DROPS";	
		megaReporte += "\nLigth Hunter" + "                " + initialArmies[0][0] + "         " + planetDrops[0] + 
					   "\nHeavy Hunter" + "                " + initialArmies[0][1] + "         " + planetDrops[1] + 
					   "\nBattle Ship" + "                " + initialArmies[0][2] + "         " + planetDrops[2] + 
					   "\nArmored Ship" + "                " + initialArmies[0][3] + "         " + planetDrops[3] + 
					   "\nMissile Launcher" + "                " + initialArmies[0][4] + "         " + planetDrops[4] + 
					   "\nIon Cannon" + "                " + initialArmies[0][5] + "         " + planetDrops[5] + 
					   "\nPlasma Cannon" + "                " + initialArmies[0][6] + "         " + planetDrops[6];
		
		megaReporte += "\n\nINITIAL ARMY ENEMY       UNITS     DROPS";
		megaReporte += "\nLigth Hunter" + "                " + initialArmies[1][0] + "        " + enemyDrops[0] + 
					   "\nHeavy Hunter" + "                " + initialArmies[1][1] + "        " + enemyDrops[1] + 
					   "\nBattle Ship" + "                " + initialArmies[1][2] + "        " + enemyDrops[2] + 
					   "\nArmored Ship" + "                " + initialArmies[1][3] + "        " + enemyDrops[3];
		
		megaReporte += "\n\n**************************************************************************************";
		
		megaReporte += "\nCOST ARMY PLANET                                  COST ARMY ENEMY";
		megaReporte += "\nMetal:" + "        " + initialCostFleet[0][0] + "                              " + "Metal:" + "        " + initialCostFleet[1][0] + 
				       "\nDeuterium:" + "     " + initialCostFleet[0][1] + "                              " + "Deuterium:" + "        " + initialCostFleet[1][1];
		
		
		megaReporte += "\n\n**************************************************************************************";
		
		megaReporte += "\nLOSSES ARMY PLANET                                LOSSES ARMY ENEMY";
		megaReporte +="\nMetal:" + "         " + resourcesLooses[0][0] + "                              " + resourcesLooses[1][0] + 
				      "\nDeuterium:" + "       " + resourcesLooses[0][1] + "                              " + resourcesLooses[1][1] + 
				      "\nWeighted:" + "      " + resourcesLooses[0][2] + "                              " + resourcesLooses[1][2];
		
		
		megaReporte += "\n\n**************************************************************************************";
		
		megaReporte += "\nWASTE GENERATED";
		megaReporte += "\nMetal:" + "          " + wasteMetalDeuterium[0] + 
				       "\nDeuterium:" + "        " + wasteMetalDeuterium[1];
		
		megaReporte += "\n\nBattle winned by " + winner + ", we collect rubble";
		
		return megaReporte;
	}
	
	
}
