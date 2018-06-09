public class Test {

    static int pos;

    static char anyChar(SourceTest s) {
        char ret = (char) s.peek();
        s.next();
        return ret;
    }

    static String test1(SourceTest s) {
        char x1 = anyChar(s);
        char x2 = anyChar(s);
        return new String(new char[]{x1, x2});
    }

    static String test2(SourceTest s) {
        String x1 = test1(s);
        char x2 = anyChar(s);
        return x1 + x2;
    }

    public static void main(String[] args) {

        SourceTest s = new SourceTest("abc");

        System.out.println(anyChar(s));

    }

}
