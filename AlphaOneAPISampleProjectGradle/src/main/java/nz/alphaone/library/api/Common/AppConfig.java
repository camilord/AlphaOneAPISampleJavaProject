package nz.alphaone.library.api.Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AlphaOneAPISampleProject
 * Copyright 2020
 * Generated in IntelliJ IDEA.
 * Developer: Camilo Lozano III
 * -> www.camilord.com
 * -> github.com/camilord
 * -> linkedin.com/in/camilord
 * Username: Camilo
 * Date: 5/06/2020
 * Time: 8:59 AM
 */
public class AppConfig
{
    private static Properties properties;

    public AppConfig() {
        properties = new Properties();
        init_config();
    }

    private static void init_config()
    {
        //String cwd = System.getProperty("user.dir");
        //File file = new File(cwd + "/alphaone.api.config");
        File file = new File("alphaone.api.config");
        try (
                BufferedReader reader = new BufferedReader(new FileReader(file));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isMatch(line, "(.*)api_base_url=(.*)")) {
                    properties.setProperty("api_base_url", getConfigValue(line));
                } else if (isMatch(line, "(.*)username=(.*)")) {
                    properties.setProperty("username", getConfigValue(line));
                } else if (isMatch(line, "(.*)password=(.*)")) {
                    properties.setProperty("password", getConfigValue(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error! \"alphaone.api.config\" not found!");
        }
    }

    /**
     * @return Properties
     */
    public Properties getConfig() {
        return properties;
    }

    private static boolean isMatch(String line, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        return m.matches();
    }

    private static String getConfigValue(String line) {
        String[] tmp = line.split("=");
        return tmp[1].trim();
    }
}
