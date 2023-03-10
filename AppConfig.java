package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private static final String CONFIG_FILE_NAME = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\gui\\config.properties";
    Properties prop;
    AppConfig()
    {
        prop = new Properties();
        try
        {
            prop.load(new FileInputStream(CONFIG_FILE_NAME));
        }
        catch (IOException e)
        {
            // initialize configuration file
            initializeConfigFile();
        }
    }

    private String getPropertyValue(String key) {
        String value = null;
        prop = new Properties();

        try {
            prop.load(new FileInputStream(CONFIG_FILE_NAME));
            value = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }

    private void createFile(String filename) {
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private void setPropertyValue(String key, String value) {
        prop = new Properties();

        try {
            prop.load(new FileInputStream(CONFIG_FILE_NAME));
            prop.setProperty(key, value);
            prop.store(new FileOutputStream(CONFIG_FILE_NAME), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeConfigFile()
    {
        createFile(CONFIG_FILE_NAME);

        this.setAppVersion("1.0.0");
        this.setAppTitle("Duka Enterprises");
        this.setAppDeveloper("Barasa Michael");
        this.setAppEmail("ourdigitaltimes@gmail.com");

        this.setDatabaseName("mysql");
        this.setDatabaseUrl("jdbc:mysql://localhost/db_barasa_michael_150374");
        this.setDatabaseUser("user");
        this.setDatabasePassword("password");

        this.setDisplayDate("true");
        this.setDisplayTime("true");
        this.setDisplayColor("white");
    }

    public void setDatabaseName(String value)
    {
        this.setPropertyValue("database.name", value);
    }

    public void setDatabaseUser(String value)
    {
        this.setPropertyValue("database.user", value);
    }

    public void setDatabaseUrl(String value)
    {
        this.setPropertyValue("database.url", value);
    }

    public void setDatabasePassword(String value)
    {
        this.setPropertyValue("database.password", value);
    }

    public void setAppVersion(String value)
    {
        this.setPropertyValue("app.version", value);
    }

    public void setAppTitle(String value)
    {
        this.setPropertyValue("app.title", value);
    }

    public void setAppDeveloper(String value)
    {
        this.setPropertyValue("app.developer", value);
    }

    public void setAppEmail(String value)
    {
        this.setPropertyValue("app.email", value);
    }

    public void setDisplayDate(String value)
    {
        this.setPropertyValue("display.date", value);
    }

    public void setDisplayTime(String value)
    {
        this.setPropertyValue("display.time", value);
    }

    public void setDisplayColor(String value)
    {
        this.setPropertyValue("display.color", value);
    }

    public String getDatabaseName()
    {
        return this.getPropertyValue("database.name");
    }

    public String getDatabaseUrl()
    {
        return this.getPropertyValue("database.url");
    }

    public String getDatabaseUser()
    {
        return this.getPropertyValue("database.user");
    }

    public String getDatabasePassword()
    {
        return this.getPropertyValue("database.password");
    }

    public String getAppVersion()
    {
        return this.getPropertyValue("app.version");
    }

    public String getAppTitle()
    {
        return this.getPropertyValue("app.title");
    }

    public String getAppDeveloper()
    {
        return this.getPropertyValue("app.developer");
    }

    public String getAppEmail()
    {
        return this.getPropertyValue("app.email");
    }

    public String getDisplayDate()
    {
        return this.getPropertyValue("display.date");
    }

    public String getDisplayTime()
    {
        return this.getPropertyValue("display.time");
    }

    public String getDisplayColor()
    {
        return this.getPropertyValue("display.color");
    }
}