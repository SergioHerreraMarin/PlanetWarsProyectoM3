import java.util.ArrayList;

public class Battle {

	//ATRIBUTOS
		//almacenar flota enemiga
	private ArrayList<MilitaryUnit>[] planetArmy;
	
		//almacenar flota de nuestro planeta
	private ArrayList<MilitaryUnit>[] enemyArmy;
	
		//almacenamos nuestro ejercito array1
		//almacenamos ejercito enemigo array2
	private ArrayList[][] armies;
	
		//guardamos todo el desarrollo de la batalla paso a paso
	private String battleDevelopment;
	
		//coste de metal deuterio de los ejercitos iniciales
	private int[][] initialCostFleet;
	
		//cantidad de unidades iniciales de cada ejercito
	private int initialNumberUnitsPlanet;
	private int initialNumberUnitsEnemy;
	
		//residuos generados en la batalla [metal, deuterio]
	private int[] wasteMetalDeuterium;
	
		//necesarios para generar reporte de batalla
		//necesarios para calcular las perdidas materiales de cada ejercito
	private int[] enemyDrops;
	private int[] planetDrops;
		
		//array de 2 filas y 3 columnas
	private int[][] resourcesLooses;
	//resourcesLooses[0] = {perdidas metal planeta, perdidas deuterio planeta, perdidas metal planeta + 5*perdidas de deuterio planeta};
	//resourcesLooses[1] = {perdidas metal enemigo, perdidas deuterio enemigo, perdidas metal enemigo + 5*perdidas de deuterio enemigo};
	//el ganador tendrá numero menor en la tercera columna
	//PÉRDIDA PONDERADA: ResourcesLooses[0][2]
	//PÉRDIDA PONDERADA: ResourcesLooses[1][2]

	
		//array de 2 filas y 7 columnas
		//para cuantificar cada tipo de unidad de los ejercitos iniciales
		//nos ayuda a calcular los costes de las flotas iniciales y por tanto las pérdidas
	private int[][] initialArmies;
	//InitialArmies[0] : unidades iniciales de nuestro planeta
	//InitialArmies[1] : las unidades iniciales enemigas
	//InitialArmies[0][0]: cazadores ligeros en nuestro planeta antes de iniciar batalla
	//InitialArmies[0][1]: cazadores pesados en nuestro planeta antes de iniciar batalla
	
		//cuantifican las unidades actuales de cada grupo, tanto para el planeta como paraa el enemigo
	private int[] actualNumberUnitsPlanet;
	private int[] actualNumberUnitsEnemy;
	//	actualNumberUnitsPlanet[0] --> cazadores ligeros
	//	actualNumberUnitsPlanet[1] --> cazadores pesados
	//	actualNumberUnitsPlanet[2] --> Naves de battalla
	//	actualNumberUnitsPlanet[3] --> Acorazados
	//	actualNumberUnitsPlanet[4] --> Lanzamisiles
	//	actualNumberUnitsPlanet[5] --> Cañones de iones
	//	actualNumberUnitsPlanet[6] --> Cañones de Plasma
	
	
	//#######################################################################################################

		//CONSTRUCTORES GETTERS Y SETTERS
	
	public ArrayList<MilitaryUnit>[] getPlanetArmy() {
		return planetArmy;
	}
	public void setPlanetArmy(ArrayList<MilitaryUnit>[] planetArmy) {
		this.planetArmy = planetArmy;
	}
	public ArrayList<MilitaryUnit>[] getEnemyArmy() {
		return enemyArmy;
	}
	public void setEnemyArmy(ArrayList<MilitaryUnit>[] enemyArmy) {
		this.enemyArmy = enemyArmy;
	}
	public ArrayList[][] getArmies() {
		return armies;
	}
	public void setArmies(ArrayList[][] armies) {
		this.armies = armies;
	}
	
