// Generated by Dagger (https://dagger.dev).
package com.vullpes.home;

import com.vullpes.mongo.database.ImageToDeleteDao;
import com.vullpes.util.conectivity.NetworkConectivityObserver;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<NetworkConectivityObserver> connectivityProvider;

  private final Provider<ImageToDeleteDao> imageToDeleteDaoProvider;

  public HomeViewModel_Factory(Provider<NetworkConectivityObserver> connectivityProvider,
      Provider<ImageToDeleteDao> imageToDeleteDaoProvider) {
    this.connectivityProvider = connectivityProvider;
    this.imageToDeleteDaoProvider = imageToDeleteDaoProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(connectivityProvider.get(), imageToDeleteDaoProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<NetworkConectivityObserver> connectivityProvider,
      Provider<ImageToDeleteDao> imageToDeleteDaoProvider) {
    return new HomeViewModel_Factory(connectivityProvider, imageToDeleteDaoProvider);
  }

  public static HomeViewModel newInstance(NetworkConectivityObserver connectivity,
      ImageToDeleteDao imageToDeleteDao) {
    return new HomeViewModel(connectivity, imageToDeleteDao);
  }
}
