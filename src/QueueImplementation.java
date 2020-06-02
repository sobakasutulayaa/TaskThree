import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Методы: enqueue, dequeue, peek, size, and is-empty
 * enqueue - аналог метода add
 * dequeue - аналог метода poll
 *
 * @param <Item> общий тип для item в queue
 */
public class QueueImplementation<Item> implements Iterable<Item> {
    private Node<Item> first;    // начало очереди
    private Node<Item> last;     // конец очереди
    private int n;               // количество элементов в очереди

    /**
     * Инициализация пустой очереди.
     */
    public QueueImplementation() {
        first = null;
        last = null;
        n = 0;
    }

    /**
     * Возращает true, если очередь не пустая.
     *
     * @return {@code true} если очередь не пустая; {@code false} в противном случае
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Возращает  кол-во элементов в очереди.
     *
     * @return the number of items
     */
    public int size() {
        return n;
    }

    /**
     * Возращает последний добавленный элемент в очередь.
     *
     * @return последний добавленный item из очереди
     * @throws NoSuchElementException, если очередь пуста
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Очередь пуста");
        return first.item;
    }

    /**
     * Добавляет элемент в очередь.
     *
     * @param item элемент для добавления
     */
    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    /**
     * Удаляет и возращает последний добавленный элемент.
     *
     * @return последний добавленный элемент очереди
     * @throws NoSuchElementException, если очередь пуста
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Очередь пуста");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }

    /**
     * Возвращает итератор, который перебирает элементы в этой очереди.
     *
     * @return итератор, который перебирает элементы в этой очереди
     */
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // класс связанного списка помощников
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}