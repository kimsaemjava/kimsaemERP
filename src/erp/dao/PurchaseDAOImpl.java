package erp.dao;
import static query.PurchaseQuery.Purchase_BASIC;
import static fw.DBUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.PurchaseDTO;
import erp.dto.PurchaseDetailDTO;

public class PurchaseDAOImpl implements PurchaseDAO{

	@Override
	public PurchaseDTO getPurchaseBasicInfo(Connection con) throws SQLException{
		PurchaseDTO purchase = null;
		PreparedStatement ptmt = con.prepareStatement(Purchase_BASIC);
		ResultSet rs = ptmt.executeQuery();
		if (rs.next()) {
			System.out.println("데이터있다~~~~~");
			purchase =  new PurchaseDTO(rs.getString(1),
					rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),
					rs.getString(6));
		}
		
		close(ptmt);
		return purchase;
	}

	@Override
	public ArrayList<PurchaseDetailDTO> getPurchaseDetailList(String deptno,String purchase_id ,Connection con) throws SQLException{
		return null;
	}

}
