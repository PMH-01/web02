package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection(){
		//** Erro Message
		//=> //** Error Message
        // => 드라이버 오류 : java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver1
        // => portNO 오류 : ~~CommunicationsException: Communications link failure
        // => DBName 오류 : java.sql.SQLSyntaxErrorException: Unknown database 'mydb1'
        // => 계정,PW 오류 : java.sql.SQLException: Access denied for user 'root1'@'localhost' (using password: YES)


		//1) 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2) Connection 에 필요한 정보 전달 & Connection 생성
			//=> 직접 MySql 연결할때의 준비 작업 id, password, DB선택
			String url="jdbc:mysql://localhost/MYSQL?useUnicode=true&characterEncoding=UTF-8";
            // => allowPublicKeyRetrieval=true : local DB open 하지 않아도 connection 허용
            // => localhost -> 동일값(ip주소) @127.0.0.1

			Connection cn = DriverManager.getConnection(url,"root","1234");
			System.out.println("** JDBC Connectio 성공");
			return cn;
		}catch(Exception e) {
			System.out.println("** Connection 실패 =>"+ e.toString());
			return null;
		}
	}
}
