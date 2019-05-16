package com.example.study;

import java.net.URL;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
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

		HtmlElement frameset1 = mainPage.getBody();
		DomNode node = frameset1.getLastChild().getPreviousSibling();
		HtmlFrame fr1 = (HtmlFrame) node;
		FrameWindow fw1 = (FrameWindow) fr1.getEnclosedWindow();
		HtmlPage p1 = (HtmlPage) fw1.getEnclosedPage();
//		System.out.println("p1 "+p1.asXml());

		HtmlElement frameset2 = p1.getBody();
		DomNode node2 = frameset2.getFirstChild().getNextSibling();
		HtmlFrame fr2 = (HtmlFrame) node2;
		FrameWindow fw2 = (FrameWindow) fr2.getEnclosedWindow();
		HtmlPage p2 = (HtmlPage) fw2.getEnclosedPage();
		System.out.println("p2 "+p2.asXml());


//div[@class='MenuDiv']/span[@id='menu']/table/tbody/tr[3]/td/span[@class='leftmenu2']/a


//		HtmlPage test = frame2(basic, mainPage);
//		System.out.println(test.asXml());


	}

	static HtmlPage frame2(Basic basic, HtmlPage mainPage) throws Exception {
		HtmlPage framePage2 = basic.getWebClient().getPage(basic.getForestBaseUrl() + "/Gate/UniMainOnestop.aspx");
//		HtmlPage framePage2 = mainPage.getFrameByName("mainFrame").getEnclosingPage();

		System.out.println("2: " + framePage2.asXml());
		return frame3(basic, framePage2).getFrameByName("mainFrame").getEnclosingPage();
	}

	static HtmlPage frame3(Basic basic, HtmlPage framePage2) throws Exception {
		HtmlPage framePage3 = basic.getWebClient().getPage(basic.getForestBaseUrl() + "/Gate/UniLeftMenuOneStop.aspx");
//		HtmlPage framePage3 = framePage2.getFrameByName("leftFrame").getEnclosingPage();
		System.out.println("3: " + framePage3.asXml());
		return menu(framePage3).getFrameByName("leftFrame").getEnclosingPage();
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
		HtmlPage webService = (HtmlPage)link.click().getEnclosingWindow().getTopWindow().getEnclosedPage();
		anchors = webService.getAnchors();
		for(HtmlAnchor anchor : anchors){
			String str = anchor.asText();
			System.out.println("** "+str);
			if (anchor.asText().equals("[N]시설물대여 신청"))
				link = anchor;
		}
		return (HtmlPage)link.click().getEnclosingWindow().getTopWindow().getEnclosedPage();
	}
}