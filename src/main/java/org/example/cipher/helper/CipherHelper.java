package org.example.cipher.helper;

/**
 * Holds all the cipher related logic
 */
public class CipherHelper {

    /*
    * Holds the key that will be used in all cipher processes
    * */
    private int[] key;

    /*
    * Constructor of the Cipher Util class
    *
    * @param key        the key to be used in all upcoming cipher processes
    * @throws Exception if key is null or empty
    * */
    public CipherHelper(int[] key) throws Exception {
        if (key != null && key.length > 0) {
            this.key = key;

        } else {
            throw new Exception("Encoding key should not be null or empty");
        }
    }
}
