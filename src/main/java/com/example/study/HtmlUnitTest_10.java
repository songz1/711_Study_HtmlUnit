package com.example.study;

import java.net.URL;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.*;

public class HtmlUnitTest_10 {
	static class Basic {
		IdPw idPw = new IdPw();
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
		final URL forestBaseUrl = new URL("https://forest.skhu.ac.kr");
		final URL loginPageUrl = new URL(forestBaseUrl + "/Gate/UniLogin.aspx");
		final URL mainPageUrl = new URL(forestBaseUrl + "/Gate/UniMyMain.aspx");

		public Basic() throws Exception {
			webClient.getOptions().setUseInsecureSSL(true);
			webClient.getOptions().setJavaScriptEnabled(false);
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

		HtmlPage test = frame2(mainPage);

		System.out.println(test.asXml());


//
//		HtmlPage an = anchor.click();
//		System.out.println("4: "+an.asXml());
	}

	static HtmlPage frame2(HtmlPage mainPage) throws Exception {
//		HtmlPage framePage2 = basic.getWebClient().getPage(basic.getForestBaseUrl() + "/Gate/UniMainOnestop.aspx");
		HtmlPage framePage2 = mainPage.getFrameByName("mainFrame").getEnclosingPage();
		System.out.println("2: " + framePage2.asXml());
		return frame3(framePage2);
	}

	static HtmlPage frame3(HtmlPage framePage2) throws Exception {
//		HtmlPage framePage3 = basic.getWebClient().getPage(basic.getForestBaseUrl() + "/Gate/UniLeftMenuOneStop.aspx");
		HtmlPage framePage3 = framePage2.getFrameByName("leftFrame").getEnclosingPage();
		System.out.println("3: " + framePage3.asXml());
		return menu(framePage3);
	}

	static HtmlPage menu(HtmlPage framePage3) throws Exception {
		List<HtmlAnchor> anchors = framePage3.getAnchors();
		HtmlAnchor link = null;
		for (HtmlAnchor anchor : anchors) {
			String str = anchor.asText();
			System.out.println("** " + str);
			if (anchor.asText().equals("웹서비스"))
				link = anchor;
		}
		HtmlPage webService = link.click();
		anchors = webService.getAnchors();
		for(HtmlAnchor anchor : anchors){
			String str = anchor.asText();
			System.out.println("** "+str);
			if (anchor.asText().equals("[N]시설물대여 신청"))
				link = anchor;
		}
		return link.click();
	}
}
