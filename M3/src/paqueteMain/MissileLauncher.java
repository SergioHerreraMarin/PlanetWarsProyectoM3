package paqueteMain;

public class MissileLauncher extends Defense{
	

	MissileLauncher(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_MISSILELAUNCHER);
		
		}else {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_MISSILELAUNCHER + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY) * 10);		
		}
			
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_MISSILELAUNCHER);
			
		}else {
					
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_MISSILELAUNCHER + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY) * 10);		
		}			
    }
	
		
	MissileLauncher(int armor, int baseDamage) {
    	
    	super(armor, baseDamage);      
    }
	

	public int attack() {
		return this.getBaseDamage();
	}
	
	@Override
	public void tekeDamage(int receivedDamage) {
		this.setArmor(this.getArmor() - receivedDamage);
	}
	
	public int getActualArmor() {
		return this.getArmor();
	}
	
	
	public int getMetalCost() {
		return ConnectionBBDD.METAL_COST_MISSILELAUNCHER;
	}
	
	public int getDeuteriumCost() {
		return ConnectionBBDD.DEUTERIUM_COST_MISSILELAUNCHER;
	}
	
	public int getChanceGeneratinWaste() {
		return this.CHANCE_GENERATNG_WASTE_MISSILELAUNCHER;
	}
	
	public int getChanceAttackAgain() {
		return this.CHANCE_ATTACK_AGAIN_MISSILELAUNCHER;
	}

	@Override
	public void resetArmor() {		
		this.setArmor(this.getInitialArmor());	
	}

}
