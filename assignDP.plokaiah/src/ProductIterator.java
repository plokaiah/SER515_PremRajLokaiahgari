public class ProductIterator implements ListIterator {

    private final ClassProductList arr;
    int ind;

    public ProductIterator(ClassProductList list) {
        this.arr = list;
        ind = 0;
    }

    @Override
    public boolean hasNext() {
        return ind < arr.size();
    }

    @Override
    public Object next() {
        return arr.get(ind);
    }

    @Override
    public void moveToHead() {
        ind = 0;
    }

    @Override
    public void remove() {
    	arr.remove(ind);
    }
}
