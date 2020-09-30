public class Warrior_23605383 {
	private int ID;
	private int Age;
	private double health;
	private double offensePower;
	private double defenseStrength;
	private int weaponInventory;
	private int PlayerRow;
	private int PlayerColumn;
	private String moves;
	private String name;
	private String type;
	private int WeaponCarry=0; //this will be updated as the warrior picks up weapons
	private boolean performedAbility = false; //check whether special ability has been activated already
	private int countSpecialAbility; //used count number of iterations special ability will be performed
	/*
	The two variables are used to store defense and offensive strength at the start of special ability
	 */
	private double previousDefenseStrength;
	private double previousOffensiveStrength;
	/*
	The two variables will be used to store the values of offensive and defensive strength for warrior battles
	 */
	private double fightOffensive;
	private double fightDefense;
	Warrior_23605383(){
		/*
		 * Empty constructor for warriors that are not in the game
		 */
	}
	
	Warrior_23605383(int ID,int Age,double health,double offensePower,double defenseStrength,int weaponInventory,int xValue,int yValue,String moves,String name,String type){
		this.ID = ID;
		this.Age=Age;
		this.health=health;
		this.offensePower= offensePower;
		this.defenseStrength= defenseStrength;
		this.weaponInventory = weaponInventory;
		PlayerColumn = xValue;
		PlayerRow= yValue;
		this.moves=moves;
		this.name = name;
		this.type = type;
	}

	public boolean isPerformedAbility() {
		return performedAbility;
	}
	public void setPerformedAbility(boolean performedAbility) {
		this.performedAbility = performedAbility;
	}
	public void setFightDefense(double fightDefense) {
		this.fightDefense = fightDefense;
	}
	public double getFightDefense() {
		return fightDefense;
	}
	public void setFightOffensive(double fightOffensive) {
		this.fightOffensive = fightOffensive;
	}
	public double getFightOffensive() {
		return fightOffensive;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getAge() {
		return this.Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public double getHealth() {
		return this.health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public double getOffensePower() {
		return this.offensePower;
	}
	public void setOffensePower(double offensePower) {
		if(offensePower <=100){
			this.offensePower = offensePower;
		}else{
			this.offensePower=100;
		}
	}
	public double getDefenseStrength() {
		return this.defenseStrength;
	}
	public void setDefenseStrength(double defenseStrength) {
		if(defenseStrength <= 100){
			this.defenseStrength = defenseStrength;
		}else {
			this.defenseStrength = 100;
		}

	}
	public int getWeaponInventory() {
		return this.weaponInventory;
	}
	public void setWeaponInventory(int weaponInventory) {
		this.weaponInventory = weaponInventory;
	}
	public int getPlayerRow() {
		return this.PlayerRow;
	}
	public void setPlayerRow(int xValue) {
		this.PlayerRow = xValue;
	}
	public int getPlayerColumn() {
		return this.PlayerColumn;
	}
	public void setPlayerColumn(int yValue) {
		this.PlayerColumn = yValue;
	}
	public String getMoves() {
		return this.moves;
	}
	public void setMoves(String moves) {
		this.moves = moves;
	}
	public String getName() {
		return this.name;
	}
	public String getType(){ return this.type;}
	public void setWeaponCarry(int weaponCarry) {this.WeaponCarry = weaponCarry;}
	public int getWeaponCarry() {return this.WeaponCarry;}
	public void rightMove(int numberOfColumn){
		if(this.PlayerColumn <numberOfColumn-1) {
			this.PlayerColumn++;
			}else {
				this.PlayerColumn =0;
			}
	}
	public void leftMove(int numb){
		if(this.PlayerColumn >0) {
			this.PlayerColumn--;
			}else {
				this.PlayerColumn =numb-1;
			}
	}
	public void upMove(int row) {
		if(this.PlayerRow >0) {
			this.PlayerRow--;
		}else {
			this.PlayerRow= row-1;
		}
	}
	public void downMove(int row){
		if(this.PlayerRow <row-1){
			this.PlayerRow++;
		}else {
			this.PlayerRow=0;
		}
	}
	public void upRight(int column ,int row){
		if((this.PlayerRow >0) && (this.PlayerColumn < column-1 && this.PlayerColumn >=0)){
			this.PlayerRow--;
			this.PlayerColumn++;
		}
		if(this.PlayerRow ==0 && this.PlayerColumn==column -1){
			this.PlayerRow = row-1;
			this.PlayerColumn=0;
		}
		if(this.PlayerColumn == column-1 && this.PlayerRow>0){
			this.PlayerRow--;
			this.PlayerColumn =0;
		}
		if(this.PlayerRow==0 && this.PlayerColumn < column-1){
			this.PlayerRow= row-1;
			this.PlayerColumn++;
		}
	}
	public void upLeft(int column ,int row){
		if(this.PlayerRow>0 && this.PlayerColumn>0){
			this.PlayerRow--;
			this.PlayerColumn--;
		}
		if(PlayerRow==0 && PlayerColumn ==0){
			this.PlayerRow= row -1;
			this.PlayerColumn= column-1;
		}
		if(this.PlayerRow ==0 && PlayerColumn>0){
			this.PlayerRow= row-1;
			this.PlayerColumn--;
		}
		if(this.PlayerColumn==0 && this.PlayerRow>0){
			//This condition here, I am unsure if it will ever happen in the game
			this.PlayerRow --;
			this.PlayerColumn = column-1;
		}
	}
	public void downRight(int column , int row){
		if(this.PlayerRow <row-1 && this.PlayerColumn<column-1){
			this.PlayerColumn++;
			this.PlayerRow++;
		}
		if(this.PlayerRow==0 && this.PlayerColumn== column-1){
			this.PlayerRow++;
			this.PlayerColumn=0;
		}
		if (this.PlayerRow== row-1 && this.PlayerColumn<column-1 ){
			this.PlayerRow=0;
			this.PlayerColumn++;
		}
		if (this.PlayerRow == row-1 && this.PlayerColumn==column-1){
			this.PlayerRow=0;
			this.PlayerColumn=0;
		}
		if(this.PlayerRow==0 && this.PlayerColumn==0){
			this.PlayerRow++;
			this.PlayerColumn++;
		}

	}
	public void downLeft(int column, int row){
		if(this.PlayerColumn >0 && this.PlayerRow <row-1){
			this.PlayerColumn--;
			this.PlayerRow++;
		}
		if(this.PlayerRow==0 && this.PlayerColumn==0){
			this.PlayerColumn = column-1;
			this.PlayerRow++;
		}
		if(this.PlayerColumn==0 && this.PlayerRow== row-1){
			this.PlayerRow=0;
			this.PlayerColumn= column-1;
		}
		if(this.PlayerColumn==column-1 && this.PlayerRow== row-1){
			this.PlayerRow=0;
			this.PlayerColumn=0;
		}
	}
	public void incrementAge(){
		this.Age++;
	}
	public void setCountSpecialAbility(int countSpecialAbility) {
		this.countSpecialAbility = countSpecialAbility;
	}
	public int getCountSpecialAbility() {
		return this.countSpecialAbility;
	}
	public void incrementCountSpecialAbility(){
		this.countSpecialAbility++;
	}
	public void setPreviousDefenseStrength(double previousDefenseStrength) {
		this.previousDefenseStrength = previousDefenseStrength;
	}
	public double getPreviousDefenseStrength() {
		return previousDefenseStrength;
	}
	public void setPreviousOffensiveStrength(double previousOffensiveStrength) {
		this.previousOffensiveStrength = previousOffensiveStrength;
	}
	public double getPreviousOffensiveStrength() {
		return previousOffensiveStrength;
	}

	@Override
	public String toString() {
		return ID+", "+Age+", "+health+", "+offensePower+", "+defenseStrength+", "+WeaponCarry+", "+type+", "+PlayerRow+", "+PlayerColumn ;
	}
}

