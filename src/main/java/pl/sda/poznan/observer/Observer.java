package pl.sda.poznan.observer;

public interface Observer<T> {
    void handle(PropertyChangeEventArgs<T> args);
}
