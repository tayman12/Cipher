package org.example.cipher.helper;

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
        String actual = cipherHelper.encode("Hello Bob", 1);
        assertEquals("BolHeol  b", actual);
    }

    @Test
    public void testEncodeMessageLengthEqualsKeyLength() throws Exception {
        String actual = cipherHelper.encode("Hello Boby", 1);
        assertEquals("BolHeol yb", actual);
    }

    @Test
    public void testEncodeForMultipleTimes() throws Exception {
        String actual = cipherHelper.encode("CERC", 1995);
        assertEquals("C RCE     ", actual);
    }

    @Test
    public void testValidateOnEncodeInputsWithValidInputsMessageIsTheSameLengthAsKey() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "hello Test", 5);
    }

    @Test
    public void testValidateOnEncodeInputsWithValidInputsMessageLengthIsLessThanKeyLength() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "hi", 5);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInvalidInputsMessageIsNull() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", null, 5);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInvalidInputsMessageIsEmpty() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "", 5);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInvalidInputsMessageLengthIsGreaterThanKeyLength() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "hello there, how are you", 5);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInvalidInputsNumberOfTimesToEncodeMessageIsNegative() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "hello", -1);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInvalidInputsNumberOfTimesToEncodeMessageIsZero() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "hello", 0);
    }
}