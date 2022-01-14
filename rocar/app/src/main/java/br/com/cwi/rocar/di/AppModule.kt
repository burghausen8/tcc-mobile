package br.com.cwi.rocar.di

import org.koin.core.module.Module

val appModules: List<Module> = listOf(dataModule, presentationModule)