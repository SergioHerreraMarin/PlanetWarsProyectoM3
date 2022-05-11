package paqueteMain;
public abstract class Defense implements MilitaryUnit, Variables{
	
	private int armor;
	private int initialArmor;
	private int baseDamage;
	
	
	public Defense() {
		
	}
	
	public Defense(int initialArmor, int baseDamage) {
		this.setInitialArmor(initialArmor);
		this.baseDamage = baseDamage;	
	}
	
	
	public int getArmor() {
		return armor;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public int getInitialArmor() {
		return initialArmor;
	}
	
	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
		this.armor = initialArmor;	
	}
	
	public int getBaseDamage() {
		return baseDamage;
	}
	
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}


	@Override
	public String toString() {
		return "Defense [armor=" + armor + ", initialArmor=" + initialArmor + ", baseDamage=" + baseDamage + "]";
	}
}
