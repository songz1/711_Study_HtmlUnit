package com.example.study;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.net.URL;

public class HtmlUnitTest_04 {
    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
        try {
            webClient.getOptions().setUseInsecureSSL(true);
            HtmlPage page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");

            HtmlForm form = page.getFormByName("form1");
            form.getInputByName("txtID").setValueAttribute("201532020");
            HtmlInput passWordInput = form.getInputByName("9wldsl9^^");
            passWordInput.removeAttribute("txtPW");
            passWordInput.setValueAttribute("txtPW");

            page = form.getInputByValue("ibtnLogin").click(); // works fine

            System.out.println(page.asText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
    }
}
