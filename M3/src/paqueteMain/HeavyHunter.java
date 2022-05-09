package paqueteMain;

public class HeavyHunter extends Ship {

	
	HeavyHunter(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(this.ARMOR_HEAVYHUNTER);
		
		}else {
			
			this.setInitialArmor(this.ARMOR_HEAVYHUNTER + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY) * 10);		
		}
		
		
		this.setArmor(this.getInitialArmor());
		
		
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(this.BASE_DAMAGE_HEAVYHUNTER);
			
		}else {
					
			this.setBaseDamage(this.BASE_DAMAGE_HEAVYHUNTER + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY) * 10);		
		}
				
    }
	
	
	
    HeavyHunter(int armor, int baseDamage) {
    	
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



	@Override
	public int getMetalCost() {
		
		return this.METAL_COST_HEAVYHUNTER;
	}



	@Override
	public int getDeuteriumCost() {

		return this.DEUTERIUM_COST_HEAVYHUNTER;
	}



	@Override
	public int getChanceGeneratinWaste() {

		return this.CHANCE_GENERATNG_WASTE_HEAVYHUNTER;
	}



	@Override
	public int getChanceAttackAgain() {

		return this.CHANCE_ATTACK_AGAIN_HEAVYHUNTER;
	}



	@Override
	public void resetArmor() {
		
		this.setArmor(this.getInitialArmor());
		
	}
	

}
