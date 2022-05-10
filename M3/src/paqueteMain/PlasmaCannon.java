package paqueteMain;

public class PlasmaCannon extends Defense {

	//CONSTRUCTOR
	PlasmaCannon(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(this.ARMOR_PLASMACANNON);
		
		}else {
			
			this.setInitialArmor(this.ARMOR_PLASMACANNON + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY) * 10);		
		}
		
		
		this.setArmor(this.getInitialArmor());
		
		
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(this.BASE_DAMAGE_PLASMACANNON);
			
		}else {
					
			this.setBaseDamage(this.BASE_DAMAGE_PLASMACANNON + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY) * 10);		
		}			
    }
	
		
	PlasmaCannon(int armor, int baseDamage) {
    	
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
		return this.METAL_COST_PLASMACANNON;
	}

	@Override
	public int getDeuteriumCost() {
		return this.DEUTERIUM_COST_PLASMACANNON;
	}

	@Override
	public int getChanceGeneratinWaste() {
		return this.CHANCE_GENERATNG_WASTE_PLASMACANNON;
	}

	@Override
	public int getChanceAttackAgain() {
		return this.CHANCE_ATTACK_AGAIN_PLASMACANNON;
	}

	@Override
	public void resetArmor() {
		
		this.setArmor(this.getInitialArmor());
		
	}	
}
