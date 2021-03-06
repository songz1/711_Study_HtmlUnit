package com.example.study;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitTest_05 {
    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
        try {
            webClient.getOptions().setUseInsecureSSL(true);
            HtmlPage page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");

            HtmlForm form = page.getFormByName("");
            form.getInputByName("txtID").setValueAttribute("");
            form.getInputByName("txtPW").setValueAttribute("");

            HtmlPage homepage = form.getInputByName("ibtnLogin").click();
            String Stringpage = homepage.getWebResponse().getContentAsString();

            System.out.println("0: "+Stringpage);
            System.out.println("1: "+page.asText());

            HtmlPage page3 = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniMyMain.aspx");

            System.out.println("3: "+page3.asText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
    }
}
