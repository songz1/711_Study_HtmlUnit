package com.example.study;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitTest_04 {
    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
        try {
            webClient.getOptions().setUseInsecureSSL(true);
            HtmlPage page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");

//            HtmlTextInput inputId = page.getFirstByXPath("//INPUT[@id='txtID']"); // ID 입력 필드
//            HtmlPasswordInput inputPassword = page.getFirstByXPath("//INPUT[@id='txtPW']"); // 암호 입력 필드
//            HtmlImageInput inputSubmit = page.getFirstByXPath("//INPUT[@id='txtID']"); // 로그인버튼
//            HtmlSubmitInput submitBtn = page.getFirstByXPath("//INPUT[@id='txtID']"); // 로그인버튼
//
//            inputId.setText(""); // ID 입력
//            inputPassword.setText(""); // 비밀번호 입력
//            inputSubmit.click(); // 로그인 버튼 클릭
//            page = submitBtn.click();

//            WebDriver driver = new HtmlUnitDriver(false);
//            WebElement pw = driver.findElement(By.id(inputId));
//            pw.sendKeys("9wldsl9^^");
//            pw.sendKeys(Keys.ENTER);

            System.out.println("1: "+page.asText());

            HtmlPage page2 = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniMyMain.aspx");

            System.out.println("2: "+page2.asText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
    }
}
