package rikkei;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // tăng thêm phần tửz
    MyList(int capacity) {
        if (capacity < 0) {
            throw new IndexOutOfBoundsException("Invalid capacity: " + capacity);
        }
        elements = new Object[capacity];
    }

    void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        if (size == elements.length) {
            ensuareCapacity(size + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    private void ensuareCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }


    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        E removed = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removed;
    }

    public int size() {
        return size;
    }

    public MyList<E> clone() {
        try {
            MyList<E> cloned = (MyList<E>) super.clone();
            cloned.elements = Arrays.copyOf(elements, size);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return (E) elements[index];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
