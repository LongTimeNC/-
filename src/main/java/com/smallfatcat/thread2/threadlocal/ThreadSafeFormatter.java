package com.smallfatcat.thread2.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生产出线程安全的日期格式化工具
 */
class ThreadSafeFormatter {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(()
            -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {

        System.out.println();
    }
}
