package com.bedsongultom.wisatariau.ui.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bedsongultom.wisatariau.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    RecyclerView rc;
    GalleryAdapter adapter;
    private RecyclerView.LayoutManager lm;
    private Context context;
    private Drawable iconY;
    private Drawable iconX;

    final  String Mtakus="Candi Muara Takus adalah situs candi tertua di Sumatra, merupakan satu-satunya situs peninggalan sejarah yang berbentuk candi di Riau. Candi yang bersifat Buddhis ini merupakan bukti bahwa agama Buddha pernah berkembang di kawasan ini.\n" +

            "Candi ini dibuat dari batu pasir, batu sungai dan batu bata. Berbeda dengan candi yang ada di Jawa, yang dibuat dari batu andesit yang diambil dari pegunungan. Bahan pembuat Candi Muara Takus, khususnya tanah liat, diambil dari sebuah desa yang bernama Pongkai, terletak kurang lebih 6 km di sebelah hilir situs Candi Muara Takus. Nama Pongkai kemungkinan berasal dari Bahasa Tionghoa, Pong berati lubang dan Kai berarti tanah, sehingga dapat bermaksud lubang tanah, yang diakibatkan oleh penggalian dalam pembuatan Candi Muara Takus tersebut. Bekas lubang galian itu sekarang sudah tenggelam oleh genangan waduk PLTA Koto Panjang. Namun dalam Bahasa Siam, kata Pongkai ini mirip dengan Pangkali yang dapat berarti sungai, dan situs candi ini memang terletak pada tepian sungai.\n" +

            "Bangunan utama di kompleks ini adalah sebuah stupa yang besar, berbentuk menara yang sebagian besar terbuat dari batu bata dan sebagian kecil batu pasir kuning. Di dalam situs Candi Muara Takus ini terdapat bangunan candi yang disebut dengan Candi Tua, Candi Bungsu, Stupa Mahligai serta Palangka. Selain bangunan tersebut di dalam komplek candi ini ditemukan pula gundukan yang diperkirakan sebagai tempat pembakaran tulang manusia. Sementara di luar situs ini terdapat pula bangunan-bangunan (bekas) yang terbuat dari batu bata, yang belum dapat dipastikan jenis bangunannya. ";

    final String AlamMayang ="Taman rekreasi ini berlokasi di Jalan Imam Munandar Harapan Raya Pekanbaru. Anda dapat menghabiskan akhir pekan bersama keluarga dan teman-teman bersantai di alam terbuka.\n" +

            "Di dalam kawasan sekitar 24 hekter ini, tersedia ragam permainan yang cukup menghibur, terutama untuk anak-anak. Mulai dari sepeda air, banana boat, safary train, flying fox, trek sepeda dan beberapa lainnya.\n" +

            "Taman rekreasi ini juga terdapat hamparan kolam yang cukup luas, dan ikannya boleh dipancing. Kalau datangnya hari libur, pengunjung juga di hibur live musik dari panggung yang terletak di pinggiran kolam.\n" +

            "Fasilitas penunjang lainnya terdapat mushola serta beberapa fasilitas lainnya. Fasilitas toiletnya juga cukup bersih. Taman rekreasi ini cocok untuk rekreasi keluarga.\n" +

            "Lokasinya juga tidak jauh-jauh amat. Kalau kita dari Bandara Internasional Sultan Syarif Kasim II, cukup sedikit menyisiri jalan protokol Jenderal Sudirman. Kemudian berbelok ke kanan dari jembatan Fly Over menyusuri Jl Imam Munandar, Pekanbaru.\n" +

            "Di penghujung Jalan Imam Munandar, sebelah kanan, sudah terlihat pintu gerbang komplek Alam Mayang. Menurut administrasi pemerintah Kota Pekanbaru, kawasan ini masuk dalam wilayah Kecamatan Tenayan Raya\n"+
            "Editor: Sesri \n" +
            "Source From : https://pekanbaru.tribunnews.com/2015/05/13/alam-mayang-destinasi-wisata-alam-di-kota-pekanbaru";

    final String SiakSriIndrapura ="Istana Siak Sri Inderapura atau Istana Asserayah Hasyimiah[1] atau Istana Matahari Timur merupakan kediaman resmi Sultan Siak yang mulai dibangun pada tahun 1889, yaitu pada masa pemerintahan Sultan Syarif Hasyim. Istana ini merupakan peninggalan Kesultanan Siak Sri Inderapura yang selesai dibangun pada tahun 1893. Kini istana ini masuk wilayah administrasi pemerintahan Kabupaten Siak.\n" +

            "Kompleks istana ini memiliki luas sekitar 32.000 meter persegi yang terdiri dari 4 istana yaitu Istana Siak, Istana Lima, Istana Padjang, dan Istana Baroe. Istana Siak sendiri memiliki luas 1.000 meter persegi. \n" +

            "Istana Siak memiliki arsitektur bercorak Melayu, Arab, dan Eropa. Bangunannya terdiri dari dua lantai. Lantai bawah dibagi menjadi enam ruangan sidang: Ruang tunggu para tamu, ruang tamu kehormatan, ruang tamu laki-laki, ruang tamu untuk perempuan, satu ruangan di samping kanan adalah ruang sidang kerajaan, juga digunakan untuk ruang pesta. Lantai atas terbagi menjadi sembilan ruangan, berfungsi untuk istirahat Sultan serta para tamu istana. Di puncak bangunan terdapat enam patung burung elang sebagai lambang keberanian Istana. Sementara pada halaman istana masih dapat dilihat delapan meriam menyebar ke berbagai sisi-sisi halaman istana, kemudian di sebelah kiri belakang istana terdapat bangunan kecil yang dahulunya digunakan sebagai penjara sementara\n"+
            "Source From : https://id.wikipedia.org/wiki/Istana_Siak_Sri_Inderapura";

    final String SungaiKampar="Sungai Kampar merupakan sebuah sungai di Indonesia, sekitar 800 km di barat laut ibu kota Jakarta\n" +
            "Sungai ini berhulu di Bukit Barisan sekitar Sumatra Barat dan bermuara di pesisir timur Pulau Sumatra di wilayah provinsi Riau. Sungai ini merupakan pertemuan dua buah sungai yang hampir sama besar, yang disebut dengan Kampar Kanan dan Kampar Kiri. Pertemuan ini berada pada kawasan Langgam (Kabupaten Pelalawan), dan setelah pertemuan tersebut sungai ini disebut dengan Sungai Kampar sampai ke muaranya di Selat Malaka. Sementara sekitar kawasan hulu air sungai ini dimanfaatkan untuk PLTA Koto Panjang yang mempunyai kapasitas 114 MW. Sementara di hilir menjelang muara, sungai ini terkenal dengan ombak besarnya yang bernama Ombak Bono.[3][4][1][5]\n" +

            "Aliran Sungai Kampar Kanan menelusuri Lima Puluh Kota dan Kampar, sedangkan aliran Sungai Kampar Kiri melewati Sijunjung, Kuantan Singingi dan Kampar, kemudian kedua aliran sungai tersebut berjumpa di Pelalawan.\n" +

            "Sungai Kampar Kanan bermata air dari Gunung Gadang, memiliki luas daerah tangkapan air 5.231 km². Alur utama semula mengalir ke utara kemudian berbelok ke timur, bertemu dengan anak sungai Batang Kapur Nan Gadang, mengalir dengan kemiringan sedang melalui lembah Batubersurat. Selanjutnya bertemu dengan anak sungai Batang Mahat, mengalir ke arah timur. Para penduduk didaerah Danau Bingkuang kerap melakukan penambangan batu dan pasir secara ilegal sehingga terjadi pengikisan tepian sungai. Sungai Kampar Kiri bermata air dari Gunung Ngalautinggi, Gunung Solokjanjang, Gunung Paninjauan Nan Elok, memiliki luas daerah tangkapan air 7.053 km². Dua anak sungai besar bernama Batang Sibayang dan Batang Singingi.\n" +

            "Semakin ke hilir, badan sungai dan volume airnya semakin membesar karena ditambah dengan berbagai anak sungai lainnya. Sungai ini dikenal dengan gelombang Bono-nya, yaitu gelombang tinggi yang diakibatkan pertemuan air sungai dengan air laut. Bono biasanya terjadi pada saat pasang, sehingga air yang berasal dari sungai, tertekan oleh air laut. Ditambah lagi dengan dangkalnya muara mengakibatkan gelombang yang tercipta semakin tinggi\n"+
            "Source From: https://id.wikipedia.org/wiki/Sungai_Kampar";

    final String MesjidAgung="merupakan sebuah masjid yang terletak di Pekanbaru, Indonesia. Masjid ini dibangun pada tahun 1963 dan selesai pada tahun 1968. Masjid yang di ibu kota Provinsi Riau, Pekanbaru tersebut saat ini merupakan salah satu yang termegah di Indonesia. Dilihat dari sisi bangunannya, masjid banyak mendapat pengaruh dari gaya arsitektur Melayu, Turki, Arab dan India. \n" +

            "Mesjid Agung An Nur berdiri tanggal 27 Rajab 1388 H atau bertepatan dengan tanggal 19 Oktober 1968, Masjid Agung An-Nur diresmikan oleh Arifin Ahmad, Gubernur Riau waktu itu dan tahun 2000 pada masa gubernur Saleh Djasit mesjid ini direnovasi secara besar-besaran.\n" +

            "Masjid Agung An-Nur Riau yang kita saksikan begitu megah saat ini bukanlah bangunan asli hasil pembangunan tahun 1966 dan diresmikan tahun 1968. Tapi merupakan bangunan hasil renovasi total dan pembangunan kembali dari masjid Agung An-Nur yang lama. Di pergantian milenium tahun 2000 lalu, pada saat Riau dibawah kepemimpinan gubernur Shaleh Djasit, Masjid Agung An-Nur yang lama di rombak total ke bentuknya saat ini.\n" +

            "Dari pembangunan tahun 2000 tersebut luas lahan masjid ini bertambah tiga kali lipat dari sebelumnya yang hanya seluas 4 hektare menjadi 12.6 hektare.\n" +

            "n taman nan hijau dan lahan parkir yang begitu luas.\n" +

            "Source From : https://id.wikipedia.org/wiki/Masjid_Agung_An-Nur";

    final String PulauJemur="Pulau Jemur (luas 250 ha) adalah sebuah pulau milik Indonesia yang terletak di Selat Malaka, dekat dengan perbatasan Malaysia. Pulau ini termasuk dalam wilayah Kecamatan Pasir Limau Kapas, Kabupaten Rokan Hilir, Provinsi Riau. Letaknya sekitar 72,4 km dari Bagansiapiapi dan 64,3 km dari Pelabuhan Klang di Malaysia. Pulau ini merupakan pulau terluas dari Kepulauan Arwah, gugusan sembilan pulau, di antaranya Pulau Jemur, Tokong Emas, Tokong Simbang dan Labuhan Bilik.\n" +

            "Pulau Jemur terkenal dengan panorama alam seperti pantai berpasir putih dan sebagai habitat penyu hijau. Perairan di sekitar pulau ini terkenal sebagai daerah penghasil ikan.\n" +

            "Pulau Jemur tidak berpenghuni dan hanya menjadi tempat persinggahan bagi nelayan yang sedang melaut. Sebuah pos TNI-AL didirikan di pulau ini untuk kepentingan pengamatan dan navigasi.\n" +

            "Pulau ini sempat menjadi objek sentimen anti-Malaysia di Indonesia, setelah sejumlah media Indonesia pada bulan Agustus 2009 melaporkan bahwa Malaysia bermaksud mengelola Pulau Jemur sebagai tujuan wisata.[1] [2]melalui situs traveljournals.net.[3] Kepemilikan sah Pulau Jemur (dan gugusan Kepulauan Arwah) oleh Indonesia didasarkan atas sertifikat tanah yang dimiliki oleh Raja Siak. Ketegangan ini baru mereda setelah diketahui terdapat pulau bernama Pulau Jemor sebagai bagian dari Kesultanan Selangor.[4] \n" +

            "Source From : https://id.wikipedia.org/wiki/Pulau_Jemur";

    final String labersa ="Labersa Water Park Pekanbaru merupakan taman rekreasi permainan air paling besar di Pekanbaru. Tempat wisata keluarga ini ialah bagian dari PT Labersa Hutahaean yang merupakan kawasan one stop recreation. Dilengkapi pula dengan sarana hotel bintang 5 dan lapangan golf.\n" +
            "Taman rekreasi yang sangat tepat dijadikan sebagai wisata keluarga karena memiliki banyak permainan anak. Lokasi yang luas juga membuat anak leluasa bermain. Di samping itu, fasilitas yang disediakan juga memadai.\n" +
            "Jam Buka Labersa Water Park Pekanbaru\n" +
            "Water park buka mulai pagi hingga sore hari. Tidak ada perubahan jam buka di hari Sabtu, Minggu, atau Hari Libur Nasional.\n" +
            "Senin-Jumat 09.00-17.00 WIB\n" +
            "Sabtu-Minggu 09.00-18.00 WIB\n"+
            "Source From : https://travelspromo.com/htm-wisata/labersa-water-park-pekanbaru/";


    final String PulauAruah ="Kepulauan ini tidak seseram namanya dan tidak ada hubunganya dengan hal-hal gaib. Sebaliknya, Kepulauan Arwah memiliki pantai kepualauan arwah propinsi riaueksotisme yang sangat mengaggumkan untuk dikunjungi. Kepulauan Arwah terdiri dari 9 gugusan kepulauan kecil yaitu Pulau Jemur, Pulau Batu Berlayar, Pulau Batu Mandi, Pulau Tokong Simbang, Pulau Batu Adang, Pulau Tokong Pucung, Pulau Pertandangan, Pulau Tokong Mas,  dan Pulau Labuhan Bilik."+
            "Source From : https://www.azwisata.com/2015/07/8-tempat-wisata-di-riau.html";

     final String AirTerjun="Air Terjun Temam merupakan salah satu objek wisata alam yang berada di Propinsi Sumatera Selatan. Air terjun ini berada di Kota Lubuk Linggau tepatnya di Kelurahan Rahma, 11 kilometer dari pusat kota Lubuk Linggau yang termasuk dalam Kabupaten Musi Rawas, Propinsi Sumatera Selatan.\n" +

             "Tidak seperti air terjun yang lain, Air Terjun Temam ini tidak meninggi tetapi melebar, dengan ukuran tinggi sekitar 12 meter dan lebar 25 meter. Di sekitar air terjun terdapat banyak batu-batuan alam serta pepohonan yang hijau dengan kondisi alam yang masih terjaga. Sangat disayangkan, potensial kawasan wisata Air Terjun Temam ini tidak diimbangi dengan fasilitas yang lebih komplit.\n" +

             "Untuk menuju ke lokasi Air Terjun Temam ini sangatlah mudah. Dari Kota Lubuk Linggau hanya memerlukan waktu 15-20 menit dengan menggunakan kendaraan pribadi. Jalan-jalan menuju ke lokasi objek wisata ini juga sudah bagus.\n"+
             "Source From :https://wisatakita.com/wisata/Sumatera.Selatan/Lubuk.Linggau/Air.Terjun.Temam.";

     final String KebunKasangKulim="PEKANBARU - Kebun Binatang Marga Satwa Kasang Kulim yang terletak di Jalan Kubang Raya, Desa Kubang Jaya, Kecamatan Siak Hulu, Kabupaten Kampar, menjadi salah satu destinasi wisata bagi masyarakat selama hari raya Idul Fitri 1437 Hijriah/2016 Masehi, yang ada di Provinsi Riau.\n" +

             "Hingga hari ini, H+4, Sabtu (9/7/16) di Kebun Binatang Marga Satwa Kasang Kulim dipadati oleh para pengunjung, yang mulai berdatangan dari pagi hari.\n" +

             "Agustina, pimpinan Kebun Binatang Marga Satwa Kasang Kulim mengatakan, sebanyak 135 jenis marga satwa berada di kebun binatang ini, dengan berbagai fasilitas dipersiapkan untuk memanjakan pengunjung yang datang.\n" +

             "Kebun binatang ini mendatangkan artis D Academy 3 Indosiar, Tasya, dan artis-artis dari Sumatera Barat. Fasilitas lainya yaitu orgen tunggal, gajah tunggang, taman pancing, out bond, kolom berenang, komedi putar, bendi, dan pasar malam. Gajah tunggang menjadi incaran pengunjung, katanya.\n" +

             "Lebih lanjut pihaknya menambahkan Kebun Binatang Marga Satwa Kasang Kulim ini buka mulai dari pukul 08.00 WIB hingga pukul 17.30 WIB dengan tiket masuk per orang seharga dewasa Rp25 ribu dan anak-anak Rp15 ribu.\n" +

             "Pada lebaran pertama kemarin pengunjung sebanyak 1.000 orang, hari raya kedua sebanyak 2500 orang, dan hari ini Jumat (8/7/16) pengunjung diprediksi sebanyak 1500 orang mengalami penurunan dikarenakan hari Jumat, serta puncaknya diprediksi akan terjadi pada Ahad (10/7/16) kebun binatang ini akan padati pengunjung sebanyak 3000 orang, dengan menampilkan Mlmusik tradisional Calempong Kampar,ungkap Agustina \n"+
             "Source From : https://mediacenter.riau.go.id/index.php?/read/22676/kebun-binatang-kasang-kulim-dipadati-pengunju.html";


    private final String [] image_descs = new String[] {
            "Muara Takus",
            "Air Terjun Lubuk Linggau",
            "Wisata Alam Mayang",
            "Istana Siak",
            "Kebun binatang kasang kulim",
            "Water Park Laberssa",
            "Pulau Jemur",
            "Sungai Kampar",
            "Mesjid Agung An Nur",
            "Pulau Aruah"

    };
    private final String [] image_urls = new String[] {

                    "https://phinemo.com/wp-content/uploads/2017/06/2120459takus-3780x390.jpg",
                    "https://phinemo.com/wp-content/uploads/2017/06/Air-Terjun-Lubuk-Bigau_1-700x460.jpg",
                    "https://phinemo.com/wp-content/uploads/2017/06/6357834187_e84b07307a_b.jpg",
                    "https://phinemo.com/wp-content/uploads/2017/06/PO2016022200062-20161124102638.jpg",
                    "https://phinemo.com/wp-content/uploads/2017/06/RIM-Kebun-Binatang-Kasang-Kulim.jpg",
                    "https://phinemo.com/wp-content/uploads/2017/06/water-park_20150719_153712.jpg",
                    "https://phinemo.com/wp-content/uploads/2017/06/Tempat-Wisata-Di-Riau-Pulau-Jemur.jpg",
                    "https://phinemo.com/wp-content/uploads/2017/06/6207196698-83206fda01-o.jpg",
                    "https://kompaswisata.com/wp-content/uploads/2017/01/Tempat-wisata-di-Pekanbaru.jpg",
                    "https://2.bp.blogspot.com/-zrVIDgzCD9c/VbSOIKgAqGI/AAAAAAAAPLw/lvhZ_JFyt5U/s1600/wisata-propinsi-riau-pantai-kepualauan-arwah.jpg"
    };

  /*  String [][] images_id = new String[][]{

            {"1", "https://phinemo.com/wp-content/uploads/2017/06/2120459takus-3780x390.jpg"},

            {"aa", "https://phinemo.com/wp-content/uploads/2017/06/Air-Terjun-Lubuk-Bigau_1-700x460.jpg"},

            {"bb", "https://phinemo.com/wp-content/uploads/2017/06/6357834187_e84b07307a_b.jpg"},

            {"cc", "https://phinemo.com/wp-content/uploads/2017/06/PO2016022200062-20161124102638.jpg"},

            {"dd", "https://phinemo.com/wp-content/uploads/2017/06/RIM-Kebun-Binatang-Kasang-Kulim.jpg"},

            {"ee", "https://phinemo.com/wp-content/uploads/2017/06/water-park_20150719_153712.jpg"},

            {"ff", "https://phinemo.com/wp-content/uploads/2017/06/Tempat-Wisata-Di-Riau-Pulau-Jemur.jpg"},

            {"gg", "https://phinemo.com/wp-content/uploads/2017/06/6207196698-83206fda01-o.jpg"},

            {"hh", "https://sgp1.digitaloceanspaces.com/tz-mag-id/wp-content/uploads/2018/08/111108084747/tempat-wisata-pekanbaru-4-1024x683.jpeg"},

            {"jj", "https://sgp1.digitaloceanspaces.com/tz-mag-id/wp-content/uploads/2018/08/111108082727/tempat-wisata-pekanbaru-1-1024x768.jpeg"}
    };
*/





    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        rc = (RecyclerView) root.findViewById(R.id.rvGallery);
        rc.setHasFixedSize(true);
        iconY = getContext().getResources().getDrawable(R.drawable.ic_close_white_m);
        iconX = getContext().getResources().getDrawable(R.drawable.ic_check_white_m);


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        rc.setLayoutManager(layoutManager);

        final ArrayList<Galleries> galleries = prepareData();
        final GalleryAdapter adapter = new GalleryAdapter(getContext(),galleries);
        rc.setAdapter(adapter);

        rc.addOnItemTouchListener(new GalleryFragment.RecyclerTouchListener(context,
                rc, new GalleryFragment.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                final LinearLayout layout = new LinearLayout(getContext());
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setGravity(Gravity.CLIP_VERTICAL);
                layout.setPadding(0, -10 , 0, 0);



                TextView title = new TextView(getContext());
                title.setBackgroundColor(Color.parseColor("#8c108f"));
                title.setText("Details of Gallery");
                title.setTextColor(Color.WHITE);
                title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                title.setPadding(30, 30, 30, 30);
                builder.setCustomTitle(title);


                final ScrollView scrollView = new ScrollView(getContext());




                String content = null;

                Galleries item = galleries.get(position);
                final String image_desc  = item.getImage_desc();
                final String image_url   = item.getImage_url();



                final ImageView imageUrl = new ImageView(getContext());
                imageUrl.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                Picasso.with(getContext())
                        .load(""+item.getImage_url())
                        .placeholder(android.R.drawable.ic_dialog_alert)
                        .error(android.R.drawable.ic_dialog_alert)
                        .into(imageUrl);
                imageUrl.setPadding(0, 0 , 0, 0);
                layout.addView(imageUrl);



                final TextView tvImageDesc = new TextView(getContext());
                tvImageDesc.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                tvImageDesc.setText(String.valueOf(item.getImage_desc()));

                tvImageDesc.setTextColor(Color.parseColor("#8c108f"));
                tvImageDesc.setTextSize(20);
                tvImageDesc.setPadding(30, 2, 30, 30);
                layout.addView(tvImageDesc);

                if (image_desc== "Muara Takus"){
                    content = Mtakus;

                }
                if(image_desc== "Air Terjun Lubuk Linggau"){
                    content = AirTerjun;

                }if(image_desc== "Wisata Alam Mayang"){

                    content = AlamMayang;

                }

                if(image_desc== "Istana Siak"){
                    content = SiakSriIndrapura;

                }

                if(image_desc== "Kebun binatang kasang kulim"){
                    content = KebunKasangKulim;

                }

                if(image_desc== "Water Park Laberssa"){
                    content = labersa;

                }

                if(image_desc== "Pulau Jemur"){
                    content = PulauJemur;
                }

                if(image_desc== "Sungai Kampar"){
                    content = SungaiKampar;

                }

                if(image_desc== "Mesjid Agung An Nur"){
                    content = MesjidAgung;

                }

                if(image_desc== "Pulau Aruah"){
                    content = PulauAruah;
                }



                final TextView documentView = new TextView(getContext());
                documentView.setGravity(View.TEXT_ALIGNMENT_CENTER|View.TEXT_ALIGNMENT_TEXT_END);
               // documentView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
              //  documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
                documentView.setPadding(30, 30, 30, 30);
                documentView.setText(content);

                layout.addView(documentView);

                scrollView.addView(layout);
                builder.setView(scrollView);

                builder.setCancelable(false)
                        .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                            }
                        });
                final AlertDialog dialog = builder.create();
                dialog.show();
                dialog.getWindow().setLayout(700, 1030);



               /* WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

                lp.copyFrom(alertDialog.getWindow().getAttributes());
                lp.width = 150;
                lp.height = 500;
                lp.x=-170;
                lp.y=100;
                dialog.getWindow().setAttributes(lp);
*/



                Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                //positiveButton.setGravity(Gravity.CENTER_HORIZONTAL);
                //params.weight = 14.0f;
                positiveButton.setPadding(0, 0, 0, 0);

                positiveButton.setGravity(Gravity.CENTER);
                positiveButton.setLayoutParams(params);
                positiveButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
                positiveButton.setTextColor(Color.parseColor("#8c108f"));
                positiveButton.invalidate();

                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


        }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));




        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private static interface ClickListener{
        public void onClick(View view,int position);
        public void onLongClick(View view,int position);
    }


    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private GalleryFragment.ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView rc, final GalleryFragment.ClickListener clicklistener){

            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=rc.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,rc.getChildAdapterPosition(child));
                    }
                }
            });
        }


        @Override
        public void onTouchEvent(RecyclerView rc, MotionEvent e) {

        }

        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }


        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }


    private ArrayList<Galleries> prepareData(){

        ArrayList<Galleries> galleries = new ArrayList<>();
        for(int i=0;i<image_descs.length;i++){
            Galleries item = new Galleries();
            item.setImage_url(image_urls[i]);
            item.setImage_desc(image_descs[i]);
            galleries.add(item);
        }
        return galleries;
    }

}