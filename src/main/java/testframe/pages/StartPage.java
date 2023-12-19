package testframe.pages;

import org.junit.Assert;
//import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testframe.managers.Wait;

import java.util.List;


public class StartPage extends Wait {

    @FindBy(xpath = "//span[text()='Каталог']")
    private WebElement menuKatalog;
    @FindBy(xpath = "//div[@class='Catalog_mainCategoryName__xzGxz']")
    private List<WebElement> punktMenuKatalog;

    @FindBy(xpath = "//p[contains(@class, 'CardCategory_title')]")
    private List<WebElement> podmenuKatalog;

    public StartPage katalog () throws InterruptedException {
        Thread.sleep(1000);
        waitClickability(menuKatalog);
        menuKatalog.click();
        return this;
    }
    //  ЭТО КОМПЛЕКТУБЮЩИЕ
    public StartPage selectPunktMenu(String nameMenu){
        for (WebElement element : punktMenuKatalog) {
            if (element.getText().equals(nameMenu)) {
                element.click();
                return this;
            }
        }
        Assert.fail( nameMenu + " не найдено");
        return this;
    }
    // ЭТО ПОДКАТЕГОРИИ
    public StartPage selectPodmenu(String namePodmenu) throws InterruptedException {
        Thread.sleep(1000);  // Ни в какую не удалось выполнить поиск без этой паузы
        // WebElement podmenuKatalog = driverManager.getDriver().findElement(By.xpath("//p[contains(@class, 'CardCategory_title') and text()=\""+namePodmenu+"\"]"));

        for (WebElement element : podmenuKatalog){
            if (element.getText().contains(namePodmenu)) {
                waitClickability(element).click();
                return this;
            }
        }
        Assert.fail( namePodmenu + " не найдено");
        return this;

    }
}







