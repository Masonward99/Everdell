package Everdell;

import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;
    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public int getIntInRange ( int max ) {
        int index = scanner.nextInt();
        while ( index >= max){
            System.out.println("Enter a number between 0 and " + max);
            index = scanner.nextInt();
        }
        return index;
    }

}
