package encryptdecrypt;

public class Encrypt extends Crypto {

    public Encrypt(String input, int key) {
        super(input, key);
    }

    @Override
    protected char makeString(char one) {
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
}
