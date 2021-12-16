package bg.softuni.musicstore.model.view;

public class StatsViewModel {

    private final int anonRequests;
    private final int authRequest;

    public StatsViewModel(int anonRequests, int authRequest) {
        this.anonRequests = anonRequests;
        this.authRequest = authRequest;
    }

    public int getTotalRequest() {
        return anonRequests + authRequest;
    }

    public int getAnonRequests() {
        return anonRequests;
    }

    public int getAuthRequest() {
        return authRequest;
    }
}
