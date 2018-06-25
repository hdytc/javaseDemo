package string;

import org.junit.Assert;
import org.junit.Test;

public class KMPTest {
    @Test
    public void test() {
        Assert.assertEquals(new KMP("BBC ABCDAB ABCDABCDABDE", "ABCDABD").getIndex(),15);
        Assert.assertEquals(new KMP("BBC ABCDAB ABCDABCDABDE", "B").getIndex(),0);
        Assert.assertEquals(new KMP("BBC ABCDAB ABCDABCDABDE", "E").getIndex(),22);
        Assert.assertEquals(new KMP("BBC ABCDAB ABCDABCDABDE", "D").getIndex(),7);
        Assert.assertEquals(new KMP("BBC ABCDAB ABCDABCDABDE", "F").getIndex(),-1);
        Assert.assertEquals(new KMP("BBC ABCDAB ABCDABCDABDE", "ABD").getIndex(),19);
    }
}
