package org.lion;

import org.junit.Test;
import org.lion.utils.CommonUtils;

/**
 * Created by lion on 2/13/17.
 */
public class CommonUtilsTests {
    @Test
    public void test8() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(CommonUtils.phaseId());
        }
    }
}
