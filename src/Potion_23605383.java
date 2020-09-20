
public class Potion_23605383 {
	private final int  PlayerColumn;
	private final int PlayerRow;
	private final int PlayerType;
	private int NumberIterations;
	String name;
	
	public Potion_23605383(int playerColumn, int playerRow, int playerType, String name) {
		this.PlayerColumn = playerColumn;
		this.PlayerRow = playerRow;
		this.PlayerType = playerType;
		this.name = name;
	}

	public Potion_23605383(int playerColumn, int playerRow, int playerType, int numberIterations,String name) {
		this.PlayerColumn = playerColumn;
		this.PlayerRow = playerRow;
		this.PlayerType = playerType;
		this.NumberIterations = numberIterations;
		this.name= name;
	}

	public int getNumberIterations() {
		return NumberIterations;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	
}
