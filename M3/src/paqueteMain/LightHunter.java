package paqueteMain;

public class LightHunter extends Ship{

		
	LightHunter(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_LIGTHHUNTER);
		
		}else {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_LIGTHHUNTER + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY) * 10);		
		}
		
			
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_LIGTHHUNTER);
			
		}else {
					
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_LIGTHHUNTER + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY) * 10);		
		}		
    }
	
    LightHunter(int armor, int baseDamage) {
    	
    	super(armor,baseDamage);      
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
		return ConnectionBBDD.METAL_COST_LIGTHHUNTER;
	}

	@Override
	public int getDeuteriumCost() {	
		return ConnectionBBDD.DEUTERIUM_COST_LIGTHHUNTER;
	}

	@Override
	public int getChanceGeneratinWaste() {
		return this.CHANCE_GENERATNG_WASTE_LIGTHHUNTER;
	}

	@Override
	public int getChanceAttackAgain() {	
		return this.CHANCE_ATTACK_AGAIN_LIGTHHUNTER;
	}
	
	@Override
	public void resetArmor() {		
		this.setArmor(this.getInitialArmor());	
	}

}

