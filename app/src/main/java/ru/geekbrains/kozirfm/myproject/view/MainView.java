package ru.geekbrains.kozirfm.myproject.view;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.geekbrains.kozirfm.myproject.model.data.Hit;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

    void initRecyclerView(List<Hit> hits);

}
