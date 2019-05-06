package com.example.study;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitTest_08 {
	public static void main(String[] args) {
		IdPw idPw = new IdPw();
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
		try {
			final URL forestBaseUrl = new URL("https://forest.skhu.ac.kr");
			final URL loginPageUrl = new URL(forestBaseUrl + "/Gate/UniLogin.aspx");
			final URL mainPageUrl = new URL(forestBaseUrl + "/Gate/UniMyMain.aspx");
			final URL rentPageUrl = new URL(forestBaseUrl + "/Gate/SAM/Lesson/G/SSEG20P.aspx");

			webClient.getOptions().setUseInsecureSSL(true);
			HtmlPage loginPage = webClient.getPage(loginPageUrl);

			HtmlForm loginForm = loginPage.getFormByName("");
			loginForm.getInputByName("txtID").setValueAttribute(idPw.getId());
			loginForm.getInputByName("txtPW").setValueAttribute(idPw.getPw());
			HtmlPage mainPage = loginForm.getInputByName("ibtnLogin").click();

			if(mainPageUrl.equals(mainPage.getBaseURL())) {
				System.out.println("** good!");
				HtmlPage rentPage = webClient.getPage(rentPageUrl);
				
			}


		} catch (MalformedURLException e) {

		} catch (IOException i) {

		}
	}
}
