package it.unibo.tankbattle.model.gamesetup.api;

import java.util.List;

/**
 * rappresent a generci list of Data that need to be read for xml files.
 * @param <T> param
 */
public interface DataList<T> {

    /**
     * 
     * @return get the List of Data
     */
    List<T> getData();

    /**
     * Set the List of data.
     * @param data the list to be set
     */
    void setData(List<T> data);
}
