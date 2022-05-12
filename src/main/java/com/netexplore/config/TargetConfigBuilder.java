package com.netexplore.config;

/**
 * @author Silence_Lurker
 */
public class TargetConfigBuilder {
    private static TargetConfig targetConfig = new TargetConfig();

    private TargetConfigBuilder() {
    }

    public static TargetConfig build() {
        if (targetConfig.getTargetUrl().equals(null)) {
            System.out.println("No target !");
            return null;
        }
        if (targetConfig.getAttackThreadNum() == -1) {
            targetConfig.setAttackThreadNum(Integer.MAX_VALUE);
        }

        return targetConfig;
    }

    public static void setURL(String url) {
        targetConfig.setTargetUrl(url);
    }

    public static void setThreadNum(int num) {
        targetConfig.setAttackThreadNum(num);
    }

}
