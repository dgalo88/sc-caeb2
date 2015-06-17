import java.io.File;
import java.util.ArrayList;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


public class Test {

	public static void main(String[] args) {
		try {

			String pathname = "C:\\Users\\Jose Hidalgo\\Desktop\\fichero1.prop";
			File file = new File(pathname);
			PropertiesConfiguration config = new PropertiesConfiguration(file);

			//		     config.save("C:\\Users\\Jose Hidalgo\\Desktop\\fichero1.prop");
			ArrayList<String> test=new ArrayList<String>();
			test.add("m1");
			test.add("m2");
			test.add("m3");
			//			config.load("C:\\Users\\Jose Hidalgo\\Desktop\\fichero1.prop");
			config.setProperty("demo3", "m1");
			config.setProperty("demo5", "m2");
			config.setProperty("demo6", test);

			config.save();

//			config.load("C:\\Users\\Jose Hidalgo\\Desktop\\fichero1.prop");
			//			List<Object> colorList=config.getList("pie");

			String[] colors = config.getStringArray("demo4");
//			List<Object> colorList = config.getList("demo4");


			//	        String background = (String) config.getProperty("demo");
			System.out.println(colors.length);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
