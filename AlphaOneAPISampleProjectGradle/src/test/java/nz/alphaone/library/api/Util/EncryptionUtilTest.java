package nz.alphaone.library.api.Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * AlphaOneAPISampleProjectGradle
 * Copyright 2020
 * Generated in IntelliJ IDEA.
 * Developer: Camilo Lozano III
 * -> www.camilord.com
 * -> github.com/camilord
 * -> linkedin.com/in/camilord
 * Username: Camilo
 * Date: 9/06/2020
 * Time: 8:02 AM
 */

public class EncryptionUtilTest
{
    public static Object[][] getMD5TestSamples() {
        return new Object[][] {
            { "~!@#$%^&*()_+", "7ce385876b9d27babc2aead40a7f7c47" },
            { "AlphaOne", "cb98699bd368385379f255cee0cd82ac" },
            { "Woopsy", "5f70ba12a83ac6a8c4c58a64113a2663" },
            { "1234567890", "e807f1fcf82d132f9bb018ca6738a19f" },
            //{ "ñ", "edb907361219fb8d50279eabab0b83b1" },
            { "QAZXSWEDCVFR", "186c549e39a1387b11a5ef267872f871" },
        };
    }

    @ParameterizedTest
    @MethodSource("getMD5TestSamples")
    public void md5(String text, String expected)
    {
        String actual = EncryptionUtil.md5(text);
        Assertions.assertEquals(expected, actual);

        if (!actual.equals(expected)) {
            System.out.println(text + " : " + expected + " == " + actual);
        }
    }

    public static Object[][] getSHA1TestSamples() {
        return new Object[][] {
                { "~!@#$%^&*()_+", "ca552f542c193dc5f61252247f4abc62dc0f294f" },
                { "AlphaOne", "3f6b28d63d7f9821639b4847646ad5e359ed7d19" },
                { "Woopsy", "63860a01bd75993713bf5489b8d9b198146d2c73" },
                { "1234567890", "01b307acba4f54f55aafc33bb06bbbf6ca803e9a" },
                //{ "ñ", "c94bcf8c2a99decd9ede6a0a0fc681362c202fc3" },
                { "QAZXSWEDCVFR", "af8ce58b30993ea04f03447e88347761694e0474" },
        };
    }

    @ParameterizedTest
    @MethodSource("getSHA1TestSamples")
    public void sha1(String text, String expected)
    {
        String actual = EncryptionUtil.sha1(text);
        Assertions.assertEquals(expected, actual);

        if (!actual.equals(expected)) {
            System.out.println(text + " : " + expected + " == " + actual);
        }

    }
}
