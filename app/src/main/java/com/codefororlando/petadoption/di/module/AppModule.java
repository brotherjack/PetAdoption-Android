package com.codefororlando.petadoption.di.module;

import android.app.Application;
import android.content.Context;

import com.codefororlando.petadoption.data.provider.AnimalProvider;
import com.codefororlando.petadoption.data.provider.IAnimalProvider;
import com.codefororlando.petadoption.data.provider.IShelterProvider;
import com.codefororlando.petadoption.data.provider.ShelterProvider;
import com.codefororlando.petadoption.network.IPetAdoptionService;
import com.codefororlando.petadoption.recyclerview.AAnimalListAdapter;
import com.codefororlando.petadoption.recyclerview.AnimalListAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tencent on 10/8/16.
 */
@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

    @Provides
    @Singleton
    IAnimalProvider provideAnimalProvider(IPetAdoptionService petAdoptionService) {
        return new AnimalProvider(petAdoptionService);
    }

    @Provides
    @Singleton
    IShelterProvider provideShelterProvider() {
        return new ShelterProvider();
    }

    @Provides
    AAnimalListAdapter provideAnimalListAdapter() {
        return new AnimalListAdapter();
    }

}
