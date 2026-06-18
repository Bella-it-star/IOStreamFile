//Nama:Halimatussa'diah
//NPM: 2410010269

package tugas;

public class MainTugas {
    public static void main(String[] args) {
        
       
        // KETENTUAN 1: Menyimpan dan menampilkan daftar kategori (Array Ukuran Tetap)
       
        String[] kategori = new String[4];
        kategori[0] = "Elektronik";
        kategori[1] = "Pakaian";
        kategori[2] = "Makanan";
        kategori[3] = "Alat Tulis";

        System.out.println("=== KATEGORI BARANG ===");
        for (String kat : kategori) {
            System.out.println("- " + kat);
        }
        System.out.println();


        
        // KETENTUAN 2: Membuat objek Gudang dan menambah minimal 5 Barang
       
        System.out.println("=== TAHAP 1: Inisialisasi Gudang & Input Barang ===");
        Gudang gudangUtama = new Gudang("barang.txt");

        gudangUtama.tambahBarang(new Barang("Laptop ASUS", 12000000, 5));
        gudangUtama.tambahBarang(new Barang("Smartphone Samsung", 5500000, 10));
        gudangUtama.tambahBarang(new Barang("Mouse Wireless", 250000, 25));
        gudangUtama.tambahBarang(new Barang("Keyboard Mekanik", 750000, 12));
        gudangUtama.tambahBarang(new Barang("Monitor 24 Inch", 2100000, 8));

        gudangUtama.tampilkanSemua();
        // Menyimpan ke file barang.txt
        gudangUtama.simpanKeBerkas();
        System.out.println();


        
        // KETENTUAN 3: Membuat objek Gudang baru untuk membuktikan data tersimpan
       
        System.out.println("=== TAHAP 2: Pembuktian Lewat Objek Gudang Baru ===");
        Gudang gudangBaru = new Gudang("barang.txt");
        
        // Memuat ulang data yang tersimpan di barang.txt tadi
        gudangBaru.muatDariBerkas();
        gudangBaru.tampilkanSemua();

        // Menampilkan total nilai persediaan barang
        System.out.println("---------------------------------------");
        System.out.println("Total Nilai Persediaan: Rp" + gudangBaru.totalNilai());
        System.out.println("---------------------------------------");
    }
}