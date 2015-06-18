package page_object.base;


import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps {

    protected WebDriver driver;

    public AbstractSteps(WebDriver driver) {
        this.driver = driver;
    }

}
