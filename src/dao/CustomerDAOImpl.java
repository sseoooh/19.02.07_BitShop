package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	private CustomerDAOImpl() {dao = CustomerDAOImpl.getInstance();}
	public static CustomerDAOImpl getInstance() {return instance;}
	CustomerDAOImpl dao;


	@Override
	public void insertCustomer(CustomerDTO cus) {
		try {
		System.out.println("CustomerDB입장");
		String sql = CustomerSQL.SIGNUP.toString();
		System.out.println("실행할쿼리"+sql);
		Connection conn =
				DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cus.getCustomerID());
		pstmt.setString(2, cus.getCustomerName());
		pstmt.setString(3, cus.getPassword());
		pstmt.setString(4, cus.getAddress());
		pstmt.setString(5, cus.getCity());
		pstmt.setString(6, cus.getPostalcode());
		pstmt.setString(7, cus.getSsn());
		int rs = pstmt.executeUpdate();
		System.out.println((rs==1) ? "입력성공":"입력실패");
				
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}

	@Override
	public List<CustomerDTO> selectCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> selectCustomerByName(String SearchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO selectCustomer(String SearchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public void updateCustomer(CustomerDTO emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(CustomerDTO emp) {
		// TODO Auto-generated method stub
		
	}

}
