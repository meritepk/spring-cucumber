package pk.merite.cucumber.configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
public class ApplicationConfiguration {

	@Bean(name = "webDriver", destroyMethod = "quit")
	@ConditionalOnMissingBean(name = "webDriver")
	public WebDriver webDriver(@Value("${webdriver.browser:chrome}") String browser,
			@Value("${webdriver.cache:target}") String location) {
		System.setProperty("wdm.cachePath", location);
		RemoteWebDriver driver = null;
		if ("chrome".equals(browser)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if ("firefox".equals(browser)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if ("edge".equals(browser)) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if ("iexplorer".equals(browser)) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if ("safari".equals(browser)) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		// else if ("opera".equals(browser)) {
		// WebDriverManager.operadriver().setup();
		// driver = new ChromiumDriver();
		// }
		// return new EventFiringWebDriver(driver);
		return driver;
	}

	@Bean
	public String maximize(WebDriver webDriver) throws Exception {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				webDriver.quit();
			}
		}));
		webDriver.manage().window().maximize();
		return "maximize";
	}
}
