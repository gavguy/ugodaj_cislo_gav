package guesum_gav;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<Game_Result> results = new ArrayList<>();

    public static void main(String[] args) {
        int myNum = rand.nextInt(100) + 1;
        System.out.println(myNum);   /// "///" ubratj i uvidish cislo zadumannoe komukterom!

        ///flazok podnjat

        String answer;
        Boolean userlost = true;

        do {
            System.out.println("ωɦαƭ เร ყσµ ɳαɱε?");
            String name = scan.next();

            long T1 = System.currentTimeMillis();


            for (int i = 1; i < 10; i++) {
                System.out.println("try * " + i);
                int userNum = askNum();

                if (myNum > userNum) {
                    System.out.println(" cislo bolse tvoego!");
                } else if (myNum < userNum) {
                    System.out.println("tvojo cislo bolsje mojego");
                } else {
                    System.out.println("Ⴎℛᗅᗅ. ℽᝪႮ Ꮙⅈℕℰ !!!");

                    long T2 = System.currentTimeMillis();

                    long t = (T2 - T1) / 100;


                    Game_Result r = new Game_Result();     ///on shas pustoj, mi sozdali game result
                    r.name = name;
                    r.triesCount = i;
                    r.time = t;
                    results.add(r); ///// sozdajom i sohronjamem v spiske


                    userlost = false;
                    break;
                }
            }
            if (userlost == true) { /// flazok opuschen
                System.out.println("oopsii! this'is " + myNum);
            }


            System.out.println("----------------------------");
            System.out.println(" Hoceh povtor, nazmi ...Y... , (YES)");
            System.out.println("ili esli ne hoces to ...N... , (NO) ");

            answer = askYN();

        } while (answer.equals("y"));

        shovResult(); ////alt+ enter =  sozdajom novij metod
        saveresult();
        System.out.println("good BY!");
    }

    private static void saveresult() {


        File file = new File("top_skore.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            out.println ("hello world");
        } catch(IOException e) {
            System.out.println("cannot save to file");
        }
    }


    private static void shovResult() {
        for (Game_Result r : results) {
            System.out.println(r.name + "->" + r.triesCount + "   " +
                    "time: " + r.time);
        }


    }


    static String askYN() {  ///string- metod vozvroshaet
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

    static int askNum() {  ///string- metod vozvroshaet
        int answer;
        do {
            try {
                answer = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("this isn't number");
                scan.next();
                continue;
            }

            if (answer < 1 || answer > 100) {
                System.out.println(" ɠเѵε ɱε α ɳµɱɓε૨ ƒ૨σɱ 0 ƭσ 100 ");
                System.out.println("ⱠɆ₮'$ ƉØ Ɨ¥     c[_]");
                //      continue;
            } else {


                return answer;
            }
        } while (true);

    }
}


