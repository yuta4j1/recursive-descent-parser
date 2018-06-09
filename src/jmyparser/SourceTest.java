package jmyparser;

public class SourceTest {

    private final String str;
    private int pos;

    public SourceTest(String str) {
        this.str = str;
    }

    public final char peek() throws Exception {

        if(pos >= str.length()) {
            throw new Exception("too short");
        }
        return str.charAt(pos);
    }

    public final void next() {
        pos++;
    }

}
