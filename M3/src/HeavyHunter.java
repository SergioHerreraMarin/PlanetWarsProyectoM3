public class HeavyHunter extends Ship{
	
	HeavyHunter(int armor, int baseDamage) {
		super();
		this.setArmor(armor);
		this.setBaseDamage(baseDamage);
	}
	
	HeavyHunter(){
		super();
		
		//ESTABLECER EL VALOR DE ARMOR
		if (this.getArmor() == this.ARMOR_HEAVYHUNTER) {
			this.getArmor() = this.ARMOR_HEAVYHUNTER;
		}else {
			this.getArmor() = this.ARMOR_HEAVYHUNTER + (Planet.getTechnologyDefense() * this.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY) * 10
		}
		
		//ESTABLECER EL VALOR DE BASEDAMAGE
		if (this.getBaseDamage() == this.BASE_DAMAGE_HEAVYHUNTER) {
			this.getBaseDamage() = this.BASE_DAMAGE_HEAVYHUNTER;
		}else {
			this.getBaseDamage() = this.BASE_DAMAGE_HEAVYHUNTER + (Planet.getTechnologyAttack() * this.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY) * 10
		}
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
		armor = this.ARMOR_HEAVYHUNTER;
	}
	
	public void initialArmorReset() {
		initialArmor = armor;
	}
	
	
	
	

}