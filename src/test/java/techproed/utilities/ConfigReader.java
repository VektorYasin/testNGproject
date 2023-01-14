package techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    //This class READS the "configuration.properties" file

    //Create Properties instance
    private static Properties properties;

    static {
        //path of the configuration file
        String path="configuration.properties";

        try {
            //Opening configuration.properties file using FileInputStream
            FileInputStream fileInputStream = new FileInputStream(path);

            //Yeni bir properties objesi yarattık
            properties = new Properties();
            properties.load(fileInputStream);

            //close the file
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //This method will "get the key" from properties file,
    //And "returns the values" as String
    //We create this method to read the file

    public static String getProperty(String key){

        String value=properties.getProperty(key);

        return value;
    }

}//class