import java.util.Random;
import java.util.Scanner;
import java.util.*;

    public class main {
        public static void main (String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            String[] gameWords = {"amount", "snake","morning", "afternoon", "automatic", "homeless", "hysterical",
                    "drink", "tremble", "group" };
            String[] tyburnTree = {"_______","\n",
                                    "|    | ","\n",
                                    "|    O ","\n",
                                    "|   /|\\","\n",
                                    "|   / \\","\n",
                                    "|     ","\n"};


            boolean gameOn = true;
            while(gameOn){
                System.out.println("LETS THE GAME BEGINS!");
                String guessWord = gameWords[random.nextInt(gameWords.length)];
                String[] wordInArrayByLetter = guessWord.split("");
                String[] guessArray = new String[guessWord.length()];
                List<String> guessWordRegister = new ArrayList<>();

                int maxFails = 6;

                for (int i = 0; i<guessWord.length();i++) {
                    guessArray[i] = "_";
                }
                int fails = 0;

                for (int q = 0; fails < maxFails;q++) {
                    System.out.println("GUESS THE LETTER!");
                    char guessLetter = scanner.nextLine().charAt(0);
                    String replyProces = "";

                    if (guessLetter == '-') {
                        break;
                    }
                    else {
                        for (int i = 0; i < guessWord.length(); i++) {
                            if (guessWord.charAt(i) == guessLetter) {
                                guessArray[i] = String.valueOf(guessLetter);
                            }
                        }
                        if (guessWord.equals(String.join("",guessArray))) {
                            gameOn = false;
                            System.out.println("YOU WON!!!");
                            break;
                        }
                    }
                    String str = String.join("", guessArray);
                    System.out.println(str);
                    guessWordRegister.add(str);
                    String wrinkles = "";

                    for (int i = 0; i<guessWord.length();i++) {
                        wrinkles = wrinkles + "_";
                    }
                    if (q==0 && guessWordRegister.get(q).equalsIgnoreCase(wrinkles)) {
                        fails++;
                    }
                    else if(q > 0 && guessWordRegister.get(q).equalsIgnoreCase(guessWordRegister.get(q-1))) {
                        fails++;
                    }
                    System.out.println(fails);
                    if (fails>0) {
                        System.out.println(String.join("",Arrays.copyOfRange(tyburnTree,0,fails*2)));}
                }
                if (fails == maxFails) {
                    System.out.println("YOU LOST!");
                    break;}
            }
        }
    }

