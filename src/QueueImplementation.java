import java.util.Iterator;

public class QueueImplementation<T> implements Iterable<T> {

    protected class QueueItem {
        public T value;
        public QueueItem next;

        public QueueItem(T value, QueueItem next) {
            this.value = value;
            this.next = next;
        }
    }

    protected QueueItem head = null;
    protected QueueItem tail = null;
    protected int size = 0;

    public void add(T value) {
        QueueItem temp = new QueueItem(value, null);
        if (tail == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int index) throws Exception {
        if (index < 0 || index > size - 1) {
            throw new Exception("Incorrect index");
        }
        QueueItem curr = head;
        while (index != 0) {
            index--;
            curr = curr.next;
        }
        return curr.value;
    }

    @Override
    public Iterator<T> iterator() {
        class QueueIterator implements Iterator<T> {
            QueueItem curr;

            public QueueIterator(QueueItem head) {
                curr = head;
            }

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T result = curr.value;
                curr = curr.next;
                return result;
            }
        }
        return new QueueIterator(head);
    }
}