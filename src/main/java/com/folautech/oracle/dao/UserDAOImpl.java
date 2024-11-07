package com.folautech.oracle.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long getNexPersonalKey() {

        StringBuilder query = new StringBuilder();

        /**
         * personal_key_seq.nextval is case insensitive
         */
        query.append("SELECT USER_GEN_SEQ.NEXTVAL ");
        query.append("FROM dual ");

        Long nextVal = null;

        try {
            nextVal = jdbcTemplate.queryForObject(query.toString(), Long.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("nextVal={}", nextVal);

        return nextVal;
    }
}
