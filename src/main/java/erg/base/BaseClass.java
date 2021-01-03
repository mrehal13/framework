package erg.base;

import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	static WebDriver driver;
	static Properties prop;
	static FileInputStream fis;
	static final String FIREFOX = "firefox";
	static final String CHROME = "chrome";

	public static WebDriver getRemoteDriver() {

		String hubURL = credentialProperty("hubURL");
		DesiredCapabilities cap = new DesiredCapabilities();		
		String browser = System.getProperty("browser");

		if(browser.equalsIgnoreCase(FIREFOX)) {
			cap.setBrowserName(FIREFOX);
			cap .setPlatform(Platform.WIN10);

			try {
				driver = new RemoteWebDriver(new URL(hubURL), cap);
			}
			catch(MalformedURLException e) {
				e.printStackTrace();
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		else if(browser.equalsIgnoreCase(CHROME)) {
			cap.setBrowserName(CHROME);
			cap .setPlatform(Platform.WIN10);

			try {
				driver = new RemoteWebDriver(new URL(hubURL), cap);
			}
			catch(MalformedURLException e) {
				e.printStackTrace();
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

		return driver;
	}


	public static String credentialProperty(String param) {
		prop = new Properties();

		try{
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/property/browserproperty.properties");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try{
			prop.load(fis);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(param);
	}

	public static WebDriver getDriver()  {


		String browser = System.getProperty("browser");

		if(browser.equalsIgnoreCase(FIREFOX)) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/servers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}else if(browser.equalsIgnoreCase(CHROME)) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/servers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

		return driver;		
	}	


	public static void getURL(String urlToOpen) {
		driver.get(urlToOpen);
	}

	public static void clickElement(WebElement webElement) {
		webElement.click();
	}

	public static void enterText(WebElement webElement, String textToEnter) {
		webElement.sendKeys(textToEnter);
	}

	public static void waitScenario(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}




	public String getResponseBody(Response res) {
		return res.getBody().asString();
	}

	public int getStatusCode(Response res) {
		return res.getStatusCode();
	}

	public String getStatusLine(Response res) {
		return res.getStatusLine();
	}

	public void checkJsonSchema(Response resp, String pathToSchemaInClasspath) {
		resp.then().body(matchesJsonSchemaInClasspath(pathToSchemaInClasspath));
	}
}
