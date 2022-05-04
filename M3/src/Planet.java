import java.util.ArrayList;
import java.util.Iterator;

public class Planet {

	private int technologyDefense, technologyAtack, metal, deuterium;
	private final int upgradeDefenseTechnologyDeuteriumCost = 10;
	private final int upgradeAttackTechnologyDeuteriumCost = 10;
	
	private ArrayList<MilitaryUnit>[] army = new ArrayList[7];

	
	
	public Planet() {
		
		technologyDefense = 1;
		technologyAtack = 1;
		
		army[0] = new ArrayList<LigthHunter>();
		army[1] = new ArrayList<HeavyHunter>();
		army[2] = new ArrayList<BattleShip>();
		army[3] = new ArrayList<ArmoredShip>();
		army[4] = new ArrayList<MissileLauncher>();
		army[5] = new ArrayList<IonCannon>();
		army[6] = new ArrayList<PlasmaCannon>();
		
	}
	
	

	public int getTechnologyDefense() {
		return technologyDefense;
	}


	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}


	public int getTechnologyAtack() {
		return technologyAtack;
	}


	public void setTechnologyAtack(int technologyAtack) {
		this.technologyAtack = technologyAtack;
	}


	public int getMetal() {
		return metal;
	}


	public void setMetal(int metal) {
		this.metal = metal;
	}


	public int getDeuterium() {
		return deuterium;
	}


	public void setDeuterium(int deuterium) {
		this.deuterium = deuterium;
	}




	public ArrayList<MilitaryUnit>[] getArmy() {
		return army;
	}


	public void setArmy(ArrayList<MilitaryUnit>[] army) {
		this.army = army;
	}
	
	
	
	public void upgradeTechnologyDefense() {
		
		//Falta comprobación. 
		technologyDefense++;
		
	}
	
	
	public void upgradeTechnologyAttack() {
		
		//Falta comprobación.
		technologyAtack++;
		
	}
	
	
	public void newLigthHunter(int n) {
		
		
		
		for(int i = 0; i < n; i++) {
			
			army[0].add(new LigthHunter());		
		}
		
		
	}
	
	
	public void newHeavyHunter(int n) {
		
		
	}
	
	
	public void newBattleShip(int n) {
		
		
	}
	
	
	public void newArmoredShip(int n) {
		
		
		
	}
	
	
	public void newMissileLauncher(int n) {
		
		
		
	}
	
	
	public void newIonCannon(int n) {
		
		
		
	}
	
	
	
	public void newPlasmaCannon(int n) {
		
		
		
	}
	
	
	
	public void printStats() {
		
		
		
	}
	
}
