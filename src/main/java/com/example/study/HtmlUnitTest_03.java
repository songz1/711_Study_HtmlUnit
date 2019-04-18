package com.example.study;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.util.List;
import java.util.logging.Level;

public class HtmlUnitTest_03 {
    public static void main(String[] args) throws Exception {
        String id = ""; // 네이버 아이디를 입력하세요.
        String password = "";  // 네이버 비밀번호를 입력하세요.

        WebClient webClient = new WebClient();
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); // 중간 로그를 보이지 않도록 함
        webClient.getOptions().setThrowExceptionOnScriptError(false); // 자바 script 오류시 처리 하도록 수정

        {
            HtmlPage page = webClient.getPage("https://nid.naver.com/nidlogin.login"); // 네이버로 로그인 페이지로 이동

            HtmlTextInput inputId = page.getFirstByXPath("//*[@id=\"id\"]"); // ID 입력 필드
            HtmlPasswordInput inputPassword = page.getFirstByXPath("//*[@id=\"pw\"]"); // 암호 입력 필드
//            HtmlImageInput inputSubmit = page.getFirstByXPath("//*[@id=\"frmNIDLogin\"]/fieldset/input"); // 로그인버튼
            HtmlSubmitInput submitBtn = page.getFirstByXPath("//*[@id=\"frmNIDLogin\"]/fieldset/input"); // 로그인버튼

            inputId.setText(id); // ID 입력
            inputPassword.setText(password); // 비밀번호 입력
//            inputSubmit.click(); // 로그인 버튼 클릭
            page = submitBtn.click();
        }

        {
            HtmlPage page2 = webClient.getPage("https://section.blog.naver.com/SectionMain.nhn"); // 네이버로 블로그 페이지로 이동

            List<?> titles = page2.getByXPath("//ul[@id='buddyNewPostListInSection']/li/h5/a"); // 이웃소식 목록 필드
            for (Object aaa : titles) { // 이웃 목록을 하나씩 처리
                HtmlAnchor title = (HtmlAnchor) aaa;
                System.out.println(title.getTextContent()); // 이웃소식 출력
            }
        }

        webClient.close(); // 네이버와 연결 종료
    }


}
