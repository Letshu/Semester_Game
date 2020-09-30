public class StoneWarrior_23605383 extends Warrior_23605383 implements WarriorTypeInterface_23605383 {
    public StoneWarrior_23605383() {
        super();
    }
    public StoneWarrior_23605383(int ID,int Age,double health,double offensePower,double defenseStrength,int weaponInventory,int Xvalue,int Yvalue,String moves,String name,String type) {
    	super(ID,Age,health,offensePower,defenseStrength,weaponInventory,Xvalue,Yvalue,moves,name,type);
    }
    public void performSpecialAbility() {
        if (!this.isPerformedAbility()){
            if(this.getHealth() <= 10){
            System.out.println("Special ability performed by stone warrior!");
            this.setPerformedAbility(true); //this shows that the special ability has been activated
                if(this.getDefenseStrength() < 95){
                    this.setPreviousDefenseStrength(this.getDefenseStrength());
                    this.setDefenseStrength(95);
                }else {
                    this.setPreviousDefenseStrength(this.getDefenseStrength());
                }
                this.setHealth(this.getHealth()-3);
            }
        }
    }
    public void specialAbilityCompleted() {
        if (this.isPerformedAbility()){
            if(this.getCountSpecialAbility() == 4){
                this.setDefenseStrength(this.getPreviousDefenseStrength());
            }
        }
    }
}