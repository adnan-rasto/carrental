package com.zbw.carrental.util;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.logging.Logger;

public class LoggingInterceptor implements Serializable {


    // ======================================
    // =             Attributes             =
    // ======================================

    @Inject
    private transient Logger logger;

    // ======================================
    // =          Business methods          =
    // ======================================

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.entering(ic.getTarget().getClass().getName(), ic.getMethod().getName());
        logger.info(">>> " + ic.getTarget().getClass().getName() + "-" + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
            logger.info("<<< " + ic.getTarget().getClass().getName() + "-" + ic.getMethod().getName());
        }
    }
}
