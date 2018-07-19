package login.service;


import login.dto.loginDTO;


public interface loginService {
	loginDTO login(String id, String pass);
}
