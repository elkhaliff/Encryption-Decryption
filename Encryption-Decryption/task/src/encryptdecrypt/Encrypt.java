package encryptdecrypt;

public class Encrypt extends Crypto {

    public Encrypt(String input, int key) {
        super(input, key);
    }

    @Override
    protected char makeString(char one) {
        return (char)((int)one + position);
    }
}
