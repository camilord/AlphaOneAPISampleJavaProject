package nz.alphaone.library.api.Authentication;

import nz.alphaone.library.api.Common.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
 * Time: 9:30 PM
 */
public class AuthenticationServiceTest {

    @Test
    public void authenticate() {
        AppConfig config = new AppConfig();
        AuthenticationService auth = new AuthenticationService(config);
        Authorization authorization = auth.authenticate();
        Assertions.assertTrue((authorization != null));
        Assertions.assertTrue((!authorization.getApiBaseUrl().equals("")));
        Assertions.assertTrue((!authorization.getSessionKey().equals("")));
        Assertions.assertTrue((!authorization.getUsername().equals("")));
    }
}