	public void setBattleDevelopment(String battleDevelopment) {
		this.battleDevelopment = battleDevelopment;
	}
	public int[][] getInitialCostFleet() {
		return initialCostFleet;
	}
	public void setInitialCostFleet(int[][] initialCostFleet) {
		this.initialCostFleet = initialCostFleet;
	}
	public int getInitialNumberUnitsPlanet() {
		return initialNumberUnitsPlanet;
	}
	public void setInitialNumberUnitsPlanet(int initialNumberUnitsPlanet) {
		this.initialNumberUnitsPlanet = initialNumberUnitsPlanet;
	}
	public int getInitialNumberUnitsEnemy() {
		return initialNumberUnitsEnemy;
	}
	public void setInitialNumberUnitsEnemy(int initialNumberUnitsEnemy) {
		this.initialNumberUnitsEnemy = initialNumberUnitsEnemy;
	}
	public int[] getWasteMetalDeuterium() {
		return wasteMetalDeuterium;
	}
	public void setWasteMetalDeuterium(int[] wasteMetalDeuterium) {
		this.wasteMetalDeuterium = wasteMetalDeuterium;
	}
	public int[] getEnemyDrops() {
		return enemyDrops;
	}
	public void setEnemyDrops(int[] enemyDrops) {
		this.enemyDrops = enemyDrops;
	}
	public int[] getPlanetDrops() {
		return planetDrops;
	}
	public void setPlanetDrops(int[] planetDrops) {
		this.planetDrops = planetDrops;
	}
	public int[][] getResourcesLooses() {
		return resourcesLooses;
	}
	public void setResourcesLooses(int[][] resourcesLooses) {
		this.resourcesLooses = resourcesLooses;
	}
	public int[][] getInitialArmies() {
		return initialArmies;
	}
	public void setInitialArmies(int[][] initialArmies) {
		this.initialArmies = initialArmies;
	}
	public int[] getActualNumberUnitsPlanet() {
		return actualNumberUnitsPlanet;
	}
	public void setActualNumberUnitsPlanet(int[] actualNumberUnitsPlanet) {
		this.actualNumberUnitsPlanet = actualNumberUnitsPlanet;
	}
	public int[] getActualNumberUnitsEnemy() {
		return actualNumberUnitsEnemy;
	}
	public void setActualNumberUnitsEnemy(int[] actualNumberUnitsEnemy) {
		this.actualNumberUnitsEnemy = actualNumberUnitsEnemy;
	}
	
//#######################################################################################################

	//METODOS
	
	public String getBattleReport(int battles) {
		return battleDevelopment;
	}
	
	public String getBattleDevelopment() {
		return battleDevelopment;
	}
	
	//METODOS QUE PUEDEN SER UTILES PARA EL DESARROLLO DE LA BATALLA
		//para inicializar el array initialArmies y poder crear reportes
	public void initInitialArmies() {
		
	}
	
		//para generar array de pérdidas
	public void updateResourcesLooses() {
		
	}
	
		//para calcular costes de las flotas
	public void fleetResourceCost(ArrayList<MilitaryUnit>[] army) {
		
	}
	
		//para calcular el número de unidades iniciales de cada flota
	public void initialFleetNumber(ArrayList<MilitaryUnit>[] army) {
		
	}
	
		//para calcular los porcentajes de unidades que quedan respecto los ejércitos iniciales
	public int remainderPercentatgeFleet(ArrayList<MilitaryUnit>[] army) {
		return initialNumberUnitsEnemy;
		
	}
	
		//para que dado un ejército nos devuelva el grupo defensor
			//0-3 en el caso de la flota enemiga
			//0-6 en el caso del ejército de nuestro planeta
	public int getGroupDefender(ArrayList<MilitaryUnit>[] army) {
		return initialNumberUnitsEnemy;
		
	}
	
		//nos servirán para escoger el grupo atacante tanto
		//del planeta como de la flota enemiga
	public int getPlanetGroupAttacker() {
		return initialNumberUnitsEnemy;
		
	}

	
	//servirá para escoger el grupo atacante tanto del planeta como de la
	//flota enemiga
	public int getEnemyGroupAttacker() {
		return initialNumberUnitsEnemy;
	
	}
	
		//restablecerá los blindajes de nuestro ejército
	public void resetArmyArmor() {
		
	}
}
