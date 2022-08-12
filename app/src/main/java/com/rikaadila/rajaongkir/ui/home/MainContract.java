package com.rikaadila.rajaongkir.ui.home;

import com.rikaadila.rajaongkir.data.cost.DataType;

import java.util.List;

/**
 * Rika Nur'adila
 */

public interface MainContract {
    interface Presenter{
        void getJNE();
        void getTIKI();
        void getPOS();
        void setupENV(String origin, String destination, int weight);
    }

    interface View{
        void onLoadingCost(boolean loadng, int progress);
        void onResultCost(List<DataType> data, List<String> courier);
        void onErrorCost();

        void showMessage(String msg);
        String getOrigin();
        String getDestination();
    }
}
