public class MyQueue<T> {

    private SimpleList<T> list;

    public MyQueue(){
        list = new SimpleList<T>();
    }

    public boolean offer(T element) {
        list.add(element);
        return true;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T head = list.get(0);
        list.remove(0);
        return head;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}