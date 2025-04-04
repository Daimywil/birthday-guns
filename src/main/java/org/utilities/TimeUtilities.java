package org.utilities;

public final class TimeUtilities {
    private TimeUtilities() {}

    public static long getCurrentTimeInMillis() {
        return (long) System.currentTimeMillis();
    }
}
