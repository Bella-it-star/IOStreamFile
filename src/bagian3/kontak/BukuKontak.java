package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    // ArrayList yang menampung objek bertipe Kontak
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah satu kontak ke koleksi
    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    // Menampilkan seluruh koleksi beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    // Mencari kontak berdasarkan nama
    public void cariKontak(String nama) {
        System.out.println("\n== Mencari Kontak: \"" + nama + "\" ==");
        boolean ditemukan = false;

        for (Kontak k : daftar) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak Ditemukan!");
                System.out.println("Keterangan: " + k.info());
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Maaf, kontak dengan nama \"" + nama + "\" tidak ditemukan.");
        }
    }

    // =========================================================================
    // METHOD BARU: Menghapus kontak berdasarkan nama & menyimpan otomatis
    // =========================================================================
    public void hapusKontak(String nama) {
        System.out.println("\n== Menghapus Kontak: \"" + nama + "\" ==");
        
        // Simpan ukuran awal untuk memeriksa apakah ada data yang terhapus
        int ukuranSebelum = daftar.size();
        
        // Menghapus elemen arraylist jika namanya cocok (case-insensitive)
        daftar.removeIf(k -> k.getNama().equalsIgnoreCase(nama));
        
        if (daftar.size() < ukuranSebelum) {
            System.out.println("Kontak \"" + nama + "\" berhasil dihapus dari daftar.");
            // Memanggil method untuk memperbarui berkas teks fisik
            simpanKeBerkas();
        } else {
            System.out.println("Gagal menghapus! Kontak dengan nama \"" + nama + "\" tidak ditemukan.");
        }
    }

    // Menyimpan seluruh kontak ke berkas, satu kontak per baris
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // Membaca kembali kontak dari berkas ke dalam ArrayList
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }
}