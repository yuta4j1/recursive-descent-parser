package jmyparser;
import static jmyparser.Parsers.*;

public class Test {

    public static void main(String[] args) {

        parseTest(anyChar, "test");
        parseTest(satisfy(Character::isDigit), "abc");
        parseTest(satisfy(Character::isDigit), "123");

    }

}

