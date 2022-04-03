package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String ENC = "enc";
        final String DEC = "dec";

        final String ALG = "-alg";
        final String MODE = "-mode";
        final String KEY = "-key";
        final String DATA = "-data";
        final String IN_FILE = "-in";
        final String OUT_FILE = "-out";

        var direction = ENC;
        var message = "";
        var key = 0;
        var in_file = "";
        var out_file = "";
        var algorithm = Crypto.SHIFT;

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-")) {
                if (MODE.equals(args[i]))
                    direction = args[++i];
                else if (KEY.equals(args[i]))
                    key = Integer.parseInt(args[++i]);
                else if (DATA.equals(args[i]))
                    message = args[++i];
                else if (IN_FILE.equals(args[i]))
                    in_file = args[++i];
                else if (OUT_FILE.equals(args[i]))
                    out_file = args[++i];
                else if (ALG.equals(args[i]))
                    algorithm = args[++i];
                else {
                    System.out.println("Error!");
                    return;
                }
            }
        }

        if (!"".equals(in_file) && "".equals(message)) {
            File file = new File(in_file);
            StringBuilder sb = new StringBuilder();
            try ( Scanner scanner = new Scanner(file) ) {
                while (scanner.hasNext())
                    sb.append(scanner.nextLine());
                message = sb.toString();
            } catch (Exception e) {
                System.out.println("Error!");
                return;
            }
        }

        Crypto crypto;
        if (ENC.equals(direction))
            crypto = new Encrypt(algorithm, message, key);
        else if (DEC.equals(direction))
            crypto = new Decrypt(algorithm, message, key);
        else {
            System.out.println("Error!");
            return;
        }
        String outString = crypto.getString();
        if ("".equals(out_file))
            System.out.println(outString);
        else {
            try (FileWriter writer = new FileWriter(out_file)) {
                writer.write(outString);
            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }
}
