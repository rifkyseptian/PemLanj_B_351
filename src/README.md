 Tugas 3 - Sistem Pengembalian Barang yang Tidak Sesuai
 
Deskripsi Program

Program ini merupakan aplikasi sederhana berbasis "Java" yang digunakan untuk mencatat proses **pengembalian barang yang tidak sesuai**.  
Pengguna dapat memasukkan data barang yang dikembalikan, alasan pengembalian, serta status verifikasi apakah pengembalian tersebut diterima atau ditolak.  
Di akhir proses, program akan menampilkan laporan pengembalian lengkap beserta total nilai barang yang diterima oleh pihak toko.

Program ini dibuat untuk memenuhi tugas praktikum pemrograman Java mengenai **penerapan class, atribut, method, dan penggunaan live template** pada blok kode perhitungan.

    Fitur Utama

1. Input Data Barang 
   Pengguna dapat memasukkan nama barang, harga, dan jumlah barang yang dikembalikan.

2. Input Alasan Pengembalian  
   Setiap barang memiliki alasan pengembalian yang dicatat agar proses verifikasi lebih jelas.

3. Status Verifikasi 
   Barang dapat diberi status "Diterima" atau "Ditolak".  
   Hanya barang dengan status "Diterima" yang akan dihitung dalam total nilai pengembalian.

4. Perhitungan Total Pengembalian  
   Program otomatis menghitung total nilai barang yang dikembalikan dan diterima oleh pihak toko.

5. Tampilan Laporan Pengembalian  
   Setelah input selesai, program menampilkan daftar seluruh barang, alasan, status verifikasi, dan total nilai akhir.

 Struktur Kelas
- Barang  
  Menyimpan data barang seperti nama, harga, dan jumlah.

- Retur Item  
  Menghubungkan objek `Barang` dengan alasan dan status verifikasi pengembalian.

- Pengembalian 
  Menampung seluruh data retur barang serta menghitung total nilai pengembalian yang diterima.

- Tugas3 (Main Class)  
  Mengatur alur utama program mulai dari input, proses, hingga menampilkan hasil.

    
