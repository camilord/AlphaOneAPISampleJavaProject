package nz.alphaone.library.api.Entity;

import java.util.HashMap;

/**
 * AlphaOneAPISampleProjectGradle
 * Copyright 2020
 * Generated in IntelliJ IDEA.
 * Developer: Camilo Lozano III
 * -> www.camilord.com
 * -> github.com/camilord
 * -> linkedin.com/in/camilord
 * Username: Camilo
 * Date: 10/06/2020
 * Time: 8:26 AM
 */
public class DataConfig {
    private final HashMap<String, String> config = new HashMap<>();

    public DataConfig(String use_compiled_pdf) {
        setUseCompiledPdf(use_compiled_pdf);
    }

    public String getUseCompiledPdf() {
        return config.get("use_compiled_pdf");
    }

    public void setUseCompiledPdf(String use_compiled_pdf) {
        config.put("use_compiled_pdf", use_compiled_pdf);
    }

    @Override
    public String toString() {
        return "DataConfig{" +
                "config=" + config +
                '}';
    }
}
