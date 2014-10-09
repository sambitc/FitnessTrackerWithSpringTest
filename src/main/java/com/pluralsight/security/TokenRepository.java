///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pluralsight.security;
//
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
///**
// *
// * @author sambitc
// */
//@Component(value = "mongoDBTokenRepository")
//public class MongoDBTokenRepository implements PersistentTokenRepository {
//    
//    JdbcTokenRepositoryImpl
//
//    @Autowired
//    PersistanceTokenDao persistanceTokenDao;
//
//    @Override
//    public void createNewToken(PersistentRememberMeToken token) {
//        persistanceTokenDao.insertToken(token);
//    }
//
//    @Override
//    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
//        return persistanceTokenDao.getTokenForSeries(seriesId);
//    }
//
//    @Override
//    public void removeUserTokens(String username) {
//        persistanceTokenDao.deleteToken(username);
//    }
//
//    @Override
//    public void updateToken(String series, String tokenValue, Date lastUsed) {
//        persistanceTokenDao.updateToken(series, tokenValue, lastUsed);
//    }
//}
