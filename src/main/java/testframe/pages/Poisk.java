package testframe.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testframe.managers.Wait;

import java.util.List;

public class Poisk extends Wait {

    @FindBy(xpath = "//div[contains(@class,'RangeSelector_inputs__vjwDe' )]/input [@name='min']")
    private WebElement minPrice;
    @FindBy(xpath = "//li[@class='ListingFilters_item__5Dt_M']//span/span/label")
    private List<WebElement> proizvoditel;
    @FindBy(xpath = "//div[text()='Товаров на странице: ']/span")
    private WebElement tovNaStranice;

    @FindBy(xpath = "//div[contains(@class,\"ListingRenderer_row\")]//div[contains(@class,\"CardText_wrap\")]//div[@title]")
    private WebElement nameTovaraVidachi;
    @FindBy(xpath = "//input[@aria-label='Поиск']")
    private WebElement polePoisk;
    @FindBy(xpath = "//span[contains(@class, 'PageTitle_count')]")
    private WebElement naidenoTovarov;
    @FindBy(xpath = "//div[@class=\"ListingFilters_filterMeta__nF_BZ\"]")
    private WebElement waitPoisk;

    public Poisk  sendMinPrice (String min) {
        waitVisibilityOfElement(minPrice).sendKeys(min);
        return this;
    }
    public Poisk  brend (String nameBrend) {
        for (WebElement element : proizvoditel) {
            if (element.getText().equals(nameBrend)) {
                element.click();
            }
        }
        return this;
    }
    public Poisk waitPoisk(){
        waitVisibilityOfElement(waitPoisk).isDisplayed();

        return this;
    }

    String tovOnPagetext;
    public String tovOnPage() {

        tovOnPagetext =  tovNaStranice.getText();
        return tovOnPagetext;
    }
    public Poisk vidacha(){
        tovOnPage();
        Assert.assertEquals("по 24",tovOnPagetext);
        return this;
    }

    String nameTovara;

    public String nameFirstTovar(){
        waitVisibilityOfElement(nameTovaraVidachi);
        nameTovara = nameTovaraVidachi.getText();
        return nameTovara;
    }

    public Poisk enterPoisk(){
        polePoisk.sendKeys(nameTovara+"\n");

        return this;
    }

    public  Poisk naidenoTov () throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("1 товар",naidenoTovarov.getText());
        return this;
    }
    public Poisk sravnenie (){
        Assert.assertEquals(nameTovara,nameTovaraVidachi.getText());
        return this;
    }


}

