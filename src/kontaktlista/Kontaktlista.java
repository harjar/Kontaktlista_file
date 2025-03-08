/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kontaktlista;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jarhar
 */
public class Kontaktlista {

    private static KonManager konmgr = new KonManager();
    private static FileManager filemgr = new FileManager();
    private static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean run = true;
        int val;
        while (run) {
            skrivUt("Meny\n");
            skrivUt("1. Lägg till en ny kontakt:\n"
                    + "2. Förnamn först.\n"
                    + "3. Efternamn först.\n"
                    + "4. Spara till fil.\n"
                    + "5. Läs från fil.\n"
                    + "0. Avsluta.\n"
                    + "Val: ");
            val = input.nextInt();
            input.nextLine();
            switch (val) {
                case 1:
                    nyKontakt();
                    break;
                case 2:
                    förnamnFörst();
                    break;
                case 3:
                    efternamnFörst();
                    break;
                case 4:
                    saveToFile();
                    break;
                case 5:
                    loadFRomFile();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    skrivUt("Ange ett alternativ i menyn\n");
            }
        }
    }

    private static void skrivUt(String text) {
        System.out.print(text);
    }

    private static void nyKontakt() {
        skrivUt("Ange förnamn: ");
        String fNamn = input.nextLine();
        skrivUt("Ange efternamn: ");
        String eNamn = input.nextLine();
        skrivUt("Ange telefonnummer: ");
        String tele = input.nextLine();
        Kontakt kon = new Kontakt(fNamn, eNamn, tele);
        konmgr.addKontakt(kon);
    }

    private static void förnamnFörst() {
        ArrayList<Kontakt> lista = konmgr.getLista();
        for (int i = 0; i < lista.size(); i++) {
            Kontakt kon = lista.get(i);
            skrivUt(kon.getFörnamn() + "\t"
                    + kon.getEfternamn() + "\t"
                    + kon.getTelefon() + "\n");
        }
    }

    private static void efternamnFörst() {
        ArrayList<Kontakt> lista = konmgr.getLista();
        for (int i = 0; i < lista.size(); i++) {
            Kontakt kon = lista.get(i);
            skrivUt(kon.getEfternamn() + "\t"
                    + kon.getFörnamn() + "\t"
                    + kon.getTelefon() + "\n");
        }
    }

    private static void saveToFile() {
        filemgr.saveToFile(konmgr.getLista());
    }

    private static void loadFRomFile() {
        ArrayList<Kontakt> kon = filemgr.readFromFile();
        konmgr.createNewList(kon);
    }

}
