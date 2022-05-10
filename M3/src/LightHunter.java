import ProyectoJava.Ship;

public class LightHunter extends Ship{
	
	private int defenseTechnology;
	
	LightHunter(int armor, int baseDamage, int defenseTechnology) {
		super();
		this.setArmor(armor);
		this.setBaseDamage(baseDamage);
		this.
	}
	
	LightHunter(){
		super();
		
		//ESTABLECER EL VALOR DE ARMOR
		if (this.getArmor() == this.ARMOR_LIGTHHUNTER) {
			this.getArmor() = this.ARMOR_LIGTHHUNTER;
		}else {
			this.getArmor() = this.ARMOR_LIGTHHUNTER + (Planet.getTechnologyDefense() * this.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY) * 10
		}
		
		//ESTABLECER EL VALOR DE BASEDAMAGE
		if (this.getBaseDamage() == this.BASE_DAMAGE_LIGTHHUNTER) {
			this.getBaseDamage() = this.BASE_DAMAGE_LIGTHHUNTER;
		}else {
			this.getBaseDamage() = this.BASE_DAMAGE_LIGTHHUNTER + (Planet.getTechnologyAttack() * this.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY) * 10
		}
	}
	
	public void setDefenseTechnology(int defenseTechnology) {
		this.defenseTechnology = defenseTechnology;
	}
	public int getDefenseTechnology() {
		return defenseTechnology;
	}
	
	
	public int attack() {
		return this.getBaseDamage();
	}
	
	public void takeDamage(int receivedDamage) {
		this.setArmor(armor - receivedDamage);
	}
	
	public int getActualArmor() {
		return this.getArmor();
	}
	
	public int getMetalCost() {
		return 3000;
	}
	
	public int getDeuteriumCost() {
		return 50;
	}
	
	public int getChanceGeneratinWaste() {
		return 45;
	}
	
	public int getChanceAttackAgain() {
		return 3;
	}
	
	public void resetArmor() {
		armor = this.ARMOR_LIGHTHUNTER;
	}
	
	public void initialArmorReset() {
		initialArmor = armor;
	}
	
	
	
	

}