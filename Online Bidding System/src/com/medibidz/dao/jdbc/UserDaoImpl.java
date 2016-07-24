package com.medibidz.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.medibidz.dao.UserDao;
import com.medibidz.dao.exception.DAOException;
import com.medibidz.entity.Branch;
import com.medibidz.entity.Department;
import com.medibidz.entity.Faculty;
import com.medibidz.entity.ItemImage;
import com.medibidz.entity.Registeration;
import com.medibidz.entity.Student;
import com.medibidz.entity.User;
import com.medibidz.entity.UserType;
import com.medibidz.entity.Wish;
import com.medibidz.util.DBUtil;


public class UserDaoImpl extends BaseDao implements UserDao
{
	
	
	public void register(Registeration reg)throws DAOException
	{
		
		Connection con = null;
		try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into new_registeration(registeration_id,first_Name,last_Name,email_id,enrollment,faculty_id,title,branch_id,semester,department_id,user_type,reg_date,password,contact_number,pic_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1,reg.getRegisterationId());
            pst.setString(2,reg.getFirstName());
            pst.setString(3,reg.getLastName());
            pst.setString(4,reg.getEmailId());
            pst.setString(5,reg.getEnrollment());
            pst.setString(6,reg.getFacultyId());
            pst.setString(7,reg.getTitle());
            if(reg.getUserType().equals(UserType.STUDENT))
            {
            	pst.setInt(8,reg.getBranch().getBranchId());
            	pst.setString(9,reg.getSemester());
            }
            else{
            	pst.setObject(8,null);
                pst.setString(9,null);                	
            }
            if(reg.getUserType().equals(UserType.FACULTY)){
            	pst.setInt(10,reg.getDepartment().getDepartmentId());                
            }
            else{
            	pst.setObject(10,null);                	
            }
            pst.setString(11,reg.getUserType().toString());
        	pst.setTimestamp(12, new Timestamp(new java.util.Date().getTime()));
            pst.setString(13,reg.getPassword());
            pst.setString(14,reg.getContactNumber());
            if (reg.getPicId()!= null) {
				int id = addImage(reg.getPicId(), con);
				pst.setInt(15, id);
			} else {
				pst.setObject(15, null);
			}
            pst.executeUpdate();
          pst.close();
        } catch (Exception e1) {
            e1.printStackTrace();
            throw new DAOException(e1.getMessage());
        }
        DBUtil.closeConnection(con);	
	
	}
	public List<User> getAllUsers()
	{
		User user=null;
	ArrayList<User> al=null; 
	Connection con=null;
	try
	{
    con = DBUtil.getConnection();
    PreparedStatement pst = con.prepareStatement("select id,first_name,last_name,email_id,title,user_type,pic_id from user");
    ResultSet rs=pst.executeQuery();
    if(rs.next())
    {
    	int id=rs.getInt(1);
    	String userType=rs.getString(6);
    	
    	if(userType.equals(UserType.FACULTY.toString()))
    	{
    		PreparedStatement  pst1= con.prepareStatement("select f.department_id,f.faculty_id,d.department_name from faculty_user f,dept_master d where f.id=? and d.department_id=f.department_id");
    		pst1.setInt(1,id);
    		ResultSet rs1=pst1.executeQuery();
    	    if(rs1.next())
    	    {	al=new ArrayList<User>();
    	    	do{	 
    	    	Department dep=new Department(rs1.getInt(1),rs1.getString(3));
    	    	user=new Faculty(rs.getInt(1),null,UserType.valueOf(rs.getString(6)),rs.getString(2),rs.getString(3),rs.getString(4),null,0,rs.getString(5),new ItemImage(rs.getInt(7)),rs1.getString(2),dep);
    	    	al.add(user);
    	    	}
    	    	while(rs.next());	
    	    }
    		rs1.close();
        	pst1.close();	
    	}

    	if(userType.equals(UserType.STUDENT.toString()))
    	{
    		PreparedStatement  pst2= con.prepareStatement("select s.enrollment,s.branch_id,s.semester,b.branch_name from student_user s,branch_master b where s.id=? and s.branch_id=b.branch_id");
    		pst2.setInt(1,id);
    		ResultSet rs2=pst2.executeQuery();
    	    if(rs2.next())
    	    {	al=new ArrayList<User>();
    	    	do{	 
    	    	Branch bra=new Branch(rs2.getInt(2),rs2.getString(4));
    	    	user=new Student(rs.getInt(1),null,UserType.valueOf(rs.getString(6)),rs.getString(2),rs.getString(3),rs.getString(4),null,0,rs.getString(5),new ItemImage(rs.getInt(7)),rs2.getString(1),bra,rs2.getString(3));
    	    	al.add(user);
    	    	}
    	    	while(rs.next());	
    	 }
    	rs2.close();
    	pst2.close();
    
    	}
    }
    rs.close();
    pst.close();
	}
	
catch (Exception e1)
	{
    e1.printStackTrace();
	}

	  DBUtil.closeConnection(con);
      return al;		

		
	}
	public List<Registeration> getNewRegisterations()
	{
		ArrayList<Registeration> al=null;
		Connection con=null;
		try
		{
	    con = DBUtil.getConnection();
	    PreparedStatement pst = con.prepareStatement("select registeration_id,first_name,last_name,email_id,enrollment,faculty_id,title,branch_id,semester,department_id,user_type,reg_date,password,contact_number,pic_id from new_registeration");
	    
	    
	    PreparedStatement pstBranch = con.prepareStatement("select branch_id,branch_name from branch_master");
	    	ResultSet rsBranch=pstBranch.executeQuery();		
	    
	    	Map<Integer,Branch> branchMap=new HashMap<Integer,Branch>();
	    	while(rsBranch.next()){
	    		branchMap.put(rsBranch.getInt(1),new Branch(rsBranch.getInt(1),rsBranch.getString(2)));
	    	}
	    	rsBranch.close();
	    	pstBranch.close();
	    	
	    	
	    PreparedStatement pstdept = con.prepareStatement("select department_id,department_name from dept_master");
	    ResultSet rsdept=pstdept.executeQuery();	
	    
	    
	    
	    
	    Map<Integer,Department> deptMap=new HashMap<Integer,Department>();
	    while(rsdept.next()){
    		deptMap.put(rsdept.getInt(1),new Department(rsdept.getInt(1),rsdept.getString(2)));
    	}
    	rsdept.close();
    	pstdept.close();
    	ResultSet rs=pst.executeQuery();
	        
	    	if(rs.next())	
	    {
	    	Registeration reg;
	    	al=new ArrayList<Registeration>();
	    	do
	    	{
	  
	    		reg=new Registeration(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),branchMap.get(rs.getObject(8)),rs.getString(9),deptMap.get(rs.getObject(10)),UserType.valueOf(rs.getString(11)),rs.getDate(12),rs.getString(13),rs.getString(14),new ItemImage(rs.getInt(15)));
	    		
	    	al.add(reg);
	    	}while(rs.next());
	    	
	    	
	    }
	    rs.close();
	    pst.close();
	    
	} 
	catch (Exception e1)
		{
	    e1.printStackTrace();
		}

		  DBUtil.closeConnection(con);
	      return al;		
	}
	
	
	public void verify(int registerationId)
	{		
	Connection con = null;
	try {
		int id=0;
        con = DBUtil.getConnection();
        con.setAutoCommit(false);
        PreparedStatement pst = con.prepareStatement("select * from new_registeration where registeration_id=?");
        pst.setInt(1,registerationId);
        ResultSet rs=pst.executeQuery();
        if(rs.next())
        {
    	String firstName=rs.getString(2);
    	String lastName=rs.getString(3);
    	String emailId=rs.getString(4);
    	String enrollment=rs.getString(5);
    	String facultyId=rs.getString(6);
    	String title=rs.getString(7);
    	int branchId=rs.getInt(8);
    	String semester=rs.getString(9);
    	int departmentId=rs.getInt(10);
    	String userType=rs.getString(11);
    	Date regDate=rs.getDate(12);
    	String password=rs.getString(13);
    	String contactNo=rs.getString(14);
    	int picId=rs.getInt(15);
    	int status=1;
    	
        PreparedStatement pst1 = con.prepareStatement("insert into user(password,user_Type,first_name,last_name,email_id,contact_number,active_status,title,pic_id) values(?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        
        pst1.setString(1,password);
        pst1.setString(2,userType);
        pst1.setString(3,firstName);
        pst1.setString(4,lastName);
        pst1.setString(5,emailId);
        pst1.setString(6,contactNo);
        pst1.setInt(7,status);
        pst1.setString(8,title);        
        pst1.setInt(9,picId);        
        int r=pst1.executeUpdate();
        if(r!=0)
        {
        	ResultSet rsKey=pst1.getGeneratedKeys();
           	if(rsKey.next())
        	{
        	 id=rsKey.getInt(1);
        	}
           	rsKey.close();
        }
        	
        if((r!=0) && (userType.equals(UserType.FACULTY.toString())))
        {
        	PreparedStatement pst2 = con.prepareStatement("insert into faculty_user(department_id,faculty_id,id) values (?,?,?)");
            
            
            pst2.setInt(1,departmentId);
            pst2.setString(2,facultyId);
            pst2.setInt(3,id);
            pst2.executeUpdate();
        }

        else if((r!=0) && (userType.equals(UserType.STUDENT.toString())))
        {
        	PreparedStatement pst2 = con.prepareStatement("insert into student_user(enrollment,branch_id,semester,id) values (?,?,?,?)");
            
        	 pst2.setString(1,enrollment);
            pst2.setInt(2,branchId);
            pst2.setString(3,semester);
            pst2.setInt(4,id);
           pst2.executeUpdate();
        }

        if(r!=0)
        {
        	PreparedStatement pst3 = con.prepareStatement("delete from new_registeration where registeration_id=?");
        	pst3.setInt(1,registerationId);
        	pst3.executeUpdate();
        }
      } 

        rs.close();       
        
        con.commit();
        pst.close();
      
    } catch (Exception e1) {
        e1.printStackTrace();
        try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    DBUtil.closeConnection(con);	
	
    }
		
	}

	public User getUserDetails(int userId)
	{	User user=null;
		Connection con = null;
		try {
			
			
			ItemImage itm=new ItemImage();
				con = DBUtil.getConnection();
             PreparedStatement pst= con.prepareStatement("select password,email_id,contact_number,pic_id,user_type from user where id=?");
             pst.setInt(1,userId);
             ResultSet rs=pst.executeQuery();
             if(rs.next())
             {
            	 String userType=rs.getString(5);
            	 if((userType.equals(UserType.FACULTY.toString()))||(userType.equals(UserType.ADMIN.toString())))
            	 {
            		
            		 user=new User(rs.getString(1),rs.getString(2),rs.getString(3),new ItemImage(rs.getInt(4)),UserType.valueOf(rs.getString(5)));
        
            	 }
            	 else if(userType.equals(UserType.STUDENT))
            	 {
            		 PreparedStatement pst2 = con.prepareStatement("select semester from student_user where id=?");
            		 pst2.setInt(1,userId);
            		 ResultSet rs2=pst2.executeQuery();
            		 
            		 user=new Student(rs.getString(1),rs.getString(2),rs.getString(3),new ItemImage(rs.getInt(4)),UserType.valueOf(rs.getString(5)),rs2.getString(1));
      
            		 pst2.close();	 
            	 }
            	 pst.close();
            	 
            	 
            	 }
             
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	

        return  user;
		
	}
	
	public void editProfile(User user,int userId)
	{ 
		Connection con = null;
		try {
			ItemImage itm=new ItemImage();
             con= DBUtil.getConnection();
             PreparedStatement pstType = con.prepareStatement("select user_type from user where id=?");
             pstType.setInt(1,userId);
            
             ResultSet rs=pstType.executeQuery();
             if(rs.next())
             {
             PreparedStatement pst = con.prepareStatement("update user set password=?,email_id=?,contact_number=? where id=?");
    		 pst.setString(1,user.getPassword());
    		 pst.setString(2,user.getEmail());
    		 pst.setString(3,user.getContactNo());
    		// pst.setInt(4,user.getPicId().getImageId());
    		 pst.setInt(4,userId);
    		 pst.executeUpdate();
    		 
    		 if(rs.getString(1).equals(UserType.STUDENT.toString()))
            	 {
    			 	Student stu=new Student();		
            		 PreparedStatement pst2 = con.prepareStatement("update student_user set semester=? where id=?");
            		 pst2.setString(1,stu.getSemester());
            		 pst2.setInt(2,userId);
            		 pst2.executeUpdate();
            		 pst2.close();	 
            	 }
            	 pst.close();
            	 }
             
            } 
		catch (Exception e1) 
		{
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
	}	
	
	
	public void updateUserStatus(int userId,int status)
	{
		Connection con = null;
		try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("update user set active_status=1 where id=?");
            
            pst.setInt(1,userId);
           
            pst.executeUpdate();
            
            pst.close();
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
	}
	
	public User findById(int id)
	{	
		User user=null;
 		
		Connection con = null;
		
		try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("select id,password,user_type,first_name,last_name,email_id,contact_number,active_status,title,pic_id from user where id=?");
            pst.setInt(1,id);
            
            PreparedStatement pstfac= con.prepareStatement("select f.department_id,f.faculty_id,d.department_name from faculty_user f,dept_master d where f.department_id=d.department_id and id=?");
            pstfac.setInt(1,id);
            
            PreparedStatement pststu= con.prepareStatement("select s.enrollment,s.branch_id,s.semester,b.branch_name from student_user s,branch_master b where s.branch_id=b.branch_id and id=?");
            pststu.setInt(1,id);
            
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
            	String userType=rs.getString(3);
            	if(userType.equals(UserType.FACULTY.toString()))
            	{
            		ResultSet rs1=pstfac.executeQuery();
            		if(rs1.next())
            		{
            		Department dep=new Department(rs1.getInt(1),rs1.getString(3));
            		 user=new Faculty(rs.getInt(1),rs.getString(2),UserType.valueOf(rs.getString(3)),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),new ItemImage(rs.getInt(10)),rs1.getString(2),dep);
            		}
            		rs1.close();
            	}            
            	else if(userType.equals(UserType.STUDENT.toString()))
            	{
            	
            		ResultSet rs2=pststu.executeQuery();
            		if(rs2.next())
            		{	Branch branch=new Branch(rs2.getInt(2),rs2.getString(4));
            			user=new Student(rs.getInt(1),rs.getString(2),UserType.valueOf(rs.getString(3)),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),new ItemImage(rs.getInt(10)),rs2.getString(1),branch,rs2.getString(3));
            		}
            		rs2.close();
            	}

            
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
		return user;
	}
	
	public void delete(int registerationId)
	{
		Connection con = null;
		try {
			con = DBUtil.getConnection();

			PreparedStatement pst = con.prepareStatement("delete * from new_registerataion where registeration_id=?");
	    	pst.setInt(1,registerationId);
	    	pst.executeUpdate();
		
	        con = DBUtil.getConnection();
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
	
		
	}
	public User getProfileDetails(String loginId,String password)
	{
		User user=null;
		Connection con = null;
		try {
			
		
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("select id,user_type,first_name,last_name,contact_number,pic_id,title from new_registeration where email_id=? and password=?");
            pst.setString(1,loginId);
            pst.setString(2,password);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            	do{
            		 user=new User(rs.getInt(1),rs.getString(2),UserType.valueOf(rs.getString(3)),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));
                 	
            	}while(rs.next());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
		return user;
		
	}
	
	public User validateLogin(String loginId,String password)
	{
		User user=null;
		Connection con = null;
		try {
			
		
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("select id,password,user_type,first_name,last_name,email_id,contact_number,active_status,title from user where email_id=? and password=?");
            pst.setString(1,loginId);
            pst.setString(2,password);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            	do{
            		 user=new User(rs.getInt(1),rs.getString(2),UserType.valueOf(rs.getString(3)),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));
                 	
            	}while(rs.next());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
		return user;
	}
	
	public String getUserName(String email,String password)
	{
		String userName=null;
	 
		Connection con = null;
		try {
			
			     
			con = DBUtil.getConnection();
           
            PreparedStatement pst = con.prepareStatement("select first_name,last_name from user where email_id=? and password=?");
            pst.setString(1,email);
            pst.setString(2,password);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
            String firstName=rs.getString("first_name");
            String lastName=rs.getString("last_name");
            userName=firstName.concat("  "+lastName);
            
            }
            pst.close();
            rs.close();
		}
            catch (Exception e1) {
                e1.printStackTrace();
            }
		
            DBUtil.closeConnection(con);	
            return userName;
		}


	public Registeration getNewRegisteration(int regId) {
		Registeration reg=null;


Connection con=null;
try
{
con = DBUtil.getConnection();
PreparedStatement pst = con.prepareStatement("select registeration_id,first_name,last_name,email_id,enrollment,faculty_id,title,branch_id,semester,department_id,user_type,reg_date,password,contact_number,pic_id from new_registeration where registeration_id=?");
pst.setInt(1, regId);
ResultSet rs=pst.executeQuery();
Statement st = con.createStatement();
	if(rs.next())	
{

		reg=new Registeration(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),null,rs.getString(9),null,UserType.valueOf(rs.getString(11)),rs.getDate(12),rs.getString(13),rs.getString(14),new ItemImage(rs.getInt(15)));
		if(UserType.isFaculty(reg.getUserType())){
			int deptId=rs.getInt(10);

		ResultSet rsdept=st.executeQuery("select department_name from dept_master where department_id="+deptId);	

		if(rsdept.next()){
			reg.setDepartment(new Department(deptId, rsdept.getString(1)));
		}

	rsdept.close();
		}
		

if(UserType.isStudent(reg.getUserType())){
	int branchId=rs.getInt(8);

	ResultSet rsBranch=st.executeQuery("select branch_name from branch_master where branch_id="+branchId);	

	if(rsBranch.next()){
		reg.setBranch(new Branch(branchId, rsBranch.getString(1)));
	}

rsBranch.close();
	
}		
		
}
	rs.close();
pst.close();





} 
catch (Exception e1)
{
e1.printStackTrace();
}

  DBUtil.closeConnection(con);



		return reg;	
		
	}
	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select user_type from user where id=?");
		    ResultSet rs=pst.executeQuery();
		    if(rs.next())
		    {
		    	
		    String userType=rs.getString(1);
			PreparedStatement pstd = con.prepareStatement("delete * from user where id=?");
	    	pstd.setInt(1,userId);
	    	pstd.executeUpdate();
	    	
	    	if(userType.equals(UserType.FACULTY.toString()))
	    	{
	    	PreparedStatement pst1 = con.prepareStatement("delete * from faculty_user where id=?");
	    	pst1.setInt(1,userId);
	    	pst1.executeUpdate();
	    	pst1.close();
	    	}
	    	else if(userType.equals(UserType.STUDENT.toString()))
	    	{
	    	PreparedStatement pst2 = con.prepareStatement("delete * from student_user where id=?");
	    	pst2.setInt(1,userId);
	    	pst2.executeUpdate();
	    	pst2.close();
	    	}
	    	pstd.close();
	    	rs.close();
	        con = DBUtil.getConnection();
		    }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
		
	}

	public void addWishList(int uid, String wish)
	{
		Connection con = null;
		try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into wish_list(user_id,wish,active_status) values(?,?,0)");
            pst.setInt(1,uid);
            pst.setString(2,wish);
            pst.executeUpdate();
            
            pst.close();
		}
		catch (Exception e1) {
            e1.printStackTrace();
        }
        DBUtil.closeConnection(con);	
		
	}
	public List<Wish> getNewWishList()
	{
	Wish wish=null;
	ArrayList<Wish> al=null; 
	Connection con=null;
	try
	{
    con = DBUtil.getConnection();
    PreparedStatement pst = con.prepareStatement("select wish_id,user_id,wish,active_status from wish_list");
    ResultSet rs=pst.executeQuery();
    if(rs.next())
    {
    	int id=rs.getInt(1);
    		al=new ArrayList<Wish>();
    	    	do{	 
    	    	wish=new Wish(rs.getInt(1),new User(rs.getInt(2)),rs.getString(3),rs.getInt(4));
    	    	al.add(wish);
    	    	}
    	    	while(rs.next());	
    	    }
    		rs.close();
        	pst.close();	
    	}
	
catch (Exception e1)
	{
    e1.printStackTrace();
	}

	  DBUtil.closeConnection(con);
      return al;			
	}
}
