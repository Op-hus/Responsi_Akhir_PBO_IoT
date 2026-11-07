// Multiple Interface: Mengimplementasikan 2 interface sekaligus
public class kameraPintar extends perangkatIoT implements koneksiInternet, kameraKeamanan {
    private boolean terhubungKeWiFi;
    private boolean sedangMerekam;

    public kameraPintar(String idPerangkat, String namaPerangkat, int konsumsiDayaWatt) {
        super(idPerangkat, namaPerangkat, konsumsiDayaWatt);
        this.terhubungKeWiFi = false;
        this.sedangMerekam = false;
    }

    // Overriding method tampilkanInformasi
    @Override
    public void tampilkanInformasi() {
        super.tampilkanInformasi();
        System.out.println("Status WiFi  : " + (this.terhubungKeWiFi ? "Connected" : "Disconnected"));
        System.out.println("Status Rekam : " + (this.sedangMerekam ? "RECORDING" : "IDLE"));
    }

    // Percabangan logika mengubah state objek
    @Override
    public void prosesSinyalKontrol(String perintah) {
        if (perintah.equalsIgnoreCase("AKTIFKAN_KEAMANAN")) {
            if (terhubungKeWiFi) {
                setStatusAktif(true);
                this.sedangMerekam = true;
                System.out.println("[" + getNamaPerangkat() + "] Sistem keamanan aktif dan perekaman dimulai.");
            } else {
                System.out.println("[" + getNamaPerangkat() + "] Gagal aktif! Kamera harus terhubung WiFi dulu.");
            }
        } else if (perintah.equalsIgnoreCase("NONAKTIFKAN")) {
            if (isStatusAktif()) {
                setStatusAktif(false);
                this.sedangMerekam = false;
                System.out.println("[" + getNamaPerangkat() + "] Perekaman dihentikan dan modul dimatikan.");
            } else {
                System.out.println("[" + getNamaPerangkat() + "] Kamera sudah dalam keadaan mati.");
            }
        } else {
            System.out.println("[" + getNamaPerangkat() + "] Perintah '" + perintah + "' tidak dapat diproses.");
        }
    }

    // Implementasi method interface: koneksiInternet
    @Override
    public void hubungkanWiFi(String ssid) {
        this.terhubungKeWiFi = true;
        System.out.println("[" + getNamaPerangkat() + "] Berhasil terhubung ke jaringan WiFi: " + ssid);
    }

    @Override
    public void putuskanWiFi() {
        this.terhubungKeWiFi = false;
        this.sedangMerekam = false;
        setStatusAktif(false);
        System.out.println("[" + getNamaPerangkat() + "] Koneksi WiFi diputus. Sistem otomatis standby.");
    }

    // Implementasi method interface: kameraKeamanan
    @Override
    public void rekamVideo() {
        if (terhubungKeWiFi && isStatusAktif()) {
            this.sedangMerekam = true;
            System.out.println("[" + getNamaPerangkat() + "] Memulai stream perekaman video HD 1080p...");
        } else {
            System.out.println("[" + getNamaPerangkat() + "] Perekaman gagal! Pastikan daya ON & WiFi terhubung.");
        }
    }

    @Override
    public void tangkapFoto() {
        if (isStatusAktif()) {
            System.out.println("[" + getNamaPerangkat() + "] SNAPSHOT! Foto snapshot berhasil disimpan ke cloud storage.");
        } else {
            System.out.println("[" + getNamaPerangkat() + "] SNAPSHOT GAGAL! Kamera sedang OFF.");
        }
    }
}