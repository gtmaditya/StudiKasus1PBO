import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            // Menampilkan menu
            System.out.println("=== Sistem Bengkel ===");
            System.out.println("1. Tambah Data Pelanggan");
            System.out.println("2. Tambah Data Kendaraan");
            System.out.println("3. Tambah Riwayat Servis");
            System.out.println("4. Lihat Riwayat Servis");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");

            // Validasi input
            while (!scanner.hasNextInt()) {
                System.out.print("Input tidak valid. Silakan masukkan angka (1-5): ");
                scanner.next(); // Membuang input yang tidak valid
            }
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.println("Menambahkan Pelanggan...");
                    Pelanggan.tambahPelanggan(scanner);
                    break;
                case 2:
                    System.out.println("Menambahkan Kendaraan...");
                    Kendaraan.tambahKendaraan(scanner);
                    break;
                case 3:
                    System.out.println("Menambahkan Riwayat Servis...");
                    RiwayatServis.tambahRiwayatServis(scanner);
                    break;
                case 4:
                    System.out.println("Melihat Riwayat Servis...");
                    RiwayatServis.tampilkanRiwayatServis();
                    break;
                case 5:
                    System.out.println("Keluar dari sistem. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

            System.out.println(); // Untuk pemisah antar opsi

        } while (pilihan != 5);

        scanner.close();
    }
}