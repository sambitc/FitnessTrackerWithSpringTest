/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.security;

import java.io.Serializable;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author sambitc
 */
public class FitnessPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private DataSource dataSource;

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject,
            Object permission) {

        JdbcTemplate template = new JdbcTemplate(dataSource);

        Object[] args = {((User) auth.getPrincipal()).getUsername(),
            targetDomainObject.getClass().getName(), permission.toString()};

        int count = template.queryForObject("SELECT count(*) FROM users inner join user_permissions on user_id=user_id_fk inner join permissions on permission_id=permission_id_fk\n"
                + "where username=? and target= ? and permission=?;",
                args, Integer.class);

        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasPermission(Authentication authentication,
            Serializable targetId, String targetType, Object permission) {
        return false;
    }

}
