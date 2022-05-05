public class LightHunter extends Ship{

	
	LightHunter(Planet planeta){
		
		//Si tecnologia es 0 
		if(planeta.getTechnologyDefense() == 0) {
			
			this.setInitialArmor(this.ARMOR_LIGTHHUNTER);
		
		}else {
			
			this.setInitialArmor(this.ARMOR_LIGTHHUNTER + (planeta.getTechnologyDefense() * this.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY) * 10);		
		}
		
    }
	
	
    LightHunter(int armor, int baseDamage) {
        super();
        this.setArmor(armor);
        this.setBaseDamage(baseDamage);
    }

    
    
    public int attack() {
        return baseDamage;
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
        armor = this.ARMOR_LIGTHHUNTER;
    }

    public void initialArmorReset() {
        initialArmor = armor;
    }





}

