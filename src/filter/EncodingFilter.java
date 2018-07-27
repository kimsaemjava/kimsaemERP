package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	//인코딩을 적용할 인코딩타입 - web.xml에 정의된 param-value를 읽어와서 셋팅
	String encoding;
	@Override
	public void init(FilterConfig config) throws ServletException {
		//web.xml에 정의한  param을 읽는 방법은 FilterConfig객체의 메소드를 통해서 접근
		
		encoding = config.getInitParameter("encoding");
		System.out.println("필터의 init():"+encoding);
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, 
			ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//설정파일을 통해서 인코딩타입을 지정할 수 있도록 정의
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, res);
			
	}

	

}
