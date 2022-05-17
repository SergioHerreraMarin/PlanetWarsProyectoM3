package paqueteMain;

public class BattleShip extends Ship {

	
	BattleShip(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_BATTLESHIP);
		
		}else {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_BATTLESHIP + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY) * 10);		
		}
		
		
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_BATTLESHIP);
			
		}else {
					
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_BATTLESHIP + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY) * 10);		
		}			
    }
	
    BattleShip(int armor, int baseDamage) {
    	
    	super(armor, baseDamage);      
    }



	@Override
	public int attack() {	
		return this.getBaseDamage();
	}

	@Override
	public void tekeDamage(int receivedDamage) {		
		this.setArmor(this.getArmor() - receivedDamage);	
	}

	@Override
	public int getActualArmor() {		
		return this.getArmor();
	}
	
	@Override
	public int getMetalCost() {
		return ConnectionBBDD.METAL_COST_BATTLESHIP;
	}

	@Override
	public int getDeuteriumCost() {
		return ConnectionBBDD.DEUTERIUM_COST_BATTLESHIP;
	}

	@Override
	public int getChanceGeneratinWaste() {
		return this.CHANCE_GENERATNG_WASTE_BATTLESHIP;
	}
	
	@Override
	public int getChanceAttackAgain() {
		return this.CHANCE_ATTACK_AGAIN_BATTLESHIP;
	}
	
	@Override
	public void resetArmor() {
		
		this.setArmor(this.getInitialArmor());	
	}
		
}
