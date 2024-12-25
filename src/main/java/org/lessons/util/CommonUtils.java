package org.lessons.util;

import java.util.Arrays;
import java.util.Objects;

public class CommonUtils {

  public static boolean iffAnyNull(Object... objects) {
    return Arrays.stream(objects).anyMatch(Objects::isNull);
  }

}
