package Number_guessing_game;

import java.util.Scanner;

public abstract class Game {
    public Scanner scanner;
    public int guessNumber;
    public int chances;

    public int score;

    public boolean win;

    public Game(){
        this.scanner = new Scanner(System.in);
        this.guessNumber = generateGuessNumber();
        this.chances = 0;
        this.score = 0;
    }

    protected abstract int generateGuessNumber();

    public abstract void guess(int number);

    public void score(){

    }
    public abstract boolean gameOver();

    protected void startNewRound() {
    }
}
