package tugas2;

import java.io.IOException;
import java.util.*;

public class Menu {

	private static HashMap<Integer, String> hNomorInduk = new HashMap<Integer, String>();
	private static HashMap<Integer, String> hNama = new HashMap<Integer, String>();
	private static HashMap<Integer, String> hJabatan = new HashMap<Integer, String>();
	private static HashMap<Integer, String> hUnitKerja = new HashMap<Integer, String>();
	private static HashMap<Integer, Integer> hLamaKerja = new HashMap<Integer, Integer>();
	private static HashMap<Integer, String> hStatus = new HashMap<Integer, String>();
	private static HashMap<Integer, Integer> hGajiPokok= new HashMap<Integer, Integer>();
	private static HashMap<Integer, Integer> hTunjangan= new HashMap<Integer, Integer>();
	private static HashMap<Integer, Integer> hPajak= new HashMap<Integer, Integer>();
	private static HashMap<Integer, Integer> hGajiTotal= new HashMap<Integer, Integer>();
	
	private static int nomorTampilan = 1;
	private static int posisiNIK = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		boolean aktif = true;

		// pre add data
		hNomorInduk.put(0, "123451");
		hNama.put(0, "najib");
		hJabatan.put(0, "manager");
		hUnitKerja.put(0, "abcde");
		hLamaKerja.put(0, 9);
		hStatus.put(0, "menikah");
		Hitung(0);
		
		hNomorInduk.put(1, "123452");
		hNama.put(1, "sule");
		hJabatan.put(1, "staff");
		hUnitKerja.put(1, "abcde");
		hLamaKerja.put(1, 5);
		hStatus.put(1, "menikah");
		Hitung(1);
		
		hNomorInduk.put(2, "123453");
		hNama.put(2, "parto");
		hJabatan.put(2, "staff");
		hUnitKerja.put(2, "abcde");
		hLamaKerja.put(2, 2);
		hStatus.put(2, "lajang");
		Hitung(2);
		
