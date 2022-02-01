/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.io.IOException;

/**
 * This is a simple app for parental control system developed by Emmanuel NTIVUGURUZWA for purpose of Job Challenge
 * Parental control is features which may be included in digital television services, computers and video games, mobile devices and software that allow parents to restrict the access of content to their children.
 * that why i chose to build stand-alone software for restrict the access for children divice (machine)
 * this software has the following main purpose:
 * -block website
 * -block program
 * -disable internet
 * -enable internet
 * -view blocked website
 * -block the pronography site and ads 
 * 
 * N.B this Software was tested in Linux Only but don't worry.
 * 
 * @author emmanuel
 */
public interface Administator {
    
    /**
     * this is a simple function for authentication
     * @param email The default email = user@gmail.com
     * @param password Default Password = password = admin1
     * @return true of false depends on credentials
     */
    public boolean signin(String email, String password);
    
    /**
     * block a web site and add by parsing the required url and should be a string
     * @param type Website type it can be pronography site and ads
     * @param url Site url
     * @return string shows the action pregress.
     */
    public String blockSite(String type, String url);
    
    /**
     * block application 
     * @param timeout Time taken to block that application
     * @param appName Name of application you want to block
     * @return Message shows the blocked web site
     * @throws IOException 
     */
    public String blockApp(int timeout, String appName) throws IOException;

    /**
     * Shows the blocked web site list
     * @param path this function was implemented in gui/SiteControl
     * @return 
     */
    public String viewBlockedWebSite(String path);
    
    /**
     * manage the internet block and unblock 
     * @param type enable or disable
     * @return string shows the action pregress.
     */
    public String manageInternet(String type);
}
