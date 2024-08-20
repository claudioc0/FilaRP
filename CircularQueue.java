public class CircularQueue<T> {
    private int top;
    private int base;
    private T[] data;
    private final int size;
    private int count;  // Aponta o número de elementos

    public CircularQueue(int size) {
        this.size = size;
        top = -1;
        base = 0;
        data = (T[]) new Object[size];
        count = 0;
    }

    public CircularQueue() {
        this(5);
    }

    public void add(T addValue) {
        if (isFull()) {
            throw new FullQueueException("The queue is full");
        }
        top = (top + 1) % size;
        data[top] = addValue;
        count++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new EmptyQueueException("A fila está vazia");
        }
        T removedValue = data[base];
        data[base] = null;
        base = (base + 1) % size;
        count--;
        if (isEmpty()) {
            top = -1;
        }
        return removedValue;
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    public void clear() {
        top = -1;
        base = 0;
        count = 0;
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "FIla Circular: []";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Fila Circular: [");

        int current = base;
        for (int i = 0; i < count; i++) {
            sb.append(data[current]);
            if (i < count - 1) {
                sb.append(", ");
            }
            current = (current + 1) % size;
        }

        sb.append("]");
        return sb.toString();
    }

}
