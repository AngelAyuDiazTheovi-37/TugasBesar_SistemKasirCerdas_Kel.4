import java.util.*;

public class MainKasir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        LaporanHarian laporan = new LaporanHarian();

        // Data awal
        daftarBarang.add(new Barang("A1", "Susu", 8000, 10));
        daftarBarang.add(new Barang("A2", "Indomie ", 3000, 20));
        daftarBarang.add(new Barang("B1", "Minyak Goreng", 14000, 4));
        daftarBarang.add(new Barang("B2", "Kecap ABC", 9000, 6));
        daftarBarang.add(new Barang("C", "Gula", 13000, 3));

        int menu;
        do {
            System.out.println("\n=== Menu Kasir ===");
            System.out.println("1. Lihat Stok Barang");
            System.out.println("2. Transaksi Baru");
            System.out.println("3. Laporan Pendapatan");
            System.out.println("4. Barang Terlaris");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\nDaftar Stok:");
                    for (Barang b : daftarBarang) {
                        System.out.printf("%s - %s (Stok: %d, Harga: %.2f)\n", b.getKode(), b.getNama(), b.getStok(), b.getHarga());
                    }
                    break;
                case 2:
                    Transaksi trx = new Transaksi();
                    String ulang; // deklarasi di sini!
                    do {
                        System.out.print("Kode barang: ");
                        String kode = sc.next();
                        Barang cari = null;
                        for (Barang b : daftarBarang)
                            if (b.getKode().equalsIgnoreCase(kode)) cari = b;
                        if (cari == null) {
                            System.out.println("Barang tidak ditemukan.");
                            ulang = "y"; // biar tidak keluar loop saat error
                            continue;
                        }
                        System.out.print("Jumlah beli: ");
                        int qty = sc.nextInt();
                        if (qty > cari.getStok()) {
                            System.out.println("Stok tidak cukup.");
                            ulang = "y";
                            continue;
                        }
                        trx.tambahBarang(cari, qty);
                        System.out.print("Tambah barang lain? (y/n): ");
                        ulang = sc.next();
                    } while (ulang.equalsIgnoreCase("y"));
                    trx.cetakStruk();
                    laporan.tambahTransaksi(trx);
                    break;
                case 3:
                    laporan.laporanPendapatan();
                    break;
                case 4:
                    laporan.barangTerlaris();
                    break;
                case 0:
                    System.out.println("Keluar...");
            }
        } while (menu != 0);
        sc.close();
    }
}
