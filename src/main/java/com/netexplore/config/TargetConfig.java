package com.netexplore.config;

/**
 * @author Silence_Lurker
 */
@IConfig
public class TargetConfig {
    private String targetUrl;
    private int attackThreadNum;

    public void setAttackThreadNum(int attackThreadNum) {
        this.attackThreadNum = attackThreadNum;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public int getAttackThreadNum() {
        return attackThreadNum;
    }

    public String getTargetUrl() {
        return targetUrl;
    }
}
