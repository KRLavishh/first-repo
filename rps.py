import random

def get_computer_choice():
    choices = ["rock", "paper", "scissors"]
    return random.choice(choices)

def get_winner(player, computer):
    if player == computer:
        return "tie"
    elif (player == "rock" and computer == "scissors") or \
         (player == "paper" and computer == "rock") or \
         (player == "scissors" and computer == "paper"):
        return "player"
    else:
        return "computer"

def play_game():
    player_score = 0
    computer_score = 0

    player_name = input("Enter your name: ")

    print(f"Welcome to Rock Paper Scissors, {player_name}!")
    print("Type rock, paper, or scissors to play. Type q to exit.")

    while True:
        player = input("\nYour choice: ").lower()

        if player == "q":
            print(f"\nFinal Score - {player_name}: {player_score} | Computer: {computer_score}")
            print(f"Thanks for playing, {player_name}!")
            break

        if player not in ["rock", "paper", "scissors"]:
            print("Invalid choice, try again.")
            continue

        computer = get_computer_choice()
        print(f"Computer chose: {computer}")

        result = get_winner(player, computer)

        if result == "tie":
            print("It's a tie!")
        elif result == "player":
            player_score += 1
            print(f"You win this round! Score - You: {player_score} | Computer: {computer_score}")
        else:
            computer_score += 1
            print(f"Computer wins this round! Score - You: {player_score} | Computer: {computer_score}")

play_game()