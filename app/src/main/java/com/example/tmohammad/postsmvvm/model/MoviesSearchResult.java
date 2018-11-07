package com.example.tmohammad.postsmvvm.model;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;

/**
 * movieSearchResult from a search, which contains LiveData<PagedList<movie>> holding query data,
 * and a LiveData<String> of network error state.
 *
 * @author Kaushik N Sanji
 */
public class MoviesSearchResult {
    //LiveData for Search Results
    private final LiveData<PagedList<Movie>> data;
    //LiveData for the Network Errors
    private final LiveData<String> networkErrors;

    public MoviesSearchResult(LiveData<PagedList<Movie>> data, LiveData<String> networkErrors) {
        this.data = data;
        this.networkErrors = networkErrors;
    }

    public LiveData<PagedList<Movie>> getData() {
        return data;
    }

    public LiveData<String> getNetworkErrors() {
        return networkErrors;
    }

}
