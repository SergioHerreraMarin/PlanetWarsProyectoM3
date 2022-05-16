public class BattleShip extends Ship{
	
	BattleShip(int armor, int baseDamage) {
		super();
		this.setArmor(armor);
		this.setBaseDamage(baseDamage);
	}
	
	BattleShip(){
		super();
		
		//ESTABLECER EL VALOR DE ARMOR
		if (this.getArmor() == this.ARMOR_BATTLESHIP) {
			this.getArmor() = this.ARMOR_BATTLESHIP;
		}else {
			this.getArmor() = this.ARMOR_BATTLESHIP + (Planet.getTechnologyDefense() * this.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY) * 10
		}
		
		//ESTABLECER EL VALOR DE BASEDAMAGE
		if (this.getBaseDamage() == this.BASE_DAMAGE_BATTLESHIP) {
			this.getBaseDamage() = this.BASE_DAMAGE_BATTLESHIP;
		}else {
			this.getBaseDamage() = this.BASE_DAMAGE_BATTLESHIP + (Planet.getTechnologyAttack() * this.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY) * 10
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
		armor = this.ARMOR_BATTLESHIP;
	}
	
	public void initialArmorReset() {
		initialArmor = armor;
	}
	
	
	
	

}