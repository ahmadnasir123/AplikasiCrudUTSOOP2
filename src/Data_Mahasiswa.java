// Ahmad Nasir
// 2007411007

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data_Mahasiswa {
	private static List<Mahasiswa> data_mahasiswa = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		boolean aktif = true;
		
		// Value static
		tambahData("207", "Aini", 80, 80, 80);
		tambahData("208", "Ahmad", 90, 75, 80);
		tambahData("208", "Nasir", 90, 85, 80);
		
		while(aktif) {
			menu();
			
			String menu_pilihan = scanner.next();
			
			if(menu_pilihan.equals("1")) {
				System.out.println();
				System.out.println("Tambah data mahasiswa");
				System.out.println();
				System.out.print("NIM		: ");
				String nim = scanner.next(); 
				System.out.print("Nama		: ");
				String nama = scanner.next();
				System.out.print("Nilai Tugas	: ");
				int nilai_tugas = scanner.nextInt();
				System.out.print("Nilai UTS	: ");
				int nilai_uts = scanner.nextInt();
				System.out.print("Nilai UAS	: ");
				int nilai_uas = scanner.nextInt();
				
				tambahData(nim, nama, nilai_tugas, nilai_uts, nilai_uas);
				System.out.println();
			} else
			if(menu_pilihan.equals("2")) {
				System.out.println();
				System.out.println("Tampilkan data mahasiswa");
				System.out.println();
				System.out.println("NIM\tNama\tTugas\tUTS\tUAS\tNilai Akhir\tNilai Huruf");
				
				for(int i = 0; i < data_mahasiswa.size(); i++) {
					Mahasiswa data = data_mahasiswa.get(i);
					
					tampilkanData(data);
				}
				
				System.out.println();
			} else
			if(menu_pilihan.equals("3")) {
				System.out.println();
				System.out.println("Ubah data mahasiswa");
				System.out.println();
				System.out.print("Masukkan NIM dari mahasiswa : ");
				
				String cari_nim = scanner.next();
				System.out.println();
				
				// buat looping arraylistnya
				for(int i = 0; i < data_mahasiswa.size(); i++) {
					Mahasiswa data = data_mahasiswa.get(i);
					
					// Ngecek klo nim yg diloop = nim yg dicari
					if(data.getNim().equals(cari_nim)) {
						System.out.println("Data ditemukan");
						System.out.println();
						
						System.out.println("NIM\tNama\tTugas\tUTS\tUAS\tNilai Akhir\tNilai Huruf");
						tampilkanData(data);
						
						System.out.println();
						
						System.out.println("Data Baru");
						System.out.print("NIM		: ");
						String nim = scanner.next(); 
						System.out.print("Nama		: ");
						String nama = scanner.next();
						System.out.print("Nilai Tugas	: ");
						int nilai_tugas = scanner.nextInt();
						System.out.print("Nilai UTS	: ");
						int nilai_uts = scanner.nextInt();
						System.out.print("Nilai UAS	: ");
						int nilai_uas = scanner.nextInt();
					
						setData(i, nim, nama, nilai_tugas, nilai_uts, nilai_uas);
					}
					
					// cek klo loop udh selesai data gk ketemu
					if(i == data_mahasiswa.size() - 1) {
						System.out.println("Data tidak ditemukan");
					}
				}
				
				System.out.println();
			} else
			if(menu_pilihan.equals("4")) {
				System.out.println();
				System.out.println("Hapus data mahasiswa");
				System.out.println();
				System.out.print("Masukkan NIM dari mahasiswa : ");
				
				String cari_nim = scanner.next();
				System.out.println();
				
				// buat looping arraylistnya
				for(int i = 0; i < data_mahasiswa.size(); i++) {
					Mahasiswa data = data_mahasiswa.get(i);
					
					// cek klo nim yg diloop = nim yg dicari
					if(data.getNim().equals(cari_nim)) {
						data_mahasiswa.remove(i);
						System.out.println("Data telah dihapus");
					}
					
					// cek klo loop udh selesai data gk ketemu
					if(i == data_mahasiswa.size() - 1) {
						System.out.println("Data tidak ditemukan");
					}
				}
				System.out.println();
			} else
			if(menu_pilihan.equals("5")) {
				System.out.println();
				System.out.println("Search data by NIM");
				System.out.println();
				System.out.print("Masukkan NIM dari mahasiswa : ");
				
				String cari_nim = scanner.next();
				System.out.println();
				
				// buat looping arraylistnya
				for(int i = 0; i < data_mahasiswa.size(); i++) {
					Mahasiswa data = data_mahasiswa.get(i);
					
					// cek klo nim yg diloop = nim yg dicari
					if(data.getNim().equals(cari_nim)) {
						System.out.println("Nim " + cari_nim + " ditemukan \n");
						
						System.out.println("NIM\tNama\tTugas\tUTS\tUAS\tNilai Akhir\tNilai Huruf");
						tampilkanData(data);
						System.out.println();
					}
					
					// cek klo loop udh selesai data gk ketemu
					if(i == data_mahasiswa.size() - 1) {
						System.out.println("Data tidak ditemukan");
					}
				}
			} else
			if(menu_pilihan.equals("6")) {
				System.out.println();
				
				System.out.println("Program dihentikan");
				
				aktif = false;
				System.exit(0);
				
				System.out.println();
			} else {
				System.out.println();
				System.out.println("Tolong masukkan pilihan yang disediakan!");
				System.out.println();
			}
		}
		scanner.close();
	}
	
	static void menu() {
		System.out.println("Program CRUD data mahasiswa");
		System.out.println("=============================");
		System.out.println("1. Tambah data mahasiswa");
		System.out.println("2. Tampilkan data mahasiswa");
		System.out.println("3. Ubah data mahasiswa");
		System.out.println("4. Hapus data mahasiswa");
		System.out.println("5. Search data by NIM");
		System.out.println("6. Selesai");
		System.out.println("=============================");
		System.out.print("pilih [1-6]? : ");
	}
	
	private static void tambahData(String nim, String nama, int nilai_tugas, int nilai_uts, int nilai_uas) {
		int nilai_akhir = nilaiAkhir(nilai_tugas, nilai_uts, nilai_uas);
		String nilai_huruf = nilaiHuruf(nilai_akhir);
		
		data_mahasiswa.add(new Mahasiswa(nim, nama, nilai_tugas, nilai_uts, nilai_uas, nilai_akhir, nilai_huruf));
	}
	
	private static void setData(int i, String nim, String nama, int nilai_tugas, int nilai_uts, int nilai_uas) {
		int nilai_akhir = nilaiAkhir(nilai_tugas, nilai_uts, nilai_uas);
		String nilai_huruf = nilaiHuruf(nilai_akhir);
		
		Mahasiswa data_baru = new Mahasiswa(nim, nama, nilai_tugas, nilai_uts, nilai_uas, nilai_akhir, nilai_huruf);
		
		data_mahasiswa.set(i, data_baru);
	}
	
	private static int nilaiAkhir(int nilai_tugas, int nilai_uts, int nilai_uas) {
		int nilai_akhir = 0;
		
		nilai_akhir = (nilai_tugas + nilai_uts + nilai_uas) / 3;
		
		return nilai_akhir;
	}
	
	private static String nilaiHuruf(int nilai_akhir) {
		String huruf = "E";
		
		if(nilai_akhir >= 81) { 
			huruf = "A";
		} else
		if(nilai_akhir >= 76) {
			huruf = "A-";
		} else
		if(nilai_akhir >= 72) {
			huruf = "B+";
		} else
		if(nilai_akhir >= 68) {
			huruf = "B";
		} else
		if(nilai_akhir >= 64) {
			huruf = "B-";
		} else
		if(nilai_akhir >= 60) {
			huruf = "C+";
		} else
		if(nilai_akhir >= 56) {
			huruf = "C";
		} else
		if(nilai_akhir >= 41) {
			huruf = "D";
		}
		
		return huruf;
	}

	private static void tampilkanData(Mahasiswa data) {
		System.out.print(data.getNim() + "\t");
		System.out.print(data.getNama() + "\t");
		System.out.print(data.getNilai_tugas() + "\t");
		System.out.print(data.getNilai_uts() + "\t");
		System.out.print(data.getNilai_uas() + "\t");
		System.out.print(data.getNilai_akhir() + "\t\t");
		System.out.print(data.getNilai_huruf() + "\t");
		System.out.println();
	}
}
