package com.netexplore.config;

/**
 * @author Silence_Lurker
 */
public @interface IConfig {
    String targetUrl() default "";

    int targetNum() default -1;
}
