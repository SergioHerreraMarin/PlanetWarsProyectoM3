package paqueteMain;
import java.util.ArrayList;
import java.util.Iterator;

public class Planet {

	private int technologyDefense;
	private int technologyAtack;
	private int metal, deuterium;
	private int upgradeDefenseTechnologyDeuteriumCost = Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
	private int upgradeAttackTechnologyDeuteriumCost = Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
	
	private ArrayList<MilitaryUnit>[] army = new ArrayList[7];
	
	
	public Planet() {
		
		technologyDefense = 0;
		technologyAtack = 0;
		metal = 10000;
		deuterium = 10000;
		
		army[0] = new ArrayList<MilitaryUnit>();
		army[1] = new ArrayList<MilitaryUnit>();
		army[2] = new ArrayList<MilitaryUnit>();
		army[3] = new ArrayList<MilitaryUnit>();
		army[4] = new ArrayList<MilitaryUnit>();
		army[5] = new ArrayList<MilitaryUnit>();
		army[6] = new ArrayList<MilitaryUnit>();		
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
				
		if(deuterium >= upgradeDefenseTechnologyDeuteriumCost) {
					
			technologyDefense++;
			deuterium -= upgradeDefenseTechnologyDeuteriumCost;	
		}
		
		upgradeDefenseTechnologyDeuteriumCost += upgradeDefenseTechnologyDeuteriumCost * (Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST/100);

	}
	
	
	public void upgradeTechnologyAttack() {
				
		if(deuterium >= upgradeAttackTechnologyDeuteriumCost) {
					
			technologyDefense++;
			deuterium -= upgradeAttackTechnologyDeuteriumCost;	
		}
		
		upgradeAttackTechnologyDeuteriumCost += upgradeAttackTechnologyDeuteriumCost * (Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST/100);			
	}
	
	
	//Falta cambiar para que lo haga bien, mirar. 
	public void newLigthHunter(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= Variables.METAL_COST_LIGTHHUNTER && this.getDeuterium() >= Variables.DEUTERIUM_COST_LIGTHHUNTER) {
				
				army[0].add(new LightHunter(this));
				this.setMetal(this.getMetal() - Variables.METAL_COST_LIGTHHUNTER);
				this.setDeuterium(this.getDeuterium() - Variables.DEUTERIUM_COST_LIGTHHUNTER);
				finalAddNum++;
			
			}else {
				
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum);
			}		
		}
	}
	
	
	public void newHeavyHunter(int n) throws ResourceException {
		
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= Variables.METAL_COST_HEAVYHUNTER && this.getDeuterium() >= Variables.DEUTERIUM_COST_HEAVYHUNTER) {
				
				army[1].add(new HeavyHunter(this));
				this.setMetal(this.getMetal() - Variables.METAL_COST_HEAVYHUNTER);
				this.setDeuterium(this.getDeuterium() - Variables.DEUTERIUM_COST_HEAVYHUNTER);
				finalAddNum++;
			
			}else {
				
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum); 
				
			}			
		}	
		
		System.out.println("Se han creado " + finalAddNum);
		
	}
	
	
	public void newBattleShip(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= Variables.METAL_COST_BATTLESHIP && this.getDeuterium() >= Variables.DEUTERIUM_COST_BATTLESHIP) {
				
				army[2].add(new BattleShip(this));
				this.setMetal(this.getMetal() - Variables.METAL_COST_BATTLESHIP);
				this.setDeuterium(this.getDeuterium() - Variables.DEUTERIUM_COST_BATTLESHIP);
				finalAddNum++;
			
			}else {
				
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum);
				
			}	
		}
		System.out.println("Se han creado " + finalAddNum);
	}
	
	
	public void newArmoredShip(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= Variables.METAL_COST_ARMOREDSHIP && this.getDeuterium() >= Variables.DEUTERIUM_COST_ARMOREDSHIP) {
				
				army[3].add(new ArmoredShip(this));
				this.setMetal(this.getMetal() - Variables.METAL_COST_ARMOREDSHIP);
				this.setDeuterium(this.getDeuterium() - Variables.DEUTERIUM_COST_ARMOREDSHIP);
				finalAddNum++;
			
			}else {
				
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum);
				
			}		
		}	
		
		System.out.println("Se han creado " + finalAddNum);
	}
	
	
	public void newMissileLauncher(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= Variables.METAL_COST_MISSILELAUNCHER && this.getDeuterium() >= Variables.DEUTERIUM_COST_MISSILELAUNCHER) {
				
				army[4].add(new ArmoredShip(this));
				this.setMetal(this.getMetal() - Variables.METAL_COST_MISSILELAUNCHER);
				this.setDeuterium(this.getDeuterium() - Variables.DEUTERIUM_COST_MISSILELAUNCHER);
				finalAddNum++;
			
			}else {
				
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum); 
				
			}		
		}	
		System.out.println("Se han creado " + finalAddNum);
	}
	
	
	public void newIonCannon(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= Variables.METAL_COST_IONCANNON && this.getDeuterium() >= Variables.DEUTERIUM_COST_IONCANNON) {
				
				army[5].add(new IonCannon(this));
				this.setMetal(this.getMetal() - Variables.METAL_COST_IONCANNON);
				this.setDeuterium(this.getDeuterium() - Variables.DEUTERIUM_COST_IONCANNON);
				finalAddNum++;
			
			}else {
				
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum); 
				
			}			
		}
		
		System.out.println("Se han creado " + finalAddNum);
	}
	
	
	
	public void newPlasmaCannon(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= Variables.METAL_COST_PLASMACANNON && this.getDeuterium() >= Variables.DEUTERIUM_COST_PLASMACANNON) {
				
				army[6].add(new PlasmaCannon(this));
				this.setMetal(this.getMetal() - Variables.METAL_COST_PLASMACANNON);
				this.setDeuterium(this.getDeuterium() - Variables.DEUTERIUM_COST_PLASMACANNON);
				finalAddNum++;
			
			}else {
				
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum);
				
			}		
		}	
		System.out.println("Se han creado " + finalAddNum);
	}
	
	
	
	public void printStats() {
		
		System.out.println("Planet Stats:\n\nTECHNOLOGY\n\nAtack Technology: " + this.getTechnologyAtack() + 
				"\nDefense Technology: " + this.getTechnologyDefense() + "\n\nDEFENSES\n\nMissile Launcher: " + 
				this.army[4].size() + "\nIon Cannon: " + this.army[5].size() + "\nPlasma Cannon: " + this.army[6].size() + 
				"\n\nFLEET\n\nLigth Hunter: " + this.army[0].size() + "\nHeavy Hunter: " + this.army[1].size() + 
				"\nBattle Ship: " + this.army[2].size() + "\nArmored Ship: " + this.army[3].size() + 
				"\n\nMetal: " + this.getMetal() + "\nDeuterium: " + this.getDeuterium());
		
	}
	
}
