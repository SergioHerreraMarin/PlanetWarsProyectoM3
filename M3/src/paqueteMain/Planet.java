package paqueteMain;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Planet {

	private int technologyDefense;
	private int technologyAtack;
	private int metal, deuterium;
	private String name;
	private int upgradeDefenseTechnologyDeuteriumCost = Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
	private int upgradeAttackTechnologyDeuteriumCost = Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
	
	private ArrayList<MilitaryUnit>[] army = new ArrayList[7];
	
	
	public Planet(String name) {
		
		technologyDefense = 0;
		technologyAtack = 0;
		metal = 0;
		deuterium = 0;
		this.name = name;
		
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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void upgradeTechnologyDefense() throws ResourceException {
				
		if(deuterium >= upgradeDefenseTechnologyDeuteriumCost) {
					
			technologyDefense++;
			deuterium -= upgradeDefenseTechnologyDeuteriumCost;	
			upgradeDefenseTechnologyDeuteriumCost += upgradeDefenseTechnologyDeuteriumCost * (Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST/100);
			//INSERTAR 
			
		
		}else {
			JOptionPane.showMessageDialog(null, "Materiales insuficientes para subir el nivel de tecologia de defensa.", "INFO", JOptionPane.INFORMATION_MESSAGE);
			throw new ResourceException("ERROR: Materiales insuficientes para subir el nivel de tecologia de defensa.");
		}	
	}
	
	
	public void upgradeTechnologyAttack() throws ResourceException {
				
		if(deuterium >= upgradeAttackTechnologyDeuteriumCost) {
					
			technologyDefense++;
			deuterium -= upgradeAttackTechnologyDeuteriumCost;	
			upgradeAttackTechnologyDeuteriumCost += upgradeAttackTechnologyDeuteriumCost * (Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST/100);	
			//INSERTAR 
			
		
		}else {
			JOptionPane.showMessageDialog(null, "Materiales insuficientes para subir el nivel de tecologia de ataque.", "INFO", JOptionPane.INFORMATION_MESSAGE);
			throw new ResourceException("ERROR: Materiales insuficientes para subir el nivel de tecologia de ataque.");
		}			
	}
	
	
	public void newLigthHunter(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {

			if(this.getMetal() >= ConnectionBBDD.METAL_COST_LIGTHHUNTER && this.getDeuterium() >= ConnectionBBDD.DEUTERIUM_COST_LIGTHHUNTER) {
				
				army[0].add(new LightHunter(this));
				this.setMetal(this.getMetal() - ConnectionBBDD.METAL_COST_LIGTHHUNTER);
				this.setDeuterium(this.getDeuterium() - ConnectionBBDD.DEUTERIUM_COST_LIGTHHUNTER);
				finalAddNum++;
				//System.out.println("Creado 1 LigthHunter, Metal actual: " + this.getMetal() + ", Deuterium actual: " + this.getDeuterium());
			
			}else {
				JOptionPane.showMessageDialog(null, "Materiales insuficientes. Se han creado " + finalAddNum + " Ligth Hunter", "INFO", JOptionPane.INFORMATION_MESSAGE);
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum + " Lighth Hunter");
			}		
		}
	}
	
	
	public void newHeavyHunter(int n) throws ResourceException {
		
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= ConnectionBBDD.METAL_COST_HEAVYHUNTER && this.getDeuterium() >= ConnectionBBDD.DEUTERIUM_COST_HEAVYHUNTER) {
				
				army[1].add(new HeavyHunter(this));
				this.setMetal(this.getMetal() - ConnectionBBDD.METAL_COST_HEAVYHUNTER);
				this.setDeuterium(this.getDeuterium() - ConnectionBBDD.DEUTERIUM_COST_HEAVYHUNTER);
				finalAddNum++;
				//System.out.println("Creado 1 HeavyHunter, Metal actual: " + this.getMetal() + ", Deuterium actual: " + this.getDeuterium());
			}else {
				JOptionPane.showMessageDialog(null, "Materiales insuficientes. Se han creado " + finalAddNum + " Heavy Hunter", "INFO", JOptionPane.INFORMATION_MESSAGE);
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum + " Heavy Hunter"); 	
			}			
		}		
	}
	
	
	public void newBattleShip(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= ConnectionBBDD.METAL_COST_BATTLESHIP && this.getDeuterium() >= ConnectionBBDD.DEUTERIUM_COST_BATTLESHIP) {
				
				army[2].add(new BattleShip(this));
				this.setMetal(this.getMetal() - ConnectionBBDD.METAL_COST_BATTLESHIP);
				this.setDeuterium(this.getDeuterium() - ConnectionBBDD.DEUTERIUM_COST_BATTLESHIP);
				finalAddNum++;
				//System.out.println("Creado 1 BattleShip, Metal actual: " + this.getMetal() + ", Deuterium actual: " + this.getDeuterium());
				
			}else {
				JOptionPane.showMessageDialog(null, "Materiales insuficientes. Se han creado " + finalAddNum + " Battle Ship", "INFO", JOptionPane.INFORMATION_MESSAGE);
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum + " Battle Ship");				
			}	
		}
	}
	
	
	public void newArmoredShip(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= ConnectionBBDD.METAL_COST_ARMOREDSHIP && this.getDeuterium() >= ConnectionBBDD.DEUTERIUM_COST_ARMOREDSHIP) {
				
				army[3].add(new ArmoredShip(this));
				this.setMetal(this.getMetal() - ConnectionBBDD.METAL_COST_ARMOREDSHIP);
				this.setDeuterium(this.getDeuterium() - ConnectionBBDD.DEUTERIUM_COST_ARMOREDSHIP);
				finalAddNum++;
				//System.out.println("Creado 1 ArmoredShip, Metal actual: " + this.getMetal() + ", Deuterium actual: " + this.getDeuterium());
				
			}else {
				
				JOptionPane.showMessageDialog(null, "Materiales insuficientes. Se han creado " + finalAddNum + " Armored Ship", "INFO", JOptionPane.INFORMATION_MESSAGE);
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum + " Armored Ship");				
			}		
		}	
	}
	
	
	public void newMissileLauncher(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= ConnectionBBDD.METAL_COST_MISSILELAUNCHER && this.getDeuterium() >= ConnectionBBDD.DEUTERIUM_COST_MISSILELAUNCHER) {
				
				army[4].add(new ArmoredShip(this));
				this.setMetal(this.getMetal() - ConnectionBBDD.METAL_COST_MISSILELAUNCHER);
				this.setDeuterium(this.getDeuterium() - ConnectionBBDD.DEUTERIUM_COST_MISSILELAUNCHER);
				finalAddNum++;
				//System.out.println("Creado 1 MissileLauncher, Metal actual: " + this.getMetal() + ", Deuterium actual: " + this.getDeuterium());
			
			}else {
				JOptionPane.showMessageDialog(null, "Materiales insuficientes. Se han creado " + finalAddNum + " Missile Launcher", "INFO", JOptionPane.INFORMATION_MESSAGE);
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum + " Missile Launcher"); 				
			}		
		}	
	}
	
	
	public void newIonCannon(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= ConnectionBBDD.METAL_COST_IONCANNON && this.getDeuterium() >= ConnectionBBDD.DEUTERIUM_COST_IONCANNON) {
				
				army[5].add(new IonCannon(this));
				this.setMetal(this.getMetal() - ConnectionBBDD.METAL_COST_IONCANNON);
				this.setDeuterium(this.getDeuterium() - ConnectionBBDD.DEUTERIUM_COST_IONCANNON);
				finalAddNum++;
				//System.out.println("Creado 1 IonCannon, Metal actual: " + this.getMetal() + ", Deuterium actual: " + this.getDeuterium());
			
			}else {
				JOptionPane.showMessageDialog(null, "Materiales insuficientes. Se han creado " + finalAddNum + " Ion Cannon", "INFO", JOptionPane.INFORMATION_MESSAGE);
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum + " Ion Cannon"); 				
			}			
		}
	}
	
	
	public void newPlasmaCannon(int n) throws ResourceException {
		
		int finalAddNum = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(this.getMetal() >= ConnectionBBDD.METAL_COST_PLASMACANNON && this.getDeuterium() >= ConnectionBBDD.DEUTERIUM_COST_PLASMACANNON) {
				
				army[6].add(new PlasmaCannon(this));
				this.setMetal(this.getMetal() - ConnectionBBDD.METAL_COST_PLASMACANNON);
				this.setDeuterium(this.getDeuterium() - ConnectionBBDD.DEUTERIUM_COST_PLASMACANNON);
				finalAddNum++;
				//System.out.println("Creado 1 PlasmaCannon, Metal actual: " + this.getMetal() + ", Deuterium actual: " + this.getDeuterium());
			
			}else {
				JOptionPane.showMessageDialog(null, "Materiales insuficientes. Se han creado " + finalAddNum + " Plasma Cannon", "INFO", JOptionPane.INFORMATION_MESSAGE);
				throw new ResourceException("ERROR: Materiales insuficientes. Se han creado " + finalAddNum + " Plasma Cannon");		
			}		
		}	
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
