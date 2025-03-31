package org.utilities;

public final class TimeUtils {
    private TimeUtils() {}

    public static long getCurrentTimeInMillis() {
        return (long) System.currentTimeMillis();
    }
}
