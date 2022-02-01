/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author emmanuel
 */
public class AdministratorImpl implements Administator {

    private String getOs() {
        String OS = System.getProperty("os.name").toLowerCase();

        if ((OS.indexOf("win") >= 0)) {
            return "windows";
        } else if ((OS.indexOf("mac") >= 0)) {
            return "mac";
        } else if ((OS.indexOf("nux") >= 0)) {
            return "linux";
        } else {
            throw new RuntimeException("Sorry, but your OS doesn't support blocking.");
        }
    }

    @Override
    public boolean signin(String email, String password) {

        try {

            if (email.equals("user@gmail.com") && password.equals("admin1")) {
                return true;
            } else if (!email.equals("user@gmail.com") && password.equals("admin1")) {
                throw new RuntimeException("wrong email");
            } else if (email.equals("user@gmail.com") && !password.equals("admin1")) {
                throw new RuntimeException("Wrong password");
            } else {
                throw new RuntimeException("wrong email and password");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public String blockSite(String type, String url) {

        String hostsFile = "";
        
//        this is a simple list of pronography in 2022 you can get the full list through this link
//        https://raw.githubusercontent.com/mhxion/pornaway/master/hosts/porn_sites.txt
//        https://github.com/mhxion/pornaway/blob/master/hosts/porn_ads.txt
        
        String pronography[] = {
            "prono1.org",
            "prono2.com",
            "0m4.ru",
            "0n-line.tv",
            "0nn.info",
            "0ping.info",
            "0pros.com",
            "0q2.sitey.me",
            "0to.info",
            "0xxx.ws",
            "100author.com",
            "100go.com",
            "00it.com",
            "100porn.com",
            "00sexus.com",
            "00webcams.com",
            "000.gaysexe.free.fr",
            "000free.us",
            "000owamail0.000webhostapp.com",
            "000tristanprod.free.fr",
            "007angels.com",
            "007freepics.com",
            "101-photos-porno.info",
            "01-sex-amateur.info",
            "01apple.com",
            "012br.com",
            "013sv.com",
            "015gf.com",
            "016ih.com",
            "017.moro.tv",
            "017gj.com",
            "0190-telefonsex.de.lv",
            "0190service.de",
            "020.moro.tv",
            "021.moro.tv",
            "03e.info",
            "03p.info",
            "0365.bid"
        };

        switch (getOs()) {
            case "windows":
                hostsFile = "C:\\Windows\\System32\\drivers\\etc\\hosts";
                break;
            case "mac":
                hostsFile = "etc/hosts";
                break;
            case "linux":
                hostsFile = "/etc/hosts";
                break;
            default:
                throw new RuntimeException("Sorry, your OS doesn't support this system.");
        }

        try {

            if (type.equals("pronography")) {
                for (int i = 0; i < pronography.length; i++) {
                    Files.write(Paths.get(hostsFile), ("127.0.0.1 " + pronography[i] + " ").getBytes(), StandardOpenOption.APPEND);
                }
                return "both pronographical Website and ads  blocked successfull !!!";
            } else {
                Files.write(Paths.get(hostsFile), ("127.0.0.1 " + url).getBytes(), StandardOpenOption.APPEND);
                return "Website " + url + " blocked !!!";
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String viewBlockedWebSite(String path) {
        throw new RuntimeException("this was implemented in gui/SiteControl");
    }

    @Override
    public String manageInternet(String type) {
        try {

            String command = "ifconfig wlan0";
            switch (type) {

                case "enable":

                    try {
                        Runtime.getRuntime().exec(command + " up");
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    return "Now internet enabled successfull";

                case "disable":
                    try {
                        Runtime.getRuntime().exec(command + " down");
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    return "Now Internet connection is blocked";
                default:
                    throw new RuntimeException("something went wrong for input type");
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String blockApp(int timeout, String appName) throws IOException {
        try {
            String command = "";

            switch (getOs()) {
                case "windows":
                    command = "taskkill /f /im ";
                    break;
                case "mac":
                    command = "killall ";
                    break;
                case "linux":
                    command = "killall ";
                    break;
                default:
                    System.exit(0);
                    throw new RuntimeException("Sorry, your OS doesn't support this system.");

            }

            while (true) {
                Runtime.getRuntime().exec(command + appName);

                // Timeout
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    throw new RuntimeException("" + e.getMessage());
                }

                return appName + " blocked successfull";
            }

        } catch (Exception e) {
            throw new RuntimeException("" + e.getMessage());
        }
    }
}
