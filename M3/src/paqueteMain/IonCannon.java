package paqueteMain;

public class IonCannon extends Defense{
	

	IonCannon(Planet planeta){
		
		//Establecer el blindaje
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_IONCANNON);
		
		}else {
			
			this.setInitialArmor(ConnectionBBDD.ARMOR_IONCANNON + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY) * 10);		
		}
						
		//Establecer al poder de ataque
		if(planeta.getTechnologyAtack() == 0) {
			
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_IONCANNON);
			
		}else {
					
			this.setBaseDamage(ConnectionBBDD.BASE_DAMAGE_IONCANNON + (planeta.getTechnologyAtack() * this.PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY) * 10);		
		}			
    }
	
		
	IonCannon(int armor, int baseDamage) {
    	
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
		return ConnectionBBDD.METAL_COST_IONCANNON;
	}

	@Override
	public int getDeuteriumCost() {
		return ConnectionBBDD.DEUTERIUM_COST_IONCANNON;
	}

	@Override
	public int getChanceGeneratinWaste() {
		return this.CHANCE_GENERATNG_WASTE_IONCANNON;
	}

	@Override
	public int getChanceAttackAgain() {
		return this.CHANCE_ATTACK_AGAIN_IONCANNON;
	}

	@Override
	public void resetArmor() {		
		this.setArmor(this.getInitialArmor());		
	}	
	
}
