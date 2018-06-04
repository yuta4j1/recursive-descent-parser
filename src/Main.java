
class Source {
    public String str;
    public int pos;
    public Source(String str) {
        this.str = str;
    }
}

public class Main {

    public static String number(Source s) {
        for(int i = 0; i < s.str.length(); i++) {
            s.pos = i;
            if(!Character.isDigit(s.str.charAt(i))) {
                return s.str.substring(0, i);
            }
        }
        return s.str;
    }
    public static void main(String[] args) {
        Source s = new Source("12+23+45");
        System.out.println(number(s));

    }

}
