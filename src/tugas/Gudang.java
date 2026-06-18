package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah objek barang ke dalam ArrayList
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    // Menampilkan semua barang yang ada di dalam gudang
    public void tampilkanSemua() {
        if (daftarBarang.isEmpty()) {
            System.out.println("(Gudang kosong)");
            return;
        }
        System.out.println("--- Daftar Barang di Gudang ---");
        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println((i + 1) + ". " + daftarBarang.get(i).info());
        }
    }

    // Menyimpan seluruh isi ArrayList ke dalam berkas teks
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                penulis.println(b.keBaris());
            }
            System.out.println("[Sistem] Berhasil menyimpan data barang ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("[Eror] Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    // Memuat kembali data dari berkas teks masuk ke ArrayList
    public void muatDariBerkas() {
        daftarBarang.clear(); // Bersihkan list sebelum memuat data baru
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("[Sistem] Berhasil memuat data barang dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("[Eror] Gagal memuat dari berkas: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("[Eror] Format angka di dalam berkas rusak: " + e.getMessage());
        }
    }

    // Menghitung total nilai seluruh persediaan (Harga * Stok)
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }
}