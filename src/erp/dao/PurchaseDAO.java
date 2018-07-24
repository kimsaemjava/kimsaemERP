package erp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.PurchaseDTO;
import erp.dto.PurchaseDetailDTO;

public interface PurchaseDAO {
	PurchaseDTO getPurchaseBasicInfo(Connection con) throws SQLException; 
	ArrayList<PurchaseDetailDTO> getPurchaseDetailList(String deptno,String purchase_id ,Connection con) throws SQLException; 
}
