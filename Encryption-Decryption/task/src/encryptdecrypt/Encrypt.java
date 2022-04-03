package encryptdecrypt;

public class Encrypt extends Crypto {

    public Encrypt(String input) {
        super(input);
    }

    @Override
    protected char makeString(char one) {
        int position = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] == one) {
                position = i;
                break;
            }
        }
        return alpha[alpha.length - position - 1];
    }
}