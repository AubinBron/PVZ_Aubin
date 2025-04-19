package com.oxyl.coursepfback.persistance.DAO;

import com.oxyl.coursepfback.config.AppConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DAO {
    private static AppConfig appConfig = new AppConfig();
    protected static JdbcTemplate jdbcTemplate = appConfig.initJdbcTemplate();
    public DAO() {
    }

}
