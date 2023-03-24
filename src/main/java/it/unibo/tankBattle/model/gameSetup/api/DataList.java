package it.unibo.tankBattle.model.gameSetup.api;

import java.util.List;

public interface DataList<T> {
    public List<T> getData();

    public void setData(List<T> data);
}
