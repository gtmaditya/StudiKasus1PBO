import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pelanggan {
    private String idPelanggan;
    private String nama;
    private String alamat;
    private String nomorTelepon;

    // List untuk menyimpan pelanggan
    private static List<Pelanggan> pelangganList = new ArrayList<>();

    public Pelanggan(String idPelanggan, String nama, String alamat, String nomorTelepon) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    // Metode untuk menambah pelanggan
    public static void tambahPelanggan(Scanner scanner) {
        System.out.print("Masukkan ID Pelanggan: ");
        String idPelanggan = scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();

        System.out.print("Masukkan Nomor Telepon: ");
        String nomorTelepon = scanner.nextLine();

        // Membuat objek Pelanggan baru dan menambahkannya ke daftar
        Pelanggan pelangganBaru = new Pelanggan(idPelanggan, nama, alamat, nomorTelepon);
        pelangganList.add(pelangganBaru);

        System.out.println("Pelanggan berhasil ditambahkan.");
    }

    // Metode untuk mendapatkan daftar pelanggan
    public static List<Pelanggan> getPelangganList() {
        return pelangganList;
    }
}
