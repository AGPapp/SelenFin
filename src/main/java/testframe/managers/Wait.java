package testframe.managers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    protected DriverManager driverManager = DriverManager.getDriverManager();

    protected PageManager pageManager = PageManager.getPageManager();

    WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 30, 1000 );

    public Wait() {
        PageFactory.initElements(driverManager.getDriver(),this);
    }
    protected WebElement waitClickability (WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
//    protected WebElement wait(WebElement loka){
//        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='CardCategory_wrap__JQAjO']//p[text()=\"Видеокарты\"]")));
//
//    }

}
