
public interface MilitaryUnit {

	public abstract int attack();
	
	public abstract void tekeDamage(int receivedDamage);
	
	public abstract int getActualArmor();
	
	public abstract int getMetalCost();
	
	public abstract int getDeuteriumCost();
	
	public abstract int getChanceGeneratinWaste();
	
	public abstract int getChanceAttackAgain();
	
	public abstract void resetArmor();
	
}
