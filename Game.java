/* Emma Gertje
 * 4/7/2020
 * CSCI 271
 * Professor David Keil
 * Optional coding project - Snake Game
 * This Game class holds the snake and board used during the game 
 * 		as well as the direction the snake is moving in and if the
 * 		game is over. This class updates the game by having the snake
 * 		move in the direction given and it also has a method that gets
 * 		the next cell the snake will be moving to that is used in the 
 * 		method that updates the game
 */
public class Game {
	private Snake snake; 
	private Board board; 
	private Direction currentDirection; 
	private boolean gameOver; 
	//constructor
	public Game(Snake snake, Board board) { 
		this.snake = snake; 
	    this.board = board; 
	} 
	//getters
	public Snake getSnake() { 
		return this.snake; 
	}
	public Board getBoard() { 
        return this.board; 
    } 
	public Direction getDirection() { 
        return this.currentDirection; 
    } 
	public boolean isGameOver() { 
        return this.gameOver; 
    } 
	//setters
	public void setSnake(Snake snake) { 
        this.snake = snake; 
    } 
	public void setBoard(Board board) { 
		this.board = board; 
	}
	public void setDirection(Direction direction) 
    { 
        this.currentDirection = direction; 
    } 
	public void setGameOver(boolean gameOver) { 
        this.gameOver = gameOver; 
    } 
	/**
	 * This method updates the game by having the snake move with the direction  
	 * given by the user, eat if there's food, see if there's a crash
	 */
    public void updateGame() { 
        System.out.println("Updating game!"); 
        if (!gameOver) { 
        	//need to make sure the snake is moving
            if (this.currentDirection != Direction.NONE) {
            	//Will now be getting the next cell the snake is moving too
                Cell nextCell = getNextCell(snake.getSnakeParts().head.data); 
                //Need to see if the cell the snake is moving to is part of the 
                	//snake's body
                //If it is then the game is over since the snake crashed into itself
                if (snake.checkIfCrashed(nextCell)) { 
                    setDirection(Direction.NONE); 
                    gameOver = true; 
                } 
                //if the snake won't crash have it move
                else {
                	//first store the CellType of the next cell because later we'll
                		//want to know if it's food
                	CellType nextCellType = nextCell.getCellType();
                	//store the old tail in a variable because if the snake
                		//has moved to a cell with food that tail will need to
                		//be added back since it's going to grow
                    Cell oldTail = snake.move(nextCell); 
                    if (nextCellType == CellType.FOOD) { 
                        snake.grow(oldTail); 
                        //now generate food again since some food has been eat
                        board.generateFood(); 
                    } 
                } 
            } 
        } 
    }
    /**
     * This method finds the next cell the snake will be moving to
     * based on the current direction stored in the GameController
     * @param currentPosition the current position of the head of 
     * the snake
     * @return the next cell the snake will be moving to
     */
    private Cell getNextCell(Cell currentPosition) { 
        int row = currentPosition.getRow(); 
        int col = currentPosition.getColumn(); 
        switch(currentDirection) {
        case UP: 
        	row--;
        	break;
        case DOWN:
        	row++;
        	break;
        case RIGHT:
        	col++;
        	break;
        case LEFT:
        	col--;
        	break;
        }
        Cell nextCell = board.getBoard()[row][col]; 
        return nextCell; 
    }
}
