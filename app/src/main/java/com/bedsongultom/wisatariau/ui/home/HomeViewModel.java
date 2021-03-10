package com.bedsongultom.wisatariau.ui.home;

import android.text.method.ScrollingMovementMethod;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText, mText2;


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Pariwisata atau turisme adalah suatu perjalanan yang dilakukan untuk rekreasi atau liburan dan juga persiapan yang dilakukan untuk aktivitas ini. Seorang wisatawan atau turis adalah seseorang yang melakukan perjalanan paling tidak sejauh 80 km dari rumahnya dengan tujuan rekreasi, merupakan definisi oleh Organisasi Pariwisata Dunia.\n" +
                "\n" +
                "Definisi yang lebih lengkap,turisme adalah industri jasa. Mereka menangani jasa mulai dari transportasi, jasa keramahan, tempat tinggal, makanan, minuman dan jasa bersangkutan lainnya seperti bank, asuransi, keamanan dll. Dan juga menawarkan tempat istrihat, budaya, pelarian, petualangan,pengalaman baru dan berbeda lainnya.\n" +
                "\n" +
                "Banyak negara bergantung banyak dari industri pariwisata ini sebagai sumber pajak dan pendapatan untuk perusahaan yang menjual jasa kepada wisatawan. Oleh karena itu pengembangan industri pariwisata ini adalah salah satu strategi yang dipakai oleh Organisasi Non-Pemerintah untuk mempromosikan wilayah tertentu sebagai daerah wisata untuk meningkatkan perdagangan melalui penjualan barang dan jasa.\n \n"+
                "Berdasarkan Peraturan Daerah Provinsi Riau Nomor 4 Tahun 2016, pada tahun 2017, Dinas Pariwisata Provinsi Riau pada awalnya bernama Dinas Pariwisata dan Ekonomi Kreatif Provinsi Riau. Sesuai dengan perkembangan tentang penataan organisasi Pemerintah Daerah maka disusun Peraturan Gubernur Riau Nomor 85 Tahun 2016 Tentang Kedudukan, Susunan Organisasi, Tugas dan Fungsi, serta Tata Kerja Dinas Pariwisata Provinsi Riau. \n");

        mText2 = new MutableLiveData<>();
        mText2.setValue("WELCOME TO WISATA RIAU");
    }

    public LiveData<String> getText() {
        return mText;

    }

    public LiveData<String> getText2(){
        return mText2;
    }

}