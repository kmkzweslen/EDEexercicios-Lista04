package ifma.lista04;

public class Deque<T> {
    private Node<T> head;
    private Node<T> tail;

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public T getFirst() {
        if (head == null) {
            throw new IllegalStateException("Deque está vazio!");
        }
        return head.getData();
    }

    public T getLast() {
        if (tail == null) {
            throw new IllegalStateException("Deque está vazio!");
        }
        return tail.getData();
    }

    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("Deque está vazio!");
        }
        T data = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public T removeLast() {
        if (tail == null) {
            throw new IllegalStateException("Deque está vazio!");
        }
        if (head == tail) { // Apenas um elemento
            T data = tail.getData();
            head = tail = null;
            return data;
        }
        Node<T> current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        T data = tail.getData();
        tail = current;
        tail.setNext(null);
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public Node<T> search(String nome) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData() instanceof Aluno) {
                Aluno aluno = (Aluno) current.getData();
                if (aluno.toString().contains(nome)) {
                    return current;
                }
            }
            current = current.getNext();
        }
        throw new IllegalArgumentException("Aluno não encontrado!");
    }
}
