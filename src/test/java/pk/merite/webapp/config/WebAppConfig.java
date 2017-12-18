package pk.merite.webapp.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebAppConfig {

    @Bean(name = "webDriver", destroyMethod = "quit")
    @ConditionalOnMissingBean(name = "webDriver")
    public WebDriver webDriver(@Value("${webdriver.browser:chrome}") String browser,
        @Value("${webdriver.location:/tmp/chromedriver.exe}") String location) {
        RemoteWebDriver driver = null;
        if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", location);
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver", location);
            driver = new FirefoxDriver();
        } else if ("edge".equals(browser)) {
            System.setProperty("webdriver.edge.driver", location);
            driver = new EdgeDriver();
        } else if ("iexplorer".equals(browser)) {
            System.setProperty("webdriver.ie.driver", location);
            driver = new InternetExplorerDriver();
        } else if ("safari".equals(browser)) {
            driver = new SafariDriver();
        } else if ("opera".equals(browser)) {
            System.setProperty("webdriver.opera.driver", location);
            driver = new OperaDriver();
        }
        return new EventFiringWebDriver(driver);
    }

    @Autowired
    public void maximize(WebDriver webDriver) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                webDriver.quit();
            }
        }));
        webDriver.manage().window().maximize();
    }
}
