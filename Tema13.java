class Card {
    private String numeDetinator;
    private String codDeblocare;
    private double balanta;

    public Card(String numeDetinator, String codDeblocare, double balanta) {
        this.numeDetinator = numeDetinator;
        this.codDeblocare = codDeblocare;
        this.balanta = balanta;
    }

    public String getNumeDetinator() {
        return numeDetinator;
    }

    public boolean verificaCod(String cod) {
        return codDeblocare.equals(cod);
    }

    public double getBalanta() {
        return balanta;
    }

    public void adaugaBani(double suma) {
        balanta += suma;
    }

    public boolean retrageBani(double suma) {
        if (suma > balanta) {
            return false;
        }
        balanta -= suma;
        return true;
    }

    public boolean transferBani(Card destinatie, double suma) {
        if (retrageBani(suma)) {
            destinatie.adaugaBani(suma);
            return true;
        }
        return false;
    }
}

class ATM {
    private Card cardInserat;

    public void load(Card card) {
        if (cardInserat != null) {
            System.out.println("Un card este deja inserat.");
            return;
        }
        cardInserat = card;
        System.out.println("Bine ati venit, " + card.getNumeDetinator() + "!");
    }

    public void eject() {
        if (cardInserat == null) {
            System.out.println("Nu exista un card inserat.");
            return;
        }
        System.out.println("La revedere, " + cardInserat.getNumeDetinator() + "!");
        cardInserat = null;
    }

    public void deposit(double suma) {
        if (cardInserat == null) {
            System.out.println("Nu exista un card inserat.");
            return;
        }
        cardInserat.adaugaBani(suma);
        System.out.println("Ati depus " + suma + " lei. Balanta curenta este de " + cardInserat.getBalanta() + " lei.");
    }

    public void withdraw(double suma) {
        if (cardInserat == null) {
            System.out.println("Nu exista un card inserat.");
            return;
        }
        if (cardInserat.retrageBani(suma)) {
            System.out.println(
                    "Ati retras " + suma + " lei. Balanta curenta este de " + cardInserat.getBalanta() + " lei.");
        } else {
            System.out.println("Fonduri insuficiente. Balanta curenta este de " + cardInserat.getBalanta() + " lei.");
        }
    }

    public void transfer(Card destinatie, double suma) {
        if (cardInserat == null) {
            System.out.println("Nu exista un card inserat.");
            return;
        }
        if (cardInserat.transferBani(destinatie, suma)) {
            System.out.println("Ati transferat " + suma + " lei catre " + destinatie.getNumeDetinator()
                    + ". Balanta curenta este de " + cardInserat.getBalanta() + " lei.");
        } else {
            System.out.println("Transfer esuat. Fonduri insuficiente. Balanta curenta este de "
                    + cardInserat.getBalanta() + " lei.");
        }
    }
}
