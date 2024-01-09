package Proiect;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    public Cards cardInserat;
    Scanner sc = new Scanner(System.in);

    /*
     * Metoda load are functionalitatea de a introduce un card in ATM
     */
    public void load(ArrayList<Cards> carduri) {
        if (cardInserat != null) {
            System.out.println("Un card este deja inserat");
            System.out.println();
            return;
        }
        System.out.println("Introduceti cardul:");
        int card = sc.nextInt();
        cardInserat = carduri.get(card);
        System.out.println("Introduceti pinul cardului:");
        int pin = sc.nextInt();
        if (pin == cardInserat.getCodDeblocare()) {
            System.out.println("Cont autorizat");
        } else {
            System.out.println("Pinul este incorect!");
        }
        System.out.println("Bine ati venit " + carduri.get(card).getNumeDetinator() + " !");
        System.out.println(" ");

    }

    /*
     * Metoda eject are funcitonalitatea de a scoate cardul din ATM
     */
    public void eject() {
        if (cardInserat == null) {
            System.out.println("Nu exista un card inserat.");
            return;
        }

        System.out.println("La revedere, " + cardInserat.getNumeDetinator() + "!");
        cardInserat = null;
    }

    /*
     * Aceasta metoda modifica datele actuale ale cardului
     */
    public void updateInfo(int pin) {
        System.out.println("Introduceti pinul curent:");
        pin = sc.nextInt();
        if (pin == cardInserat.getCodDeblocare()) {
            System.out.println("Introduceti noul nume:");
            String numeNou = sc.next();
            cardInserat.setNumeDetinator(numeNou);

            System.out.println("Introduceti noul cod de deblocare:");
            int codDeblocareNou = sc.nextInt();
            cardInserat.setCodDeblocare(codDeblocareNou);

            System.out.println("Informatii actualizate cu succes.");
            System.out.println();
            return;
        } else {
            System.out.println();
            System.out.println("Pinul este incorect!");
            System.out.println();
            return;
        }

    }

    public void verificareBalanta() {
        System.out.println(cardInserat.getBalanta());
    }

    /* prin aceasta ,metoda vdepozitam bani pe card */
    public void deposit(double suma) {
        if (cardInserat == null) {
            System.out.println("Nu exista un card inserat.");
            return;
        }
        System.out.println("Inserati suma pe care doriti sa o depozitati:");
        suma = sc.nextInt();
        cardInserat.deposit(suma);
        System.out.println("Ati depus " + suma + " lei. Balanta curenta este de " + cardInserat.getBalanta() + " lei.");
        return;
    }

    /* prin aceasta metoda scoatem bani de pe card */
    public void withdraw(double suma) {
        if (cardInserat == null) {
            System.out.println("Nu exista un card inserat.");
            return;
        }
        System.out.println("Inserati suma pe care doriti sa o retrageti:");
        suma = sc.nextInt();
        if (suma < cardInserat.getBalanta()) {
            cardInserat.withdraw(suma);
            System.out.println(
                    "Ati retras " + suma + " lei. Balanta curenta este de " + cardInserat.getBalanta() + " lei.");
            System.out.println();
            return;
        } else {
            System.out.println("Fonduri insuficiente");
            return;
        }

    }

    /* Prin aceasta metoda transferam bani de pe un card pe altul */
    public void transfer(ArrayList<Cards> carduri, double suma) {
        if (cardInserat == null) {
            System.out.println("Nu exista un card inserat.");
            return;
        }
        sc.nextLine();
        System.out.println("Te rog sa introduci IBAN-ul destinatarului");
        String iban = sc.nextLine();
        System.out.println("Introduceti suma pe care doriti sa o transferati");
        suma = sc.nextInt();
        for (int i = 0; i < carduri.size(); i++) {
            if (carduri.get(i).getIBAN().equalsIgnoreCase(iban)) {
                cardInserat.withdraw(suma);
                carduri.get(i).transfer(suma);
                System.out.println("Transfer efectuat cu success!");
                carduri.get(i).getBalanta();
            }
            i++;
        }
    }

    /* Prin aceasta metoda cream un card nou */
    public static void creareCard(ArrayList<Cards> carduri) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduceti numele dvs. sau 'stop' pentru a opri");
        String numeDetinator = sc.next();

        if (numeDetinator.equalsIgnoreCase("stop")) {
            sc.close();
            return;
        }

        System.out.println("Intorduceti PIN ul cardului:");
        int codDeblocare = sc.nextInt();

        System.out.println("Introduceti balanta cardului:");
        double balanta = sc.nextDouble();

        System.out.println("Introduceti IBAN-ul cardului in formatul : RO XXXX");
        String IBAN = sc.next();

        Cards card = new Cards(numeDetinator, codDeblocare, balanta, IBAN);
        carduri.add(card);
        System.out.println("Cardul a fost creat cu succes!");

    }

    /* prin aceasta metoda stergem un card existent */
    public static void stergeCard(ArrayList<Cards> carduri) {
        if (carduri == null) {
            System.out.println("Lista de carduri nu este initializata.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti numele detinatorului pentru a sterge un card:");
        String numeDetinator = sc.next();

        for (int i = 0; i < carduri.size(); i++) {
            if (carduri.get(i).getNumeDetinator().equalsIgnoreCase(numeDetinator)) {
                carduri.remove(i);
                System.out.println("Cardul pentru " + numeDetinator + " a fost sters cu succes!");

                return;
            }
        }

    }

}
