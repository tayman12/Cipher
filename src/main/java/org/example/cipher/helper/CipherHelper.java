package org.example.cipher.helper;

import org.example.cipher.model.Message;
import sun.misc.resources.Messages_es;

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
    * Encode message k times using the following principle:
    * The message is written down below the key, so that characters in the message and numbers in the key are correspondingly aligned.
    * Character in the message at the position i is written in the encoded message at the position ai, where ai is the corresponding number in the key.
    * And then the encoded message is encoded in the same way. This process is repeated k times. After kth encoding they exchange their message.
    *
    * @param message    the message to be encoded
    * @param k          number of times to encode message
    *
    * @return String    encoded message
    *
    * @throws Exception if any of the following assumptions failed:
    *     - Message should not be null or empty
    *     - Message length should not be greater than key length
    *     - Number of times to encode the message has to be a positive number    * */
    public String encode(Message message) throws Exception {
        validateOnEncodeInputs(message);

        char[] encodedMessage = new char[key.length];
        char[] messageCharacters = message.getText().toCharArray();

        for (int i = 0; i < message.getEncodeTimes(); i++) {
            for (int j = 0; j < key.length; j++) {
                if (j < messageCharacters.length) {
                    encodedMessage[key[j] - 1] = messageCharacters[j];

                } else {
                    encodedMessage[key[j] - 1] = ' ';
                }
            }
            messageCharacters = encodedMessage.clone();
        }

        return new String(encodedMessage);
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
    private void validateOnEncodeInputs(Message message) throws Exception {
        if (message == null || message.getText().length() == 0) {
            throw new Exception("Message should not be null or empty");

        } else if (message.getText().length() > key.length) {
            throw new Exception("Message length should not be greater than key length");

        } else if (message.getEncodeTimes() <= 0) {
            throw new Exception("Number of times to encode the message has to be a positive number");
        }
    }
}