package encryptdecrypt;

public class Encrypt extends Crypto {

    public Encrypt(String algorithm, String input, int key) {
        super(algorithm, input, key);
    }

    @Override
    protected char makeStringShift(char one, char[] alpha) {
        int current = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] == one) {
                current = i;
                break;
            }
        }
        current += position;
        current = current < alpha.length ? current : current - alpha.length;
        return alpha[current];
    }

    @Override
    protected char makeStringUnicode(char one) {
        return (char)((int)one + position);
    }
}
