package com.example.study;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.*;

public class HtmlUnitTest_09 {
	public static void main(String[] args)  throws Exception, FailingHttpStatusCodeException, MalformedURLException, IOException {
		HtmlPage  framePage1,framePage2, lastPage = null;

		HtmlElement buildingTable,lectreRoomTable;
		HtmlElement button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;

		String s;

		Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);//error -> log
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);

		//로그인
		webClient.getOptions().setUseInsecureSSL(true);
//		webClient.getOptions().setJavaScriptEnabled(false);
//		webClient.getOptions().setCssEnabled(false);
		HtmlPage page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");
		HtmlForm form = page.getFormByName("");
		form.getInputByName("txtID").setValueAttribute("");
		form.getInputByName("txtPW").setValueAttribute("");
		HtmlPage homepage = form.getInputByName("ibtnLogin").click();
		System.out.println("Login Success");

		//시설물 대여 페이지로
		HtmlPage page2 = webClient.getPage("https://forest.skhu.ac.kr/Gate/SAM/Lesson/G/SSEG20P.aspx");
		System.out.println("Rent Page");
		Thread.sleep(3_000);

		//건물 조회 table 찾기
		/*framePage2 = (HtmlPage)page.getFrameByName("mainFrame").getEnclosedPage();//find a frame 'rightFrame'*/
//         framePage1 = (HtmlPage)page.getFrameByName("contentFrame").getEnclosedPage();//find a frame 'rightFrame'
		System.out.println("Building Table");

		List<?> list ;
		HtmlForm p2 = page2.getFirstByXPath("//FORM[@id='Form1']");//프레임내에 테이블 이름이 같은게 있기때문에 XPath로 찾는다.
		/*list.remove(0);*/
         /*buildingTable = list.get(0);

         s = buildingTable.asText();*/

      /*   final List<WebWindow> windows = webClient.getWebWindows();//메모리
         for (final WebWindow wd : windows) {
         wd.getJobManager().removeAllJobs();
         }*/
		/*System.out.println(s);*/
		System.out.println("Building Table List Success");
		System.out.println("htmlform : "+p2.getId());


		//건물 선택 해 강의실 조회하기
		//승연관
		HtmlButton btn = p2.getButtonByName("gv건물목록_ctl02_btnSelect");//button '선택'
		p2 = btn.click();
		System.out.println(p2.asXml());
		//승연관 강의실 조회하기
		//*framePage1 = (HtmlPage)page.getFrameByName("rightFrame").getEnclosedPage();//find a frame 'rightFrame'
         /*list = lastPage.getByXPath("//table[@class='gridForm']");//프레임내에 테이블 이름이 같은게 있기때문에 XPath로 찾는다.
         list.remove(0);*/
		/*buildingTable = list.get(0);//**/

		//*s = buildingTable.asText();*//*
		//일만관
//		button2 = page2.getFirstByXPath("//a[@id='gv건물목록_ctl03_btnSelect']");//button '선택'
//		page2 = button2.click();

//		//월당관
//		button3 = page2.getFirstByXPath("//a[@id='gv건물목록_ctl04_btnSelect']");//button '선택'
//		page2 = button3.click();
//
//		//열림관
//		button4 = page2.getFirstByXPath("//a[@id='gv건물목록_ctl05_btnSelect']");//button '선택'
//		page2 = button4.click();

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



