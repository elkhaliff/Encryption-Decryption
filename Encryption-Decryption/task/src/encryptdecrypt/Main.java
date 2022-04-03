package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        var input_message = "we found a treasure!";
        Crypto enc = new Encrypt(input_message);
        System.out.println(enc.write());
    }
}