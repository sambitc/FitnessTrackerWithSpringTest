package com.pluralsight.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

public class ExUsernamePasswordAuthenticationFilter extends
        UsernamePasswordAuthenticationFilter {

    private String extraParameter = "j_company";
    private String delimiter = ":";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
        String j_company = request.getParameter("j_company");

        System.out.println("Company Value is --------" + j_company);
        request.getSession().setAttribute("j_company", j_company);
        return super.attemptAuthentication(request, response);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        String username = request.getParameter(getUsernameParameter());
        String extraInput = request.getParameter(getExtraParameter());

        String combinedUsername = username + getDelimiter() + extraInput;

        System.out.println("Combined username = " + combinedUsername);
        return combinedUsername;
    }

    /**
     * @return The parameter name which will be used to obtain the extra input
     * from the login request
     */
    public String getExtraParameter() {
        return this.extraParameter;
    }

    /**
     * @param extraParameter The parameter name which will be used to obtain the
     * extra input from the login request
     */
    public void setExtraParameter(String extraParameter) {
        this.extraParameter = extraParameter;
    }

    /**
     * @return The delimiter string used to separate the username and extra
     * input values in the string returned by <code>obtainUsername()</code>
     */
    public String getDelimiter() {
        return this.delimiter;
    }

    /**
     * @param delimiter The delimiter string used to separate the username and
     * extra input values in the string returned by
     * <code>obtainUsername()</code>
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
