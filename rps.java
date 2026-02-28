import java.util.Random;
import java.util.Scanner;

public class rps {
    
    public static String getWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "tie";
        }
        else if (player.equals("rock") && computer.equals("scissors") 
            || player.equals("paper") &&
        computer.equals("rock") 
        || player.equals("scissors") && computer.equals("paper")){
            return "player";
        }
        else{
            return "computer";
        }

    }

    public static String getComputerChoice(){
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        String computerChoice = choices[random.nextInt(choices.length)];
        return computerChoice;
    }

    public static void playAgain(String playerName){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play again?");
        System.out.print("Type y or n: ");
        String decision = scanner.nextLine().toLowerCase();
        if (decision.equals("y")){
            main(null);
        }
        else if (decision.equals("n")){
            System.out.println("Play again sometime, " + playerName + "!");
        }
        else{
            System.out.println("Invalid decision.");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerScore = 0;
        int computerScore = 0;
       
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Welcome to Rock Paper Scissors, " + playerName);
        System.out.println("Type rock, paper, or scissors to play. Type q to quit.");

        while (true){
            System.out.print("\nYour choice: ");
            String player = scanner.nextLine().toLowerCase();
            if (player.equals("q")){
                System.out.println("Final Score - " + playerName + ": " + playerScore);
                System.out.println("Thanks for playing, " + playerName + "!");
                break;
            }
            if (!player.equals("rock") && 
            !player.equals("paper") && 
            !player.equals("scissors")){
                System.out.println("Invalid choice, try again.");
                continue;
            }
        
        
            String computer = getComputerChoice();
            System.out.println("Computer chose: " + computer);

            String result = getWinner(player, computer);

            if (result.equals("tie")){
                System.out.println("It's a tie!");
            }
                else if (result.equals("player")){
                playerScore += 1;
                
                System.out.println("You win this round! Score - You: " + playerScore+ " | Computer: " + computerScore);
            }
            else    {
                computerScore += 1;
                System.out.println("Computer wins this round! Score - You: " + playerScore + " | Computer: " + computerScore);
            }

            if  (playerScore == 6){
                System.out.println("You are the winner, " + playerName + "!");
                playAgain(playerName);
                break;
        }
            if  (computerScore == 6){
                System.out.println("You are the loser, " + playerName + "..");
                playAgain(playerName);
                break;
            }
    }
    scanner.close();
}
}