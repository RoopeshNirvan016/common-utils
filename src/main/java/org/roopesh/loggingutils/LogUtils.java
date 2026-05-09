package org.roopesh.loggingutils;
import org.slf4j.Logger;

public class LogUtils {

    /*
     * Private constructor
     * Prevents object creation
     */
    private LogUtils() {
    }


    /*
     * Standardized error formatting
     */
    public static String formatError(
            String errorCode,
            String traceId,
            Exception ex
    ) {

        return String.format(
                "[ERROR_CODE=%s] [TRACE_ID=%s] [EXCEPTION=%s] [MESSAGE=%s]",
                errorCode,
                traceId,
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }

    /*
     * Standardized trace message
     */
    public static String buildTraceMessage(
            String traceId,
            String message
    ) {

        return String.format(
                "[TRACE_ID=%s] %s",
                traceId,
                message
        );
    }

    /*
     * Performance logging
     */
    public static void logExecutionTime(
            Logger logger,
            String operation,
            long startTime
    ) {

        long executionTime = System.currentTimeMillis() - startTime;

        logger.info(
                "[PERFORMANCE] Operation={} completed in {} ms",
                operation,
                executionTime
        );
    }

}
