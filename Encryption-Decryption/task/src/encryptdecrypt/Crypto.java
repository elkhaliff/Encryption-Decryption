package encryptdecrypt;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Crypto {
    protected String data;
    final char[] alpha;

    public Crypto(String input) {
        read(input);
        alpha = IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();
    }

    void read(String input) {
        data = input;
    }

    abstract protected char makeString(char one);

    public String write() {
        char[] chars = data.toCharArray();
        char[] out = new char[chars.length];
        String alphaStr = String.valueOf(alpha);
        for (int i = 0; i < chars.length; i++) {
            out[i] = alphaStr.contains(String.valueOf(chars[i])) ? makeString(chars[i]) : chars[i];
        }
        return String.valueOf(out);
    };
}