package pl.sda.poznan.iterator;

public class MyCollection implements Iterable<String> {

    private int index = 0;
    private String[] elements = new String[10];

    public void addElement(String e) {
        if (index < elements.length) {
            elements[index++] = e;
        }
    }

    @Override
    public Iterator<String> getIterator() {
        return new MyCollectionIterator();
    }

    private class MyCollectionIterator implements Iterator<String> {

        private int iteratorIndex = 0;

        @Override
        public String getNextElement() {
            if (!hasNextElement()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return elements[iteratorIndex++];
        }

        @Override
        public boolean hasNextElement() {

            return iteratorIndex < elements.length;
        }
    }

}
