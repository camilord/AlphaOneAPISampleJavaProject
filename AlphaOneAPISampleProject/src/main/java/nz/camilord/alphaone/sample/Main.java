package nz.camilord.alphaone.sample;

import nz.alphaone.library.api.Common.AppConfig;

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
