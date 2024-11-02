import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class RiwayatServis {
    private String idServis;
    private Date tanggal;
    private Kendaraan kendaraan;
    private Pelanggan pelanggan;
    private JenisServis jenisServis;
    private double totalBiaya;

    // Daftar untuk menyimpan riwayat servis
    private static ArrayList<RiwayatServis> riwayatServisList = new ArrayList<>();

    public RiwayatServis(String idServis, Date tanggal, Kendaraan kendaraan, Pelanggan pelanggan, JenisServis jenisServis) {
        this.idServis = idServis;
        this.tanggal = tanggal;
        this.kendaraan = kendaraan;
        this.pelanggan = pelanggan;
        this.jenisServis = jenisServis;
        this.totalBiaya = jenisServis.hitungBiaya();
    }

    public void tambahBiayaTambahan(double biayaTambahan) {
        if (biayaTambahan < 0) {
            throw new IllegalArgumentException("Biaya tambahan tidak boleh negatif");
        }
        this.totalBiaya += biayaTambahan;
    }

    public String getInfoServis() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String tanggalFormat = dateFormat.format(tanggal);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String biayaFormat = currencyFormat.format(totalBiaya);

        return String.format("""
            ID Servis: %s
            Tanggal: %s
            Kendaraan: %s
            Pelanggan: %s
            Jenis Servis: %s
            Total Biaya: %s
            """,
                idServis,
                tanggalFormat,
                kendaraan.getInfo(),
                pelanggan.getNama(),
                jenisServis.getNamaServis(),
                biayaFormat
        );
    }

    // Metode untuk menambahkan riwayat servis ke daftar
    public static void tambahRiwayatServis(Scanner scanner) {
        System.out.print("Masukkan ID Servis: ");
        String idServis = scanner.nextLine();

        System.out.print("Masukkan Plat Nomor Kendaraan: ");
        String platNomor = scanner.nextLine();
        Kendaraan kendaraan = null;

        // Mencari kendaraan berdasarkan plat nomor
        for (Kendaraan k : Kendaraan.getKendaraanList()) {
            if (k.getPlatNomor().equalsIgnoreCase(platNomor)) {
                kendaraan = k;
                break;
            }
        }

        if (kendaraan == null) {
            System.out.println("Kendaraan dengan plat nomor tersebut tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan ID Pelanggan: ");
        String idPelanggan = scanner.nextLine();
        Pelanggan pelanggan = null;

        // Mencari pelanggan berdasarkan ID
        for (Pelanggan p : Pelanggan.getPelangganList()) {
            if (p.getIdPelanggan().equalsIgnoreCase(idPelanggan)) {
                pelanggan = p;
                break;
            }
        }

        if (pelanggan == null) {
            System.out.println("Pelanggan dengan ID tersebut tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan Nama Servis: ");
        String namaServis = scanner.nextLine();

        System.out.print("Masukkan Biaya Dasar Servis: ");
        double biayaDasar = scanner.nextDouble();
        scanner.nextLine(); // Konsumsi newline

        JenisServis jenisServis = new JenisServis(namaServis, biayaDasar);

        System.out.print("Masukkan Tanggal Servis (format: dd-MM-yyyy): ");
        String tanggalInput = scanner.nextLine();
        Date tanggal;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            tanggal = dateFormat.parse(tanggalInput);
        } catch (Exception e) {
            System.out.println("Format tanggal tidak valid.");
            return;
        }

        // Membuat objek RiwayatServis
        RiwayatServis riwayatServis = new RiwayatServis(idServis, tanggal, kendaraan, pelanggan, jenisServis);

        // Tambahkan biaya tambahan jika ada
        System.out.print("Apakah ada biaya tambahan? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.print("Masukkan biaya tambahan: ");
            double biayaTambahan = scanner.nextDouble();
            scanner.nextLine(); // Konsumsi newline

            riwayatServis.tambahBiayaTambahan(biayaTambahan);
        }

        // Tambahkan riwayatServis ke daftar
        riwayatServisList.add(riwayatServis);

        System.out.println("Riwayat servis berhasil ditambahkan:");
        System.out.println(riwayatServis.getInfoServis());
    }

    // Metode untuk menampilkan seluruh riwayat servis
    public static void tampilkanRiwayatServis() {
        if (riwayatServisList.isEmpty()) {
            System.out.println("Belum ada riwayat servis yang terdaftar.");
        } else {
            System.out.println("\nDaftar Riwayat Servis:");
            for (RiwayatServis riwayat : riwayatServisList) {
                System.out.println(riwayat.getInfoServis());
            }
        }
    }
}
