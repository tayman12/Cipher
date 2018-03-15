package org.example.cipher.helper;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CipherHelperTest {

    @Test
    public void testCreateCipherHelperWithValidKey() throws Exception {
        int[] key = new int[]{1, 2, 3};
        CipherHelper cipherHelper = new CipherHelper(key);
        assertNotNull(cipherHelper);
    }

    @Test(expected = Exception.class)
    public void testCreateCipherHelperwithNullKey() throws Exception {
        new CipherHelper(null);
    }

    @Test(expected = Exception.class)
    public void testCreateCipherHelperwithEmptyKey() throws Exception {
        new CipherHelper(new int[0]);
    }
}