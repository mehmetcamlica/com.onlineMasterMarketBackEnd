package utilities.API_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APIReader {

	static Properties apiProperties;

	static {
		String dosyaYolu = "src/test/java/config_Requirements/api.properties";
		try {
			FileInputStream fis= new FileInputStream(dosyaYolu);
			apiProperties= new Properties();
			apiProperties.load(fis);
		} catch (IOException e) {
			System.out.println("properties dosyasi okunamadi");
		}
	}

	public static String getApiProperties(String key) {
		return (apiProperties.getProperty(key));
	}
}
