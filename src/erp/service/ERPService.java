package erp.service;

import erp.dto.LoginDTO;

public interface ERPService {
	LoginDTO login(String id, String pass);
}
