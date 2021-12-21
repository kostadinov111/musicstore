package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.view.StatsViewModel;
import bg.softuni.musicstore.service.StatsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    private int anonRequests, authRequest;

    @Override
    public void onRequest() {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if (authentication != null && (authentication.getPrincipal() instanceof UserDetails)) {
            authRequest++;
        } else {
            anonRequests++;
        }
    }

    @Override
    public StatsViewModel getStats() {

        return new StatsViewModel(anonRequests, authRequest);
    }
}
