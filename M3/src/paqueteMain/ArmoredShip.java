package paqueteMain;

public class ArmoredShip extends Ship {

	
	ArmoredShip(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(this.ARMOR_ARMOREDSHIP);
		
		}else {
			
			this.setInitialArmor(this.ARMOR_ARMOREDSHIP + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY) * 10);		
		}
		
		
		this.setArmor(this.getInitialArmor());
		
		
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(this.BASE_DAMAGE_ARMOREDSHIP);
			
		}else {
					
			this.setBaseDamage(this.BASE_DAMAGE_ARMOREDSHIP + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY) * 10);		
		}
				
    }
	
	
    ArmoredShip(int armor, int baseDamage) {
    	
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
	public int getActualArmor(){
		return this.getArmor();
	}

	@Override
	public int getMetalCost() {
		return this.METAL_COST_ARMOREDSHIP;
	}

	@Override
	public int getDeuteriumCost() {
		return this.DEUTERIUM_COST_ARMOREDSHIP;
	}

	@Override
	public int getChanceGeneratinWaste() {
		return this.CHANCE_GENERATNG_WASTE_ARMOREDSHIP;
	}

	@Override
	public int getChanceAttackAgain() {

		return this.CHANCE_ATTACK_AGAIN_ARMOREDSHIP;
	}

	@Override
	public void resetArmor() {		
		this.setArmor(this.getInitialArmor());	
	}
}
