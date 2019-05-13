package com.example.study;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

public class HtmlUnitTest_09 {
	public static void main(String[] args)  throws Exception, FailingHttpStatusCodeException, MalformedURLException, IOException {
		HtmlPage  framePage1,framePage2;

		HtmlElement buildingTable,lectreRoomTable;
		HtmlElement button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;

		String s;

		Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);//error -> log
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);

		//로그인
		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false);
		HtmlPage page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");
		HtmlForm form = page.getFormByName("");
		form.getInputByName("txtID").setValueAttribute("");
		form.getInputByName("txtPW").setValueAttribute("");
		HtmlPage homepage = form.getInputByName("ibtnLogin").click();
		System.out.println("Login Success");

		//시설물 대여 페이지로
		HtmlPage page2 = webClient.getPage("https://forest.skhu.ac.kr/Gate/SAM/Lesson/G/SSEG20P.aspx?maincd=0&systemcd=S&seq=100");
		System.out.println("Rent Page");
		/* Thread.sleep(3_000);*/

		//건물 조회 table 찾기
		/*framePage2 = (HtmlPage)page.getFrameByName("mainFrame").getEnclosedPage();//find a frame 'rightFrame'*/
//         framePage1 = (HtmlPage)page.getFrameByName("contentFrame").getEnclosedPage();//find a frame 'rightFrame'
		System.out.println("Building Table");
   /*   HtmlPage work;
      work = page2.getFrameByName("mainFrame").getEnclosingPage();*/
      /*List<?> list;
      list= (List<?>)work.getByXPath("/table[@class='gridForm']/");//프레임내에 테이블 이름이 같은게 있기때문에 XPath로 찾는다.*/

		HtmlElement son;
//		son= (HtmlElement) page2.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]").get(0);
//		System.out.println(son.asText());
		son = (HtmlElement) page2.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]").get(0);

		HtmlAnchor a = (HtmlAnchor)page2.getElementById("gv건물목록_ctl02_btnSelect");
		HtmlPage pp = a.click();
		System.out.println(pp.asText());
		/*list= (List<?>)work.getByXPath("//div[@id='upContents']/div[@id='divContainer']/div[@id='divBody']/div[@id='divBuildList']/table[@class='gridForm']")*/
		/*List<DomElement> classs = page2.getElementsByName("tr");*/
		/*   List<DomElement> trs = page2.getElementsByName("tr"); // -- 11개 있음
		 *//*HtmlOption o = ((HtmlSelect)classs.get(0)).getOption(11);*//*

      for(DomElement e : trs){
         *//*if(e.getAttribute("class").indexOf("row")>0){*//*
         List<HtmlElement> tds = e.getElementsByTagName("td");
         char f=0, t=0;
         System.out.print(tds.get(0).asText()+"+"+tds.get(1).asText());
         *//*}*//*
      }*/
/*
      list.remove(0);
      buildingTable = list.get(0);

      s = buildingTable.asText();
*/

/*      final List<WebWindow> windows = webClient.getWebWindows();//메모리
      for (final WebWindow wd : windows) {
         System.out.println(wd);
         System.out.println("역");
         wd.getJobManager().removeAllJobs();
         System.out.println(wd);
      }
      System.out.println(s);*/
		System.out.println("Building Table List Success");

		List<HtmlElement> Roomlist;

		//건물 선택 해 강의실 조회하기
		//승연관
		/*      (HtmlElement) page2.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]/").get(1);
		 *//*button1 = page2.getByXPath("//a[@id='gv건물목록_ctl02_btnSelect']");//button '선택'*//*
      button1 = page2.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']//a[@id='gv건물목록_ctl02_btnSelect']");//button '선택'
      page2 = button1.click();
      Roomlist= page2.getByXPath("//div[@class='divBuildingRoomList']/table[@class='gridForm']");*/

		/*System.out.println("승연관");*/
		//승연관 강의실 조회하기

/*      //일만관
      button2 = page2.getFirstByXPath("//a[@id='gv건물목록_ctl03_btnSelect']");//button '선택'
      page2 = button2.click();

      //월당관
      button3 = page2.getFirstByXPath("//a[@id='gv건물목록_ctl04_btnSelect']");//button '선택'
      page2 = button3.click();

      //열림관
      button4 = page2.getFirstByXPath("//a[@id='gv건물목록_ctl05_btnSelect']");//button '선택'
      page2 = button4.click();*/

		//나눔관
      /*   button5 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl06_btnSelect']");//button '선택'
         framePage1 = button5.click();*/

		//이천환관
      /*   button6 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl07_btnSelect']");//button '선택'
         framePage1 = button6.click();*/

		//새천년관
      /*   button7 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl08_btnSelect']");//button '선택'
         framePage1 = button7.click();*/

		//성미가엘성당
   /*      button8 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl09_btnSelect']");//button '선택'
         framePage1 = button8.click();*/

		//미가엘관
/*         button9 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl10_btnSelect']");//button '선택'
         framePage1 = button9.click();*/

		//운동장
/*         button10 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl11_btnSelect']");//button '선택'
         framePage1 = button10.click();*/



		webClient.close();
		/*System.out.println(s);*/
		//*return s;*/
	}

}



