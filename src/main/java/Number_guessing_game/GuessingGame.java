package Number_guessing_game;


import java.util.Random;

public class GuessingGame extends  Game {

    @Override
    protected int generateGuessNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;

    }

    @Override
    public void guess(int number) {
        if (number > guessNumber) {
            System.out.println("Too high");
        } else if (number < guessNumber) {
            System.out.println("Too low");
        } else {
            System.out.println("Congratulations! You guessed the correct number!");
            win = true;
        }
        chances++;
        System.out.println(guessNumber);
    }

    @Override
    public boolean gameOver() {
        return chances > 10;
    }

    @Override
    public void score() {
        score = 100 - (10 * chances);
        System.out.printf("Your score is: %d%n", score);
    }

    @Override
    public void startNewRound(){
        score = 0;
        chances = 0;
        guessNumber = generateGuessNumber();
    }


    public static void main(String[] args) {
        int round = 1;
        int rounds = 3;
        Game game = new GuessingGame();
        User user = new User();


        while (round <= rounds) {
            System.out.println("Round" + round);

            while (!game.gameOver() && !game.win) {
                int number = user.getNumber();
                game.guess(number);
                game.score();
            }

            round++;
            game.startNewRound();
        }
    }
}
