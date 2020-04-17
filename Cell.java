/* Emma Gertje
 * 4/6/2020
 * CSCI 271
 * Professor David Keil
 * Optional coding project - Snake Game
 * This Cell class holds the row and column number of the
 * 		specific cell in the board it is representing.
 * 		It also holds the type of cell it is.
 */
public class Cell {
	private final int ROW;
	private final int COLUMN;
	private CellType cellType;
	//constructor
	public Cell(int row, int column) {
		this.ROW = row;
		this.COLUMN = column;
	}
	//getters
	public int getRow() {
		return this.ROW;
	}
	public int getColumn() {
		return this.COLUMN;
	}
	public CellType getCellType() {
		return this.cellType;
	}
	//setter
	public void setCellType(CellType type) {
		this.cellType = type;
	}
	//toString method
	public String toString() {
		return String.format("row: %d, column: %d%n", this.ROW, this.COLUMN);
	}

}
