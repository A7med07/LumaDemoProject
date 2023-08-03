package Pages;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Search  {
    protected By searchField= By.name("q");
    protected By toolBar= By.cssSelector(".toolbar.toolbar-products");
    protected By searchResult= By.className("base");
    protected By Result= By.xpath("//div[@class='search results']");
    protected By sorter_options= By.cssSelector("select[id=\"sorter\"]");
    protected By listMode= By.xpath("//*[@id=\"mode-list\"]");
    private WebDriver driver;

    public Search(WebDriver driver) {
        this.driver = driver;
    }
    public void setSearchField(String text) {
        (new ElementActions(driver)).waitToBeReady(searchField).type(searchField,text).
                keyPress(searchField, Keys.ENTER);
    }

    public By getListMode() {
        driver.findElement(listMode).click();
        return listMode;
    }

    public By getSearchResult() {
        ElementActions.getInstance().getText(searchResult);
        return searchResult;
    }

    private Select selectSorter_options(){
        return new Select(driver.findElement(sorter_options));
    }
    public void selectFromSorter_options(String option){
        selectSorter_options().selectByValue(option);
        ElementActions.getInstance().captureScreenshot(sorter_options);
    }

    public By getResult() {
        ElementActions.getInstance().waitToBeReady(Result).scrollToElement(Result);
        return Result;
    }
}
