package create_api.test.config;

import create_api.test.register.RegisterForDb;
import create_api.test.register.RegisterRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private RegisterRepository registerRepo;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeaderFromUI = request.getHeader("Authorization");

        if(authHeaderFromUI != null && authHeaderFromUI.startsWith("Bearer ")){
            String token = authHeaderFromUI.substring(7);
            String email = jwtConfig.extractEmail(token);

            if(email != null){
                RegisterForDb user = registerRepo.findByEmail(email).orElse(null);

                if(user != null){
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }

        filterChain.doFilter(request, response);

    }
}