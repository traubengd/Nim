import java.util.Scanner;

public class Nim {

   /* This is a Java programme that plays the game Nim, with either two human players, or a human player versus a computer player
    */
	
	static int numberOfMatches = 11;
	static int takenMatches;
	static Scanner input = new Scanner(System.in);
	static boolean playerOneTurn;
	static boolean computerPlayer;

   public static void main(String []args) {
	   System.out.println("Welcome to the game Nim! Would you like to play a two-player game (please type 1), or a one-player game against the computer (please type 2)?");
	   while (true){
		   String gameChoice = input.next();
		   if (gameChoice.equals("1")) 
			   break;
		   else if (gameChoice.equals("2")){
			   computerPlayer = true;
			   break;
		   }
		   else
			   System.out.println("You did not enter a valid option, please try again");
	   }
	   
	   System.out.println("There are " + numberOfMatches + " matches.");
	   while (numberOfMatches>0){
		   playerOneTurn = !playerOneTurn;
		   if (playerOneTurn){
			   System.out.println("It is player 1's turn");
			   System.out.println("How many do you want to take?");
			   takenMatches = takeUserInput();
		   }
		   else if (computerPlayer){
			   System.out.println("It is the computer player's turn");
			   takenMatches = determineComputerMove(numberOfMatches);
			   System.out.println("The computer player will take " + takenMatches + " matches!");
		   }
		   else{
			   System.out.println("It is player 2's turn");
			   System.out.println("How many do you want to take?");
			   takenMatches = takeUserInput();
		   }
		   numberOfMatches = numberOfMatches - takenMatches;
		   System.out.println("There are " + numberOfMatches + " matches.");
	   }
	   
	   System.out.println("There are no matches remaining");
	   if (playerOneTurn){
			   System.out.println("Player 1 has lost the game!");
		}
		else if (computerPlayer){
			System.out.println("The computer has lost the game! Congratulations, you won!");
		}
		else{
			   System.out.println("Player 2 has lost the game!");
		}
   }
   
   public static int takeUserInput(){
	   while(true){
		int userNumber = input.nextInt();
		if(userNumber>0 && userNumber<5 && userNumber<=numberOfMatches){
			return userNumber;
		}
		else {
			System.out.println("You did not enter a valid number, please try again");
		}
		}
   }
   
   public static int determineComputerMove(int currentMatches){
	   switch (currentMatches){
		   case 11: return 1;
		   case 10: return 4;
		   case 9: return 3;
		   case 8: return 2;
		   case 7: return 1;
		   case 6: return 1;
		   case 5: return 4;
		   case 4: return 3;
		   case 3: return 2;
		   case 2: return 1;
		   case 1: return 1;
		   default: return 1;
	   }
   }
}