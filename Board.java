/* Emma Gertje
 * 4/7/2020
 * CSCI 271
 * Professor David Keil
 * Optional coding project - Snake Game
 * This Snake Board class is the board of the game. It holds the a
 * 		amount of rows and columns in the board and the board itself which
 * 		is made up of cells. It also has a generateFood function that will  
 * 		generate food on a random cell in the board.
 */
public class Board {
	final int ROW_COUNT; //amount of rows in board
	final int COLUMN_COUNT; //amount of columns in board
	private Cell[][] board; //2D array which is the board which is made up of cells
	//constructor
	public Board(int numOfRows, int numOfColumns) {
		this.ROW_COUNT = numOfRows;
		this.COLUMN_COUNT = numOfColumns;
		//now make the board with the appropriate amount of 
			//rows and columns
		board = new Cell[this.ROW_COUNT][this.COLUMN_COUNT];
		//now populate the board with the correct row and column for
			//the cells in the board
		for(int row = 0; row < this.ROW_COUNT; row++) {
			for(int col = 0; col < this.COLUMN_COUNT; col++) {
				Cell newCell = new Cell(row, col);
				board[row][col] = newCell;
				//make every cell initially empty
				newCell.setCellType(CellType.EMPTY);
			}
		}
	}
	//getter
	public Cell[][] getBoard() {
		return this.board;
	}
	//setter
	public void setBoard(Cell[][] board) {
		this.board = board;
	}
	/**
	 * This method generates food on a random cell in the board
	 */
	public void generateFood() {
		//random row and column where the food will be generated at
		int row = (int)(Math.random() * this.ROW_COUNT);
		int col = (int)(Math.random() * this.COLUMN_COUNT);
		//now at this row and column make the cell a food type
		board[row][col].setCellType(CellType.FOOD);
		System.out.printf("Food is generated at: %d, %d%n", row, col);
	}

}
