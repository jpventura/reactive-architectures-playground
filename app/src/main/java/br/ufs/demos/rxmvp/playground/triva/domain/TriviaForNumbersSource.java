package br.ufs.demos.rxmvp.playground.triva.domain;

import io.reactivex.Flowable;

/**
 * Created by bira on 6/26/17.
 */

public interface TriviaForNumbersSource {

    Flowable<FactAboutNumber> fetchTrivia();

}
