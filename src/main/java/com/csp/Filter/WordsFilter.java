package com.csp.Filter;

import com.csp.Utils.WordsUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.List;

/**
 * 过滤敏感词
 */
public class WordsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        WordsRequest request = new WordsRequest((HttpServletRequest) servletRequest);
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    class WordsRequest extends HttpServletRequestWrapper{

        public WordsRequest(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getParameter(String name) {
            String input = super.getParameter(name);
            List<String> list = WordsUtil.getWords();
            for(String word : list){
                input = input.replaceAll(word, "*");
            }
            return input;
        }
    }
}
