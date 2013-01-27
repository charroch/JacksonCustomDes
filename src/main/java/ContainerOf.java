import org.codehaus.jackson.annotate.JsonUnwrapped;

public class ContainerOf<T> {
    public int pages;
    public String name;

    @JsonUnwrapped
    public T what;
}
