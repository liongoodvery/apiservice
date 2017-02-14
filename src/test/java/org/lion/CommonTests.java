package org.lion;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Base64;

/**
 * Created by lion on 2/12/17.
 */
public class CommonTests {
    @Test
    public void test8() throws Exception {
        String nullStr = "\u0000";
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(nullStr).append(2);
        System.out.println(new String(Base64.getEncoder().encode(sb.toString().getBytes())));
    }

    @Test
    public void test20() throws Exception {
        Timestamp time = new Timestamp(1111111);
        System.out.println(time);
    }
}
