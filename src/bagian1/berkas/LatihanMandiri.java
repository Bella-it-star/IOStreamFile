
package bagian1.berkas;


import java.io.File;
import java.io.IOException;

public class LatihanMandiri {

    public static void main(String[] args) {
        System.out.println("=== SOAL 1 ===");
        soalNomorSatu();

        System.out.println("\n=== SOAL 2 ===");
        soalNomorDua();

        System.out.println("\n=== SOAL 3 ===");
        soalNomorTiga();
    }

    // 1. Buat objek File yang menunjuk laporan.txt. Tampilkan apakah berkas 
    // tersebut ada, dan jika ada tampilkan ukurannya dalam byte.
    public static void soalNomorSatu() {
        File berkas = new File("laporan.txt");
        
        if (berkas.exists()) {
            System.out.println("Status: Berkas 'laporan.txt' ditemukan.");
            System.out.println("Ukuran berkas: " + berkas.length() + " byte");
        } else {
            System.out.println("Status: Berkas 'laporan.txt' tidak ditemukan.");
        }
    }

    // 2. Buat sebuah folder baru bernama arsip menggunakan method mkdir(). 
    // Tampilkan pesan berhasil atau gagal berdasarkan nilai yang dikembalikan method tersebut.
    public static void soalNomorDua() {
        File folder = new File("arsip");
        
        // method mkdir() mengembalikan nilai boolean (true jika berhasil, false jika gagal/sudah ada)
        if (folder.mkdir()) {
            System.out.println("Pesan: Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Pesan: Gagal membuat folder 'arsip' (atau folder sudah ada).");
        }
    }

    // 3. Buat objek File sementara.txt, buat berkasnya, lalu hapus kembali dengan method delete(). 
    // Tampilkan status keberadaan berkas sebelum dan sesudah dihapus.
    public static void soalNomorTiga() {
        File berkasSementara = new File("sementara.txt");
        
        try {
            // Membuat berkas baru fisik di penyimpanan
            if (berkasSementara.createNewFile()) {
                System.out.println("Berkas 'sementara.txt' berhasil dibuat.");
            }
            
            // Cek status sebelum dihapus
            System.out.println("Status sebelum dihapus (exists()): " + berkasSementara.exists());
            
            // Menghapus berkas
            if (berkasSementara.delete()) {
                System.out.println("Berkas 'sementara.txt' berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus berkas.");
            }
            
            // Cek status sesudah dihapus
            System.out.println("Status sesudah dihapus (exists()): " + berkasSementara.exists());
            
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan I/O: " + e.getMessage());
        }
    }
}
