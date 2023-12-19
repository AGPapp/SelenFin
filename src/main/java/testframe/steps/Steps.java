package testframe.steps;
import io.cucumber.java.bg.И;
import testframe.managers.DriverManager;
import testframe.managers.PageManager;


public class Steps {
    final DriverManager driverManager = DriverManager.getDriverManager();
    final PageManager pageMan = PageManager.getPageManager();


    @И("Открыть браузер и развернуть на весь экран")
    public void запуск(){
        driverManager.getDriver().manage().window().maximize();
    }
    @И("Зайти на http://regard.ru")
    public void переход(){
        driverManager.getDriver().get("http://regard.ru");
    }


    @И("Открыть меню 'Каталог'")
    public void каталог() throws InterruptedException {
        pageMan.getStartPage().katalog();
    }
    @И("Выбрать раздел {string}")
    public void выборРаздела(String razdel){
        pageMan.getStartPage().selectPunktMenu(razdel);
    }
    @И("Выбрать подраздел {string}")
    public void выборПодраздела(String namePodmenu) throws InterruptedException {
        pageMan.getStartPage().selectPodmenu(namePodmenu);
    }
    @И("Задать параметр поиска по цене от {string} рублей")
    public void минЦена(String price){
        pageMan.getPoisk().sendMinPrice(price);
    }
    @И("Выбрать производителя {string}")
    public void производитель(String brend){
        pageMan.getPoisk().brend(brend);
    }
    @И("Дождаться выполнения поиска")
    public void ожиданиеПоиска(){
        pageMan.getPoisk().waitPoisk();
    }
    @И("Проверить, что в поисковой выдаче не более 24 товаров")
    public void выдача(){
        pageMan.getPoisk().vidacha();
    }
    @И("Сохранить наименование первого товара в списке")
    public void первыйТовар(){
        pageMan.getPoisk().nameFirstTovar();
    }
    @И("В поисковую строку ввести запомненное значение, выполнить поиск")
    public void новыйПоиск(){
        pageMan.getPoisk().enterPoisk();
    }
    @И("Проверить, что наименование товара соответствует сохраненному значению")
    public void сравнение(){
        pageMan.getPoisk().sravnenie();
    }
    @И("Проверить, что в поисковой выдаче не более 1 товара")
    public void резПоиска() throws InterruptedException {
        pageMan.getPoisk().naidenoTov();
    }



}
