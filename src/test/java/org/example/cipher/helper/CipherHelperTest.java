package org.example.cipher.helper;

import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertNotNull;

public class CipherHelperTest {

    private static CipherHelper cipherHelper;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        int[] key = new int[]{1, 2, 3, 4, 5};
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
    public void testValidateOnEncodeInputsWithValidInputsMessageIsTheSameLengthAsKey() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "hello", 5);
    }

    @Test
    public void testValidateOnEncodeInputsWithValidInputsMessageLengthIsLessThanKeyLength() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "hi", 5);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInValidInputsMessageIsNull() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", null, 5);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInValidInputsMessageIsEmpty() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "", 5);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInValidInputsMessageLengthIsGreaterThanKeyLength() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "hello there", 5);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInValidInputsNumberOfTimesToEncodeMessageIsNegative() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "hello", -1);
    }

    @Test(expected = Exception.class)
    public void testValidateOnEncodeInputsWithInValidInputsNumberOfTimesToEncodeMessageIsZero() throws Exception {
        Whitebox.invokeMethod(cipherHelper, "validateOnEncodeInputs", "hello", 0);
    }

}