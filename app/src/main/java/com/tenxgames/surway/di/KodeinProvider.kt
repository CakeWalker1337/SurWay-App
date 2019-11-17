package com.tenxgames.surway.di

import org.kodein.di.Kodein

interface KodeinProvider {
    fun provide(): Kodein.Module
}