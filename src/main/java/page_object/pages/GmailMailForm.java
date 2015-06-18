package page_object.pages;


import org.openqa.selenium.support.FindBy;
import page_object.constants_containers.XpathContainer;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class GmailMailForm extends HtmlElement {
    
    @FindBy(xpath = XpathContainer.GmailComposeMailForm.COMPOSE_FORM_TO_XPATH)
    private TextInput toField;
    
    @FindBy(xpath = XpathContainer.GmailComposeMailForm.COMPOSE_FORM_SUBJ_XPATH)
    private TextInput subjField;
    
    @FindBy(xpath = XpathContainer.GmailComposeMailForm.COMPOSE_FORM_TEXT_XPATH)
    private TextInput textField;

    @FindBy(xpath = XpathContainer.GmailComposeMailForm.COMPOSE_FORM_SENDBTN_XPATH)
    private Button sendBtn;

    @FindBy(xpath = XpathContainer.GmailComposeMailForm.ATTACH_FILE_BUTTON_XPATH)
    private Button attachFileBtn;

    public TextInput getToField() {
        return toField;
    }

    public TextInput getSubjField() {
        return subjField;
    }

    public TextInput getTextField() {
        return textField;
    }

    public void composeMailAndSend(String email, String subject, String text) {
        toField.sendKeys(email);
        subjField.sendKeys(subject);
        textField.sendKeys(text);
        sendBtn.click();
    }

    public void composeMailWithAttchAndSend(String email, String subject, String text, String filePath) {
        toField.sendKeys(email);
        subjField.sendKeys(subject);
        textField.sendKeys(text);
        attachFileBtn.click();
        uploadFile(filePath);
        sendBtn.click();
    }

    private void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    private void uploadFile(String fileLocation) {
        try {
            setClipboardData(fileLocation);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
