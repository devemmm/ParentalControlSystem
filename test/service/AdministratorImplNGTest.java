/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;


import org.testng.Assert;
import org.testng.annotations.Test;


/**
 *
 * @author emmanuel
 */
public class AdministratorImplNGTest {
        
    Administator administrator = new AdministratorImpl();
    
    public AdministratorImplNGTest() {
    }

    @Test(expectedExceptions = {RuntimeException.class})
    public void testSigninwithWrongCredentials() {
        boolean result = administrator.signin("user@gmail.com", "admin2");
        Assert.assertEquals(result, "ok");
        
    }
    
    @Test
    public void testSignin() {
        boolean result = administrator.signin("user@gmail.com", "admin1");
        Assert.assertEquals(result, true);
    }
}
