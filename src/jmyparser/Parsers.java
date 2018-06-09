package jmyparser;

import java.util.function.Function;

public class Parsers {

    public static <T> void parseTest(Parser<T> p, String src) {
        SourceTest s = new SourceTest(src);
        try {
            System.out.println(p.parse(s));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static final Parser<Character> anyChar = satisfy(s -> true);

    public static final Parser<Character> satisfy(Function<Character, Boolean> f) {
        return s -> {
            char ch = s.peek();
            if(!f.apply(ch)) {
                throw new Exception("not satisfy");
            }
            s.next();
            return ch;
        };
    }

}
