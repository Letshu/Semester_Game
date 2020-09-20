import java.util.ArrayList;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import princeton.In;

public class Game_23605383 {
	private static int Orow ; //number of rows in the game board
	private static int Ocolumn; //number of columns in the game
	private static  int noGame; //number of iterations in the game
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
	public static void main(String[] args) {
        In gameFile = new In(args[0]);
        int outputVersion = Integer.parseInt(args[1]);       
        Orow= gameFile.readInt();
        Ocolumn = gameFile.readInt();
        noGame = gameFile.readInt();
        String[][] gameBoard = new String[Orow][Ocolumn];
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
        WarriorTypeInterface_23605383[] template = new WarriorTypeInterface_23605383[numberWarriows];
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
		UsefulMethods_23605383.sortWarrior(warrior); // this sorts the warriors in order if they're in the same cell according to ID
		Restorer_23605383[] r = new Restorer_23605383[restorer.size()];
		r = restorer.toArray(r);
		Weapon_23605383[] w = new Weapon_23605383[weapon.size()];
		w= weapon.toArray(w);
		Potion_23605383[] q = new Potion_23605383[potion.size()];
		q = potion.toArray(q);
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
		if ((noGame>0)){
			for(int i =0;i< noGame;i++){
				if (CheckNumberPieces(gameBoard)){
					//This checks that there's exactly one type of piece in a cell
					piecesOverload = true;
					break; }
				if(UsefulMethods_23605383.checkNumberWarriors(gameBoard)){
					//this checks that there's no more than 10 warriors in a cell at a time
					warriorOverload = true;
					break; }
				UsefulMethods_23605383.waterNeighbor(gameBoard); // this check if there's sufficient warriors in water piece neighborhood
				UsefulMethods_23605383.AddWater(gameBoard); //this adds water piece where there's no water piece
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
		int ply =0;
		if (outputVersion == 0) {
			// warrior statistics mode
			System.out.println("I'm in here");
        } 
        else if (outputVersion == 1) {
            // warrior statistics with visualization mode
			printGame(gameBoard);
			UsefulMethods_23605383.printWarrior(warrior);
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
	public static void Stats(String[][] temp){
		warrior = new Warrior_23605383[numberWarriows];
		String check = "";
		for (int i = 0; i <Orow ; i++) {
			for (int j = 0; j < Ocolumn; j++) {
				if (temp[i][j].length()>1){
					System.out.println(temp[i][j]);
					int count =1;
					int index =3;
					while(index < temp[i][j].length() && count < temp[i][j].length()-2){
						check = temp[i][j].substring(count,index);
						if (check.contains("S")){
							warrior[Integer.parseInt(check.charAt(1)+"")] = stone[Integer.parseInt(check.charAt(1)+"")];
							System.out.println(check);
						}
						if (check.contains("F")){
							warrior[Integer.parseInt(check.charAt(1)+"")] = flame[Integer.parseInt(check.charAt(1)+"")];
							System.out.println(check);
						}
						if (check.contains("A")){
							warrior[Integer.parseInt(check.charAt(1)+"")] = air[Integer.parseInt(check.charAt(1)+"")];
							System.out.println(check);
						}
						if (check.contains("W")){
							warrior[Integer.parseInt(check.charAt(1)+"")] = water[Integer.parseInt(check.charAt(1)+"")];
							System.out.println(check);
							System.out.println("wATER");
						}
						index = index+2;
						count = count+2;
					}
				}
			}
			System.out.println();
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
						System.out.print(UsefulMethods_23605383.NumberOfWarriors(temp[i][j]));
					}else {
						System.out.print(temp[i][j].charAt(1));
					}
				}else{
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

}