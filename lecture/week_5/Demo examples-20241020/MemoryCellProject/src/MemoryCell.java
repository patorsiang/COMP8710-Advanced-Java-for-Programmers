import java.util.Optional;

public class MemoryCell {
    private Optional<String> value;

    public MemoryCell() {
        value = Optional.empty();
    }

    public Optional<String> getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = Optional.ofNullable(value);
//        this.value = Optional.of(value);
    }

    public static void main(String[] args) {
        var c = new MemoryCell();
        c.setValue("testing");
        c.setValue(null);
//        c.getValue().ifPresent(System.out::println);
        System.out.println("Value: " + c.getValue().orElse("n/a"));
    }

}