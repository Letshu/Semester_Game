import java.util.ArrayList;
import java.util.Arrays;

public class Game_23605383 {
	private static int Orow ; //number of rows in the game board
	private static int Ocolumn; //number of columns in the game
	private static  int noGame; //number of iterations in the game
	private static String[][] gameBoard;
	public static boolean NoPiece= false; //This variable is helped to check that there's no piece on the board
	/*
	Arrays below is to store the defense strength and offense strength of each warrior at the start,
	of the game and after each iterations. It will be updated constantly.
	The warrior moves array doesn't change unless the warrior is in a Trance.
	Note: the position each array will correspond to the warriors position in the warrior array
	 */
	public static Warrior_23605383[] warrior;
	public static double[] DefenseStrength;
	public static double[] OffensePower;
	public static String[] warriorMoves;
	public static StoneWarrior_23605383[] stone;
	public static WaterWarrior_23605383[] water;
	public static FlameWarrior_23605383[] flame;
	public static AirWarrior_23605383[] air;
	public static String PieceType="";
	public static int numberWarriows;
	public static WarriorTypeInterface_23605383[] template;
	public static boolean[] specailAbilityCheck;
	public static boolean winner;
	public static void main(String[] args) {
		try{
			In gameFile = new In(args[0]);
			int outputVersion = Integer.parseInt(args[1]);
		}catch (Exception e){
			System.out.println("Usage: < program name > < name of the game setup file > .txt");
			System.exit(0);
		}
        In gameFile = new In(args[0]);
        int outputVersion = Integer.parseInt(args[1]);
        Orow= gameFile.readInt();
        Ocolumn = gameFile.readInt();
        noGame = gameFile.readInt();
        gameBoard = new String[Orow][Ocolumn];
        FillArray(gameBoard);
        gameFile.readLine();
        gameFile.readString();
        numberWarriows= gameFile.readInt();
        int count =0;
        gameFile.readLine();
		warrior = new Warrior_23605383[numberWarriows];
        stone = new StoneWarrior_23605383[numberWarriows];
         air = new AirWarrior_23605383[numberWarriows];
        water = new WaterWarrior_23605383[numberWarriows];
        flame = new FlameWarrior_23605383[numberWarriows];
        OffensePower = new double[numberWarriows];
        DefenseStrength = new double[numberWarriows];
        warriorMoves = new String[numberWarriows];
        template = new WarriorTypeInterface_23605383[numberWarriows];
        specailAbilityCheck = new boolean[numberWarriows];
        /*
        I used ArrayList for here because I don't know how many of these pieces are in the board before hand
         */
        ArrayList<Restorer_23605383> restorer = new ArrayList<Restorer_23605383>();
        ArrayList<Potion_23605383> potion = new ArrayList<Potion_23605383>();
        ArrayList<Weapon_23605383> weapon = new ArrayList<Weapon_23605383>();

		while(count < numberWarriows) {
			int PlayerRow = gameFile.readInt();
			int PlayerColumn= gameFile.readInt();
			int id = gameFile.readInt();
			String warriorType = gameFile.readString();
			int age = gameFile.readInt();
			double health = gameFile.readDouble();
			double offensePower= gameFile.readDouble();
			double defenseStrength = gameFile.readDouble();
			int weaponSize = gameFile.readInt();
			String moves = gameFile.readString();
			switch(warriorType.charAt(0)) {
			case 'A':
				String name = "A";
				air[count] = new AirWarrior_23605383(id,age,health,offensePower,defenseStrength,weaponSize,PlayerColumn,PlayerRow,moves,name,"Air");
				gameBoard[PlayerRow][PlayerColumn] += name;
				OffensePower[count]= offensePower;
				warriorMoves[count] = moves;
				DefenseStrength[count] = defenseStrength;
				break;
			case 'W':
				name = "W";
				water[count] = new WaterWarrior_23605383(id,age,health,offensePower,defenseStrength,weaponSize,PlayerColumn,PlayerRow,moves,name,"Water");
				gameBoard[PlayerRow][PlayerColumn] += name;
				OffensePower[count]= offensePower;
				warriorMoves[count] = moves;
				DefenseStrength[count] = defenseStrength;
				break;
			case 'S':
				name = "S";
				stone[count] = new StoneWarrior_23605383(id,age,health,offensePower,defenseStrength,weaponSize,PlayerColumn,PlayerRow,moves,name,"Stone");
				gameBoard[PlayerRow][PlayerColumn] += name;
				OffensePower[count]= offensePower;
				warriorMoves[count] = moves;
				DefenseStrength[count] = defenseStrength;
				break;
			case 'F':
				name = "F";
				flame[count] = new FlameWarrior_23605383(id,age,health,offensePower,defenseStrength,weaponSize,PlayerColumn,PlayerRow,moves,name,"Flame");
				gameBoard[PlayerRow][PlayerColumn] += name;
				OffensePower[count]= offensePower;
				warriorMoves[count] = moves;
				DefenseStrength[count] = defenseStrength;
				break;
			}
			count++;
			gameFile.readLine();
		}
		count =0; //count is reset to zero to manage how many variables I use
		String name ="";
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h"+i;
					int row = gameFile.readInt();
					int col = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[row][col] += name;
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p"+i;
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,name));
					}
					
					gameFile.readLine();
				}
			}
			
			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x"+i;
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[row][col] += name;
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "w" ;
					gameFile.readLine();
				}
			}
			
			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "c" ;
					gameFile.readLine();
				}
			}
		}
		/*
		 * There will be 5 repetition of the above code to account for 7 pieces in the game
		 */
		count =0; //count is reset to zero to manage how many variables I use
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h";
					int row = gameFile.readInt();
					int col = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[row][col] += name;
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p";
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,name));
					}

					gameFile.readLine();
				}
			}

			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x";
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[row][col] += name;
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "w" ;
					gameFile.readLine();
				}
			}

			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "c" ;
					gameFile.readLine();
				}
			}
		}

		count =0; //count is reset to zero to manage how many variables I use
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h";
					int row = gameFile.readInt();
					int col = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[row][col] += name;
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p";
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,name));
					}

					gameFile.readLine();
				}
			}

			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x";
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[row][col] += name;
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "w" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "c" ;
					gameFile.readLine();
				}
			}
		}

		count =0; //count is reset to zero to manage how many variables I use
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h";
					int row = gameFile.readInt();
					int col = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[row][col] += name;
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p";
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,name));
					}
					gameFile.readLine();
				}
			}

			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x";
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[row][col] += name;
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "w" ;
					gameFile.readLine();
				}
			}

			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "c" ;
					gameFile.readLine();
				}
			}
		}

		count =0; //count is reset to zero to manage how many variables I use
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h";
					int row = gameFile.readInt();
					int col = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[row][col] += name;
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p";
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,name));
					}

					gameFile.readLine();
				}
			}

			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x";
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[row][col] += name;
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "w" ;
					gameFile.readLine();
				}
			}

			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "c" ;
					gameFile.readLine();
				}
			}
		}

		count =0; //count is reset to zero to manage how many variables I use
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h";
					int row = gameFile.readInt();
					int col = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[row][col] += name;
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p";
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[row][col] += name;
						potion.add(new Potion_23605383(col,row,Type,name));
					}

					gameFile.readLine();
				}
			}

			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x";
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[row][col] += name;
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "w" ;
					gameFile.readLine();
				}
			}

			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int row =gameFile.readInt();
					int col = gameFile.readInt();
					gameBoard[row][col] += "c" ;
					gameFile.readLine();
				}
			}
		}
		placeWarriors(); //this intializes my warrior array for the final time so it can be printed out
		Restorer_23605383[] r = new Restorer_23605383[restorer.size()];
		r = restorer.toArray(r);
		Weapon_23605383[] w = new Weapon_23605383[weapon.size()];
		w= weapon.toArray(w);
		Potion_23605383[] q = new Potion_23605383[potion.size()];
		q = potion.toArray(q);
		convertInterface(warrior);
		UsefulMethods_23605383.sortWarrior(template); // this sorts the warriors in order if they're in the same cell according to ID
		UsefulMethods_23605383.sortInterfaceByRow(template); //this sorts out the warriors in the same row by column
		CheckZeroWarrior();
		checkWinner();
		if(winner){
			printGame(gameBoard);
		}
		/*
		I will use 3 for loops.
		The first loop is for how many iterations are in a game.
		The 2nd and third loop is for loop through each cell of the grid
		The aim is to go throw the grid updating each piece in the cell accordingly
		 */
		boolean piecesOverload = false; //this is to check whether there is a piece overload within a cell
		boolean MagicActivated = false; // this to check whether Magic crystal was activated
		boolean warriorOverload = false;
		boolean[][] checkWarrior = new boolean[Orow][Ocolumn] ;// this is used to check warrior's neighborhood
		/*
		The Game play will occur below
		The steps are setup in such a way that it follows the 10 steps of the requirements
		 */
		if ((noGame>0) && !NoPiece && !winner){
			for(int i =1;i<= noGame;i++){
				if (CheckNumberPieces(gameBoard)){
					//This checks that there's exactly one type of piece in a cell
					piecesOverload = true;
					break; }
				if(UsefulMethods_23605383.checkNumberWarriors(gameBoard)){
					//this checks that there's no more than 10 warriors in a cell at a time
					warriorOverload = true;
					break; }
				defenseAndoffenseStrength(); // this saves the defense
				UsefulMethods_23605383.sortWarrior(template); // this sorts the warriors in order if they're in the same cell according to ID
				UsefulMethods_23605383.sortInterfaceByRow(template);
				CheckZeroWarrior();
				checkWinner();
				if(winner){
					break;
				}
				printGame(gameBoard);
				UsefulMethods_23605383.printWarrior(template);
				AddorRemoveHeath(); //This method adds or removes warrior health according to water piece
				water(); // this performs water piece
				specialAbility();
				IncrementSpecialAbility();
				specialAbilityCompleted();
				defenseStrengthAdjust();
				warriorBattle();
				removeWarrior();
				ageIncrement();
				ageDefenseAdjust();
				warriorMove(i);
				updatedGameBoard();
				addWarrior();
				if(UsefulMethods_23605383.checkNumberWarriors(gameBoard)){
					//this checks that there's no more than 10 warriors in a cell at a time
					warriorOverload = true;
					break;
				}
				UsefulMethods_23605383.sortWarrior(template); // this sorts the warriors in order if they're in the same cell according to ID
				UsefulMethods_23605383.sortInterfaceByRow(template);
			}
		}
		if(piecesOverload){
			if(PieceType.equals("magic")){
				System.out.println("Error: multiple magic crystal pieces configured on the grid.");
			}else{
				System.out.println("Error: multiple "+ PieceType+" pieces were configured at the same position on the game grid.");
			}
		}
		if (warriorOverload){
			System.out.println("Error: warrior limit exceeded at cell "+UsefulMethods_23605383.WarriorRow+" "+UsefulMethods_23605383.WarriorColumn);
		}
		if(winner){
			System.out.println("A warrior has been proven victor!");
		}
		if (outputVersion == 0) {
			// warrior statistics mode
			if(!warriorOverload && !piecesOverload && !winner && !NoPiece){
				UsefulMethods_23605383.printWarrior(template);
			}
        } 
        else if (outputVersion == 1) {
            // warrior statistics with visualization mode
			if(!warriorOverload && !piecesOverload && !winner && !NoPiece){
				printGame(gameBoard);
				UsefulMethods_23605383.printWarrior(template);
			}
        }
    }
	private static void removeWarrior() {
		ArrayList<WarriorTypeInterface_23605383> temp= new ArrayList<WarriorTypeInterface_23605383>();
		for (int i = 0; i < template.length; i++) {
			if(template[i].getHealth() <= 0 && !template[i].isPerformedAbility()){
				System.out.println("A warrior has left the game!");
			}
			if (template[i].getHealth()>0){
				temp.add(template[i]);
			}
		}
		template = new WarriorTypeInterface_23605383[temp.size()];
		template = temp.toArray(template);
	}
	private static void updatedGameBoard() {
		//This method removes all the warriors inside the gameBoard array
		for (int i = 0; i <Orow ; i++) {
			for (int j = 0; j < Ocolumn; j++) {
				if(gameBoard[i][j].contains("W")){
					gameBoard[i][j] = gameBoard[i][j].replaceAll("W","");
				}
				if(gameBoard[i][j].contains("S")){
					gameBoard[i][j] = gameBoard[i][j].replaceAll("S","");
				}
				if(gameBoard[i][j].contains("F")){
					gameBoard[i][j] = gameBoard[i][j].replaceAll("F","");
				}
				if(gameBoard[i][j].contains("A")){
					gameBoard[i][j] = gameBoard[i][j].replaceAll("A","");
				}
			}
		}
	}
	public static void addWarrior(){
		//This method adds warriors in gameBoard array
		for (int i = 0; i <template.length ; i++) {
			if(template[i] != null){
				if(template[i].getType().equals("Stone")){
					gameBoard[template[i].getPlayerRow()][template[i].getPlayerColumn()] +="S";
				}
				if(template[i].getType().equals("Water")){
					gameBoard[template[i].getPlayerRow()][template[i].getPlayerColumn()] +="W";
				}
				if(template[i].getType().equals("Air")){
					gameBoard[template[i].getPlayerRow()][template[i].getPlayerColumn()] +="A";
				}
				if(template[i].getType().equals("Flame")){
					gameBoard[template[i].getPlayerRow()][template[i].getPlayerColumn()] +="F";
				}
			}
		}
	}
	private static void checkWinner() {
		int count=0;
		for (int i = 0; i <Orow ; i++) {
			for (int j = 0; j <Ocolumn ; j++) {
				count = count+ UsefulMethods_23605383.NumberOfWarriors(gameBoard[i][j]);
			}
		}
		if (count==1){
			winner = true;
		}
	}
	public static void warriorMove(int i){
		int index =i-1;
		for (int j = 0; j <template.length ; j++) {
			if (!(template[j] == null)){
				if(template[j].getMoves().length()>index){
					char move = template[j].getMoves().charAt(index);
					switch(move){
						case 'd': //right
							template[j].rightMove(Ocolumn);
							break;
						case 'a'://left
							template[j].leftMove(Ocolumn);
							break;
						case 'w': //up
							template[j].upMove(Orow);
							break;
						case 'x': //down
							template[j].downMove(Orow);
							break;
						case 'e': //up right
							template[j].upRight(Ocolumn,Orow); // NB!need to check this method again
							break;
						case 'q': //up left
							template[j].upLeft(Ocolumn,Orow);
							break;
						case 'c': //right bottom
							template[j].downRight(Ocolumn,Orow);
							break;
						case 'z': //left bottom
							template[j].downLeft(Ocolumn,Orow);
							break;
					}
				}
				if(template[j].getMoves().length()<= index){
					int count = index%(template[j].getMoves().length());
					char move = template[j].getMoves().charAt(count);
					switch(move){
						case 'd': //right
							template[j].rightMove(Ocolumn);
							break;
						case 'a'://left
							template[j].leftMove(Ocolumn);
							break;
						case 'w': //up
							template[j].upMove(Orow);
							break;
						case 'x': //down
							template[j].downMove(Orow);
							break;
						case 'e': //up right
							template[j].upRight(Ocolumn,Orow); // NB!need to check this method again
							break;
						case 'q': //up left
							template[j].upLeft(Ocolumn,Orow);
							break;
						case 'c': //right bottom
							template[j].downRight(Ocolumn,Orow);
							break;
						case 'z': //left bottom
							template[j].downLeft(Ocolumn,Orow);
							break;
					}
				}
			}
		}
	}
	private static void warriorBattle() {
		boolean[][] tempt;
		for (int i = 0; i < template.length; i++) {
			tempt=UsefulMethods_23605383.WarriorNeighborhood(gameBoard,template[i].getPlayerRow(),template[i].getPlayerColumn());
			for (int j = 0; j <tempt.length ; j++) {
				for (int k = 0; k <tempt[j].length ; k++) {
					if(tempt[j][k]){
						for (int l = 0; l <template.length ; l++) {
							if(template[l].getPlayerRow()==j && template[l].getPlayerColumn()==k){
								if(template[i].getFightDefense() < template[l].getFightDefense()){
									template[i].setHealth(template[i].getHealth()-template[l].getFightOffensive());
								}
							}
						}
					}
				}
			}
		}
	}
	public static void printBoard( String[][] temp) {
    	for(int i=0;i<temp.length;i++) {
    		for(int j=0;j<temp[i].length;j++) {
    			System.out.print(temp[i][j]);
    		}
    		System.out.println();
    	}
    }
    public static void FillArray(String[][] SC){
        for (int i = 0; i < SC.length; i++){
            Arrays.fill(SC[i], ".");
        }
    }
    public static boolean checkPieces(String temp){
    	/*
    	A cell must have a maximum of 1 healer,potion,magic,weapon and water
    	this method checks each cell
    	 */
    	int countH=0,countP=0,countM=0,countWeapon=0,countW=0;
    	for(int i=0;i<temp.length();i++){
    		char check = temp.charAt(i);
    		switch (check){
				case 'x':
					countWeapon++;
					break;
				case 'h':
					countH++;
					break;
				case 'p':
					countP++;
					break;
				case 'c':
					countM++;
					break;
				case 'w':
					countW++;
					break;
			}
		}
    	if (countH>1){
    		PieceType = "healer";
    		return false;
		}
    	if (countM >1){
    		PieceType = "magic";
    		return false;
		}
    	if(countP>1){
    		PieceType= "potion";
    		return false;
		}
    	if (countW>1){
    		PieceType = "water";
    		return false;
		}
    	return true;
	}
	public static boolean CheckNumberPieces(String[][] temp){
		for (int i = 0; i <temp.length ; i++) {
			for (int j = 0; j <temp[i].length ; j++) {
				if(!(checkPieces(temp[i][j]))){
					return true;
				}
			}
		}
		return false;
	}
	public static void ageIncrement(){
		for (int i = 0; i <template.length ; i++) {
			if(template[i] != null){
				template[i].incrementAge();
			}
		}
	}
	public static void placeWarriors(){
		for (int i = 0; i < stone.length ; i++) {
			if(!(stone[i] == null)){
				warrior[i] = stone[i];
			}
		}
		for (int i = 0; i <flame.length ; i++) {
			if (!(flame[i]==null)){
				warrior[i] = flame[i];
			}
		}
		for (int i = 0; i <water.length ; i++) {
			if (!(water[i]==null)){
				warrior[i] = water[i];
			}
		}
		for (int i = 0; i <air.length ; i++) {
			if (!(air[i] == null)){
				warrior[i] = air[i];
			}
		}
	}
	public static void printGame(String[][] temp){
		for (int i = 0; i < temp.length ; i++) {
			for (int j = 0; j < temp[i].length ; j++) {
				if(temp[i][j].length() >1){
					if(UsefulMethods_23605383.NumberOfWarriors(temp[i][j]) >1){
						System.out.print(UsefulMethods_23605383.NumberOfWarriors(temp[i][j])+" ");
					}else {
						System.out.print(temp[i][j].charAt(1)+" ");
					}
				}else{
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
	public static void convertInterface(Warrior_23605383[] temp){
		for (int i = 0; i < numberWarriows ; i++) {
			template[i] = (WarriorTypeInterface_23605383) temp[i];
		}
	}
	public static void AddorRemoveHeath(){
		boolean[][] check = new boolean[Orow][Ocolumn];
		for (int i = 0; i <template.length ; i++) {
			check=UsefulMethods_23605383.WarriorNeighborhood(gameBoard,template[i].getPlayerRow(),template[i].getPlayerColumn());
			int countWater=0;
			for (int j = 0; j <check.length ; j++) {
				for (int k = 0; k <check[j].length ; k++) {
					if(check[j][k]){
						countWater = countWater + UsefulMethods_23605383.NumberOfWarrior(gameBoard[j][k]);
					}
				}
			}
			if (countWater >=1){
				template[i].setHealth(template[i].getHealth()+3.0);
			}else {
				template[i].setHealth(template[i].getHealth()-0.5);
			}
			if(template[i].getType().equals("Water")){
				template[i].setOffensePower(template[i].getOffensePower()+countWater); // adds 1% to warrior object offense power
			}
		}

	}
	public static void specialAbility(){
		for (int i = 0; i <template.length ; i++) {
			if(template[i].getHealth() <= 10){
					specailAbilityCheck[i]= true;
					template[i].performSpecialAbility();
			}
		}
	}
	public static void IncrementSpecialAbility(){
		for (int i = 0; i <template.length ; i++) {
			if(specailAbilityCheck[i]){
				template[i].incrementCountSpecialAbility();
			}
		}
	}
	public static void specialAbilityCompleted(){
		for (int i = 0; i <template.length ; i++) {
			template[i].specialAbilityCompleted();
		}
	}
	public static void defenseStrengthAdjust(){
		/*
		This method adjusts the defense strength of a warrior if there's the same type of warrior in the cell
		 */
		for (int i = 0; i <template.length ; i++) {
			for (int j = 0; j <template.length ; j++) {
				if(template[i].getPlayerRow()== template[j].getPlayerRow() && template[i].getPlayerColumn() == template[j].getPlayerColumn() && template[i].getType().equals(template[j].getType()) ){
					template[i].setDefenseStrength(template[i].getDefenseStrength()+2);
				}
			}
		}
		//this removes the extra 2 because the above code includes the warrior itself
		for (int i = 0; i <template.length ; i++) {
			template[i].setDefenseStrength(template[i].getDefenseStrength()-2);
		}
	}
	public static void defenseAndoffenseStrength(){
		for (int i = 0; i <template.length ; i++) {
			if(template[i] != null){
				template[i].setFightDefense(template[i].getDefenseStrength());
				template[i].setFightOffensive(template[i].getOffensePower());
			}
		}
	}
	public static void ageDefenseAdjust(){
		/*
		this method adjusts warrior's defense strength according to its age
		 */
		for (int i = 0; i <template.length ; i++) {
			if(template[i] != null){
				if(template[i].getAge()>15 && template[i].getAge()<=25){
					if(template[i].getDefenseStrength()>70.0){
						template[i].setDefenseStrength(70.0);
					}
				}
				if(template[i].getAge()>25 && template[i].getAge()<= 50){
					if(template[i].getDefenseStrength()>50){
						template[i].setDefenseStrength(50);
					}
				}
				if(template[i].getAge()>50){
					if(template[i].getDefenseStrength()>30){
						template[i].setDefenseStrength(30);
					}
				}
			}
		}
	}
	public static void water(){
		String[][] temp= new String[Orow][Ocolumn];
		for (int i = 0; i <Orow ; i++) {
			for (int j = 0; j <Ocolumn ; j++) {
				temp[i][j] = gameBoard[i][j];
			}
		}
		boolean[][] checkWater;
		int countingWater=0;
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j <gameBoard[i].length ; j++) {
				if (temp[i][j].contains("w")){
					countingWater=0;
					checkWater = UsefulMethods_23605383.WarriorNeighborhood(temp,i,j);
					for (int k = 0; k <Orow ; k++) {
						for (int l = 0; l <Ocolumn ; l++) {
							if(checkWater[k][l]){
								if(temp[k][l].contains("w")){
									countingWater++;
								}
							}
						}
					}
					if(countingWater <= 1 || countingWater >= 4){
						gameBoard[i][j] = gameBoard[i][j].replace("w","");
					}
				}
				if(!temp[i][j].contains("w")){
					countingWater=0;
					checkWater = UsefulMethods_23605383.WarriorNeighborhood(gameBoard,i,j);
					for (int k = 0; k <Orow ; k++) {
						for (int l = 0; l <Ocolumn ; l++) {
							if(checkWater[k][l]){
								if(temp[k][l].contains("w")){
									countingWater++;
								}
							}
						}
					}
					if(countingWater == 3){
						gameBoard[i][j] += "w";
					}
				}

			}
		}
	}
	public static void CheckZeroWarrior(){
		//This method checks if there's no warrior on the grid
		int countWarrior =0;
		for (int i = 0; i <Orow ; i++) {
			for (int j = 0; j < Ocolumn ; j++) {
				countWarrior += UsefulMethods_23605383.NumberOfWarriors(gameBoard[i][j]);
			}
		}
		if(countWarrior==0){
			//it sets NoPiece variable as true
			NoPiece = true;
			System.out.println("No warriors are left!");
		}
	}
}