package com.aqacources.tests.utils;

import java.util.Map;

/**
 * Created by Marina on 24.02.2019.
 */
public class YamlFile {


    // Values from yaml file
    private String url;
    private String email;
    private String password;
    private Map <String, String> test;
    private String[] anotherTestKeys;

    /**
     * Get URL from yaml file
     *
     * @return String represents URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Get email from yaml file
     *
     * @return String represents email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get password from yaml file
     *
     * @return String represents password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get test from yaml file
     *
     * @return Map represents test
     */
    public Map <String, String> getTest() {
        return test;
    }

    /**
     * Get anotherTestKeys from yaml file
     *
     * @return array that contains string values
     */
    public String[] getAnotherTestKeys() {
        return anotherTestKeys;
    }
}
