package it.unibo.tankBattle.model.gameSetup.api;

import java.util.List;
/**
 * javadock.
 * @param <T> param
 */
public interface DataList<T> {
    /**
     * javadoc.
     * @return return
     */
    List<T> getData();
    /**
     * javadoc.
     * @param data param
     */
    void setData(List<T> data);
}
