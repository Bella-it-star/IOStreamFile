package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // 1. Membuat objek BukuKontak dan mengisinya dengan data baru (Termasuk Email)
        BukuKontak buku = new BukuKontak("kontak.txt");
        
        System.out.println("=== TAHAP 1: Menambahkan & Menyimpan Kontak ===");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        
        System.out.println();
        
        // 2. Membuat objek baru yang kosong, lalu memuat data dari berkas teks
        System.out.println("=== TAHAP 2: Memuat Ulang dari Berkas ===");
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak: " + bukuLain.jumlahKontak());
        
        // 3. Pengujian Soal 1: Mencari Kontak
        System.out.println("\n=== TAHAP 3: Pengujian cariKontak() ===");
        bukuLain.cariKontak("budi");  // Kontak ditemukan
        bukuLain.cariKontak("Zaki");  // Kontak tidak ditemukan
        
        // 4. Pengujian Soal 3: Menghapus Kontak & Menyimpan Otomatis
        System.out.println("\n=== TAHAP 4: Pengujian hapusKontak() ===");
        bukuLain.hapusKontak("budi"); // Menghapus Budi, otomatis memicu simpanKeBerkas()
        
        // 5. Tampilkan hasil akhir untuk memastikan data diperbarui di memori
        System.out.println("\n=== TAHAP 5: Hasil Akhir Setelah Dihapus ===");
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak akhir: " + bukuLain.jumlahKontak());
    }
}