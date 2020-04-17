/* Emma Gertje
 * 4/6/2020
 * CSCI 271
 * Professor David Keil
 * Optional coding project - Snake Game
 * This CellList class represents a linked list of cells. It will
 * 		be used to implement the snake in the game. It has a head which
 * 		is the head of the snake which is the first element in the list.
 * 		There are methods to prepend and append nodes as well as delete 
 * 		a given cell and delete the last item in the list
 */
public class CellList {
	//head holds the head of the snake, so the first node in the
		//linked list
	CellListNode head;
	//constructor that initializes the head with a cell
	public CellList(CellListNode nd) {
		head = nd;
		//now make sure that the CellType for this cell is a SNAKE_PART
			//since this cell list will be used for the snake parts
		head.data.setCellType(CellType.SNAKE_PART);
	}
	/**
	 * add a cell to the front of the linked list by making it the head
	 * @param c the cell being added to the front of the linked list
	 */
	public void prepend(Cell c) {
		//Make sure the CellType of c is SNAKE_PART since it's being added
			//to the snake
		c.setCellType(CellType.SNAKE_PART);
		//initializing the node with the input data
		CellListNode nd = new CellListNode(c);
		//make the next node of the new node the head
		nd.next = head;
		//make the new node the firstNode
		head = nd;
	}
	/**
	 * display all the elements in a linked list of cells
	 */
	public void display() {
		//first node that will be displayed is the head
		CellListNode nd = head;
		//checking to make sure that the current node isn't null because if it is there 
			//are no more elements in the list
		while(nd != null) {
			System.out.println(nd);
			nd = nd.next;
		}
	}
	/**
	 * add a cylinder object to the end of the linked list by making it the last node 
	 * @param c the cell that is being appended to the linked list
	 */
	public void append(Cell c) {
		//make sure the CellType for c is SNAKE_PART 
		c.setCellType(CellType.SNAKE_PART);
		//initializing the new node with input data
		CellListNode nd = new CellListNode(c);
		//if the head is null then the node should be appended as the head
		if(head.equals(null)){
	           head = nd;
	           return;
	          }
	        CellListNode current = head;
	        while(current.next != null){
	            current  = current.next;
	        }
	        current.next = nd;
	} 
	/**
	 * This method deletes and returns the last cell in the list
	 * @return the last cell in this linked list of cells
	 */
	public Cell deleteLast() {
		//first check to see if the list is null by checking to see if the 
			//head is null
		if(head == null) {
			return null;
		}
		//now check to see if the head is the only element
		if(head.next == null) {
			Cell lastNode = head.data;
			//now make head null since it's being deleted
			head = null;
			return lastNode;
		}
        //now find the second to last node
		CellListNode secondLast = head;
		while(secondLast.next.next != null) {
			secondLast = secondLast.next;
		}
		//once we've found the second to last node, change the next node to null
			//but store it first
		CellListNode lastNode = secondLast.next;
		secondLast.next = null;
		return lastNode.data;
		
    } 
}
