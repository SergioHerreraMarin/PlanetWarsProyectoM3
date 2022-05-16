package paqueteMain;

public class PlasmaCannon extends Defense {

	//CONSTRUCTOR
	PlasmaCannon(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_PLASMACANNON);
		
		}else {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_PLASMACANNON + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY) * 10);		
		}
		
			
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_PLASMACANNON);
			
		}else {
					
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_PLASMACANNON + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY) * 10);		
		}			
    }
	
		
	PlasmaCannon(int armor, int baseDamage) {  
		
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
		return ConnectionBBDD.METAL_COST_PLASMACANNON;
	}

	@Override
	public int getDeuteriumCost() {
		return ConnectionBBDD.DEUTERIUM_COST_PLASMACANNON;
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
