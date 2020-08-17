package ru.geekbrains.kozirfm.myproject.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface DetailView extends MvpView {

    void setDetailPhoto(String url);

}
