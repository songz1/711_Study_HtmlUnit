package com.example.study;

import java.lang.Object;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.gargoylesoftware.htmlunit.WebClient;


import java.net.URL;
import java.util.ArrayList;

/*
 *
 * @author vishal.khokhar
 */
public class HtmlUnitTest_02 {

    public static void main(String[] args) {
//        new HtmlUnitTest_02().doLoginMethodOne();
//        new HtmlUnitTest_02().doLoginMethodSecond();
        new HtmlUnitTest_02().doLoginMethodThird();


    }


    public static String getPageSource(Page page) {
        if (page instanceof HtmlPage) {
            return ((HtmlPage) page).asXml();
        }
//        else if(page instanceof Javascript)
//        {
//            return ((JavaScriptPage)page).getContent();
//        }
        else if (page instanceof TextPage) {
            return ((TextPage) page).getContent();
        } else //page instanceof UnexpectedPage
        {
            return ((UnexpectedPage) page).getWebResponse().getContentAsString();
        }
    }

    /*
    private void doLoginMethodOne() {
        try {
            String username = "";
            String password = "";

//            WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_11);
            WebClient webClient = new WebClient();

            // for local testing
            ProxyConfig proxyConfig = new ProxyConfig();
            proxyConfig.setProxyHost("127.0.0.1");
            proxyConfig.setProxyPort(8080);
            webClient.getOptions().setProxyConfig(proxyConfig);

            webClient.getOptions().setPrintContentOnFailingStatusCode(false);
            webClient.getOptions().setUseInsecureSSL(true);
            webClient.getOptions().setRedirectEnabled(true);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getOptions().setJavaScriptEnabled(false);

            // 사이트 URL 설정
//            Page pageSource = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");
//            String pageSourceString = getPageSource(pageSource);

            HtmlPage page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");
//            HtmlPage page = (HtmlPage)pageSourceString;
            HtmlForm form = page.getFormByName("form1");
            form.getInputByName("txtID").setValueAttribute(username);
            form.getInputByName("txtPW").setValueAttribute(password);

            HtmlPage homepage = form.getInputByValue("ibtnLogin").click();
            String Stringpage = homepage.getWebResponse().getContentAsString();

            System.out.println(Stringpage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    */

/*
    private void doLoginMethodSecond() {
        try {
            String id = "";
            String pw = "";

            WebClient webClient = new WebClient();

            // for local testing
            ProxyConfig proxyConfig = new ProxyConfig();
            proxyConfig.setProxyHost("127.0.0.1");
            proxyConfig.setProxyPort(8080);
            webClient.getOptions().setProxyConfig(proxyConfig);

            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getOptions().setJavaScriptEnabled(false);

            // 귀하의 사이트 URL을 설정하십시오.
            WebRequest webRequest = new WebRequest(new URL("https://forest.skhu.ac.kr/Gate/UniLogin.aspx"), HttpMethod.POST);

            webRequest.setRequestParameters(new ArrayList<NameValuePair>());
            webRequest.getRequestParameters().add(new NameValuePair("txtID", id));
            webRequest.getRequestParameters().add(new NameValuePair("txtPW", pw));
            webRequest.getRequestParameters().add(new NameValuePair("jsessionid", "934179CEDE3B37016895C94ADF0D953D"));
            webRequest.getRequestParameters().add(new NameValuePair("submit", "ibtnLogin"));

            HtmlPage homepage = webClient.getPage(webRequest);
            String Stringpage = homepage.getWebResponse().getContentAsString();

            System.out.println(Stringpage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
*/

    private void doLoginMethodThird() {
        try {
            String id = "";
            String pw = "";

            WebClient webClient = new WebClient();

            // for local testing
            ProxyConfig proxyConfig = new ProxyConfig();
            proxyConfig.setProxyHost("127.0.0.1");
            proxyConfig.setProxyPort(8080);
            webClient.getOptions().setProxyConfig(proxyConfig);

            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getOptions().setJavaScriptEnabled(false);

            // 사이트 URL 설정
            Page page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");
            WebResponse response = page.getWebResponse();
            String content = response.getContentAsString();

//            HtmlForm form = content.getFormByName("loginform");
//            form.getInputByName("사용자 이름").setValueAttribute(사용자 이름);
//            HtmlInput passWordInput = form.getInputByName("password");
//            passWordInput.removeAttribute("disabled");
//            passWordInput.setValueAttribute("userPassword");

//            page = form.getInputByValue("login").click();
//            String Stringpage = page.getWebResponse().getContentAsString();

            System.out.println("11 " + content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
