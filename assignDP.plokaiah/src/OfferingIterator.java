// Iteration pattern being used
public class OfferingIterator implements ListIterator{

    private final OfferingList array_1;
    int ind;

    public OfferingIterator(OfferingList list) {
        this.array_1 = list;
        ind = 0;
    }

    @Override
    public boolean hasNext() {
        return ind < array_1.size();
    }

    @Override
    public Object next() {
        return array_1.get(ind);
    }

    @Override
    public void moveToHead() {
        ind = 0;
    }

    @Override
    public void remove() {
    	array_1.remove(ind);
    }
}
