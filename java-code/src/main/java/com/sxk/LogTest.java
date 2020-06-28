package com.sxk;


import java.io.File;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.AsyncAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sxk
 * 创建日期：2020/5/14
 */
@Slf4j
public class LogTest {

  public static void main(String[] args) {
    log.info("info");
    log.debug("debug");

    initLogger();
    Logger logger = LoggerFactory.getLogger(key);
    logger.info("aaaa");
    logger.info("bbbb");
    logger.warn("ccccc");
    logger.error("ddddd");
  }

  static String folder = "/data/cb/logs";
  static String key = "es-test";

  @SuppressWarnings("unchecked")
  public static void initLogger() {

    // 为false时，返回多个LoggerContext对象， true：返回唯一的单例LoggerContext
    final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
    final Configuration config = ctx.getConfiguration();
    // 创建一个展示的样式：PatternLayout， 还有其他的日志打印样式。
    Layout layout = PatternLayout.newBuilder()
        .withPattern(PatternLayout.DEFAULT_CONVERSION_PATTERN)
        .withConfiguration(config)
        .build();

    File pathFolder = new File(folder);
    pathFolder.mkdirs();
    String fileName = String.format(folder + "/11.%s-%s.log", "2020", "05-28");

    System.out.println(fileName);
    AsyncAppender asyncAppender = AsyncAppender
        .newBuilder()
        .setName(key)
        .build();

    Appender appender = FileAppender.newBuilder()
        .setConfiguration(config)
        .withFileName(fileName)
        .withName(key)
        .withLayout(layout)
        .build();

    appender.start();
    config.addAppender(appender);
    AppenderRef ref = AppenderRef.createAppenderRef(key, null, null);
    AppenderRef[] refs = new AppenderRef[]{ref};

    LoggerConfig loggerConfig = LoggerConfig
        .createLogger(true, Level.ALL, key, "true", refs, null,
            config, null);
    loggerConfig.addAppender(appender, null, null);
    config.addLogger(key, loggerConfig);
    ctx.updateLoggers();
  }

}
