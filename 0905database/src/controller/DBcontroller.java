package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Buy;

@WebServlet("*.db")
public class DBcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DBcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURL.substring(contextPath.length()+1);
		switch(command) {
		case "mysql.db":
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shenah?characterEncoding=UTF-8&serverTimezone=UTC", "root", "shenaihua");
				System.out.println(con);
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			break;
		case"oracle.db":
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe","user03","user03");
				System.out.println(con);
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		break;
		case "insert.db": 
			Connection con1 = null;
			PreparedStatement pstmt1 = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/shenah?characterEncoding=UTF-8&serverTimezone=UTC", "root", "shenaihua");
				pstmt1 = con1.prepareStatement("insert into usertbl(userid, name, birthyear, addr, mobile, mdate) values(?,?,?,?,?,?)");
				pstmt1.setString(1, "rs");
				pstmt1.setString(2, "로제");
				pstmt1.setInt(3, 1997);
				pstmt1.setString(4, "한국");
				pstmt1.setString(5, "01047503848");
				pstmt1.setDate(6, new Date(97, 1, 11)); // 월은 -1해서 대입; 일은 +1해서 대입 
				int result = pstmt1.executeUpdate();
				if(result>0) {
					System.out.println("삽입성공");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					if(pstmt1 != null) pstmt1.close();
					if(con1 != null) con1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		break;
		case "delete.db": 
			Connection con2 = null;
			PreparedStatement pstmt2 = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/shenah?characterEncoding=UTF-8&serverTimezone=UTC", "root", "shenaihua");
				pstmt2 = con2.prepareStatement("delete from usertbl where userid=?");
				pstmt2.setString(1, "jn");

				int result = pstmt2.executeUpdate();
				if(result>0) {
					System.out.println("삭제성공");
				}else {
					System.out.println("에러는 없지만 삭제는 하지 않음");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					if(pstmt2 != null) pstmt2.close();
					if(con2 != null) con2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		break;
		case "update.db": 
			Connection con3 = null;
			PreparedStatement pstmt3 = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/shenah?characterEncoding=UTF-8&serverTimezone=UTC", "root", "shenaihua");
				pstmt3 = con3.prepareStatement("update usertbl set mdate = ? where userid = 'rs'");
				pstmt3.setDate(1, new Date(97, 1, 12));

				int result = pstmt3.executeUpdate();
				if(result>0) {
					System.out.println("갱신성공");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					if(pstmt3 != null) pstmt3.close();
					if(con3 != null) con3.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		break;
		case "selectlist.db":
			Connection con4 = null;
			PreparedStatement pstmt4 = null;
			ResultSet result = null;
			List <Buy> list = new ArrayList<>();
			Buy buy = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/shenah?characterEncoding=UTF-8&serverTimezone=UTC", "root", "shenaihua");
				pstmt4 = con4.prepareStatement("select * from buytbl");
				
				result = pstmt4.executeQuery();
				while(result.next()) {
					buy = new Buy();
					buy.setNum(result.getInt("num"));
					buy.setUserid(result.getString("userid"));
					buy.setProductname(result.getString("productname"));
					buy.setGroupname(result.getString("groupname"));
					buy.setPrice(result.getInt("price"));
					buy.setAmount(result.getInt("amount"));
					
					list.add(buy);
				}
			} catch (Exception e) { 
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					if(result != null) result.close();
					if(pstmt4 != null) pstmt4.close();
					if(con4 != null) con4.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		for(Buy b : list) {
			System.out.println(b);
		}
		break;
		
		case "selectnum.db"	:
			Connection con5 = null;
			PreparedStatement pstmt5 = null;
			ResultSet rs1 = null;
			Buy buy1 =null; 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/shenah?characterEncoding=UTF-8&serverTimezone=UTC", "root", "shenaihua");
				pstmt5 = con5.prepareStatement("select * from buytbl where num = ?");
				pstmt5.setInt(1, Integer.parseInt(request.getParameter("num")));
				rs1 = pstmt5.executeQuery();
				if(rs1.next()) {
					buy1 = new Buy();
					buy1.setNum(rs1.getInt("num"));
					buy1.setUserid(rs1.getString("userid"));
					buy1.setProductname(rs1.getString("productname"));
					buy1.setGroupname(rs1.getString("groupname"));
					buy1.setPrice(rs1.getInt("price"));
					buy1.setAmount(rs1.getInt("amount"));
				}
				
			} catch (Exception e) { 
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					if(rs1 != null) rs1.close();
					if(pstmt5 != null) pstmt5.close();
					if(con5 != null) con5.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		System.out.println(buy1);
		break;
		}
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
