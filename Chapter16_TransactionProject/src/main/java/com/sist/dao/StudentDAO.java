package com.sist.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class StudentDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	//1. 드라이브 등록
	public StudentDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	//2. 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		
	}catch(Exception ex)
	{
		
	}
	}
	//3. 해제
	public void disConnection()
	{
		try
		{	
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
			
		}catch(Exception ex) {}
	}
	////////////////////////////////SqlSessoinFactory가 해결
	//4. 목록 읽기
	public List<StudentVO> studentListData()
	{	
	List<StudentVO> list=new ArrayList<StudentVO>();
	try
	{
		getConnection(); //@Before
		///////////////핵심 코딩 => 메소드마다 달라진다
		String sql="SELECT no,name,kor,eng,math "
				+ "FROM std_input";
		//////////// 공통으로 사용되는 코드 =>selectList
		ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();//commit(x)
		while(rs.next())
		{
			//어떤 데이터에 값을 담을지 설정 => resultType="StudentVO"
			StudentVO vo=new StudentVO();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setKor(rs.getInt(3));
			vo.setEng(rs.getInt(4));
			vo.setMath(rs.getInt(5));
			//////////////////////////////selectOne
			list.add(vo);//selectList
		}
		rs.close();
	}catch(Exception ex)
	{
		//@AfterThrowing
		ex.printStackTrace();
	}finally
	{
		//@After
		disConnection();
	}
	//@AfterReturning
		return list;
	}
	//5. 추가 => 3명 동시에 => 트랜잭션 적용 => 1(오류 발생시),2,3 => 전체 취소
	public void studentInsert()
	{
		try
		{
			getConnection();
			String sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//?에 값을 채운다
			ps.setInt(1, 1);
			ps.setString(2, "홍길동");
			ps.setInt(3, 90);
			ps.setInt(4, 80);
			ps.setInt(5, 95);
			//오라클에 실행 요청==>
			ps.executeUpdate();	//여기에는 Commit()
			sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//?에 값을 채운다
			ps.setInt(1, 1);
			ps.setString(2, "심청이");
			ps.setInt(3, 90);
			ps.setInt(4, 80);
			ps.setInt(5, 95);
			//오라클에 실행 요청==>
			ps.executeUpdate();	//여기에는 Commit()
			sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//?에 값을 채운다
			ps.setInt(1, 3);
			ps.setString(2, "박문수");
			ps.setInt(3, 90);
			ps.setInt(4, 80);
			ps.setInt(5, 95);
			//오라클에 실행 요청==>
			ps.executeUpdate();	//여기에는 Commit()
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	//1=commit,2(에러 발생),3 => 1은 수행되었을 것, 1=commit,2=commit,3(에러 발생) =>1,2 수행되었을 것
	public void txInsert()
	{
		try
		{
			getConnection();
			conn.setAutoCommit(false);//커밋을 날리지 않겠다는 의미  , 지원(AOP) => @Around
			String sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//?에 값을 채운다
			ps.setInt(1, 1);
			ps.setString(2, "홍길동");
			ps.setInt(3, 90);
			ps.setInt(4, 80);
			ps.setInt(5, 95);
			//오라클에 실행 요청==>
			ps.executeUpdate();
			sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//?에 값을 채운다
			ps.setInt(1, 2);
			ps.setString(2, "심청이");
			ps.setInt(3, 90);
			ps.setInt(4, 80);
			ps.setInt(5, 95);
			//오라클에 실행 요청==>
			ps.executeUpdate();
			sql="INSERT INTO std_input VALUES(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//?에 값을 채운다
			ps.setInt(1, 3);
			ps.setString(2, "박문수");
			ps.setInt(3, 90);
			ps.setInt(4, 80);
			ps.setInt(5, 95);
			//오라클에 실행 요청==>
			ps.executeUpdate();
			
			conn.commit(); //지원(AOP) => @Around
		}catch(Exception ex)
		{
			ex.printStackTrace();
			try
			{
			conn.rollback();//모든 SQL문장 취소
			}catch(Exception e)
			{
				
			}
		}
		finally
		{
			
			try
			{
				//원상 복귀를 해줘야함
				conn.setAutoCommit(true);
			}catch(Exception ex) {}			
				disConnection();
			
		}
	}
	//위의 상황을 방지하기 위해서 동시에 처리 방식에서 => 일괄처리 (트랜잭션)
	//입고 => 재고 , 출고 => 재고  => 동시처리를 해줘야함
	//카드 결제 = 포인트 누적 이걸 동시에 처리해야하기 때문에 이럴때 사용하는 것이 트랜잭션이다.
	
	
	
	
	
	
	
}
