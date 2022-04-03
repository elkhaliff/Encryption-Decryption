package encryptdecrypt;

public class Decrypt extends Crypto {

    public Decrypt(String input, int key) {
        super(input, key);
    }

    @Override
    protected char makeString(char one) {
        return (char)((int)one - position);
    }
}
