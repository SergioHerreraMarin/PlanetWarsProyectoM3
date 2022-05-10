 
public class MissileLauncher extends Defense{
	
	//CONSTRUCTOR
	public MissileLauncher(int armor, int baseDamage) {
		super();
	}	
	
	//IMPLEMENTAR MÉTODOS DEFINIDOS EN INTERFAZ MilitaryUnit
	public int attack() {
		return getBaseDamage();
	}
	
	public void takeDamage(int receivedDamage) {
		int blindajeFinal = this.getInitialArmor() - receivedDamage;
	}
	
	public int getActualArmor() {
		return getActualArmor();
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
		
	}

	@Override
	public void tekeDamage(int receivedDamage) {
		// TODO Auto-generated method stub
		
	}
}
