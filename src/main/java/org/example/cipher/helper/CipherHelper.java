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

    /*
    * Check that inputs to be encoded are valid
    *
    * @param message    the message to be encoded
    * @param k          number of times to encode message
    *
    * @throws Exception if any of the following assumptions failed:
    *     - Message should not be null or empty
    *     - Message length should not be greater than key length
    *     - Number of times to encode the message has to be a positive number
    * */
    private void validateOnEncodeInputs(String message, int k) throws Exception {
        if (message == null || message.length() == 0) {
            throw new Exception("Message should not be null or empty");
        } else if (message.length() > key.length) {
            throw new Exception("Message length should not be greater than key length");
        } else if (k <= 0) {
            throw new Exception("Number of times to encode the message has to be a positive number");
        }
    }
}
