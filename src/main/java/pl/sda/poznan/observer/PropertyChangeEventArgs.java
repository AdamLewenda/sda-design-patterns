package pl.sda.poznan.observer;

public class PropertyChangeEventArgs<T> {
    private T source;
    private String propertyName;
    private Object newValue;
    private Object oldValue;

    public PropertyChangeEventArgs(T source, String propertyName, Object newValue, Object oldValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public T getSource() {
        return source;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Object getNewValue() {
        return newValue;
    }
}
