import java.util.List;

class Generics {

    static void processStuff(List<Number> numbers) {
        // ...
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);
        processStuff(integers);
    }

}

