package pl.sda.poznan.chor;

import java.awt.dnd.InvalidDnDOperationException;

// bazowa klasa dla Handlerow, czyli obiektow umiejacych przetwarzac zadania
// klasy rozszerzajace te klase sa elementami lancucha zobowiazan (chain of responsibility)
public abstract class PaymentHandler {

    protected PaymentHandler nextHandler;

    public void setNextHandler(PaymentHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //sprawdzic, czy mozemy przetworzyc zadanie, jesli nie to przekazac wyzej
    //wzdluz lancucha zobowiazan
    public void processPayment(BankAccount bankAccount, double amount) {
        //jezeli dany hanlder umie obsluzyc zadanie (canHandle zwraca true)
        //to wykonuje metode obslugi zadania
        //w przeciwnym wypadku sprawdza, czy jest kolejny handler,
        //jesli tak to przekazuje zadanie wyzej, wtedy kolejny handler zwonu sprawdzi czy umie to zrobiv itd.
        if (canHandlePayment(amount)) {
            handle(bankAccount, amount);
        } else if (nextHandler != null) {
            nextHandler.processPayment(bankAccount, amount);
        } else {
            throw new InvalidDnDOperationException(
                    "Nie jestem w stanie obsluzyc zadania. Kwota zbyt duza");
        }
    }

    private boolean canHandlePayment(double amount) {
        return amount < getMaxPrice();
    }

    //abstrakcyjna metoda (nie moze miec ciala)
    //dlatego, ze na tym etapie jeszcze nie wiemy jak przetwarzac platnosc
    protected abstract void handle(BankAccount account, double amount);

    //Metoda zwraca maksymalna kwote jaka moze obsluzyc dana metoda (np. 50 zl dla zblizeniowej i 500 dla pin);
    protected abstract double getMaxPrice();
}
