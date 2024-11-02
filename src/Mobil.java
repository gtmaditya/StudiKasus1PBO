public class Mobil extends Kendaraan {
    private int jumlahPintu;

    public Mobil(String platNomor, String merk, String model, int tahun, int jumlahPintu) {
        super(platNomor, merk, model, tahun);
        this.jumlahPintu = jumlahPintu;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }
}

