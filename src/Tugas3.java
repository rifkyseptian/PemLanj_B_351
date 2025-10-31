import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class Barang menyimpan informasi barang yang dikembalikan,
 * meliputi nama barang, harga satuan, dan jumlah barang.
 */
class Barang {
    private String nama;
    private double harga;
    private int jumlah;

    /**
     * Konstruktor untuk membuat objek Barang.
     *
     * @param nama   Nama barang
     * @param harga  Harga satuan barang
     * @param jumlah Jumlah barang yang dikembalikan
     */
    public Barang(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    /**
     * Mendapatkan nama barang.
     *
     * @return Nama barang
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mendapatkan harga satuan barang.
     *
     * @return Harga barang
     */
    public double getHarga() {
        return harga;
    }

    /**
     * Mendapatkan jumlah barang yang dikembalikan.
     *
     * @return Jumlah barang
     */
    public int getJumlah() {
        return jumlah;
    }

    /**
     * Menghitung total harga barang berdasarkan jumlah dan harga satuan.
     *
     * @return Total harga barang
     */
    public double getTotalHarga() {
        return harga * jumlah;
    }
}

/**
 * Class ReturItem mewakili satu data pengembalian barang,
 * termasuk barang, alasan pengembalian, dan hasil verifikasi.
 */
class ReturItem {
    private Barang barang;
    private String alasan;
    private String statusVerifikasi;

    /**
     * Konstruktor ReturItem.
     * Status verifikasi didapat dari metode verifikasiOtomatis().
     *
     * @param barang Barang yang dikembalikan
     * @param alasan Alasan pengembalian barang
     */
    public ReturItem(Barang barang, String alasan) {
        this.barang = barang;
        this.alasan = alasan;
        this.statusVerifikasi = verifikasiOtomatis(alasan);
    }

    /**
     * Melakukan verifikasi otomatis apakah pengembalian diterima atau ditolak.
     * Jika alasan mengandung kata tertentu seperti "rusak", "cacat", atau "tidak sesuai",
     * maka pengembalian diterima.
     *
     * @param alasan Alasan pengembalian barang
     * @return Status verifikasi: "Diterima" atau "Ditolak"
     */
    private String verifikasiOtomatis(String alasan) {
        String alasanLower = alasan.toLowerCase();
        if (alasanLower.contains("rusak") || alasanLower.contains("tidak sesuai") || alasanLower.contains("cacat")) {
            return "Diterima";
        } else {
            return "Ditolak";
        }
    }

    /**
     * Mendapatkan objek Barang dari retur.
     *
     * @return Barang yang dikembalikan
     */
    public Barang getBarang() {
        return barang;
    }

    /**
     * Mendapatkan alasan pengembalian.
     *
     * @return Alasan pengembalian
     */
    public String getAlasan() {
        return alasan;
    }

    /**
     * Mendapatkan status verifikasi retur.
     *
     * @return Status verifikasi (Diterima/Ditolak)
     */
    public String getStatusVerifikasi() {
        return statusVerifikasi;
    }

    /**
     * Mengembalikan total harga barang hanya jika retur diterima.
     *
     * @return Total harga atau 0 jika ditolak
     */
    public double getTotalJikaDiterima() {
        return statusVerifikasi.equalsIgnoreCase("diterima") ? barang.getTotalHarga() : 0;
    }
}

/**
 * Class Pengembalian menyimpan daftar retur barang
 * dan menghitung total nilai retur yang diterima.
 */
class Pengembalian {
    private List<ReturItem> daftarRetur = new ArrayList<>();

    /**
     * Menambahkan data retur ke dalam daftar.
     *
     * @param item Objek ReturItem yang akan ditambahkan
     */
    public void tambahRetur(ReturItem item) {
        daftarRetur.add(item);
    }

    /**
     * Menghitung total nilai pengembalian yang diterima.
     * Metode ini dapat dijadikan Custom Live Template.
     *
     * @return Total nilai retur yang diterima
     */
    public double hitungTotalPengembalianDiterima() {
        double total = 0;
        for (ReturItem item : daftarRetur) {
            total += item.getTotalJikaDiterima();
        }
        return total;
    }

    /**
     * Menampilkan laporan lengkap pengembalian barang,
     * termasuk nama barang, jumlah, harga, alasan, dan status verifikasi.
     */
    public void tampilkanLaporanPengembalian() {
        System.out.println("\n===== LAPORAN PENGEMBALIAN BARANG =====");
        for (ReturItem item : daftarRetur) {
            Barang b = item.getBarang();
            System.out.printf("%-20s | Jumlah: %2d | Harga Satuan: Rp%.0f | Total: Rp%.0f%n",
                    b.getNama(), b.getJumlah(), b.getHarga(), b.getTotalHarga());
            System.out.println("Alasan Pengembalian : " + item.getAlasan());
            System.out.println("Status Verifikasi   : " + item.getStatusVerifikasi());
            System.out.println("-----------------------------------------------");
        }

        System.out.printf("Total Pengembalian yang Diterima: Rp%.0f%n", hitungTotalPengembalianDiterima());
        System.out.println("===============================================");
    }
}

/**
 * Class utama yang menjalankan aplikasi sistem pengembalian barang.
 * Program menerima input barang dari pengguna dan menampilkan laporan retur.
 */
public class Tugas3 {
    /**
     * Method utama untuk menjalankan program.
     *
     * @param args Argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pengembalian pengembalian = new Pengembalian();

        System.out.println("=== SISTEM PENGEMBALIAN BARANG TIDAK SESUAI ===");

        char lanjut;
        do {
            System.out.print("Masukkan nama barang yang dikembalikan: ");
            String nama = input.nextLine();

            System.out.print("Masukkan harga barang: ");
            double harga = input.nextDouble();

            System.out.print("Masukkan jumlah barang yang dikembalikan: ");
            int jumlah = input.nextInt();
            input.nextLine(); // bersihkan buffer

            System.out.print("Masukkan alasan pengembalian: ");
            String alasan = input.nextLine();

            Barang barang = new Barang(nama, harga, jumlah);
            ReturItem retur = new ReturItem(barang, alasan);
            pengembalian.tambahRetur(retur);

            System.out.print("Apakah ingin menambah data pengembalian lain? (ya/tidak): ");
            lanjut = input.next().toLowerCase().charAt(0);
            input.nextLine();

        } while (lanjut == 'y');

        pengembalian.tampilkanLaporanPengembalian();
        input.close();
    }
}