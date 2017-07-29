package trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanEncoderTest {
    @Test
    public void encode() throws Exception {
        HuffmanEncoder encoder = new HuffmanEncoder("SUSIE SAYS IT IS EASY");
        encoder.encode();
    }

}