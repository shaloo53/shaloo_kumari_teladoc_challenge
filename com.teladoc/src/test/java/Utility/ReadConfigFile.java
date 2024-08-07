package Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	Properties prop;

	public ReadConfigFile() throws IOException{
		prop = new Properties();
		FileInputStream fs = new FileInputStream(new File("Config.properties"));
		prop.load(fs);
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getURL() {
		return prop.getProperty("URL");
	}
}