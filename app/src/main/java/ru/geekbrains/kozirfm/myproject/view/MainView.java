package ru.geekbrains.kozirfm.myproject.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.geekbrains.kozirfm.myproject.model.data.Photos;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

    void initRecyclerView(Photos photos);

}
