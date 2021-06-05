package com.ti.testcases;

import com.ti.pages.NavPage;
import com.ti.pages.StudentsPage;
import org.testng.annotations.Test;

public class TestClass extends BaseTest{

    @Test(priority = 1)
    void loginWithRightCredentials(){
        //Act
        loginPage
                .loginAs(userCredentials.get("username"))
                .withPassword(userCredentials.get("userpass"))
                .andRememberMe(true);

        //Instanciación de a página Nav
        //navPage = new NavPage();
        navPage = loginPage.login();

        //Assert
        loginPage.verySchoolName();
    }

    @Test(priority = 2)
    void createNewStudent(){
        //Act
        //studentsPage = new StudentsPage();
        //Instanciación de la página Students
        studentsPage = navPage.goToStudents();

        studentsPage.andCreateNew();

        studentsPage
                .genderAs(studentPersonalDetails[0])
                .withFirstName(studentPersonalDetails[1])
                .withLastName(studentPersonalDetails[2])
                .withDayOfBirth(studentPersonalDetails[3])
                .andCurrentAddress(studentPersonalDetails[4]);

        studentsPage
                .userEmail(studentAccountInfo.get("email"))
                .withUserName(studentAccountInfo.get("user"))
                .withPassword(studentAccountInfo.get("password"))
                .andConfirmPassword(studentAccountInfo.get("password"));

        studentsPage.schoolDetails("015");

        //Assert
        studentsPage.validateStudentIsAdded(studentPersonalDetails[1]);
    }

}
