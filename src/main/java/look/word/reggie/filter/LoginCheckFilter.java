package look.word.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.sun.prism.impl.BaseContext;
import lombok.extern.slf4j.Slf4j;
import look.word.reggie.common.R;
import look.word.reggie.service.UserThreadLocal;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对非登陆 进行拦截
 *
 * @author : look-word
 * 2022-08-09 09:14
 **/
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        log.info("拦截到的请求：{}", requestURI);

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}", id);
        //1、定义不需要处理的请求路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/user/sendMsg",
                "/user/login"
        };

        //2、判断本次请求是否需要处理
        boolean check = check(urls, requestURI);


        //3、如果不需要处理，则直接放行
        if (check) {
            filterChain.doFilter(request, response);
            return;
        }

        //4-1、判断登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("employee") != null) {
            Long empId = (Long) request.getSession().getAttribute("employee");
            log.info("用户已登录，用户id为：{}", empId);
            UserThreadLocal.setCurrentId(empId);
            filterChain.doFilter(request, response);
            log.info("清除employee的threadLocal");
            UserThreadLocal.remove();
            return;
        }
        //4-2、判断登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("user") != null) {
            log.info("用户已登录，用户id为：{}", request.getSession().getAttribute("user"));

            Long userId = (Long) request.getSession().getAttribute("user");
            UserThreadLocal.setCurrentId(userId);
            filterChain.doFilter(request, response);
            log.info("清除user的threadLocal");
            UserThreadLocal.remove();
            return;
        }

        //5、如果未登录则返回未登录结果，通过输出流方式向客户端页面响应数据
        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));

    }

    /**
     * 路径匹配，检查本次请求是否需要放行
     *
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }

}
