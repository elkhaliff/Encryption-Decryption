package encryptdecrypt;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Crypto {
    public static final String SHIFT = "shift";
    public static final String UNICODE = "unicode";

    final char[] alphaLow;
    final char[] alphaUp;

    protected String algorithm;
    protected String data;
    protected int position;


    public Crypto(String algorithm, String input, int key) {
        this.algorithm = algorithm;
        data = input;
        position = key;
        alphaLow = IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();
        alphaUp = IntStream.rangeClosed('A', 'Z')
                .mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();
    }

    abstract protected char makeStringShift(char one, char[] alpha);
    abstract protected char makeStringUnicode(char one);

    public String getString() {
        char[] chars = data.toCharArray();
        char[] out = new char[chars.length];
        String alphaLowStr = String.valueOf(alphaLow);
        String alphaUpStr = String.valueOf(alphaUp);

        for (int i = 0; i < chars.length; i++) {
            if (SHIFT.equals(algorithm))
                if (alphaLowStr.contains(String.valueOf(chars[i])))
                    out[i] = makeStringShift(chars[i], alphaLow);
                else if (alphaUpStr.contains(String.valueOf(chars[i])))
                    out[i] = makeStringShift(chars[i], alphaUp);
                else
                    out[i] = chars[i];
            else if (UNICODE.equals(algorithm))
                out[i] = makeStringUnicode(chars[i]);
        }
        return String.valueOf(out);
    }
}
