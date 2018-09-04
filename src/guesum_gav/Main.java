package guesum_gav;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int myNum = rand.nextInt(100) + 1;
        ///System.out.println(myNum);   /// "///" ubratj i uvidish cislo zadumannoe komukterom!

         ///flazok podnjat

        String answer;
        Boolean userlost = true;

        do {

            for (int i = 0; i < 10; i++) {
                System.out.println("try * " + i);
                int userNum = scan.nextInt();

                if (myNum > userNum) {
                    System.out.println(" cislo bolse tvoego!");
                } else if (myNum < userNum) {
                    System.out.println("tvojo cislo bolsje mojego");
                } else {
                    System.out.println("uraaa! ti viigral!!!!");

                    userlost = false ;
                    break;
                }
            }
            if ( userlost == true) { /// flazok opuschen
                System.out.println("oopsii! this'is "+myNum);
            }
            System.out.println("----------------------------");
            System.out.println(" Hoceh povtor, nazmi ...Y... , (YES)");

            System.out.println("ili esli ne hoces to ...N... , (NO) ");

        answer = scan.next();

        } while (answer.equals("y"));
    }
}


