package encryptdecrypt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var input_message = scanner.nextLine();
        var inp_key = scanner.nextInt();
        Crypto enc = new Encrypt(input_message, inp_key);
        System.out.println(enc.write());
    }
}
