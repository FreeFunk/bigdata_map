package com.edgedo.common.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.springframework.stereotype.Component;

/**
 * @author WangZhen
 * @description 日志 控制类
 * @date 2020/1/19
 */
@Component
public class LoggerTool {

    public String changeLogLevel(String logLevel){
            //改变日志等级
            String level = logLevel.toLowerCase();
            org.apache.logging.log4j.core.LoggerContext ctx = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
            Configuration config = ctx.getConfiguration();
            String edgedoLogerName = "com.edgedo";
            LoggerConfig edgedoLogerCfg = config.getLoggerConfig(edgedoLogerName);
            LoggerConfig rootLogerCfg = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);

            switch (level) {
                case "trace":
                    if(edgedoLogerCfg!=null){
                        edgedoLogerCfg.setLevel(org.apache.logging.log4j.Level.TRACE);
                    }
                    if(rootLogerCfg!=null){
                        rootLogerCfg.setLevel(org.apache.logging.log4j.Level.TRACE);
                    }
                    break;
                case "debug":
                    if(edgedoLogerCfg!=null){
                        edgedoLogerCfg.setLevel(org.apache.logging.log4j.Level.DEBUG);
                    }
                    if(rootLogerCfg!=null){
                        rootLogerCfg.setLevel(org.apache.logging.log4j.Level.DEBUG);
                    }
                    break;
                case "info":
                    if(edgedoLogerCfg!=null){
                        edgedoLogerCfg.setLevel(org.apache.logging.log4j.Level.INFO);
                    }
                    if(rootLogerCfg!=null){
                        rootLogerCfg.setLevel(org.apache.logging.log4j.Level.INFO);
                    }
                    break;
                case "warn":
                    if(edgedoLogerCfg!=null){
                        edgedoLogerCfg.setLevel(org.apache.logging.log4j.Level.WARN);
                    }
                    if(rootLogerCfg!=null){
                        rootLogerCfg.setLevel(org.apache.logging.log4j.Level.WARN);
                    }
                    break;
                case "error":
                    if(edgedoLogerCfg!=null){
                        edgedoLogerCfg.setLevel(org.apache.logging.log4j.Level.ERROR);
                    }
                    if(rootLogerCfg!=null){
                        rootLogerCfg.setLevel(org.apache.logging.log4j.Level.ERROR);
                    }
                    break;
                default:
                    System.out.println("日志级别修改失败！");
                    break;
            }
            ctx.updateLoggers();
            return "success";
    }

}
