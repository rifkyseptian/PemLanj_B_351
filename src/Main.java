import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    private String nama;
    private double harga;

    public MenuItem(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}

class Pesanan {
    private MenuItem item;
    private int jumlah;

    public Pesanan(MenuItem item, int jumlah) {
        this.item = item;
        this.jumlah = jumlah;
    }

    public double getTotal() {
        return item.getHarga() * jumlah;
    }

    public void tampilkanPesanan() {
        System.out.printf("%-15s x%d\tRp %.2f\n", item.getNama(), jumlah, getTotal());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Nasi Goreng", 20000));
        menu.add(new MenuItem("Mie Ayam", 15000));
        menu.add(new MenuItem("Es Teh", 5000));
        menu.add(new MenuItem("Jus Jeruk", 7000));

        ArrayList<Pesanan> daftarPesanan = new ArrayList<>();

        System.out.println("=== Aplikasi Nota Pemesanan Restoran ===");

        char lagi = 0;
        do {
            System.out.println("\nMenu Makanan & Minuman:");
            for (int i = 0; i < menu.size(); i++) {
                System.out.printf("%d. %-15s Rp %.2f\n", (i + 1), menu.get(i).getNama(), menu.get(i).getHarga());
            }

            System.out.print("Pilih nomor menu: ");
            int pilihan = input.nextInt();

            if (pilihan < 1 || pilihan > menu.size()) {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            System.out.print("Masukkan jumlah pesanan: ");
            int jumlah = input.nextInt();

            daftarPesanan.add(new Pesanan(menu.get(pilihan - 1), jumlah));

            System.out.print("Tambah pesanan lain? (ya/tidak): ");
            lagi = input.next().charAt(0);

        } while (lagi == 'y' || lagi == 'Y');

        double totalBayar = 0;
        System.out.println("\n=== Nota Pembelian ===");
        for (Pesanan p : daftarPesanan) {
            p.tampilkanPesanan();
            totalBayar += p.getTotal();
        }

        System.out.println("----------------------------");
        System.out.printf("Total Bayar:\tRp %.2f\n", totalBayar);
        System.out.println("Terima kasih telah memesan!");

        input.close();
    }
}