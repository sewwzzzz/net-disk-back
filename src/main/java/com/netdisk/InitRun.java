package com.netdisk;

import com.netdisk.component.RedisComponent;
import com.netdisk.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import javax.sql.DataSource;

@Component("initRun")
public class InitRun implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitRun.class);

    @Resource
    private DataSource dataSource;

    @Resource
    private RedisComponent redisComponent;

    @Override
    public void run(ApplicationArguments args) {
        try {
            dataSource.getConnection();
            redisComponent.getSysSettingsDto();
            logger.info("Service started successfully, you can start developing happily");
        } catch (Exception e) {
            logger.error("Database or redis settings failed, please check the configuration");
            throw new BusinessException("Service startup failed");
        }
    }
}
