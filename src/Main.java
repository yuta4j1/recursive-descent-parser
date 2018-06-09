
/**
 * 対象文字列と文字位置を保持するクラス
 *
 */
class SourceTest {
    private final String str;
    private int pos;

    public SourceTest(String str) {
        this.str = str;
    }

    /**
     * 現在の文字位置を返すメソッド
     * @return
     */
    public final int peek() {
        if(pos < str.length()) {
            return str.charAt(pos);
        }
        return -1;
    }

    /**
     * 文字位置を進める
     */
    public final void next() {
        pos++;
    }
}

class Parser extends SourceTest {

    public Parser(String str) {
        super(str);
    }

    public final int number() {
        StringBuilder sb = new StringBuilder();
        int ch;
        while((ch = peek()) >= 0 && Character.isDigit(ch)) {
            sb.append((char) ch);
            next();
        }

        return Integer.parseInt(sb.toString());

    }

    public final int expr() {
        int x = term();
        while(true) {
            switch(peek()) {
            case '+':
                next();
                x += term();
                continue;
            case '-':
                next();
                x -= term();
                continue;
            }
            break;
        }
        return x;
    }

    public final int term() {
        int x = factor();
        while(true) {
            switch(peek()) {
            case '*':
                next();
                x *= factor();
                continue;
            case '/':
                next();
                x /= factor();
                continue;
            }
            break;
        }
        return x;
    }
    public int factor() {
        if(peek() == '(') {
            next();
            int ret = expr();
            if(peek() == ')') {
                next();
            }
            return ret;
        }
        return number();
    }
}

public class Main {

    static void test(String s) {
        System.out.println(s + " = " + new Parser(s).expr());
    }

    public static void main(String[] args) {
       test("12+23+34");
       test("56+23-34");
       test("(46+46)/23*34");
       test("46-(23+4-15)*2");

    }

}
