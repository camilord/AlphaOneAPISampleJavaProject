package nz.alphaone.library.api.ProjectList;

import nz.alphaone.library.api.Authentication.AuthenticationService;
import nz.alphaone.library.api.Authentication.Authorization;
import nz.alphaone.library.api.Common.AppConfig;
import nz.alphaone.library.api.Entity.ProjectEntry;
import nz.alphaone.library.api.Response.MarkDoneResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * AlphaOneAPISampleProjectGradle
 * Copyright 2020
 * Generated in IntelliJ IDEA.
 * Developer: Camilo Lozano III
 * -> www.camilord.com
 * -> github.com/camilord
 * -> linkedin.com/in/camilord
 * Username: Camilo
 * Date: 8/06/2020
 * Time: 9:56 PM
 */
public class ProjectListServiceTest
{
    private Authorization getAuthorization() {
        AppConfig config = new AppConfig();
        AuthenticationService auth = new AuthenticationService(config);
        return auth.authenticate();
    }

    @Test
    public void getAlphaGoProjectList()
    {
        ProjectListService listObj = new ProjectListService(getAuthorization());
        ArrayList<ProjectEntry> list = listObj.getAlphaGoProjectList(0);

        String[] first_list = new String[list.size()];
        int index = 0;
        for (ProjectEntry item : list)
        {
            // asert alphaone id
            Assertions.assertTrue((!item.getAlphaID().equals("")));
            Assertions.assertTrue(Pattern.compile("[0-9]{3,6}").matcher(item.getAlphaID()).matches());
            first_list[index] = item.getAlphaID();

            // assert consent number
            Assertions.assertTrue((!item.getConsentNumber().equals("")));
            Assertions.assertTrue(Pattern.compile("([A-Z]{2})?[0-9]{3,6}").matcher(item.getConsentNumber()).matches());

            // assert state
            Assertions.assertTrue((!item.getApplicationState().equals("")));

            // assert flag
            Assertions.assertTrue((!item.getApplicationFlag().equals("")));
            Assertions.assertTrue((item.getApplicationFlag().contains("ALPHAGO_")));

            // assert request key which is using UUID
            Assertions.assertTrue((!item.getRequestKey().equals("")));
            Assertions.assertTrue(Pattern.compile("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})").matcher(item.getRequestKey()).matches());

            index++;
        }

        // second list and check against first list to test the pagination
        list = listObj.getAlphaGoProjectList(1);
        for (ProjectEntry item : list)
        {
            // asert alphaone id
            Assertions.assertTrue((!item.getAlphaID().equals("")));
            Assertions.assertTrue(Pattern.compile("[0-9]{3,6}").matcher(item.getAlphaID()).matches());
            Assertions.assertFalse(Arrays.stream(first_list).anyMatch(x -> x == item.getAlphaID()));

            // assert consent number
            Assertions.assertTrue((!item.getConsentNumber().equals("")));
            Assertions.assertTrue(Pattern.compile("([A-Z]{2})?[0-9]{3,6}").matcher(item.getConsentNumber()).matches());

            // assert state
            Assertions.assertTrue((!item.getApplicationState().equals("")));

            // assert flag
            Assertions.assertTrue((!item.getApplicationFlag().equals("")));
            Assertions.assertTrue((item.getApplicationFlag().contains("ALPHAGO_")));

            // assert request key which is using UUID
            Assertions.assertTrue((!item.getRequestKey().equals("")));
            Assertions.assertTrue(Pattern.compile("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})").matcher(item.getRequestKey()).matches());
        }
    }

    @Test
    public void markAlphaGoProjectAsDone() {
        ProjectListService listObj = new ProjectListService(getAuthorization());
        ArrayList<ProjectEntry> list = listObj.getAlphaGoProjectList(0);

        for (ProjectEntry item : list)
        {
            MarkDoneResponse response = listObj.markAlphaGoProjectAsDone(item);

            Assertions.assertTrue(response.getResult());
            Assertions.assertEquals("Success!", response.getMessage());
            Assertions.assertTrue(response.getTimestamp() > 0);
            Assertions.assertTrue((!response.getResponseID().equals("")));
            Assertions.assertTrue(Pattern.compile("[0-9]{1,}").matcher(response.getResponseID()).matches());

            break;
        }
    }
}
