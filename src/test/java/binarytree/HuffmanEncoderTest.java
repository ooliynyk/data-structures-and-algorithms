package binarytree;

import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanEncoderTest {

    private static final String MESSAGE = "SUSIE SAYS IT IS EASY\n";

    @Test
    public void decode() throws Exception {
        HuffmanEncoder encoder = new HuffmanEncoder(MESSAGE);
        String[] encodedMessage = encoder.encode();
        assertEquals(MESSAGE, encoder.decode(encodedMessage));
    }

    @Test
    public void encode() throws Exception {
        HuffmanEncoder encoder = new HuffmanEncoder(MESSAGE);
        String[] encodedMessage = encoder.encode();
        assertNotNull(encodedMessage);
        assertEquals(MESSAGE.length(), encodedMessage.length);
    }

}