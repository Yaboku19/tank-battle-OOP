package it.unibo.tankbattle.model.gamesetup.api;

import java.util.List;

/**
 * Represents a list of {@link Data}.
 * @param <T> data type
 */
public interface DataList<T> {

    /**
     * Gets data list name.
     * @return get the List of Data
     */
    List<T> getData();
}
