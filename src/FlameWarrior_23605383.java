public class FlameWarrior_23605383 extends Warrior_23605383 implements WarriorTypeInterface_23605383 {

    public FlameWarrior_23605383() {
        super();
    }
    public FlameWarrior_23605383(int ID,int Age,double health,double offensePower,double defenseStrength,int weaponInventory,int Xvalue,int Yvalue,String moves,String name,String type) {
    	super(ID,Age,health,offensePower,defenseStrength,weaponInventory,Xvalue,Yvalue,moves,name,type);
    }
    
    public void performSpecialAbility() {
        if(!this.isPerformedAbility()){
            if(this.getDefenseStrength() <= 10){
                if(!isPerformedAbility()){
                    this.setPerformedAbility(true);
                    System.out.println("Special ability performed by flame warrior!");
                    this.setPreviousDefenseStrength(this.getDefenseStrength());
                    this.setDefenseStrength(100.0);
                }
            }
        }
    }
    public void specialAbilityCompleted() {
        if (this.getCountSpecialAbility()== 2){
            if(this.isPerformedAbility()){
                if(this.getPreviousOffensiveStrength() <70){
                    this.setDefenseStrength(70);
                }else{
                    this.setDefenseStrength(this.getPreviousDefenseStrength());
                }
            }
        }
    }

}