package rahualshetty.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rahualshetty.pageboject.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginPage;
	
	public void initializeBrowser() throws IOException {
		
		
		String browserName = getGlobalProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox"))
		{
			//firefox
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws IOException {
		initializeBrowser();
		loginPage = new LoginPage(driver);
		loginPage.goTo("https://rahulshettyacademy.com/client");
		return loginPage;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		File file = new File(filePath);
		String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data =  mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
	}
	
	public String getGlobalProperty(String propertie) throws IOException {
		//Properties
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
						"\\src\\main\\java\\rahualshetty\\resourse\\GlobalData.properties");
				prop.load(fis);
				return prop.getProperty(propertie);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	
	public String getScreenshot(String testName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"/TestReport/"+testName+".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+"/TestReport/"+testName+".png";
		
	}
}
