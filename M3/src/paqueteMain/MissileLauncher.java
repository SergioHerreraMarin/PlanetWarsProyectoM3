package paqueteMain;

public class MissileLauncher extends Defense{
	
	//CONSTRUCTOR
	MissileLauncher(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(this.ARMOR_MISSILELAUNCHER);
		
		}else {
			
			this.setInitialArmor(this.ARMOR_MISSILELAUNCHER + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY) * 10);		
		}
		
		
		this.setArmor(this.getInitialArmor());
		
		
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(this.BASE_DAMAGE_MISSILELAUNCHER);
			
		}else {
					
			this.setBaseDamage(this.BASE_DAMAGE_MISSILELAUNCHER + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY) * 10);		
		}			
    }
	
		
	MissileLauncher(int armor, int baseDamage) {
    	
    	super(armor, armor, baseDamage);      
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
	
	public void setArmor(int armor) {
        
		this.setArmor(armor);	
    }
	
	public int getBaseDamage() {
        return this.getBaseDamage();
    }
	
	public int getMetalCost() {
		return this.METAL_COST_MISSILELAUNCHER;
	}
	
	public int getDeuteriumCost() {
		return this.DEUTERIUM_COST_MISSILELAUNCHER;
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
