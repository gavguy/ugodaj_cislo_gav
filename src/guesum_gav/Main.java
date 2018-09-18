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
        loadResult();

          /// "///" ubratj i uvidish cislo zadumannoe komukterom!

        ///flazok podnjat

        String answer;
        Boolean userlost = true;
        do {

            int myNum = rand.nextInt(100) + 1;
            System.out.println(myNum);
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
                    results.sort(Comparator.<Game_Result>comparingInt(r0 -> r0.triesCount)
                            .thenComparingLong(r0 -> r0.time));


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

    private static void loadResult() {


        File file = new File("top_skore.txt");
        try (Scanner in = new Scanner(file)) {


            while (in.hasNext()) {
                Game_Result result = new Game_Result();
                result.name = in.next();
                result.triesCount = in.nextInt();
                result.time = in.nextLong();
                results.add(result);
            }


        } catch (IOException e) {
            System.out.println("cannot load from file");

        }
    }


    private static void saveresult() {


        File file = new File("top_skore.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            for (Game_Result r : results) {
                out.printf("%s %d %d\n", r.name, r.triesCount, r.time);

            }
        } catch (IOException e) {
            System.out.println("cannot save to file");
        }


    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    //   private static void shovResult()  {//      int count = 0;
//
//        for (Game_Result r : results) {
//
//
//
//            System.out.printf("%s %d %2fsec\n", r.name, r.triesCount, r.time/1000.0);      //////// esli min. 5 to pojdet, esli mense 5 strocek to error
//            count+1;
//                if (count = 5) {
//                    break;
//                }
//        }
//
//
//    }
    /////////////////////////////////////////////////////////////////////
//    private static void shovResult() {
//        int count = Math.min(5, results.size()); /// isem minimalnoje znacenije , i ono fiksiruetsja
//        if (results.size() < 5) {
//            count = results.size();
//        }
//        for (int i = 0; i < count; i++) {
//            Game_Result r = results.get(i);
//            System.out.printf("%s %d %2fsec\n", r.name, r.triesCount, r.time / 1000.0);
//
//        }
//
//    }
/////////////////////////////////////////////////////////////////////////////////////////////////////-pojavilos nedavno( funkcionalnoje programm.sortirovka po hodu
// private static void shovResult() {
//    results.stream() ////iset i peredajot dalsje
//            .sorted(Comparator.<Game_Result>comparingInt(r -> r.triesCount)
//                                .thenComparingLong(r -> r.time))
//            .limit(5)
//            .forEach(r -> {  ///peredajot dejstvije
//                System.out.printf("%s %d %2fsec\n", r.name, r.triesCount, r.time / 1000.0);
//            }); ///- ljamda
//
///////////////////////////////////////////////////////////////////////////////////////////////////-pojavilos nedavno( funkcionalnoje programm.sortirovanij spisok
    private static void shovResult() {
        results.stream() ////iset i peredajot dalsje
//            .sorted(Comparator.<Game_Result>comparingInt(r -> r.triesCount) ///--- uze ne nando, posle vivoda sorterujetsja
//                                .thenComparingLong(r -> r.time))
                .limit(5)
                .forEach(r -> {  ///peredajot dejstvije
                    System.out.printf("%s %d %2fsec\n", r.name, r.triesCount, r.time / 1.0);
                }); ///- ljamda

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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


