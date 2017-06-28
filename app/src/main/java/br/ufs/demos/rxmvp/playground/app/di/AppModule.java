package br.ufs.demos.rxmvp.playground.app.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import br.ufs.demos.rxmvp.playground.triva.di.TriviaComponent;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bira on 6/26/17.
 */

@Module(
        subcomponents = {
                TriviaComponent.class
        }
)
public class AppModule {

    @Provides @Singleton Context provideContext(Application application) {
        return application;
    }

}
