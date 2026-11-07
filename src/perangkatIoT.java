public abstract class perangkatIoT {
    public static final String PROTOKOL_DEFAULT = "MQTT v5.0";
    private final String idPerangkat;

    // Enkapsulasi: Data disembunyikan pakai private
    private String namaPerangkat;
    private boolean statusAktif;
    private int konsumsiDayaWatt;

    // Overloaded (Inisialisasi nilai awal)
    public perangkatIoT(String idPerangkat, String namaPerangkat) {
        this.idPerangkat = idPerangkat;
        this.namaPerangkat = namaPerangkat;
        this.statusAktif = false;
        this.konsumsiDayaWatt = 5;
    }

    // Overloaded (variasi parameter lain)
    public perangkatIoT(String idPerangkat, String namaPerangkat, int konsumsiDayaWatt) {
        this.idPerangkat = idPerangkat;
        this.namaPerangkat = namaPerangkat;
        this.statusAktif = false;
        this.konsumsiDayaWatt = konsumsiDayaWatt;
    }

    public abstract void prosesSinyalKontrol(String perintah);

    // Prosedur: Menampilkan data (tipe void)
    public void tampilkanInformasi() {
        System.out.println("ID Device    : " + this.idPerangkat);
        System.out.println("Nama Device  : " + this.namaPerangkat);
        System.out.println("Status Aktif : " + (this.statusAktif ? "ON" : "OFF"));
        System.out.println("Daya (Watt)  : " + this.konsumsiDayaWatt + " W");
        System.out.println("Protokol     : " + PROTOKOL_DEFAULT);
    }

    public double hitungEstimasiBiaya(int jamOperasional, double tarifPerKWh) {
        double totalKWh = (this.konsumsiDayaWatt * jamOperasional) / 1000.0;
        return totalKWh * tarifPerKWh;
    }

    public String getIdPerangkat() {
        return idPerangkat;
    }

    public String getNamaPerangkat() {
        return namaPerangkat;
    }

    public void setNamaPerangkat(String namaPerangkat) {
        this.namaPerangkat = namaPerangkat;
    }

    public boolean isStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(boolean statusAktif) {
        this.statusAktif = statusAktif;
    }

    public int getKonsumsiDayaWatt() {
        return konsumsiDayaWatt;
    }

    public void setKonsumsiDayaWatt(int konsumsiDayaWatt) {
        this.konsumsiDayaWatt = konsumsiDayaWatt;
    }
}