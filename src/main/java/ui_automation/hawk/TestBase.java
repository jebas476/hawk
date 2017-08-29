package ui_automation.hawk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class TestBase {
	public static WebDriver driver;
	public Properties prop;

	public void initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		initializeBrowser(browserName);
	}

	public void initializeDriver(String browserName) throws IOException {
		System.out.println(browserName);
		initializeBrowser(browserName);
	}

	public void initializeBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			// execute in chrome driver
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C://eclipse//geckodriver.exe");
			driver = new FirefoxDriver();
			// fire fox code
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C://eclipse//iedriver.exe");
			driver = new InternetExplorerDriver();
			// IE code
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void navigate_to_url(String url) {
		System.out.println(url);
		System.out.println(driver.toString());
		driver.get(url);
	}

	public static void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".//test-screenshots//" + result + "screenshot.png"));
	}
}