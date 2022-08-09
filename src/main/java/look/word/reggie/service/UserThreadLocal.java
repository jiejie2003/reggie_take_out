package look.word.reggie.service;

/**
 * 基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
 */
public class UserThreadLocal {

    private UserThreadLocal() {
    }

    private static ThreadLocal<Long> THREADLOCAL = new ThreadLocal<>();

    /**
     * 设置值
     *
     * @param id
     */
    public static void setCurrentId(Long id) {
        THREADLOCAL.set(id);
    }

    /**
     * 获取值
     *
     * @return
     */
    public static Long getCurrentId() {
        return THREADLOCAL.get();
    }

    public static void remove() {
        THREADLOCAL.remove();
    }
}
