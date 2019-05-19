package com.example.study;

import java.net.URL;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import net.sourceforge.htmlunit.corejs.javascript.Node;

public class HtmlUnitTest_10 {
	static class Basic {
		IdPw idPw = new IdPw();
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
		final URL forestBaseUrl = new URL("https://forest.skhu.ac.kr");
		final URL loginPageUrl = new URL(forestBaseUrl + "/Gate/UniLogin.aspx");
		final URL mainPageUrl = new URL(forestBaseUrl + "/Gate/UniMyMain.aspx");

		public Basic() throws Exception {
			webClient.getOptions().setUseInsecureSSL(true);
			webClient.getOptions().setJavaScriptEnabled(true);
			webClient.getOptions().setCssEnabled(false);
		}

		public IdPw getIdPw() {
			return idPw;
		}

		public void setIdPw(IdPw idPw) {
			this.idPw = idPw;
		}

		public WebClient getWebClient() {
			return webClient;
		}

		public void setWebClient(WebClient webClient) {
			this.webClient = webClient;
		}

		public URL getForestBaseUrl() {
			return forestBaseUrl;
		}

		public URL getLoginPageUrl() {
			return loginPageUrl;
		}

		public URL getMainPageUrl() {
			return mainPageUrl;
		}
	}

	public static void main(String[] args) throws Exception {
		Basic basic = new Basic();
		HtmlPage loginPage = basic.getWebClient().getPage(basic.getLoginPageUrl());

		HtmlForm loginForm = loginPage.getFormByName("");
		loginForm.getInputByName("txtID").setValueAttribute(basic.getIdPw().getId());
		loginForm.getInputByName("txtPW").setValueAttribute(basic.getIdPw().getPw());

		HtmlPage mainPage = loginForm.getInputByName("ibtnLogin").click();
		System.out.println("main: " + mainPage.asXml());

		HtmlElement frameset0 = mainPage.getBody();
		DomNode node0 = frameset0.getLastChild().getPreviousSibling();
		HtmlFrame fr0 = (HtmlFrame) node0;
		FrameWindow fw0 = (FrameWindow) fr0.getEnclosedWindow();
		HtmlPage p0 = (HtmlPage) fw0.getEnclosedPage();
		System.out.println("p0 "+p0.asXml());

		frame1(mainPage);

		HtmlElement frameset01 = p0.getBody();
		DomNode node01 = frameset01.getLastChild().getPreviousSibling();
		HtmlFrame fr01 = (HtmlFrame) node01;
		FrameWindow fw01 = (FrameWindow) fr01.getEnclosedWindow();
		HtmlPage p01 = (HtmlPage) fw01.getEnclosedPage();
		System.out.println("p01 " + p01.asXml());

//		HtmlAnchor a0 = p01.getAnchorByHref("javascript:__doPostBack('gv건물목록$ctl02$btnSelect','')");
//		HtmlPage test = a0.click();
//		System.out.println("test " + test.asXml());
		HtmlAnchor link = null;
		List<HtmlAnchor> anchors = p01.getAnchors();
		for (HtmlAnchor anchor : anchors) {
			String str = anchor.getId();
			System.out.println("&(*) " + str);
			if (anchor.getId().equals("gv건물목록_ctl02_btnSelect")) {
				System.out.println("input ");
				link = anchor;
			}
		}
		System.out.println("link: "+link);
		HtmlPage test = link.click();
		Thread.sleep(3_000);
		System.out.println("test " + test.asXml());

	}

	static void frame1(HtmlPage mainPage) throws Exception {
		HtmlElement frameset1 = mainPage.getBody();
		DomNode node = frameset1.getLastChild().getPreviousSibling();
		HtmlFrame fr1 = (HtmlFrame) node;
		FrameWindow fw1 = (FrameWindow) fr1.getEnclosedWindow();
		HtmlPage p1 = (HtmlPage) fw1.getEnclosedPage();
		System.out.println("p1 "+p1.asXml());
		frame2(p1);

		return ;
	}

	static void frame2(HtmlPage p1) throws Exception {
		HtmlElement frameset2 = p1.getBody();
		DomNode node2 = frameset2.getFirstChild().getNextSibling();
		HtmlFrame fr2 = (HtmlFrame) node2;
		FrameWindow fw2 = (FrameWindow) fr2.getEnclosedWindow();
		HtmlPage p2 = (HtmlPage) fw2.getEnclosedPage();
		System.out.println("p2 " + p2.asXml());
		menu(p2);

		return ;
	}

	static void menu(HtmlPage p2) throws Exception {
		HtmlAnchor menu0 = p2.getAnchorByText("웹서비스");
		p2 = menu0.click();
		System.out.println("p22 " + p2.asXml());

		HtmlAnchor menu2 = p2.getAnchorByText("[N]시설물대여 신청");
		menu2.click();

		return ;
	}
}
