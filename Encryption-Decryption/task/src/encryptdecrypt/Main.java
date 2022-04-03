package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        final String ENC = "enc";
        final String DEC = "dec";

        final String MODE = "-mode";
        final String KEY = "-key";
        final String DATA = "-data";

        var direction = ENC;
        var message = "";
        var key = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-")) {
                if (MODE.equals(args[i]))
                    direction = args[++i];
                else if (KEY.equals(args[i]))
                    key = Integer.parseInt(args[++i]);
                else if (DATA.equals(args[i]))
                    message = args[++i];
            }
        }
        Crypto crypto;
        if (ENC.equals(direction))
            crypto = new Encrypt(message, key);
        else if (DEC.equals(direction))
            crypto = new Decrypt(message, key);
        else {
            System.out.println("error!");
            return;
        }
        System.out.println(crypto.write());
    }
}
