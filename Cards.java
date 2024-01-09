package Proiect;

/*Clasa Cards ne seteaza ce atribute are un card , toate fiind private   */
public  class Cards extends ATM{
   
        private String numeDetinator;
        private int codDeblocare;
        private double balanta;
        private String IBAN;
        

        public Cards(String numeDetinator, int codDeblocare, double balanta, String IBAN) {
          this.numeDetinator = numeDetinator;
            this.codDeblocare = codDeblocare;
            this.balanta = balanta;
            this.IBAN = IBAN;
        }
    
        public String getNumeDetinator() {
            return numeDetinator;
        }
    
        public void setNumeDetinator(String numeNou) {
            this.numeDetinator = numeDetinator;
        }
    
        public int getCodDeblocare() {
            return codDeblocare;
        }
    
        public void setCodDeblocare(int codDeblocare) {
            this.codDeblocare = codDeblocare;
        }
    
        public double getBalanta() {
            return balanta;
        }
    
        public void setBalanta(double balanta) {
            this.balanta = balanta;
        }
    
        public void deposit(double suma) {
            balanta += suma;
        }
        
        @Override public void withdraw(double suma) {
            if (suma > balanta) {
                System.out.println("Fonduri insuficiente");
            } else {
                balanta -= suma;
                System.out.println("");
            }
        }
    
        public void transfer( double suma) {
        	
        	double x = getBalanta() + suma;
        	setBalanta(x);
        }
    
        public String getIBAN() {
        	return this.IBAN;
        }
    }

