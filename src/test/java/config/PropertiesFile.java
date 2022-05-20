package config;

import tests.Testng_Demo1;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");
    public static void main(String[] args) {
        getProperties();
        setProperties();
        getProperties();
    }

    public static void getProperties() {
        try {
            InputStream ip = new FileInputStream(projectPath + "/src/test/java/config/config.properties");
            prop.load(ip);
            String browser = prop.getProperty("browserName");
            String result = prop.getProperty("result");
            System.out.println("Browser name " + browser);
            Testng_Demo1.browserName = browser;
            Testng_Demo1.result = result;
        } catch (Exception exp) {
            exp.getMessage();
            exp.getCause();
            exp.printStackTrace();
        }
    }

    public static void setProperties() {
        try {
            OutputStream op = new FileOutputStream(projectPath + "/src/test/java/config/config.properties");
            prop.setProperty("result", "pass");
            prop.store(op, "Writing the value to config file");
        } catch (Exception exp) {
            exp.getMessage();
            exp.getCause();
            exp.printStackTrace();
        }
    }
}
