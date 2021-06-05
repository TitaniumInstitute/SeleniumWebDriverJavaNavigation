package com.ti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavPage extends MainPage{

    @FindBy(linkText = "Students")
    private WebElement navStudents;

    public StudentsPage goToStudents(){
        navStudents.click();
        preLoading();
        return new StudentsPage();
    }
}
