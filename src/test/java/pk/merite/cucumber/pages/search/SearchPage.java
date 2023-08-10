package pk.merite.cucumber.pages.search;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import pk.merite.cucumber.pages.Page;

@Component
public class SearchPage extends Page {

    @Value("${page.search.url}")
    private String url;
    @Value("${page.search.txt-search.xpath}")
    private String txtSearchXpath;
    @Value("${page.search.btn-search.xpath}")
    private String btnSearchXpath;

    public void load() {
        load(url);
        visible(By.xpath(txtSearchXpath));
    }

    public void enterSearchText(String text) {
        input(text, By.xpath(txtSearchXpath));
    }

    public void clickSearch() {
        click(By.xpath(btnSearchXpath));
    }
}
