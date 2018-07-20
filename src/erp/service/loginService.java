package erp.service;


import java.util.ArrayList;

import erp.dto.loginDTO;


public interface loginService {
	loginDTO login(String id, String pass);
	ArrayList<loginDTO> empList();
}
