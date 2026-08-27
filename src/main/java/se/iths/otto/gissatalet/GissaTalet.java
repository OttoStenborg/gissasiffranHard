package se.iths.otto.gissatalet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GissaTalet {
    static void main() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int antalGissningar = 0;
        int randomTal = 0;
        int maxTal = 0;
        boolean loopMeny = true;
        while (loopMeny) {
            System.out.println("Välkommen till Ottos gissanummer spel, ange vilken svårighetsgrad (lätt, medium och svår):");
            String val = sc.nextLine();
            if (val.equalsIgnoreCase("lätt")) {
                randomTal = random.nextInt(10);
                maxTal = 10;
                loopMeny = false;
            } else if (val.equalsIgnoreCase("medium")) {
                randomTal = random.nextInt(50);
                maxTal = 50;
                loopMeny = false;
            } else if (val.equalsIgnoreCase("svår")) {
                randomTal = random.nextInt(100);
                maxTal = 100;
                loopMeny = false;
            } else {
                System.out.println("ogiltigt input");
                loopMeny = true;

            }
            System.out.println(randomTal);
            while (true) {
                System.out.println("Ange en siffra eller skriv 1000 för att avsluta");
                int gissning;
                try {
                    gissning = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Ange en siffra, inte minus eller bokstav");
                    sc.nextLine();
                    continue;
                }

                if (gissning == 1000) {
                    System.out.println("Programmet avslutas.");
                    System.exit(0);
                }

                int diff = Math.abs(gissning - randomTal);
                if (gissning > maxTal) {
                    System.out.printf("för högt tal! Svara inom intevall. Intervallet är mellan 0 och %d", maxTal);
                } else if (gissning == randomTal) {
                    System.out.printf("Grattis du gissade rätt! på %d antal gissningar", antalGissningar);
                    break;
                } else if (gissning < randomTal) {
                    System.out.println(diff <= 7 ? "för lågt men nära, prova igen" : "för lågt, prova igen");
                    antalGissningar++;
                } else {
                    System.out.println(diff <= 7 ? "för högt men nära, prova igen" : "för högt prova igen");
                    antalGissningar++;
                }
            }
        }
    }
}
