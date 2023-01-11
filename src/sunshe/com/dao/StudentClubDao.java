package xueshe.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import xueshe.com.model.Club;
import xueshe.com.model.Course;
import xueshe.com.model.Student;
import xueshe.com.model.StudentClub;
import xueshe.com.model.StudentCourse;

public class StudentClubDao extends BaseDao{
	//获得该学生的该社团内的已选择的课程（某年份）
	//获得该学生已加入的社团
	public ArrayList<Club> getAllSelectedClubs(String Sno)
	{
		String sql="SELECT clname,clno FROM clubs WHERE  clno in (SELECT clno FROM studentclubs WHERE sno=?)";
		ArrayList<Club> clubList = new ArrayList<Club>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Sno);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Club club = new Club();
					club.setCLname(rst.getString("CLname"));
					club.setCLno(rst.getString("clno"));
					clubList.add(club);
				}
				conn.close();
				return clubList;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	//获得学生加入的社团号
		public ArrayList<String> getClubClno(String Sno)
		{
			String sql="SELECT clno FROM studentclubs WHERE  sno =?";
			ArrayList<String> clubList2 = new ArrayList<String>();
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, Sno);
				try (ResultSet rst = pstmt.executeQuery()) {
					while (rst.next()) {
						clubList2.add(rst.getString("clno"));
					}
					conn.close();
					return clubList2;
				}
			} catch (SQLException se) {
				se.printStackTrace();
				return null;
			}
		}
	//增加一条学生选社团的记录
	public boolean insertStudentClub(String Sno,String clno)
	{
		String sql = "INSERT INTO studentclubs (sno,clno) VALUES (?,?)";
		try (Connection conn = this.dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Sno);
			pstmt.setString(2, clno);
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//删除一条学生社团的记录
	public boolean deleteStudentClub(String Sno, String Clno) /*   修改  */
	{
		String sql = "DELETE FROM studentclubs WHERE sno=? AND clno=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Sno);
			pstmt.setString(2, Clno);
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (Exception se) {
			se.printStackTrace();
			return false;
		}
	}
	//根据课程号和学号获得选课信息
		public StudentClub getStudentClubBySnoClno(String Sno,String Clno)
		{
			String sql="SELECT sno,cno FROM studentclubs WHERE sno=? AND clno=?";
			try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, Sno);
				pstmt.setString(2, Clno);
				try (ResultSet rst = pstmt.executeQuery()) {
					while (rst.next()) {
						StudentClub scl = new StudentClub();
						scl.setClno(rst.getString("clno"));
						scl.setSno(rst.getString("sno"));
						conn.close();
						return scl;
					}
					return null;
				}
			} catch (SQLException se) {
				se.printStackTrace();
				return null;
			}
		}
	//查询学生是否选择了该社团
	public boolean ifSelectedClub(String Sno,String Clno)
	{
		String sql="SELECT sno,clno FROM studentclubs WHERE sno=? AND clno=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, Sno);
			pstmt.setString(2, Clno);
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					conn.close();
					return true;
				}
				conn.close();
				return false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	//获得所有的选社团信息
	public ArrayList<StudentClub> getAllStudentClub()
	{
		String sql="SELECT * FROM studentclubs";
		ArrayList<StudentClub> studentclubList = new ArrayList<StudentClub>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					StudentClub studentClub = new StudentClub();
					studentClub.setClno(rst.getString("clno"));
					studentClub.setSno(rst.getString("sno"));
					studentclubList.add(studentClub);
				}
				conn.close();
				return studentclubList;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}
	//根据社团号查询社团成员
	public ArrayList<Student> getStudentByClno(String Clno)
	{
		String sql = "SELECT * from students where sno in (SELECT sno from studentclubs where clno =?)";
		ArrayList<Student> studentList = new ArrayList<Student>();
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Clno);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Student student = new Student();
				student.setSno(rst.getString("sno"));
				student.setSname(rst.getString("sname"));
				student.setSsex(rst.getString("ssex"));
				student.setSpassword(rst.getString("spassword"));
				studentList.add(student);
			}
			conn.close();
			return studentList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//根据社团号查询社团人数
		public int getStudenNumbertByClno(String Clno)
		{
			String sql = "SELECT * from students where sno in (SELECT sno from studentclubs where clno =?)";
			try {
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Clno);
				ResultSet rst = pstmt.executeQuery();
				int count=0;
				while (rst.next()) {
					++count;
				}
				conn.close();
				return count;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
}
