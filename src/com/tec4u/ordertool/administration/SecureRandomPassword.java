/**
 * 
 */
package com.tec4u.ordertool.administration;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author d.reinerts
 *
 */
public class SecureRandomPassword {
	private static final String CHAR_LCS = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UCS = CHAR_LCS.toUpperCase();
    private static final String DIGITS = "0123456789";
    private static final String PUNCTUATION = "!@#&()–[{}]:;',?/*";
    private static final String SYMBOLS = "~$^+=<>";
	private static final String SPECIALS = PUNCTUATION + SYMBOLS;
    private static final int PASSWORD_LENGTH = 20;

    private static final String PASSWORD_ALLOW =
            CHAR_LCS + CHAR_UCS + DIGITS + SPECIALS;

    private static SecureRandom random = new SecureRandom();

    public static String generateStrongPassword() {
        StringBuilder result = new StringBuilder(PASSWORD_LENGTH);

        String strLowerCase = generateRandomString(CHAR_LCS, 2);
        result.append(strLowerCase);

        String strUppercaseCase = generateRandomString(CHAR_UCS, 2);
        result.append(strUppercaseCase);

        String strDigit = generateRandomString(DIGITS, 2);
        result.append(strDigit);

        String strSpecialChar = generateRandomString(SPECIALS, 2);
        result.append(strSpecialChar);

        String strOther = generateRandomString(PASSWORD_ALLOW, PASSWORD_LENGTH - 8);
        result.append(strOther);

        String password = result.toString();
        
        return shuffleString(password);
    }

    // generate a random char[], based on `input`
    private static String generateRandomString(String input, int size) {

        if (input == null || input.length() <= 0)
            throw new IllegalArgumentException("Invalid input.");
        if (size < 1) throw new IllegalArgumentException("Invalid size.");

        StringBuilder result = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            // produce a random order
            int index = random.nextInt(input.length());
            result.append(input.charAt(index));
        }
        return result.toString();
    }

    // for final password, make it more random
    public static String shuffleString(String input) {
        List<String> result = Arrays.asList(input.split(""));
        Collections.shuffle(result);
        // java 8
        return result.stream().collect(Collectors.joining());
    }
    
   
}
