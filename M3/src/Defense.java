
public abstract class Defense implements MilitaryUnit, Variables{
	
	//ATRIBUTOS
	private int armor;
	private int initialArmor;
	private int baseDamage;
	
	
	public Defense() {
		
	}
	
	public Defense(int armor, int initialArmor, int baseDamage) {
		
		this.armor = armor;
		this.initialArmor = initialArmor;
		this.baseDamage = baseDamage;	
	}
	
	
	//GETTERS Y SETTERS
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
	}
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Defense [armor=" + armor + ", initialArmor=" + initialArmor + ", baseDamage=" + baseDamage + "]";
	}
}
