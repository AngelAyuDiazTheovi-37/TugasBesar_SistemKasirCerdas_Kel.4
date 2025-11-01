import java.util.*;

public class LaporanHarian {
    private List<Transaksi> transaksiHariIni = new ArrayList<>();

    public void tambahTransaksi(Transaksi t) {
        transaksiHariIni.add(t);
    }

    public void laporanPendapatan() {
        double total = 0;
        for (Transaksi t : transaksiHariIni) {
            total += t.hitungTotal();
        }
        System.out.printf("Total pendapatan hari ini: %.2f\n", total);
    }

    public void barangTerlaris() {
        HashMap<String, Integer> terlaris = new HashMap<>();
        for (Transaksi t : transaksiHariIni) {
            for (Barang b : t.getDaftarBarang().keySet()) {
                int qty = t.getDaftarBarang().get(b);
                terlaris.put(b.getNama(), terlaris.getOrDefault(b.getNama(), 0) + qty);
            }
        }
        System.out.println("Barang terlaris:");
        terlaris.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(e -> System.out.printf("%s : %d\n", e.getKey(), e.getValue()));
    }
}
