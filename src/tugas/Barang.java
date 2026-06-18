package tugas;

public class Barang {
    private String nama;
    private double harga;
    private int stok;

    // Constructor untuk menginisialisasi objek Barang
    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter untuk mengakses atribut dari luar class
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Mengubah data barang menjadi format baris teks untuk disimpan (pemisah ';')
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

    // Mengembalikan informasi lengkap barang untuk ditampilkan di layar
    public String info() {
        return nama + " | Harga: Rp" + harga + " | Stok: " + stok;
    }
}