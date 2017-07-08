package br.ufs.demos.rxmvp.playground.trivia.presentation;

import br.ufs.demos.rxmvp.playground.shared.emptystate.EmptyStateView;
import br.ufs.demos.rxmvp.playground.shared.errorstate.ErrorStateView;
import br.ufs.demos.rxmvp.playground.shared.loadingcontent.LoadingView;
import br.ufs.demos.rxmvp.playground.shared.networking.NetworkingErrorView;
import br.ufs.demos.rxmvp.playground.trivia.presentation.models.FactViewModel;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/**
 * Created by bira on 6/29/17.
 */

public interface DisplayFactsView
        extends LoadingView, ErrorStateView, EmptyStateView, NetworkingErrorView {

    Disposable subscribeInto(Flowable<FactViewModel> flow);

}
