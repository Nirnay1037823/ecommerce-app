//package com.example.ecommerce.application.Configuration;
//
//import com.example.ecommerce.application.Services.TokenService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.bson.types.ObjectId;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.web.filter.GenericFilterBean;
//
//import java.io.IOException;
//
//@Configuration //Among the other beans this is the priority
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class JwtFilter extends GenericFilterBean {
//    private TokenService tokenService;
//    public JwtFilter(TokenService tokenService) {
//        this.tokenService = tokenService;
//    }
//    @Override
//    public void doFilter(ServletRequest req,
//                         ServletResponse res,
//                         FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
//        String token = httpServletRequest.getHeader("Authorization");
//        if("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
//            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
//            return ;
//        }
//        //specific APIs without token
//        if(allowRequestWithoutToken(httpServletRequest)) {
//            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
//            filterChain.doFilter(req,res);
//        }
//        else {
//            ObjectId userId = new ObjectId(tokenService.getUserIdToken(token));
//            httpServletRequest.setAttribute("userId", userId);
//            filterChain.doFilter(req,res);
//        }
//    }
//    public boolean allowRequestWithoutToken(HttpServletRequest httpServletRequest) {
//        System.out.println(httpServletRequest.getRequestURI());
//        String requestURI = httpServletRequest.getRequestURI();
//        if (requestURI.contains("/user")
////                || requestURI.equals("/api/v1/user/registration")
////                || requestURI.equals("/api/v1/user/login")
//                || requestURI.equals("/api/v1/products/get-all")
//                || requestURI.equals("/api/v1/category/get-all")) {
//            return true;
//        }
//        return false;
//    }
//}
