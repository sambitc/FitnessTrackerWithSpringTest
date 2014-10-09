/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 *
 * @author sambitc
 */
public class PasswordHash extends TestCase {

    public void testMd5Hash() {
        String password = "mindfire";
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String hashedPassword = passwordEncoder.encodePassword(password, null);
        System.out.println(hashedPassword);
    }

}