		while(aktif) {
			menu();
			System.out.print("+++ masukan pilihan anda: ");
			String pilihan = scanner.nextLine();
			System.out.println();
			
			// Tambah Data
			if(pilihan.equals("1")) {
				// Nomor Induk
				System.out.print("Nomor Induk      : ");
				String nomor_induk = scanner.next();
				// Nama
				System.out.print("Nama             : ");
				String nama = scanner.next();
				// Jabatan
				System.out.println("Jabatan          * manager    * staff    atau   * ob ");
				System.out.print("                 : ");
				String jabatan = scanner.next();
				// Unit Kerja
				System.out.print("Unit Kerja       : ");
				String unit_kerja = scanner.next();
				// Lama Kerja
				System.out.print("Lama Kerja       : ");
				Integer lama_kerja = scanner.nextInt();
				// Status
				System.out.println("Status           * menikah atau * lajang");
				System.out.print("                 : ");
				String status = scanner.next();
							
				// Naro Var ke Hash Map
				boolean TambahData = false;
				int i = 0;
				while(TambahData == false) {
					if(hNomorInduk.containsKey(i)) {
						i += 1;
					} else {
						hNomorInduk.put(i, nomor_induk);
						hNama.put(i, nama);
						hJabatan.put(i, jabatan);
						hUnitKerja.put(i, unit_kerja);
						hLamaKerja.put(i, lama_kerja);
						hStatus.put(i, status);
						Hitung(i);
						TambahData = true;
					}
				}
			} else	// Hapus Data
			if(pilihan.equals("2")) {
				System.out.print("Masukkan nomor induk yang ingin dihapus: ");
				String NIK_yg_dicari = scanner.next();
				
				posisiNIK = cariNIK(NIK_yg_dicari);
				
				hapusData(posisiNIK);
				
			} else
			if (pilihan.equals("3")) {
				System.out.print("Masukkan nomor induk yang ingin diedit: ");
				String NIK_yg_dicari = scanner.next();

				posisiNIK = cariNIK(NIK_yg_dicari);
				
				// nampilin data input karyawan sebelumnya
				System.out.println("\nNomor Induk	: " + hNomorInduk.get(posisiNIK));
				System.out.println("Nama		: " + hNama.get(posisiNIK));
				System.out.println("Jabatan		* manager   * staff   atau   * ob");
				System.out.println("		: " + hJabatan.get(posisiNIK));
				System.out.println("Unit Kerja	: " + hUnitKerja.get(posisiNIK));
				System.out.println("Lama Kerja	: " + hLamaKerja.get(posisiNIK));
				System.out.println("Status		* menikah atau * lajang");
				System.out.println("		: " + hStatus.get(posisiNIK));
				System.out.println("\n");
				
				// hapus data untuk input selanjutnya
				hapusData(posisiNIK);
				
				// input data baru
				System.out.println("Masukkan data yang baru");
				
				// Nomor Induk
				System.out.print("Nomor Induk      : ");
				String nomor_induk = scanner.next();
				// Nama
				System.out.print("Nama             : ");
				String nama = scanner.next();
				// Jabatan
				System.out.println("Jabatan          * manager    * staff    atau   * ob ");
				System.out.print("                 : ");
				String jabatan = scanner.next();
				// Unit Kerja
				System.out.print("Unit Kerja       : ");
				String unit_kerja = scanner.next();
				// Lama Kerja
				System.out.print("Lama Kerja       : ");
				Integer lama_kerja = scanner.nextInt();
				// Status
				System.out.println("Status           * menikah atau * lajang");
				System.out.print("                 : ");
				String status = scanner.next();
							
				// Naro Var ke Hash Map
				hNomorInduk.put(posisiNIK, nomor_induk);
				hNama.put(posisiNIK, nama);
				hJabatan.put(posisiNIK, jabatan);
				hUnitKerja.put(posisiNIK, unit_kerja);
				hLamaKerja.put(posisiNIK, lama_kerja);
				hStatus.put(posisiNIK, status);
				Hitung(posisiNIK);
		
			} else
			if (pilihan.equals("4")) {
				sortingData();
			} else
			if (pilihan.equals("5")){
				System.out.print("Masukkan nomor induk yang ingin ditampilkan: ");
				String NIK_yg_dicari = scanner.next();
				
				posisiNIK = cariNIK(NIK_yg_dicari);
					
				// Tabel gaji dsb
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("No.\tNomor\t   Nama   \tGaji\t\tTunjangan\tPajak\t\tGaji yg  ");
				System.out.println("   \tInduk\t\t\tPokok\t\t\t\t\t\tDiterima");
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.print(1 + "\t");
				System.out.print(hNomorInduk.get(posisiNIK) + "\t   ");
				System.out.print(hNama.get(posisiNIK) + "   \t");
				System.out.print(hGajiPokok.get(posisiNIK) + "\t\t");
				System.out.print(hTunjangan.get(posisiNIK) + "\t\t");
				System.out.print(hPajak.get(posisiNIK) + "\t\t");
				System.out.println("Rp." + hGajiTotal.get(posisiNIK));
				
					
			} else  // Tampilkan Data
			if(pilihan.equals("6")) {
				dataInputKaryawan();
				dataTabelKaryawan();
			} else
			if (pilihan.equals("7")) {
				System.out.println("Anda telah keluar dari aplikasi");
				System.exit(0);
			}
		}
		scanner.close();
	}
	
	static void menu() {
		System.out.println("\n[--- MENU PILIHAN: -----------------------------------------------------------------------]");
		System.out.println();
		System.out.println("1. Tambah Data");
		System.out.println("2. Hapus Data");
		System.out.println("3. Edit Data");
		System.out.println("4. Urutkan Data");
		System.out.println("5. Lakukan Pencarian");
		System.out.println("6. Tampilkan Data");
		System.out.println();
		System.out.println("7. Keluar dari program");
		System.out.println();
	}
	
	static void dataInputKaryawan() {
		for(int i : hNomorInduk.keySet()) {
			System.out.print("* Data Karyawan ke-");
			System.out.println(nomorTampilan);
			System.out.println();
			System.out.println("		Nomor Induk	: " + hNomorInduk.get(i));
			System.out.println("		Nama		: " + hNama.get(i));
			System.out.println("		Jabatan		* manager   * staff   atau   * ob");
			System.out.println("				: " + hJabatan.get(i));
			System.out.println("		Unit Kerja	: " + hUnitKerja.get(i));
			System.out.println("		Lama Kerja	: " + hLamaKerja.get(i));
			System.out.println("		Status		* menikah atau * lajang");
			System.out.println("				: " + hStatus.get(i));
			System.out.println("\n");
			nomorTampilan += 1;
		}
	}
	
	static void dataTabelKaryawan() {
		// Tabel gaji dsb
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("No.\tNomor\t   Nama   \tGaji\t\tTunjangan\tPajak\t\tGaji yg  ");
		System.out.println("   \tInduk\t\t\tPokok\t\t\t\t\t\tDiterima");
		System.out.println("------------------------------------------------------------------------------------------");
		nomorTampilan = 1;
		for(int i : hNomorInduk.keySet()) {
			System.out.print(nomorTampilan + "\t");
			System.out.print(hNomorInduk.get(i) + "\t   ");
			System.out.print(hNama.get(i) + "   \t");
			System.out.print(hGajiPokok.get(i) + "\t\t");
			System.out.print(hTunjangan.get(i) + "\t\t");
			System.out.print(hPajak.get(i) + "\t\t");
			System.out.println("Rp." + hGajiTotal.get(i));
			nomorTampilan += 1;
		}
	}
	
	static void Hitung(int i) {
		// Masukin Gaji Pokok
		String jabatan = hJabatan.get(i);
		if(jabatan.equals("manager")) {
			hGajiPokok.put(i, 5000000);
		}
		if(jabatan.equals("staff")) {
			hGajiPokok.put(i, 3000000);
		}
		if(jabatan.equals("ob")) {
			hGajiPokok.put(i, 2000000);
		}
				
		// ngitung tunjangan dan Dimasukin
		int gaji = hGajiPokok.get(i);
		int tahun_kerja = hLamaKerja.get(i);
		int tunjangan = 0;
			
		if (tahun_kerja > 0) {
			tunjangan = ((10 * gaji) / 100) * tahun_kerja;
			hTunjangan.put(i, tunjangan);
		} 
		if (tahun_kerja == 0) {
			tunjangan = ((10 * gaji) / 100);
			hTunjangan.put(i, tunjangan);
		}
			
		// ngitung pajak
		int pajak = 0;
		if(hJabatan.get(i).equals("manager")) {
			pajak = (15 * gaji) / 100;
		}
		if(hJabatan.get(i).equals("staff")) {
			pajak = (5 * gaji) / 100;
		}
		if(hJabatan.get(i).equals("ob")) {
			pajak = 0;
		}
		hPajak.put(i, pajak);
					
		// ngitung gaji yang diterima
		int gaji_total = gaji + tunjangan - pajak;
		hGajiTotal.put(i, gaji_total);
	}
	
	static void hapusData(int posisiNIK) {
		hNomorInduk.remove(posisiNIK);
		hNama.remove(posisiNIK);
		hJabatan.remove(posisiNIK);
		hUnitKerja.remove(posisiNIK);
		hLamaKerja.remove(posisiNIK);
		hStatus.remove(posisiNIK);
		hGajiPokok.remove(posisiNIK);
		hTunjangan.remove(posisiNIK);
		hPajak.remove(posisiNIK);
		hGajiTotal.remove(posisiNIK);
	}
	
	static int cariNIK(String NIK_yg_dicari) {
		posisiNIK = 0;
		
		for(Map.Entry<Integer, String> entry : hNomorInduk.entrySet()) {
			if(Objects.equals(entry.getValue(), NIK_yg_dicari)) {
				posisiNIK = entry.getKey();
			}
		}
		
		return posisiNIK;
	}
	
	static int cariNama(String nama) {
		int posisi = 0;
		
		for(Map.Entry<Integer, String> entry : hNama.entrySet()) {
			if(Objects.equals(entry.getValue(), nama)) {
				posisi = entry.getKey();
			}
		}
		
		return posisi;
	}
	
	// sorting data berdasarkan nama
	static void sortingData() {
		List<String> namaKaryawan = new ArrayList<>(hNama.values());
		
		nomorTampilan = 1;
		
		Collections.sort(namaKaryawan);
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("No.\tNama\t   Nomor    \tGaji\t\tTunjangan\tPajak\t\tGaji yg  ");
		System.out.println("   \t\t   Induk\tPokok\t\t\t\t\t\tDiterima");
		System.out.println("------------------------------------------------------------------------------------------");
		
		for (int i = 0; i < namaKaryawan.size(); i++) {
//			String nama = cariNama();
			String nama = namaKaryawan.get(i);
			
			int posisiNama = cariNama(nama);
			
			System.out.print(nomorTampilan + "\t");
			System.out.print(hNama.get(posisiNama) + "\t");
			System.out.print("   " + hNomorInduk.get(posisiNama) + "\t");
			System.out.print(hGajiPokok.get(posisiNama) + "\t\t");
			System.out.print(hTunjangan.get(posisiNama) + "\t\t");
			System.out.print(hPajak.get(posisiNama) + "\t\t");
			System.out.println("Rp." + hGajiTotal.get(posisiNama));
			
			nomorTampilan += 1;
		}
		
	}
}

