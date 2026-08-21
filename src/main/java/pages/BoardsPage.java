package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BoardsPage extends BasePage {

    public BoardsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver,10),this);
    }

    @FindBy(xpath = "//button[@data-testid='create-board-tile']")
    WebElement btnCreateNewBoardTile;
    @FindBy(xpath = "//button[@data-testid='create-board-button']")
    WebElement btnCreateBoard;
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement btnSumbitCreate;

    public void clickBtnCreateNewBoardTile() {
        btnCreateNewBoardTile.click();
    }

    public void clickBtnCreateBoard() {
        clickWait(btnCreateBoard);
    }

    public void typeBoardTitle(Board board) {
        clickWait(inputBoardTitle);
        inputBoardTitle.sendKeys(board.getTitle());
    }

    public void clickBtnCreate() {
        btnSumbitCreate.click();
    }
}
