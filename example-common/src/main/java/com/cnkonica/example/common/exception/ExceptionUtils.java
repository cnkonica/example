package com.cnkonica.example.common.exception;

public class ExceptionUtils {
//    private static final Logger logger = LoggerFactory.getLogger(ExceptionUtils.class);
//    public static final int ERROR_MESSAGE_MAX_LENGTH= 200;
//    private ExceptionUtils(){}
//
//    public static <T extends Exception> void log(Supplier<T> exceptionSupplier) throws Exception {
//        logger.error("异常{}", exceptionSupplier.get().getMessage());
//        throw exceptionSupplier.get();
//    }
//
//    /**
//     * 捕获异常处理
//     */
//    public static <T> T tryCatch(TryCathes.ThrowableSupplier<T> supplier) {
//        try {
//            return supplier.get();
//        } catch (BusinessException be) {
//            logger.error("异常：{}", be.getMessage());
//            throw be;
//        } catch (Exception e) {
//            logger.error("系统异常", e);
//            throw new BusinessException(CommonResultCode.SYSTEM_ERROR, e);
//        }
//    }
//
//    public static void tryCatch(TryCathes.ThrowableRunnable runnable) {
//        try {
//             runnable.run();
//        } catch (BusinessException be) {
//            logger.error("异常：{}", be.getMessage());
//            throw be;
//        } catch (Exception e) {
//            logger.error("系统异常", e);
//            throw new BusinessException(CommonResultCode.SYSTEM_ERROR, e);
//        }
//    }
//
//    public static void tryCatch(TryCathes.ThrowableRunnable runnable, Consumer<Exception> runWhenException, BizResultCode resultCode) {
//
//        try {
//            runnable.run();
//        } catch (BusinessException be) {
//            runWhenException.accept(be);
//            throw be;
//        } catch (Exception e) {
//            runWhenException.accept(e);
//            throw new BusinessException(CommonResultCode.SYSTEM_ERROR, e);
//        }
//    }
//
//    public static <T> T tryCatch(TryCathes.ThrowableSupplier<T> supplier, Consumer<Exception> runWhenException, BizResultCode resultCode) {
//        return TryCathes.of(supplier).orElseThrow(e->{
//            runWhenException.accept(e);
//            return new BusinessException(resultCode, e);
//        });
//    }
//
//    public static void checkAruement(boolean judge, Runnable runWhenException, Supplier<String> errorMeesageSupplier) {
//        if (!judge) {
//            runWhenException.run();
//            throw new BusinessException(CommonResultCode.ILLEGAL_ARGUMENT, errorMeesageSupplier.get());
//        }
//    }
//
//    public static void checkNull(Object object, Runnable runWhenException, Supplier<String> errorMeesageSupplier) {
//        if (object == null) {
//            runWhenException.run();
//            throw new BusinessException(CommonResultCode.ILLEGAL_ARGUMENT, errorMeesageSupplier.get());
//        }
//    }
//
//    public static void checkString(String string, Runnable runWhenException, Supplier<String> errorMeesageSupplier) {
//        if (StringUtils.isBlank(string)) {
//            runWhenException.run();
//            throw new BusinessException(CommonResultCode.ILLEGAL_ARGUMENT, errorMeesageSupplier.get());
//        }
//    }
//
//    public static <T> void checkCollection(Collection<T> collection, Runnable runWhenException, Supplier<String> errorMeesageSupplier) {
//        if (CollectionUtils.isEmpty(collection)) {
//            runWhenException.run();
//            throw new BusinessException(CommonResultCode.ILLEGAL_ARGUMENT, errorMeesageSupplier.get());
//        }
//    }
}
