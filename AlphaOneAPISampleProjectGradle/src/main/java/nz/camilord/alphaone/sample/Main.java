package nz.camilord.alphaone.sample;

import nz.alphaone.library.api.Authentication.AuthenticationService;
import nz.alphaone.library.api.Authentication.Authorization;
import nz.alphaone.library.api.Common.AppConfig;
import nz.alphaone.library.api.Entity.ProjectEntry;
import nz.alphaone.library.api.ProjectList.ProjectListService;
import nz.alphaone.library.api.Response.MarkDoneResponse;

import java.util.ArrayList;

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

        // reusable variables
        Authorization authorization;

        /**
         * ================ AUTHENTICATION ========================
         */

        AuthenticationService auth = new AuthenticationService(config);
        authorization = auth.authenticate();

        System.out.println("\n");

        if (authorization.isAuthorized())
        {
            /**
             * ================ GET PROJECT LIST ========================
             */
            ProjectListService projectList = new ProjectListService(authorization);
            ArrayList<ProjectEntry> list = projectList.getAlphaGoProjectList(0);
            System.out.println(list);

            System.out.println("\n");

            /**
             * ================ MARK PROJECT AS DONE ========================
             */

            for (ProjectEntry item : list) {
                MarkDoneResponse response = projectList.markAlphaGoProjectAsDone(item);
                System.out.println(response);
                break;
            }
        } else {
            System.out.println("Error! Unable to get authorization.");
        }

        System.out.println("\n");

    }

}
