package bg.softuni.musicstore.service;

import bg.softuni.musicstore.model.view.StatsViewModel;

public interface StatsService {

    void onRequest();

    StatsViewModel getStats();
}
