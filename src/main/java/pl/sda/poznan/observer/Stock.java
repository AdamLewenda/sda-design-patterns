package pl.sda.poznan.observer;

// klasa stock jest obserwowalna (dajaca sie obserwowac_=)
public class Stock extends Observable<Stock> {
    private String name;
    //pole na zmiane ktorego chcemy reagowac - patrz setter
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        //zmienna pomocnicza do przecowania aktualnej (starej ceny, sprzed wywolania settera)
        double oldPrice = this.price;
        //jezeli nowa cena (argument settera) rowna sie starej cenie to nie powiadamiany
        if (price == oldPrice) {
            return;
        }
        // teraz this.price przechowuje nowa wartosc podana jako argument settera
        // jezeli ceny sie zmienly to ustawiamy nowa wartosc
        this.price = price;
        // i powiadamiamy obserwatorow
        propertyChanged(new PropertyChangeEventArgs<>(this, "price", this.price, oldPrice));
    }

    //wykonuj tylko, jezeli ceny sa rozne
    public void setPriceWithValidation(double price) {

        double oldPrice = price;
        this.price = price;
        if (oldPrice != this.price) {
            propertyChanged(new PropertyChangeEventArgs<>(this, "price", this.price, oldPrice));
        }

    }

    public void set(double price) {
        if (this.price == price) {
            return;
        }
        double oldPrice = price;
        this.price = price;
        propertyChanged(new PropertyChangeEventArgs<>(this, "price", this.price, oldPrice));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
