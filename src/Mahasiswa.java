
public class Mahasiswa {
	private String nim;
	private String nama;
	private int nilai_tugas;
	private int nilai_uts;
	private int nilai_uas;
	private int nilai_akhir;
	private String nilai_huruf;
	
	Mahasiswa(String nim, String nama, int nilai_tugas, int nilai_uts, int nilai_uas, int nilai_akhir, String nilai_huruf) {
		this.nim = nim;
		this.nama = nama;
		this.nilai_tugas = nilai_tugas;
		this.nilai_uts = nilai_uts;
		this.nilai_uas = nilai_uas;
		this.nilai_akhir = nilai_akhir;
		this.nilai_huruf = nilai_huruf;
	}

	public String getNim() {
		return nim;
	}

	public String getNama() {
		return nama;
	}

	public int getNilai_tugas() {
		return nilai_tugas;
	}

	public int getNilai_uts() {
		return nilai_uts;
	}

	public int getNilai_uas() {
		return nilai_uas;
	}

	public int getNilai_akhir() {
		return nilai_akhir;
	}

	public String getNilai_huruf() {
		return nilai_huruf;
	}
	
	
}
