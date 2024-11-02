public class JenisServis {
    private String namaServis;
    private double biayaDasar;

    public JenisServis(String namaServis, double biayaDasar) {
        this.namaServis = namaServis;
        this.biayaDasar = biayaDasar;
    }

    public String getNamaServis() {
        return namaServis;
    }

    public double hitungBiaya() {
        return biayaDasar;
    }
}
