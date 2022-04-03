package encryptdecrypt;

public class Decrypt extends Crypto {

    public Decrypt(String algorithm, String input, int key) {
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
        current -= position;
        current = current >= 0 ? current : current + alpha.length;
        return alpha[current];
    }

    @Override
    protected char makeStringUnicode(char one) {
        return (char)((int)one - position);
    }
}
