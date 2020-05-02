/* Emma Gertje
 * 4/7/2020
 * CSCI 271
 * Professor David Keil
 * Optional coding project - Snake Game
 * This GameController class is the class that handles the user 
 * 		interaction and where the user actually plays the game. The 
 * 		user keeps entering the direction they want the snake to go 
 * 		until the snake collides or they decide to exit the game
 */
import java.util.Scanner;
public class GameController { 
	public Game game;
	public GameController(Game game) {
		this.game = game;
	}
	//in the main method the user will be giving input and playing the game
	public static void main(String[] args) {
		//create Scanner object
		Scanner input = new Scanner(System.in);
		System.out.println("Starting the game!");
		//will have the head start at (0,0)
		Cell initialPosition = new Cell(0, 0);
		//make snake with the initialPosition
		Snake initialSnake = new Snake(initialPosition);
		System.out.println("Please enter the number of rows you'd like in the board: ");
		int rows = input.nextInt();
		System.out.println("Please enter the number of columns you'd like in the board: ");
		int columns = input.nextInt();
		//make board with the rows and columns entered by the user
		Board board = new Board(rows, columns);
		//make a new game with the snake and the board
		Game newGame = new Game(initialSnake, board);
		//gameOver should initially be false 
		newGame.setGameOver(false);
		//have the user play the game until they lose or decide to leave
		//first have the user choose a direction for the snake
		int direction = getChoice();
		while(!(newGame.isGameOver()) && ((direction == 1) || (direction == 2) || (direction == 3) || (direction == 4) || (direction == 5))) {
			//if the user wants to exit the game, have gameOver be true
			if(direction == 5) {
				newGame.setGameOver(true);
				System.out.println("The game is now over!");
			}
			else {
				switch(direction) {
				case 1:
					newGame.setDirection(Direction.RIGHT);
					break;
				case 2: 
					newGame.setDirection(Direction.LEFT);
					break;
				case 3: 
					newGame.setDirection(Direction.UP);
					break;
				case 4:
					newGame.setDirection(Direction.DOWN);
					break;
				}
				//now that the direction has been updated with user input 
					//have the game be updated
				newGame.updateGame();
				//will now end the game if gameOver is true by breaking the loop
				if(newGame.isGameOver() == true) {
					break;
				}
				//now, generate food
				newGame.getBoard().generateFood();
				//get the next direction of the snake
				direction = getChoice();
			}
		}
	}
	private static int getChoice() {
		//create Scanner object
		Scanner input = new Scanner(System.in);
		System.out.printf("Please enter a 1 if you want the snake to go right..%n");
		System.out.printf("Please enter a 2 if you want the snake to go left...%n");
		System.out.printf("Please enter a 3 if you want the snake to go up...%n");
		System.out.printf("Please enter a 4 if you want the snake to go down...%n");
		System.out.printf("Please enter a 5 if you want to exit the game...%n");
		System.out.println("Choice: ");
		int choice = input.nextInt();
		return choice;
	}
}

