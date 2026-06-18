package bagian3.kontak;

public class Kontak {
    // Atribut: data yang dimiliki setiap kontak
    private String nama;
    private String nomor;
    private String email; // <-- Tambahan atribut baru

    // Constructor: disesuaikan untuk menerima tiga parameter
    public Kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email; // <-- Inisialisasi atribut email
    }

    // Getter: cara membaca atribut dari luar class
    public String getNama() {
        return nama;
    }

    public String getNomor() {
        return nomor;
    }

    public String getEmail() { // <-- Tambahan getter baru untuk email
        return email;
    }

    // Mengubah objek menjadi satu baris teks dengan pemisah semikolon (;) untuk disimpan ke berkas
    // Diubah agar mencakup email menjadi 3 bagian
    public String keBaris() {
        return nama + ";" + nomor + ";" + email;
    }

    // Mengembalikan keterangan kontak dalam bentuk teks untuk ditampilkan ke layar
    public String info() {
        return nama + " - " + nomor + " (" + email + ")";
    }
}