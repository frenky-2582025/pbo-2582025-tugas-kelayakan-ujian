import java.util.Scanner;

public class KelayakanUjian {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data sesuai tipe data yang sesuai
        System.out.print("kehadiran (%) : ");
        int kehadiran = scanner.nextInt();

        System.out.print("Nilai tugas   : ");
        int nilaiTugas = scanner.nextInt();

        System.out.print("Dispensasi    : ");
        boolean dispensasi = scanner.nextBoolean();

        // ---------------------------------------------------------------------
        // KETENTUAN 1: Tiga Versi Penulisan Logika Kelayakan Ujian
        // ---------------------------------------------------------------------

        // a. Tanpa kurung
        boolean a = kehadiran >= 75 && nilaiTugas >= 60 || dispensasi;

        // b. Kurung precedence (penjumlahan/pengelompokan berdasarkan prioritas operator &&)
        boolean b = (kehadiran >= 75 && nilaiTugas >= 60) || dispensasi;

        // c. Kurung digeser (memaksa || dievaluasi terlebih dahulu)
        boolean c = kehadiran >= 75 && (nilaiTugas >= 60 || dispensasi);

        /*
         * KOMENTAR KETENTUAN 1:
         * Hasil versi 'a' sama persis dengan versi 'b'.
         * Kesimpulan: Operator && mengikat lebih kuat daripada || (memiliki precedence lebih tinggi),
         * sehingga Java membaca ekspresi 'a' persis seperti versi 'b'.
         */

        // ---------------------------------------------------------------------
        // KETENTUAN 2: Pembuktian Short-Circuit Evaluation
        // ---------------------------------------------------------------------
        int cek = 0;

        // Menguji short-circuit dengan post-increment cek++
        boolean testShortCircuit = (kehadiran >= 75) && ((nilaiTugas >= 60) || (cek++ > 0));

        /*
         * KOMENTAR KETENTUAN 2:
         * Nilai 'cek' berakhir di 0 (tidak bertambah) karena terjadi short-circuit evaluation.
         * Ketika kehadiran = 40, kondisi pertama (kehadiran >= 75) bernilai false.
         * Karena menggunakan operator &&, Java langsung menghentikan evaluasi dan mengabaikan
         * seluruh ekspresi di sebelah kanan &&, sehingga (cek++) tidak pernah dieksekusi.
         */

        // ---------------------------------------------------------------------
        // KETENTUAN 3, 4, & 5: Output Program Tanpa Menggunakan IF
        // ---------------------------------------------------------------------
        System.out.println("\n===== KELAYAKAN UJIAN =====");
        System.out.println("Kehadiran   : " + kehadiran + "%");
        System.out.println("Nilai tugas : " + nilaiTugas);
        System.out.println("Dispensasi  : " + dispensasi);
        System.out.println();
        System.out.println("a (tanpa kurung)     : " + a);
        System.out.println("b (kurung precedence): " + b);
        System.out.println("c (kurung digeser)   : " + c);
        System.out.println("!dispensasi          : " + (!dispensasi));
        System.out.println("cek dipanggil        : " + cek);

        scanner.close();
    }
}