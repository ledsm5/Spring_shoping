package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter{
	
	//제일많이 사용 
		///컨트롤러에 들어오기전에 차단
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			// TODO Auto-generated method stub
			//세션이 있는지 없는지 확인
			HttpSession session = request.getSession(false);
			if(session != null) {
				Object authInfo = session.getAttribute("authInfo");
				if(authInfo != null) return true;
			}
			response.sendRedirect(request.getContextPath()+ "/"); //프로젝트명 주소로 간다  
			return false;
		}

		
		
		/// 컨트롤러에 진입후 view가 랜더링하기 전에 실행
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			// TODO Auto-generated method stub
			super.postHandle(request, response, handler, modelAndView);
		}
		
		///컨트롤러에 진입후 view까지 정상적으로 랜더링 한 후에 실행 
		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			// TODO Auto-generated method stub
			super.afterCompletion(request, response, handler, ex);
		}
}
