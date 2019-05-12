package com.example.study;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;

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
			CookieManager cm = webClient.getCookieManager();
			cm.clearCookies();

			HtmlForm loginForm = loginPage.getFormByName("");
			loginForm.getInputByName("txtID").setValueAttribute(idPw.getId());
			loginForm.getInputByName("txtPW").setValueAttribute(idPw.getPw());
			HtmlPage mainPage = loginForm.getInputByName("ibtnLogin").click();

			Cookie authCookie = cm.getCookie(".AuthCookie");
			Cookie uniCookie = cm.getCookie("UniCookie");
			cm.addCookie(authCookie);
			cm.addCookie(uniCookie);
			System.out.println("@@@@@@@");
			System.out.println(cm.getCookies());




			if(mainPageUrl.equals(mainPage.getBaseURL())) {
				HtmlPage rentPage = webClient.getPage(rentPageUrl);
				System.out.println("** good!");
//				HtmlElement building = (HtmlElement) rentPage.getElementById("gv건물목록_ctl02_btnSelect");
//				HtmlPage page = building.click();

//				HtmlPage page = rentPage.getHtmlElementById("gv건물목록_ctl02_btnSelect").click();
//				System.out.println("$$$$$$$$"+page);

//
//				HtmlTable table = rentPage.getHtmlElementById("gv건물목록");
//				String a = table.asXml();
//				System.out.println(a);
//				System.out.println("^^^^^");
//
//				for(HtmlTableRow row : table.getRows()){
//					System.out.println("Found row");
//					for(HtmlTableCell cell : row.getCells()){
//						System.out.println("	Found cell: "+cell.asText());
//					}
//				}


			}


		} catch (MalformedURLException e) {

		} catch (IOException i) {

		}catch(ElementNotFoundException e){

		}
	}
}
