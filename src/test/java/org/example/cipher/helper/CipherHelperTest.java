package org.example.cipher.helper;

import org.example.cipher.model.Message;
import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CipherHelperTest {

    private static CipherHelper cipherHelper;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        int[] key = new int[]{4, 5, 3, 7, 2, 8, 1, 6, 10, 9};
        cipherHelper = new CipherHelper(key);
    }

    @Test
    public void testCreateCipherHelperWithValidKey() throws Exception {
        int[] key = new int[]{1, 2, 3};
        CipherHelper cipherHelper = new CipherHelper(key);
        assertNotNull(cipherHelper);
    }

    @Test(expected = Exception.class)
    public void testCreateCipherHelperWithNullKey() throws Exception {
        new CipherHelper(null);
    }

    @Test(expected = Exception.class)
    public void testCreateCipherHelperWithEmptyKey() throws Exception {
        new CipherHelper(new int[0]);
    }

    @Test
    public void testEncodeMessageLengthIsLessThanKeyLength() throws Exception {
        Message message = new Message();

        message.setEncodeTimes(1);
        message.setText("Hello Bob");

        String actual = cipherHelper.encode(message);
        assertEquals("BolHeol  b", actual);
    }

    @Test
    public void testEncodeMessageLengthEqualsKeyLength() throws Exception {
        Message message = new Message();

        message.setEncodeTimes(1);
        message.setText("Hello Boby");

        String actual = cipherHelper.encode(message);
        assertEquals("BolHeol yb", actual);
    }

    @Test
    public void testEncodeForMultipleTimes() throws Exception {
        Message message = new Message();

        message.setEncodeTimes(1995);
        message.setText("CERC");

        String actual = cipherHelper.encode(message);
        assertEquals("C RCE     ", actual);
    }

    @Test
    public void testValidateOnEncodeInputsWithValidInputsMessageIsTheSameLengthAsKey() throws Exception {
        Message message = new Message();

        message.setEncodeTimes(5);
        message.setText("hello Test");

        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", message);
    }

    @Test
    public void testValidateOnEncodeInputsWithValidInputsMessageLengthIsLessThanKeyLength() throws Exception {
        Message message = new Message();

        message.setEncodeTimes(5);
        message.setText("hi");

        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", message);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInvalidInputsMessageIsNull() throws Exception {
        Message message = new Message();

        message.setEncodeTimes(5);

        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", message);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInvalidInputsMessageIsEmpty() throws Exception {
        Message message = new Message();

        message.setEncodeTimes(5);
        message.setText("");

        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", message);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInvalidInputsMessageLengthIsGreaterThanKeyLength() throws Exception {
        Message message = new Message();

        message.setEncodeTimes(5);
        message.setText("hello there, how are you");

        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", message);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInvalidInputsNumberOfTimesToEncodeMessageIsNegative() throws Exception {
        Message message = new Message();

        message.setEncodeTimes(-1);
        message.setText("hello");

        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", message);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInvalidInputsNumberOfTimesToEncodeMessageIsZero() throws Exception {
        Message message = new Message();

        message.setEncodeTimes(0);
        message.setText("hello");

        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", message);
    }
}