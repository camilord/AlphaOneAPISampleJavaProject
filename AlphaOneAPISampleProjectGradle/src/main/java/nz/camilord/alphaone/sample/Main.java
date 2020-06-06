package nz.camilord.alphaone.sample;

import nz.alphaone.library.api.Common.AppConfig;

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
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello AlphaOne API, from Java 11");

        System.out.println("\nAPI CREDENTIALS:");
        AppConfig config = new AppConfig();
        System.out.println("  - " + config.getConfig().get("api_base_url"));
        System.out.println("  - " + config.getConfig().get("username"));
        System.out.println("  - " + config.getConfig().get("password"));

        System.out.println("\n");
    }
}
