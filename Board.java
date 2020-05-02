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
	 * This method generates food on a random cell in the board as long
	 * as its not part of the snake or have food in it already
	 */
	public void generateFood() {
		boolean needToGenerateAgain = true;
		//this while loop will keep going until food is generated again
		while(needToGenerateAgain) {
			//random row and column where the food will be generated at
			int row = (int)(Math.random() * this.ROW_COUNT);
			int col = (int)(Math.random() * this.COLUMN_COUNT);
			//now make sure this cell is empty because food should only be
				//generated on an empty cell
			//will first check if board is full, if the board is full then 
				//no food should be generated
			if(isBoardFull()) {
				System.out.println("The board is full so no food can be generated");
				break;
			}
			else if(board[row][col].getCellType() == CellType.EMPTY) {
				//now at this row and column make the cell a food type
				board[row][col].setCellType(CellType.FOOD);
				System.out.printf("Food is generated at: %d, %d%n", row, col);
				needToGenerateAgain = false;
				break;
			}
			else {
			System.out.println("Food needs to be generated again.");
			}
		}
	}
	/**
	 * This method determines if the board is full or not, meaning all of the 
	 * cells have either food or are part of the snake
	 * @return true is the board is full and false otherwise
	 */
	public boolean isBoardFull() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				//if an empty cell is found then the board isn't empty and 
					//false is returned
				if(board[i][j].getCellType() == CellType.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * This method determines if the board is made up of only snake parts or not
	 * @return true if the board is made up of only snake parts and false otherwise
	 */
	public boolean isAllSnakeParts() {
		boolean allSnakeParts = true;
		for(int i = 0; i < ROW_COUNT; i++) {
			for(int j = 0; j < COLUMN_COUNT; j++) {
				if(board[i][j].getCellType() == CellType.EMPTY || board[i][j].getCellType() == CellType.FOOD) {
					allSnakeParts = false;
					return allSnakeParts;
				}
			}
		}
		return allSnakeParts;
	}
}

