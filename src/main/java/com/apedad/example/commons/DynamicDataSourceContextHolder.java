package com.apedad.example.commons;


/**
 * @author Administrator
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<DataSourceKey> CURRENT_DATESOURCE = new ThreadLocal<>();

    /**
     * 清除当前数据源
     */
    public static void clear() {
        CURRENT_DATESOURCE.remove();
    }

    /**
     * 获取当前使用的数据源
     *
     * @return 当前使用数据源的ID
     */
    public static DataSourceKey get() {
        return CURRENT_DATESOURCE.get();
    }

    /**
     * 设置当前使用的数据源
     *
     * @param value 需要设置的数据源ID
     */
    public static void set(DataSourceKey value) {
        CURRENT_DATESOURCE.set(value);
    }

}
