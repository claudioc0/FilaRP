public class StaticQueue<T> {
    private int top;
    private int base;
    private T[] data;
    private final int size;
    private int count;  // Aponta o número de elementos
    public StaticQueue(int size) {
        this.size = size;
        top = -1;
        base = 0;
        data = (T[]) new Object[size];
        count = 0;
    }

    public StaticQueue() {
        this(5);
    }

    public void add(T addValue) {
        if (isFull()) {
            throw new FullQueueException("A fila está cheia");
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

    // Move os elementos para a posicao da frente
    public void move(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O número de posicoes não pode ser negativo");
        }
        if (isEmpty()) {
            return;
        }

        T[] temp = (T[]) new Object[size];
        for (int i = 0; i < count; i++) {
            temp[(i + n) % size] = data[(base + i) % size];
        }
        data = temp;
        base = (base + n) % size;
        if (base < 0) base += size;
        top = (base + count - 1) % size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Fila Estárica: []";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Fila Estática: [");

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
