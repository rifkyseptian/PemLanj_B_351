import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class Barang menyimpan informasi detail mengenai barangg
 * seperti nama, harga satuan, dan jumlah barang yang di kembalikan
 */
class Barang {
    private String nama;
    private double harga;
    private int jumlah;

    /**
     * Konstruktor untuk instalasi objek Barang
     * @param nama
     * @param harga
     * @param jumlah
     */

    public Barang(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    /**
     * @return Harga satuan barang
     */

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getTotalHarga() {
        return harga * jumlah;
    }
}

// Class Pengembalian merepresentasikan proses retur barang
class Pengembalian {
    private List<Barang> daftarBarang = new ArrayList<>();
    private List<String> alasan = new ArrayList<>();

    public void tambahBarang(Barang barang, String alasanPengembalian) {
        daftarBarang.add(barang);
        alasan.add(alasanPengembalian);
    }

    // 💡 Bagian ini bisa dijadikan CUSTOM LIVE TEMPLATE (rumus perhitungan total)
    public double hitungTotalNilaiPengembalian() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getTotalHarga();
        }
        return total;
    }

    public void tampilkanDaftarPengembalian() {
        System.out.println("\n===== DAFTAR PENGEMBALIAN BARANG =====");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang b = daftarBarang.get(i);
            System.out.printf("%-20s | Jumlah: %2d | Harga Satuan: Rp%.0f | Total: Rp%.0f%n",
                    b.getNama(), b.getJumlah(), b.getHarga(), b.getTotalHarga());
            System.out.println("Alasan: " + alasan.get(i));
            System.out.println("-----------------------------------------------");
        }
        System.out.printf("Total Nilai Barang yang Dikembalikan: Rp%.0f%n", hitungTotalNilaiPengembalian());
        System.out.println("===============================================");
    }
}

// Class utama
public class Tugas3 {
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
            input.nextLine(); // membersihkan buffer

            System.out.print("Masukkan alasan pengembalian: ");
            String alasan = input.nextLine();

            Barang barang = new Barang(nama, harga, jumlah);
            pengembalian.tambahBarang(barang, alasan);

            System.out.print("Apakah ingin menambah data pengembalian lain? (ya/tidak): ");
            lanjut = input.next().toLowerCase().charAt(0);
            input.nextLine();

        } while (lanjut == 'y');

        pengembalian.tampilkanDaftarPengembalian();

        input.close();
    }
}
