
package bagian2.bacatulis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

    // 1. Tulis 5 nama hari ke dalam berkas hari.txt (satu nama per baris), 
    // lalu baca kembali dan tampilkan ke layar.
    public static void soalNomorSatu() {
        String[] hariAwal = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        // Bagian MENULIS (Write) ke file
        // Secara default, FileWriter akan membuat file baru jika belum ada, 
        // atau menimpa (overwrite) jika file sudah ada.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("hari.txt"))) {
            for (String hari : hariAwal) {
                bw.write(hari);
                bw.newLine(); // Membuat baris baru
            }
            System.out.println("[Sistem] Berhasil menulis 5 hari ke 'hari.txt'.");
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }

        // Bagian MEMBACA (Read) file dan menampilkan ke layar
        System.out.println("Isi berkas hari.txt saat ini:");
        try (BufferedReader br = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                System.out.println("- " + baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
    }

    // 2. Tambahkan (append) 2 nama hari lagi ke berkas hari.txt tanpa menghapus 
    // isi sebelumnya, lalu tampilkan seluruh isinya.
    public static void soalNomorDua() {
        String[] hariTambahan = {"Sabtu", "Minggu"};

        // Bagian APPEND (Menambah data di akhir file)
        // Parameter 'true' pada new FileWriter("hari.txt", true) mengaktifkan mode append
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("hari.txt", true))) {
            for (String hari : hariTambahan) {
                bw.write(hari);
                bw.newLine();
            }
            System.out.println("[Sistem] Berhasil menambahkan 2 hari baru (append).");
        } catch (IOException e) {
            System.out.println("Gagal menambah isi berkas: " + e.getMessage());
        }

        // Tampilkan kembali seluruh isi berkas setelah di-append
        System.out.println("Isi berkas hari.txt setelah diperbarui:");
        try (BufferedReader br = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                System.out.println("- " + baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
    }

    // 3. Baca berkas hari.txt lalu hitung dan tampilkan berapa banyak baris yang ada di dalamnya.
    public static void soalNomorTiga() {
        int jumlahBaris = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("hari.txt"))) {
            // Lakukan perulangan selama baris yang dibaca tidak kosong (null)
            while (br.readLine() != null) {
                jumlahBaris++; // Tambah counter baris
            }
            System.out.println("Jumlah total baris di dalam berkas 'hari.txt' adalah: " + jumlahBaris + " baris.");
        } catch (IOException e) {
            System.out.println("Gagal menghitung baris berkas: " + e.getMessage());
        }
    }
}
