public class Main {
    public static void main(String[] args) {
        lampuPintar lampuTeras = new lampuPintar("LMP-01", "Lampu Teras Depan", 15);

        System.out.println("--- UJI STATUS AWAL & INHERITANCE (LAMPU) ---");
        lampuTeras.tampilkanInformasi();

        System.out.println("\n--- UJI LOGIKA STATE PERCABANGAN (LAMPU) ---");
        lampuTeras.prosesSinyalKontrol("HIDUPKAN");
        lampuTeras.prosesSinyalKontrol("HIDUPKAN");

        System.out.println("\n--- UJI METHOD FUNGSI RETURN VALUE ---");
        double estimasiBiaya = lampuTeras.hitungEstimasiBiaya(12, 1444.70);
        System.out.printf("Estimasi Biaya Teras (12 Jam) : Rp %.2f\n", estimasiBiaya);

        System.out.println("\n--- UJI MULTIPLE INTERFACE & SUPER CHAINING ---");
        kameraPintar cctvGarasi = new kameraPintar("CAM-09", "CCTV Garasi Mobil", 25);
        cctvGarasi.tampilkanInformasi();

        System.out.println("\n--- UJI STATE INTERACTION (KONTROL KAMERA) ---");
        cctvGarasi.prosesSinyalKontrol("AKTIFKAN_KEAMANAN");
        cctvGarasi.hubungkanWiFi("Home_Network_5G");
        cctvGarasi.prosesSinyalKontrol("AKTIFKAN_KEAMANAN");
        cctvGarasi.tangkapFoto();

        System.out.println("\n--- UJI POLIMORFISME INTERFACE ---");

        koneksiInternet devNet = new kameraPintar("DEV-CAM-10", "CCTV Teras Belakang", 20);
        kameraKeamanan devSec = (kameraKeamanan) devNet; // Casting referensi interface

        devNet.hubungkanWiFi("Guest_WiFi"); // Dipanggil via variabel referensi bertipe interface
        devSec.rekamVideo();
        devNet.putuskanWiFi();
    }
}