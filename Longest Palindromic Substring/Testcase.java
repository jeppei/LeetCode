import java.util.List;

public class Testcase {
    public String input;
    public List<String> expected;

    public Testcase(String input, List<String> expectedResult) {
        this.input = input;
        this.expected = expectedResult;
    }
}