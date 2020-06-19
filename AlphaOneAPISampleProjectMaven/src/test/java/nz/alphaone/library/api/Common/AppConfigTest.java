package nz.alphaone.library.api.Common;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

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
public class AppConfigTest
{
    @Test
    public void getConfig()
    {
        AppConfig config = new AppConfig();
        Properties props = config.getConfig();
        assertTrue(props.containsKey("api_base_url"));
        assertTrue(props.containsKey("username"));
        assertTrue(props.containsKey("password"));
        System.out.println("Test Executed: " + new Date());
    }
}
