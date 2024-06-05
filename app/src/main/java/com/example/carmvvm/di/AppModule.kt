package com.example.carmvvm.di

import com.example.carmvvm.NullOnEmptyConverterFactory
import com.example.carmvvm.remotedatasource.VehicleRemoteDataSource
import com.example.carmvvm.repository.VehicleRepository
import com.example.carmvvm.service.VehicleService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("http://103.123.173.50:8090/jhsmobileapi/mobile/configure/v1/")
        .addConverterFactory(NullOnEmptyConverterFactory())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): VehicleService = retrofit.create(VehicleService::class.java)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(characterService: VehicleService) = VehicleRemoteDataSource(characterService)

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: VehicleRemoteDataSource
    ) =
        VehicleRepository(remoteDataSource)
}