package paqueteMain;

public interface MilitaryUnit {


	int attack();
	
	void tekeDamage(int receivedDamage);
	
	int getActualArmor();

	int getMetalCost();

	int getDeuteriumCost();
	
	int getChanceGeneratinWaste();

	int getChanceAttackAgain();

	void resetArmor();

	
}
