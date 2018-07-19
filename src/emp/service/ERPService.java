package emp.service;

import emp.dto.LoginDTO;

public interface ERPService {
	LoginDTO login(String id, String pass);
}
