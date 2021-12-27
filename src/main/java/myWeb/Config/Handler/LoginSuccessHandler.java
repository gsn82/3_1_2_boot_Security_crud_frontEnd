package myWeb.Config.Handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException{
        Set<String> roleSet = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roleSet.contains("Admin")) httpServletResponse.sendRedirect("/admin");
        else httpServletResponse.sendRedirect("/user");
    }
}