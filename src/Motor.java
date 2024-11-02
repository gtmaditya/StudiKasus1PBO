public class Motor extends Kendaraan {
    private String tipeMotor;

    public Motor(String platNomor, String merk, String model, int tahun, String tipeMotor) {
        super(platNomor, merk, model, tahun);
        this.tipeMotor = tipeMotor;
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }

    public String getTipeMotor() {
        return tipeMotor;
    }
}
