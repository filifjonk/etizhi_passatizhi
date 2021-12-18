import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.*;

public class vsetesti extends BASETESTKSUXA {
    private final static String URL = "https://www.ozon.ru/";

    private final SelenideElement searchButton = $x("//input[@name='text']");
    static final SelenideElement backToMainPage = $x("//img[@alt='Ozon']");

    private final SelenideElement changeCityButton = $x("//span[@class='ui-b4 ui-d7']//span[@class='ui-e7']");
    private final SelenideElement cities = $x("//div[@class='ui-y8']//input[@class=\"ui-f7 ui-g\"]");
    private final SelenideElement checkCity = $x("//span[@class='ui-b4 ui-d7']//span[@class='ui-e7']");
    private final SelenideElement hvalinsk = $x("//a[@class=\"a3i8\"]");
    private final SelenideElement promoInput = $x("//input[@class=\"ui-f7 ui-f9\"]");
    private final SelenideElement promoError = $x("//div[@class=\"d0c3\"]");



    @Test
    public void PromoCode(){
        //проверяю,что нельзя ввести промокод без авторизации
        Selenide.open(URL);
        promoInput.click();
        promoInput.setValue("121212");
        promoInput.sendKeys(Keys.ENTER);
        Assert.assertTrue(promoError.getText().contains("Вы не авторизованы"));

    }

    @Test
    public void search() {
        //поиск в каталоге
        Selenide.open(URL);
        searchButton.setValue("Зубная щетка");
        searchButton.sendKeys(Keys.ENTER);
        backToMainPage.click();
    }

    @Test
    public void change() {
        Selenide.open(URL);
    //меняю город на хвалынск
        changeCityButton.click();
        cities.sendKeys("Хвалынск");
        Selenide.sleep(7000);
        hvalinsk.click();
        Selenide.sleep(7000);
        System.out.println(checkCity.getText());
        Assert.assertTrue(checkCity.getText().contains("Хвалынск"));
    }
}