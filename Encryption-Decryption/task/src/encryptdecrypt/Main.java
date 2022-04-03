package encryptdecrypt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var direction = scanner.nextLine();
        var input_message = scanner.nextLine();
        var inp_key = scanner.nextInt();

        Crypto crypto;
        if ("enc".equals(direction))
            crypto = new Encrypt(input_message, inp_key);
        else if ("dec".equals(direction))
            crypto = new Decrypt(input_message, inp_key);
        else {
            System.out.println("error!");
            return;
        }
        System.out.println(crypto.write());
    }
}
