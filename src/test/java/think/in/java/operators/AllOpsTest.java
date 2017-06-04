package think.in.java.operators;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by limenghua on 2017/5/26.
 */
public class AllOpsTest {

    private AllOps allOps = new AllOps();

    @Test
    public void testBoolTest() throws Exception {
        allOps.boolTest(true, false);
    }
}