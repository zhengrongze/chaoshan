package com.mc.utils;

import lombok.Data;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import java.util.Random;

/**
 * @ClassName Logger
 * @Author ZhengRongZe
 * @Date 2019/3/11 10:04
 **/
public class Logger {
    private static final String DEFALT_NAME = "chaoshan";
    private org.slf4j.Logger logger;
    private Class<?> clazz;
    private String modelName;

    //私有化单例
    private Logger(Class<?> clazz, String modelName) {
        this.logger = null;
        this.logger = LoggerFactory.getLogger(clazz);
        this.modelName = modelName;
    }
    public static Logger getLogger(Class<?> clazz){
        return new Logger(clazz,DEFALT_NAME);
    }

    public String getName(){
        return this.logger.getName();
    }
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    public void trace(String msg) {
        this.logger.trace(this.setMsg(msg));
    }

    public void trace(String format, Object arg) {
        this.logger.trace(this.setMsg(format), arg);
    }

    public void trace(String format, Object arg1, Object arg2) {
        this.logger.trace(this.setMsg(format), arg1, arg2);
    }

    public void trace(String format, Object... arguments) {
        this.logger.trace(this.setMsg(format), arguments);
    }

    public void trace(String msg, Throwable t) {
        this.logger.trace(this.setMsg(msg), t);
    }

    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    public void debug(String msg) {
        this.logger.debug(this.setMsg(msg));
    }

    public void debug(String format, Object arg) {
        this.logger.debug(this.setMsg(format), arg);
    }

    public void debug(String format, Object arg1, Object arg2) {
        this.logger.debug(this.setMsg(format), arg1, arg2);
    }

    public void debug(String format, Object... arguments) {
        this.logger.debug(this.setMsg(format), arguments);
    }

    public void debug(String msg, Throwable t) {
        this.logger.debug(this.setMsg(msg), t);
    }

    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    public void info(String msg) {
        this.logger.info(this.setMsg(msg));
    }

    public void info(String format, Object arg) {
        this.logger.info(this.setMsg(format), arg);
    }

    public void info(String format, Object arg1, Object arg2) {
        this.logger.info(this.setMsg(format), arg1, arg2);
    }

    public void info(String format, Object... arguments) {
        this.logger.info(this.setMsg(format), arguments);
    }

    public void info(String msg, Throwable t) {
        this.logger.info(this.setMsg(msg), t);
    }

    public boolean isInfoEnabled(Marker marker) {
        return this.logger.isTraceEnabled(marker);
    }

    public void info(Marker marker, String msg) {
        this.logger.info(marker, this.setMsg(msg));
    }

    public void info(Marker marker, String format, Object arg) {
        this.logger.info(marker, this.setMsg(format), arg);
    }

    public void info(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.info(marker, this.setMsg(format), arg1, arg2);
    }

    public void info(Marker marker, String format, Object... arguments) {
        this.logger.info(marker, this.setMsg(format), arguments);
    }

    public void info(Marker marker, String msg, Throwable t) {
        this.logger.info(marker, this.setMsg(msg), t);
    }

    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    public void warn(String msg) {
        this.logger.warn(this.setMsg(msg));
    }

    public void warn(String format, Object arg) {
        this.logger.warn(this.setMsg(format), arg);
    }

    public void warn(String format, Object... arguments) {
        this.logger.warn(this.setMsg(format), arguments);
    }

    public void warn(String format, Object arg1, Object arg2) {
        this.logger.warn(this.setMsg(format), arg1, arg2);
    }

    public void warn(String msg, Throwable t) {
        this.logger.warn(this.setMsg(msg), t);
    }

    public boolean isWarnEnabled(Marker marker) {
        return this.logger.isWarnEnabled(marker);
    }

    public void warn(Marker marker, String msg) {
        this.logger.warn(marker, this.setMsg(msg));
    }

    public void warn(Marker marker, String format, Object arg) {
        this.logger.warn(marker, this.setMsg(format), arg);
    }

    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.warn(marker, this.setMsg(format), arg1, arg2);
    }

    public void warn(Marker marker, String format, Object... arguments) {
        this.logger.warn(marker, this.setMsg(format), arguments);
    }

    public void warn(Marker marker, String msg, Throwable t) {
        this.logger.warn(marker, this.setMsg(msg), t);
    }

    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    public void error(String msg) {
        this.logger.error(this.setMsg(msg));
    }

    public void error(String format, Object arg) {
        this.logger.error(this.setMsg(format), arg);
    }

    public void error(String format, Object arg1, Object arg2) {
        this.logger.error(this.setMsg(format), arg1, arg2);
    }

    public void error(String format, Object... arguments) {
        this.logger.error(this.setMsg(format), arguments);
    }

    public void error(String msg, Throwable t) {
        this.logger.error(this.setMsg(msg), t);
    }

    public boolean isErrorEnabled(Marker marker) {
        return this.logger.isTraceEnabled(marker);
    }

    public void error(Marker marker, String msg) {
        this.logger.error(marker, msg);
    }

    public void error(Marker marker, String format, Object arg) {
        this.logger.error(marker, format, arg);
    }

    public void error(Marker marker, String format, Object arg1, Object arg2) {
        this.logger.error(marker, format, arg1, arg2);
    }

    public void error(Marker marker, String format, Object... arguments) {
        this.logger.error(marker, format, arguments);
    }

    public void error(Marker marker, String msg, Throwable t) {
        this.logger.error(marker, msg, t);
    }
    private String setMsg(String msg){
        StringBuilder sb = new StringBuilder("【");
        sb.append(this.modelName).append("】");
        sb.append(msg);
        return sb.toString();
    }
}
