package Number_guessing_game;

import java.util.Scanner;

public class User {
    private Scanner scanner;

    public User(){
        this.scanner = new Scanner(System.in);
    }

    public int getNumber(){
        System.out.println("Enter your number: ");
        return scanner.nextInt();
    }
}
