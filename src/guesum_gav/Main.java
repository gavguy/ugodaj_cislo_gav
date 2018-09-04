package guesum_gav;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int myNum = rand.nextInt(100) + 1;
        System.out.println(myNum);   /// "///" ubratj i uvidish cislo zadumannoe komukterom!

         ///flazok podnjat

        int answer;
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

            answer = askNum();

        } while (answer.equals("y"));
        System.out.println("good BY!");
    }



    static String askYN()   {  ///string- metod vozvroshaet
        String answer;
        do {
            answer = scan.next();
            if (!answer.equals("y") && !answer.equals("n")) {
                System.out.println("Y/N - Maybee...");
                System.out.println("ⱠɆ₮'$ ƉØ Ɨ¥     c[_]");
          //      continue;
            } else {


                return answer;
            }
        } while (true);

    }

///////////////////////////////////////////////////

    static int askNum()   {  ///string- metod vozvroshaet
        int answer;
        do {
            answer = scan.nextInt();
            if (answer <1 || answer >100) {
                System.out.println(" ɠเѵε ɱε α ɳµɱɓε૨ ƒ૨σɱ 0 ƭσ 100 ");
                System.out.println("ⱠɆ₮'$ ƉØ Ɨ¥     c[_]");
                //      continue;
            } else {


                return answer;
            }
        } while (true);

    }
}


