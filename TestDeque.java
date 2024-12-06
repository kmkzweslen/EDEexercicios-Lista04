package ifma.lista04;

public class TestDeque {
    public static void main(String[] args) {
        Deque<Aluno> deque = new Deque<>();

        Aluno aluno1 = new Aluno("Weslen", 8.5, 7.0);
        Aluno aluno2 = new Aluno("Cleide", 9.0, 9.0);

        deque.addLast(aluno1);
        deque.addLast(aluno2);

        System.out.println("Deque: " + deque);

        System.out.println("Primeiro aluno: " + deque.getFirst());
        System.out.println("Último aluno: " + deque.getLast());

        System.out.println("Removendo o primeiro: " + deque.removeFirst());
        System.out.println("Deque: " + deque);

        deque.addLast(aluno1);
        System.out.println("Busca por 'Cleide': " + deque.search("Cleide").getData());
    }
}
