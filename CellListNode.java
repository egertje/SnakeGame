/* Emma Gertje
 * 4/6/2020
 * CSCI 271
 * Professor David Keil
 * Optional coding project - Snake Game
 * This CelListNode class holds the node for the list of cells
 *		that will be the snake in this game. It has a cell as data
 *		and a pointer to the next node
 */
public class CellListNode {
	//data is the cell object that the node is holding
	Cell data; 
	//next is the successor of the current node
	CellListNode next; 
	//constructor with a Cell object for input
	CellListNode(Cell c) {
		data = c;
		next = null;
	}
	//toString method for CellListNode class which returns the row
		//and column
	public String toString() {
		return this.toString();
	}

}
