package com.sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ShiftCipherTest {

    private final ShiftCipher cipher = new ShiftCipher();

    @ParameterizedTest
    @CsvSource({
        "ATTACK,17,RKKRTB",
        "HELLO,0,HELLO",
        "ABC,-1,ZAB",
        "'',17,INVALID",
        "attack,17,INVALID",
        "ABC123,17,INVALID",
        "null,17,INVALID"
    })
    void testEncrypt(String plainText, int key, String expected) {

        if ("null".equals(plainText)) {
            plainText = null;
        }

        assertEquals(expected, cipher.encrypt(plainText, key));
    }

    @ParameterizedTest
    @CsvSource({
        "RKKRTB,17,ATTACK",
        "HELLO,0,HELLO",
        "ZAB,-1,ABC",
        "'',17,INVALID",
        "attack,17,INVALID",
        "ABC123,17,INVALID",
        "null,17,INVALID"
    })
    void testDecrypt(String cipherText, int key, String expected) {

        if ("null".equals(cipherText)) {
            cipherText = null;
        }

        assertEquals(expected, cipher.decrypt(cipherText, key));
    }
}
