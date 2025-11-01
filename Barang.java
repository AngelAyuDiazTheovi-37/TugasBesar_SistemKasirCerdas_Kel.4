public class Barang {
    private String kode, nama;
    private double harga;
    private int stok;

    public Barang(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }
    public double hitungDiskon() {
        return (stok < 5) ? 0.15 * harga : 0.0;
    }
    public double getSubtotal(int jumlah) {
        return (harga - hitungDiskon()) * jumlah;
    }
}
