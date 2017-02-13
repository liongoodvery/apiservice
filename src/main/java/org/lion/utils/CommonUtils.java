package org.lion.utils;

import java.util.UUID;

/**
 * Created by lion on 2/13/17.
 */
public class CommonUtils {
    public static String phaseId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
