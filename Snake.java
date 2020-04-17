/* Emma Gertje
 * 4/6/2020
 * CSCI 271
 * Professor David Keil
 * Optional coding project - Snake Game
 * This Snake class is the snake in the Snake Game.
 * 		It holds the linked list of cells which is the snake
 * 		and has several methods which are used by the snake 
 * 		such as grow, move, and check collisions
 */
public class Snake {
	//this CellList represents the snake
	private CellList snakeParts;
	//constructor
	public Snake(Cell initialPosition) {
		//create CellListNode with the initial position which will
			//be the head of the snakeParts list
		CellListNode head = new CellListNode(initialPosition);
		//now initialize the snakeParts list with the head
		snakeParts = new CellList(head);
	}
	//getter
	public CellList getSnakeParts() {
		return this.snakeParts;
	}
	//setter
	public void setSnakeParts(CellList snake) {
		this.snakeParts = snake;
	}
	/**
	 * This method grows the snake's size by one by adding a cell
	 * to the list of snake parts when the snake eats food
	 * @param newTail the Cell which is the cell right behind the snake which
	 * is being added
	 */
	public void grow(Cell newTail) {
		System.out.println("The snake is growing!");
		//add a tail whenever the snake grows
		snakeParts.append(newTail);
	}
	/**
	 * Move the snake's head to the newCell and remove the old tail
	 * since it's moved up one
	 * @param newCell the Cell the snake's head is moving to
	 * @return the old tail of the snake that's no longer
	 * a part of the snake
	 */
	public Cell move(Cell newCell) {
		System.out.format("Snake is moving to %s", newCell.toString());
		//will first remove the old tail since the snake won't be there anymore
		Cell oldTail = snakeParts.deleteLast();
		//now need to make the new head the newCell
		Cell newHead = newCell;
		snakeParts.prepend(newHead);
		return oldTail;
	}
	/**
	 * Check to see if the next cell the snake will move to is part of the 
	 * snake's body
	 * @param nextCell the next Cell the snake  will move to
	 * @return true if the snake will crash into itself and false otherwise
	 */
	public boolean checkIfCrashed(Cell nextCell) {
		System.out.println("Will check if the snake crased into itself.");
		//need to traverse the list and make sure this new cell it's moving
			//to isn't a cell in the snakeParts list
		//First node in the list is the head
		CellListNode nd = snakeParts.head;
		//checking to make sure that the current node isn't null because if it is there 
			//are no more elements in the list
		while(nd != null) {
			//checking to make sure the current node's cell and newCell arent' equal
			if(nd.data == nextCell) {
				System.out.println("The snake crashed into itself!");
				return true;
			}
			nd = nd.next;
		}
		System.out.println("The snake did not crash into itself!");
		//return false if there wasn't a crash
		return false;
	}
}
