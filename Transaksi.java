import java.util.HashMap;

public class Transaksi {
    private HashMap<Barang, Integer> daftarBarang = new HashMap<>();
    private double totalHarga = 0;

    public void tambahBarang(Barang b, int jumlah) {
        daftarBarang.put(b, daftarBarang.getOrDefault(b, 0) + jumlah);
        totalHarga += b.getSubtotal(jumlah);
        b.kurangiStok(jumlah);
    }

    public double hitungTotal() { return totalHarga; }

    public HashMap<Barang, Integer> getDaftarBarang() { return daftarBarang; }

    public void cetakStruk() {
        System.out.println("| Kode | Nama | Qty | Harga | Diskon | Subtotal |");
        for (Barang b : daftarBarang.keySet()) {
            int qty = daftarBarang.get(b);
            double diskon = b.hitungDiskon();
            double subtotal = b.getSubtotal(qty);
            System.out.printf("| %s | %s | %d | %.2f | %.2f | %.2f |\n",
                b.getKode(), b.getNama(), qty, b.getHarga(), diskon, subtotal);
        }
        System.out.println("-----------------------------------------------");
        System.out.printf("Total: %.2f\n", totalHarga);
    }
}