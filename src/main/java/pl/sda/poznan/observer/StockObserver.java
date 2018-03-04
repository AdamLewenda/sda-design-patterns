package pl.sda.poznan.observer;

public class StockObserver implements Observer<Stock> {

    private Stock stockToObserve;

    public StockObserver(Stock stockToObserve) {
        this.stockToObserve = stockToObserve;
        this.stockToObserve.subscribe(this);
    }

    @Override
    public void handle(PropertyChangeEventArgs<Stock> args) {
        //tutaj logika przetwarzania zdarzenia
        // np wyslanie maila powiadamiajacego
        System.out.println("wartosc sie zmienila: " + args.getOldValue());
        System.out.println("stara wartosc: " + args.getOldValue());
        System.out.println("nowa wartosc: " + args.getNewValue());
    }
}
