package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import static utils.PropertiesReader.getProperty;

public class BoardsTests extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod
    public void login() {
        new HomePage(getDriver()).clickLinkLogin();
        User user = User.builder()
                .email(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        new LoginPage(getDriver()).typeLoginForm(user);
        boardsPage = new BoardsPage(getDriver());
    }

    @Test
    public void createNewBoardPositiveTest() {
        Board board = Board.builder()
                .title("My first board")
                .build();
        boardsPage.clickBtnCreateNewBoardTile();
        boardsPage.clickBtnCreateBoard();
        boardsPage.typeBoardTitle(board);
        boardsPage.clickBtnCreate();
    }
}
