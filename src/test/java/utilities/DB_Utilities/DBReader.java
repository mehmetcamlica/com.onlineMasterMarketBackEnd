package utilities.DB_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBReader {
	static Properties dbProperties;

	static {
		String dosyaYolu = "src/test/java/config_Requirements/db.properties";
		try {
			FileInputStream fis= new FileInputStream(dosyaYolu);
			dbProperties= new Properties();
			dbProperties.load(fis);
		} catch (IOException e) {
			System.out.println("properties dosyasi okunamadi");
		}
	}

	public static String getDbProperties(String key) {
		return (dbProperties.getProperty(key));
	}
}
