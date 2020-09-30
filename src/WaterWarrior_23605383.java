public class WaterWarrior_23605383 extends Warrior_23605383 implements WarriorTypeInterface_23605383 {


    public WaterWarrior_23605383() {
        super();
    }
    
    public WaterWarrior_23605383(int ID,int Age,double health,double offensePower,double defenseStrength,int weaponInventory,int Xvalue,int Yvalue,String moves,String name,String type) {
    	super(ID,Age,health,offensePower,defenseStrength,weaponInventory,Xvalue,Yvalue,moves,name,type);
    }
    public void performSpecialAbility() {
        if (this.getHealth() <= 10){
            if(!this.isPerformedAbility()){
                this.setPerformedAbility(true);
                System.out.println("Special ability performed by water warrior!");
                this.setHealth(this.getHealth()+20.0);
            }
        }
    }
    public void specialAbilityCompleted() {
    }

}