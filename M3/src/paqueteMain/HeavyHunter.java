package paqueteMain;

public class HeavyHunter extends Ship {

	
	HeavyHunter(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_HEAVYHUNTER);
		
		}else {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_HEAVYHUNTER + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY) * 10);		
		}
		
		
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_HEAVYHUNTER);
			
		}else {
					
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_HEAVYHUNTER + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY) * 10);		
		}			
    }
	
		
    HeavyHunter(int armor, int baseDamage) {  	
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
		return ConnectionBBDD.METAL_COST_HEAVYHUNTER;
	}

	@Override
	public int getDeuteriumCost() {
		return ConnectionBBDD.DEUTERIUM_COST_HEAVYHUNTER;
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
