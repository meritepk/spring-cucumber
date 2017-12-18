package pk.merite.webapp.pages.search;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import pk.merite.webapp.pages.Page;

@Component
public class SearchPage extends Page {

    @Value("${search.page.url}")
    private String url;
    @Value("${search.page.txt-search.xpath}")
    private String txtSearchXpath;
    @Value("${search.page.btn-search.xpath}")
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
