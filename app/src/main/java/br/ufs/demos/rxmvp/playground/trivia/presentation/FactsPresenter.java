package br.ufs.demos.rxmvp.playground.trivia.presentation;

import br.ufs.demos.rxmvp.playground.shared.BehavioursCoordinator;
import br.ufs.demos.rxmvp.playground.shared.lifecyclestrategy.LifecycleStrategist;
import br.ufs.demos.rxmvp.playground.trivia.domain.FactAboutNumber;
import br.ufs.demos.rxmvp.playground.trivia.domain.GetRandomFacts;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/**
 * Created by bira on 6/29/17.
 */

public class FactsPresenter {

    private GetRandomFacts usecase;
    private DisplayFactsView view;
    private BehavioursCoordinator<FactAboutNumber> coordinator;
    private LifecycleStrategist strategist;
    private ViewModelMapper mapper;

    public FactsPresenter(GetRandomFacts usecase,
                          DisplayFactsView view,
                          BehavioursCoordinator<FactAboutNumber> coordinator,
                          LifecycleStrategist strategist,
                          ViewModelMapper mapper) {

        this.usecase = usecase;
        this.view = view;
        this.coordinator = coordinator;
        this.strategist = strategist;
        this.mapper = mapper;
    }

    public void fetchRandomFacts() {
        Flowable<FactViewModel> dataFlow =
                usecase.fetchTrivia()
                        .compose(coordinator)
                        .map(fact -> mapper.translateFrom(fact));

        Disposable toDispose = view.subscribeInto(dataFlow);
        strategist.applyStrategy(toDispose);
    }

}
