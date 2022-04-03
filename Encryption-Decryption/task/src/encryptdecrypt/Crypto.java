package encryptdecrypt;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Crypto {
    protected String data;
    protected int position;

    public Crypto(String input, int key) {
        read(input);
        position = key;
    }

    void read(String input) {
        data = input;
    }

    abstract protected char makeString(char one);

    public String getString() {
        char[] chars = data.toCharArray();
        char[] out = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            out[i] = makeString(chars[i]);
        }
        return String.valueOf(out);
    }
}
