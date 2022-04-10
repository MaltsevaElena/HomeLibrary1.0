package ru.maltseva.home_library.aController.implEnterToConsoleCommand;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption {

    public static StringBuffer encryprion(String password) {
        StringBuffer result;
        byte[] bytes;

        MessageDigest sha1;

        bytes = new byte[0];

        try {
            sha1 = MessageDigest.getInstance("SHA-1");
            bytes = sha1.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        result = new StringBuffer();
        for (byte b: bytes) {
            result.append(String.format("%02x",b));
        }

        return result;
    }
}
