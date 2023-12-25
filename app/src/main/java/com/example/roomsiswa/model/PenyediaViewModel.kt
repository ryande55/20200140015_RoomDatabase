// Package dan imports yang diperlukan untuk proyek ini.
package com.example.roomsiswa.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomsiswa.AplikasiSiswa

// Objek singleton untuk menyediakan factory untuk membuat ViewModel.
object PenyediaViewModel {
    val Factory = viewModelFactory {
        // Inisialisasi HomeViewModel dengan repository dari AplikasiSiswa.
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        // Inisialisasi EntryViewModel dengan repository dari AplikasiSiswa.
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        // Inisialisasi DetailsViewModel dengan SavedStateHandle dan repository dari AplikasiSiswa.
        initializer {
            DetailsViewModel(
                createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa,
            )
        }

        // Inisialisasi EditViewModel dengan SavedStateHandle dan repository dari AplikasiSiswa.
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa,
            )
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah instance dari
 * [AplikasiSiswa].
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
