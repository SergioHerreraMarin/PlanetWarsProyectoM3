
public class IonCannon extends Defense{
	
	//CONSTRUCTOR
	public IonCannon(int armor, int baseDamage) {
		super();
	} 

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return getBaseDamage();
	}

	@Override
	public void tekeDamage(int receivedDamage) {
		// TODO Auto-generated method stub
		int blindajeFinal = this.getInitialArmor() - receivedDamage;
	}

	@Override
	public int getActualArmor() {
		// TODO Auto-generated method stub
		return getActualArmor();
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return this.METAL_COST_IONCANNON;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return this.DEUTERIUM_COST_IONCANNON;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return this.CHANCE_GENERATNG_WASTE_IONCANNON;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return this.CHANCE_ATTACK_AGAIN_IONCANNON;
	}

	@Override
	public void resetArmor() {
		// TODO Auto-generated method stub
		
	}	
	
}