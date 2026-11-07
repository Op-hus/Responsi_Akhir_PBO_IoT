public class lampuPintar extends perangkatIoT {
    private int tingkatKecerahan;
    private String warnaRGB;

    public lampuPintar(String idPerangkat, String namaPerangkat, int konsumsiDayaWatt) {
        super(idPerangkat, namaPerangkat, konsumsiDayaWatt);
        this.tingkatKecerahan = 0;
        this.warnaRGB = "Warm White";
    }

    // Overriding: Mengganti isi method tampilkanInformasi milik induk
    @Override
    public void tampilkanInformasi() {
        super.tampilkanInformasi(); // Pemanggilan method milik induk
        System.out.println("Kecerahan    : " + this.tingkatKecerahan + "%");
        System.out.println("Warna Light  : " + this.warnaRGB);
    }

    @Override
    public void prosesSinyalKontrol(String perintah) {
        if (perintah.equalsIgnoreCase("HIDUPKAN")) {
            if (!isStatusAktif()) {
                setStatusAktif(true);
                this.tingkatKecerahan = 100;
                System.out.println("[" + getNamaPerangkat() + "] Lampu dinyalakan pada kecerahan 100%.");
            } else {
                System.out.println("[" + getNamaPerangkat() + "] Lampu sudah dalam keadaan aktif!");
            }
        } else if (perintah.equalsIgnoreCase("MATIKAN")) {
            if (isStatusAktif()) {
                setStatusAktif(false);
                this.tingkatKecerahan = 0;
                System.out.println("[" + getNamaPerangkat() + "] Lampu dimatikan.");
            } else {
                System.out.println("[" + getNamaPerangkat() + "] Lampu memang sudah mati!");
            }
        } else {
            System.out.println("[" + getNamaPerangkat() + "] Perintah '" + perintah + "' tidak dikenal oleh Lampu.");
        }
    }

    public int getTingkatKecerahan() {
        return tingkatKecerahan;
    }

    public String getWarnaRGB() {
        return warnaRGB;
    }

    public void setWarnaRGB(String warnaRGB) {
        this.warnaRGB = warnaRGB;
    }
}