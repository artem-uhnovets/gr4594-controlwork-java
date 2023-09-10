package model.toyshop.iterator;

import java.util.Iterator;
import java.util.List;

public class ToyIterator<T> implements Iterator<T> {
    private int index;
    private List<T> toysList;

    public ToyIterator(List<T> allPersons) {
        this.toysList = allPersons;
    }

    @Override
    public boolean hasNext() {
        return index < toysList.size();
    }

    @Override
    public T next() {
        return toysList.get(index++);
    }
}
