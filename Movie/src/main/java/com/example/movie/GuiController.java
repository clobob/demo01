package com.example.movie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class GuiController {

    public Pane home,ifAccount,signupPane,signIn,staffSigninPane;
    public Button homeCustBut, homeStaffBut,signInBut,signUpBut,guestBut,logInBut,registerBut,staffLoginBut,
            backTohomeBut,backToCusBut,backToHome2But,backToCus2But;
    public TextField usernameInput,passwordInput,suUserNaInput,suPwInput,suPwAgInput,staffUserNaInput,staffPWinput;


    public void switchPane(Pane pane){
        home.setVisible(false);
        ifAccount.setVisible(false);
        signupPane.setVisible(false);
        signIn.setVisible(false);
        staffSigninPane.setVisible(false);
        pane.setVisible(true);
    }
    public void clickHomeCusBut(ActionEvent actionEvent) {
        switchPane(ifAccount);
    }

    public void clickHomeStaffBut(ActionEvent actionEvent) {
        switchPane(staffSigninPane);
    }

    public void clickSignInBut(ActionEvent actionEvent) {
        switchPane(signIn);
    }

    public void clickSignUpBut(ActionEvent actionEvent) {
        switchPane(signupPane);
    }

    public void clickGuestBut(ActionEvent actionEvent) {
    }

    public void clickLogInBut(ActionEvent actionEvent) {
    }

    public void clickRegisterBut(ActionEvent actionEvent) {
    }

    public void clickStaffLoginBut(ActionEvent actionEvent) {
    }

    public void clickBackToHomeBut(ActionEvent actionEvent) {
        switchPane(home);
    }

    public void clickBackToCuBut(ActionEvent actionEvent) {
        switchPane(ifAccount);
    }

    public void clickBackToHome2But(ActionEvent actionEvent) {
        switchPane(home);
    }

    public void clickBackToCus2But(ActionEvent actionEvent) {
        switchPane(ifAccount);
    }
}