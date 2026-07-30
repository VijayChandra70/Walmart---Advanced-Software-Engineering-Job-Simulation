import java.util.Arrays;
import java.util.NoSuchElementException;

// Max heap where every parent node has 2^childExponent children.
// childExponent = 1 gives a normal binary heap.
public class Task1PowerOfTwoMaxHeap<T extends Comparable<T>> {

    private Object[] data;
    private int size;

    private int childExponent; // this is "x" from the problem statement
    private int numChildren;   // 2^childExponent, calculated once so we don't redo it every time

    public Task1PowerOfTwoMaxHeap(int childExponent) {
        if (childExponent < 0 || childExponent > 30) {
            // 1 << 31 overflows a Java int and becomes negative, so 30 is the safe max
            throw new IllegalArgumentException("childExponent must be between 0 and 30");
        }

        this.childExponent = childExponent;
        this.numChildren = 1 << childExponent;
        this.data = new Object[16];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(T value) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size] = value;
        heapifyUp(size);
        size++;
    }

    @SuppressWarnings("unchecked")
    public T popMax() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }

        T max = (T) data[0];

        size--;
        data[0] = data[size];
        data[size] = null;

        if (size > 0) {
            heapifyDown(0);
        }

        return max;
    }

    @SuppressWarnings("unchecked")
    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) >> childExponent; // same as (i-1) / numChildren, just faster
            if (((T) data[i]).compareTo((T) data[parent]) <= 0) {
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    @SuppressWarnings("unchecked")
    private void heapifyDown(int i) {
        while (true) {
            // using long here because for big childExponent values, i << childExponent
            // can overflow a normal int and give a wrong (negative) index
            long firstChild = ((long) i << childExponent) + 1;
            if (firstChild >= size) {
                break; // no children, we're at a leaf
            }

            int lastChild = (int) Math.min(firstChild + numChildren, size);
            int biggest = (int) firstChild;

            for (int c = (int) firstChild + 1; c < lastChild; c++) {
                if (((T) data[c]).compareTo((T) data[biggest]) > 0) {
                    biggest = c;
                }
            }

            if (((T) data[i]).compareTo((T) data[biggest]) >= 0) {
                break;
            }

            swap(i, biggest);
            i = biggest;
        }
    }

    private void swap(int i, int j) {
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
