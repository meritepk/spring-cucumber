package pk.merite.cucumber.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Page {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebDriver webDriver;
	@Value("${webdriver.wait.sleepInMillis:500}")
	private long sleepInMillis;
	@Value("${webdriver.wait.timeOutInSeconds:2500}")
	private long timeOutInMillis;

	public WebDriver webDriver() {
		return webDriver;
	}

	public WebDriverWait driverWait() {
		return driverWait(webDriver, timeOutInMillis, sleepInMillis);
	}

	public WebDriverWait driverWait(long timeOutInSeconds) {
		return driverWait(webDriver, timeOutInSeconds, sleepInMillis);
	}

	public WebDriverWait driverWait(long timeOutInSeconds, long sleepInMillis) {
		return driverWait(webDriver, timeOutInSeconds, sleepInMillis);
	}

	public WebDriverWait driverWait(WebDriver webDriver, long timeOutInSeconds, long sleepInMillis) {
		return new WebDriverWait(webDriver, Duration.ofMillis(timeOutInSeconds), Duration.ofMillis(sleepInMillis));
	}

	public ExpectedCondition<WebElement> elementBy(By locator) {
		return ExpectedConditions.presenceOfElementLocated(locator);
	}

	public void load(String url) {
		logger.debug("page load: " + url);
		webDriver().get(url);
	}

	public String title() {
		logger.debug("page title: " + webDriver().getTitle());
		return webDriver().getTitle();
	}

	public void visible(By locator) {
		logger.debug("page visible: " + locator);
		driverWait().until(elementBy(locator)).isDisplayed();
	}

	public void click(By locator) {
		logger.debug("page click: " + locator);
		driverWait().until(elementBy(locator)).click();
	}

	public void input(String text, By locator) {
		logger.debug("page input: " + locator + "; " + text);
		driverWait().until(elementBy(locator)).sendKeys(text);
	}

}
