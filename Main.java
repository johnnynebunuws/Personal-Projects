package Proiect;

import java.util.ArrayList;
import java.util.Scanner;
/*Clasa Main este cea care ne excuta tot codul scris in celelalte clase  */
public class Main {
    public static void main(String[] args) {
        ArrayList<Cards> carduri = new ArrayList<>();
        Scanner sn = new Scanner(System.in);
        ATM atm = new ATM();
        do {
            System.out.println("Ce operatie doriti sa efectuati:");
            System.out.println();
            System.out.println("1. Creare card");
            System.out.println("2. Stergere card");
            System.out.println("3. Introducere card");
            System.out.println("4. Iesire");

            int alegere = sn.nextInt();

            switch (alegere) {
                case 1:
                    ATM.creareCard(carduri);
                    break;
                case 2:
                    ATM.stergeCard(carduri);
                    break;
                case 3:
                    atm.load(carduri);
                    System.out.println("Ce operatie doriti sa efectuati:");
                    System.out.println();
                    System.out.println("1. Scoatere card");
                    System.out.println("2. Verificare balanta");
                    System.out.println("3. Modificare numele sau pinul cardului");
                    System.out.println("4. Depozitare bani");
                    System.out.println("5. Retragere bani");
                    System.out.println("6. Transfer bani");
                    int choice = sn.nextInt();
                    switch (choice) {
                        case 1:
                            atm.eject();
                            break;
                        case 2:
                            atm.verificareBalanta();;
                            break;
                        case 3:
                            atm.updateInfo(choice);
                            break;
                        case 4:
                            atm.deposit(choice);
                            break;
                        case 5:
                            atm.withdraw(choice);
                            break;
                        case 6:
                            atm.transfer(carduri, choice);

                    }
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }

}
