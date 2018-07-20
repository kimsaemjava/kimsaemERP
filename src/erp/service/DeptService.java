package erp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.dto.DeptDTO;

public interface DeptService {
	ArrayList<DeptDTO> getDeptName();
}
