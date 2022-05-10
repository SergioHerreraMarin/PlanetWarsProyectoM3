package paqueteMain;

public class BattleShip extends Ship {

	
	BattleShip(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(this.ARMOR_BATTLESHIP);
		
		}else {
			
			this.setInitialArmor(this.ARMOR_BATTLESHIP + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY) * 10);		
		}
		
		
		this.setArmor(this.getInitialArmor());
		
		
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(this.BASE_DAMAGE_BATTLESHIP);
			
		}else {
					
			this.setBaseDamage(this.BASE_DAMAGE_BATTLESHIP + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY) * 10);		
		}
				
    }
	
	
	
    BattleShip(int armor, int baseDamage) {
    	
    	super(armor, armor, baseDamage);      
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
	
	public void setArmor(int armor) {    
		this.setArmor(armor);	
    }

	public int getBaseDamage() {
        return this.getBaseDamage();
    }
	
	@Override
	public int getMetalCost() {
		return this.METAL_COST_BATTLESHIP;
	}

	@Override
	public int getDeuteriumCost() {
		return this.DEUTERIUM_COST_BATTLESHIP;
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
