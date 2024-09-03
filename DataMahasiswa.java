import javax.swing.*;
import java.util.*;

public class DataMahasiswa {
    public static void main(String[] args) {
        ArrayList<String> mahasiswaList = new ArrayList<>();
        String[] options = {"Tambah Mahasiswa", "Hapus Mahasiswa", "Ubah Mahasiswa", "Urutkan Mahasiswa", "Tampilkan Mahasiswa", "Keluar"};
        int choice;

        do {
            choice = JOptionPane.showOptionDialog(null, "Selamat datang! Silahkan pilih aksi!", "Manajemen Data Mahasiswa",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == JOptionPane.CLOSED_OPTION) {
                break;
            }

            switch (choice) {
                case 0: // Tambah Mahasiswa
                    String namaBaru = JOptionPane.showInputDialog("Masukkan nama mahasiswa:");
                    if (namaBaru != null && !namaBaru.trim().isEmpty()) {
                        mahasiswaList.add(namaBaru);
                        JOptionPane.showMessageDialog(null, "Nama Mahasiswa: " + namaBaru + " berhasil ditambahkan.");
                    }
                    break;

                case 1: // Hapus Mahasiswa
                    if (!mahasiswaList.isEmpty()) {
                        String namaHapus = JOptionPane.showInputDialog("Masukkan nama mahasiswa yang akan dihapus:");
                        if (mahasiswaList.remove(namaHapus)) {
                            JOptionPane.showMessageDialog(null, "Nama Mahasiswa: " + namaHapus + " berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nama Mahasiswa: " + namaHapus + " tidak ditemukan.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Daftar mahasiswa kosong.");
                    }
                    break;

                case 2: // Ubah Mahasiswa
                    if (!mahasiswaList.isEmpty()) {
                        String namaLama = JOptionPane.showInputDialog("Masukkan nama mahasiswa yang akan diubah:");
                        if (mahasiswaList.contains(namaLama)) {
                            String namaBaruUbah = JOptionPane.showInputDialog("Masukkan nama baru:");
                            if (namaBaruUbah != null && !namaBaruUbah.trim().isEmpty()) {
                                mahasiswaList.set(mahasiswaList.indexOf(namaLama), namaBaruUbah);
                                JOptionPane.showMessageDialog(null, "Nama Mahasiswa: " + namaLama + " berhasil diubah menjadi " + namaBaruUbah + ".");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Nama Mahasiswa: " + namaLama + " tidak ditemukan.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Daftar mahasiswa kosong.");
                    }
                    break;

                case 3: // Urutkan Mahasiswa
                    if (!mahasiswaList.isEmpty()) {
                        Collections.sort(mahasiswaList);
                        JOptionPane.showMessageDialog(null, "Daftar mahasiswa berhasil diurutkan.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Daftar mahasiswa kosong.");
                    }
                    break;

                case 4: // Tampilkan Mahasiswa
                    if (!mahasiswaList.isEmpty()) {
                        StringBuilder sb = new StringBuilder("Daftar Mahasiswa:\n");
                        for (String mahasiswa : mahasiswaList) {
                            sb.append(mahasiswa).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Daftar mahasiswa kosong.");
                    }
                    break;

                case 5: // Keluar
                    JOptionPane.showMessageDialog(null, "Terima kasih!");
                    break;

                default:
                    break;
            }
        } while (choice != 5);
    }
}
