import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Kendaraan {
    protected String platNomor;
    protected String merk;
    protected String model;
    protected int tahun;

    // List untuk menyimpan kendaraan
    private static List<Kendaraan> kendaraanList = new ArrayList<>();

    public Kendaraan(String platNomor, String merk, String model, int tahun) {
        this.platNomor = platNomor;
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
    }

    public abstract String getTipeKendaraan();

    public String getInfo() {
        return getTipeKendaraan() + " - " + merk + " " + model + " (" + tahun + ")";
    }

    public String getPlatNomor() {
        return platNomor;
    }

    // Metode untuk menambahkan kendaraan
    public static void tambahKendaraan(Scanner scanner) {
        System.out.print("Masukkan Plat Nomor: ");
        String platNomor = scanner.nextLine();

        System.out.print("Masukkan Merk: ");
        String merk = scanner.nextLine();

        System.out.print("Masukkan Model: ");
        String model = scanner.nextLine();

        System.out.print("Masukkan Tahun: ");
        int tahun = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        System.out.print("Pilih Tipe Kendaraan (1: Mobil, 2: Motor): ");
        int tipe = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        Kendaraan kendaraan;

        if (tipe == 1) {
            System.out.print("Masukkan Jumlah Pintu: ");
            int jumlahPintu = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline
            kendaraan = new Mobil(platNomor, merk, model, tahun, jumlahPintu);
        } else if (tipe == 2) {
            System.out.print("Masukkan Tipe Motor: ");
            String tipeMotor = scanner.nextLine();
            kendaraan = new Motor(platNomor, merk, model, tahun, tipeMotor);
        } else {
            System.out.println("Tipe kendaraan tidak valid.");
            return; // Keluar dari metode jika tipe tidak valid
        }

        // Menambahkan kendaraan ke list
        kendaraanList.add(kendaraan);
        System.out.println("Kendaraan berhasil ditambahkan: " + kendaraan.getInfo());
    }

    // Metode untuk mendapatkan daftar kendaraan
    public static List<Kendaraan> getKendaraanList() {
        return kendaraanList;
    }
}
