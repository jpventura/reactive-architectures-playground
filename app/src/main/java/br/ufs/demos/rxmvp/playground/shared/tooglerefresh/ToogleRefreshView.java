package br.ufs.demos.rxmvp.playground.shared.tooglerefresh;

import io.reactivex.functions.Action;

/**
 * Created by bira on 7/8/17.
 */

public interface ToogleRefreshView {

    Action disableRefresh();

    Action enableRefresh();

}
