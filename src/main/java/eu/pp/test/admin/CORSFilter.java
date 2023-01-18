package eu.pp.test.admin;

import lombok.NoArgsConstructor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@NoArgsConstructor
public class CORSFilter implements Filter {
    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        //destroy
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
//    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain chain) throws IOException, ServletException {
//        final HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "*");
//        response.setHeader("Access-Control-Allow-Headers", "*");
//        chain.doFilter(servletRequest, servletResponse);
//    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("CORSFilter HTTP Request: " + request.getMethod());

        // Authorize (allow) all domains to consume the content
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");

        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
        if (request.getMethod().equals("OPTIONS")) {
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }

        // pass the request along the filter chain
        chain.doFilter(request, servletResponse);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(final FilterConfig fConfig) throws ServletException {
        //init
    }
}
