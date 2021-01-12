package com.apedad.example.commons;


public enum DataSourceKey {
    DB_MASTER,
    DB_SLAVE1,
    DB_SLAVE2,
    DB_OTHER;

    /**
     * 根据Key得到枚举的Value
     *
     * @param key
     * @return
     */
    public static DataSourceKey getDataSourceValue(String key) {
        DataSourceKey[] values = DataSourceKey.values();
        for (DataSourceKey value : values) {
            if (value.toString().equals(key)) {
                return value;
            }
        }
        throw new RuntimeException("数据源枚举不存在，请确认...");
    };
}
