package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.SimpleEmail;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EtcServiceImpl implements EtcService {
	
	private EtcServiceImpl(){};
	
	private static EtcService etcService;
	
	public static EtcService sharedInstance(){
		if(etcService == null) {
			etcService = new EtcServiceImpl();
		}
		return etcService;
	}

	@Override
	public boolean mailSend(HttpServletRequest request) {
		boolean result = false; 
		try {
			request.setCharacterEncoding("utf-8");
			String receiver = request.getParameter("receiver");
			String subject = request.getParameter("subject");
			String msg = request.getParameter("msg");
			
			String uploadPath = request.getServletContext().getRealPath("/upload");
			MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
			
			//업로드 파일 이름 가져오기 
			
			SimpleEmail email = new SimpleEmail();
			//email서버 설정 
			email.setHostName("smtp.naver.com");
			email.setSmtpPort(587);
			email.setSSLOnConnect(true);
			email.setStartTLSEnabled(true);
			//인코딩 설정 
			email.setCharset("utf-8");
			//받는 사람과 제목 및 내용 설정 
			email.setMsg(msg);
			email.setSubject(subject);
			email.addTo(receiver);
			//보내는 사람 설정 
			email.setAuthentication("ggangpae3", "qkranstjr");
			email.setFrom("ggangpae3@naver.com", "관리자", "utf-8");
			//메일 보내기 
			email.send();
			result = true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String proxy(HttpServletRequest request) {
		
			String result="";
			try {
				String addr = "http://www.weather.go.kr/weather/forecast/mid-term-xml.jsp?stnId=109";
				
				//url로 변환 
				URL url = new URL(addr);
				
				//URLConnection 객체 만들기 
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				
				//옵션 설정 
				//이 시간동안 다운로드 받지 못하면 연결 해제 
				con.setConnectTimeout(30000); //설정하지 않으면 인터넷 끊길 때 무한루프에 빠질 수 있음  
				con.setUseCaches(false); //전에 데이터 사용하지 않음 
				
				//문자열을 다운로드 받을 수 있는 스트림 생성 
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				//문자열을 복사하지 않고 추가할 수 있는 클래스의 인스턴스 생성 
				StringBuilder sb = new StringBuilder();
				while(true) {
					String line = br.readLine();
					if(line == null) {
						break;
					}
					sb.append(line);
				}
				result = sb.toString();
				sb = null;
				con.disconnect();
			}catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return result;
		
	}

	@Override
	public void push(HttpServletRequest request, HttpServletResponse response) {
		//출력을 위한 스트림 생성 
		PrintWriter pw = null; 
		
		try {
			//출력형식을 text/event-stream으로 설정 
			response.setContentType("text/event-stream");
			//출력 인코딩 설정 
			response.setCharacterEncoding("UTF-8");
			//출력 내용을 만들고 출력하기 
			pw = response.getWriter();
			Random r = new Random();
			pw.write("data:" + (r.nextInt(46)+1)+"\n\n");
			Thread.sleep(1000);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			if(pw != null) pw.close();
		}
		
	}
}
