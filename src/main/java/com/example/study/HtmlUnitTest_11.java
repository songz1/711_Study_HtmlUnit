package com.example.study;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HtmlUnitTest_11 {
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
		Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);//error -> log
		Basic basic = new Basic();
		HtmlPage loginPage = basic.getWebClient().getPage(basic.getLoginPageUrl());

		HtmlForm loginForm = loginPage.getFormByName("");
		loginForm.getInputByName("txtID").setValueAttribute(basic.getIdPw().getId());
		loginForm.getInputByName("txtPW").setValueAttribute(basic.getIdPw().getPw());

		HtmlPage mainPage = loginForm.getInputByName("ibtnLogin").click();
		/*System.out.println("main: " + mainPage.asXml());*/

		HtmlElement frameset0 = mainPage.getBody();
		DomNode node0 = frameset0.getLastChild().getPreviousSibling();
		HtmlFrame fr0 = (HtmlFrame) node0;
		FrameWindow fw0 = (FrameWindow) fr0.getEnclosedWindow();
		HtmlPage p0 = (HtmlPage) fw0.getEnclosedPage();
		/*System.out.println("p0 "+p0.asXml());*/

		frame1(mainPage);

		HtmlElement frameset01 = p0.getBody();
		DomNode node01 = frameset01.getLastChild().getPreviousSibling();
		HtmlFrame fr01 = (HtmlFrame) node01;
		FrameWindow fw01 = (FrameWindow) fr01.getEnclosedWindow();
		HtmlPage p01 = (HtmlPage) fw01.getEnclosedPage();
		/*System.out.println("p01 " + p01.asXml());*/

/*      HtmlElement son;
      son= (HtmlElement) p01.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[1]").get(1);
      System.out.println(son.asText());

      List<?> buildingClik = p01.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]");

      *//*buildingClik.get(1).click();*//*
      System.out.println(buildingClik.get(1));
      *//*System.out.println("p01 " + p01.asXml());*/
		System.out.println("건물 목록");
		List<HtmlElement> buildingList1;
		buildingList1 = p01.getByXPath("//table[@id='gv건물목록']/tbody/tr[@class='cssRowStyle']/td[1]");

		List<HtmlElement> buildingList2;
		buildingList2 = p01.getByXPath("//table[@id='gv건물목록']/tbody/tr[@class='cssAlternatingRowStyle']/td[1]");

		System.out.println("*******************************************");
		int count = 0;
		for (int j = 0; j < (buildingList1.size() + buildingList2.size()); j++) {
			if (count % 2 == 0) {
				System.out.println(buildingList1.get(j).asText());
				++count;
			} else {
				--j;
				System.out.println(buildingList2.get(j).asText());
				++count;
			}
			/*System.out.println(check);*/
			if (count == 10) {
				break;
			}
		}
		HtmlAnchor link = null;
		List<HtmlAnchor> anchors = p01.getAnchors();
		for (HtmlAnchor anchor : anchors) {
			String str = anchor.getId();
			/*System.out.println("&(*) " + str);*/
			if (anchor.getId().equals("gv건물목록_ctl02_btnSelect")) {
				/*System.out.println("input ");*/
				link = anchor;
			}
		}
		/*System.out.println("link: "+link);*/
		HtmlPage test = link.click();
		Thread.sleep(3_000);
		/*System.out.println("test " + test.asXml());*/
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("시설물 대여 강의실 목록");
		List<HtmlElement> classroomList1;
		classroomList1 = test.getByXPath("//table[@id='gv시설목록']/tbody/tr[@class='cssRowStyle']/td[1]");
		List<HtmlElement> classroomListNum1;
		classroomListNum1 = test.getByXPath("//table[@id='gv시설목록']/tbody/tr[@class='cssRowStyle']/td[3]");

		List<HtmlElement> classroomList2;
		classroomList2 = test.getByXPath("//table[@id='gv시설목록']/tbody/tr[@class='cssAlternatingRowStyle']/td[1]");
		List<HtmlElement> classroomListNum2;
		classroomListNum2 = test.getByXPath("//table[@id='gv시설목록']/tbody/tr[@class='cssAlternatingRowStyle']/td[3]");

		System.out.println("*******************************************");
		int check = 0;
		for (int j = 0; j < (classroomList2.size() + classroomList1.size()); j++) {
			if (check % 2 == 0) {
				System.out.println(classroomList1.get(j).asText() + " 인원수 :" + classroomListNum1.get(j).asText());
				++check;
			} else {
				--j;
				System.out.println(classroomList2.get(j).asText() + " 인원수 :" + classroomListNum2.get(j).asText());
				++check;
			}
			/*System.out.println(check);*/
			if (check == 10) {
				break;
			}
		}
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("시설물 대여 강의실 1406를 선택해 보자");
		System.out.println();
		HtmlAnchor link2 = null;
		List<HtmlAnchor> anchors2 = test.getAnchors();
		for (HtmlAnchor anchor : anchors2) {
			String str = anchor.getId();
			/*System.out.println("&(*) " + str);*/
			if (anchor.getId().equals("gv시설목록_ctl02_btnSelect")) {
				/*System.out.println("input ");*/
				link2 = anchor;
			}
		}
		/*System.out.println("link2 "+link2);*/
		HtmlPage test2 = link2.click();
		Thread.sleep(3_000);
		/*System.out.println("test2 " + test2.asXml());*/
		List<HtmlElement> approveList;
		approveList = test2.getByXPath("//table[@id='gv시설대여현황']/tbody/tr[@class='cssRowStyle']/td[1]");
		List<HtmlElement> approveTimeList;
		approveTimeList = test2.getByXPath("//table[@id='gv시설대여현황']/tbody/tr[@class='cssRowStyle']/td[2]");
		for (int k = 0; k < approveList.size(); k++) {
			System.out.println(" 대여상태 : " + approveList.get(k).asText() + "    대여시간 :" + approveTimeList.get(k).asText());
		}

	}

	static void frame1(HtmlPage mainPage) throws Exception {
		HtmlElement frameset1 = mainPage.getBody();
		DomNode node = frameset1.getLastChild().getPreviousSibling();
		HtmlFrame fr1 = (HtmlFrame) node;
		FrameWindow fw1 = (FrameWindow) fr1.getEnclosedWindow();
		HtmlPage p1 = (HtmlPage) fw1.getEnclosedPage();
		/*System.out.println("p1 "+p1.asXml());*/
		frame2(p1);

		return;
	}

	static void frame2(HtmlPage p1) throws Exception {
		HtmlElement frameset2 = p1.getBody();
		DomNode node2 = frameset2.getFirstChild().getNextSibling();
		HtmlFrame fr2 = (HtmlFrame) node2;
		FrameWindow fw2 = (FrameWindow) fr2.getEnclosedWindow();
		HtmlPage p2 = (HtmlPage) fw2.getEnclosedPage();
		/*System.out.println("p2 " + p2.asXml());*/
		menu(p2);

		return;
	}

	static void menu(HtmlPage p2) throws Exception {
		HtmlAnchor menu0 = p2.getAnchorByText("웹서비스");
		p2 = menu0.click();
		/*System.out.println("p22 " + p2.asXml());*/

		HtmlAnchor menu2 = p2.getAnchorByText("[N]시설물대여 신청");
		menu2.click();
		return;
	}


}
