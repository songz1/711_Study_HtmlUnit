package com.example.study;

import java.net.URL;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import static com.gargoylesoftware.htmlunit.util.UrlUtils.normalize;

public class HtmlUnitTest_06 {
    public static void main(String[] args) {
        IdPw idPw = new IdPw();
        WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
        try {
            webClient.getOptions().setUseInsecureSSL(true);
            HtmlPage page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");

            HtmlForm form = page.getFormByName("");
            form.getInputByName("txtID").setValueAttribute(idPw.getId());
            form.getInputByName("txtPW").setValueAttribute(idPw.getPw());

            HtmlPage homepage = form.getInputByName("ibtnLogin").click();
            System.out.println("===========================TEST 1===========================");
//            System.out.println(page.asText());

            System.out.println(homepage.asXml());
//            HtmlPage page2 = webClient.getPage("https://forest.skhu.ac.kr/Gate/SAM/Lesson/G/SSEG20P.aspx?&maincd=O&systemcd=S&seq=100");
//            System.out.println("===========================TEST 2===========================");
//            System.out.println(page2.asText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
    }
}
