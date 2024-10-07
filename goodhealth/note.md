### Apa itu REST Server?
REST (Representational State Transfer) Server adalah server yang menyediakan layanan web menggunakan prinsip-prinsip REST. REST adalah arsitektur yang menggunakan HTTP untuk komunikasi antara klien dan server. RESTful API adalah antarmuka yang memungkinkan klien untuk berinteraksi dengan server melalui operasi CRUD (Create, Read, Update, Delete) menggunakan metode HTTP standar seperti GET, POST, PUT, dan DELETE.

### Karakteristik REST Server:
1. **Stateless**: Setiap permintaan dari klien ke server harus berisi semua informasi yang diperlukan untuk memahami dan memproses permintaan tersebut. Server tidak menyimpan informasi tentang status klien antara permintaan.
2. **Client-Server Architecture**: Memisahkan antarmuka pengguna dari penyimpanan data, meningkatkan portabilitas antarmuka pengguna di berbagai platform dan meningkatkan skalabilitas server.
3. **Cacheable**: Respons harus dapat di-cache untuk meningkatkan kinerja.
4. **Layered System**: Arsitektur dapat terdiri dari beberapa lapisan, seperti server, gateway, dan proxy, yang dapat meningkatkan skalabilitas dan keamanan.
5. **Uniform Interface**: Menggunakan antarmuka yang seragam untuk berinteraksi dengan sumber daya, biasanya melalui URL dan metode HTTP standar.

### Bukti bahwa Project ini Sedang Membangun REST Server:
1. **Operasi CRUD**:
   - Anda memiliki endpoint untuk membuat (`create.php`), membaca (`index.php`), memperbarui (`update.php`), dan menghapus (`delete.php`) data, yang merupakan operasi dasar dalam RESTful API.

2. **Metode HTTP**:
   - Anda menggunakan metode HTTP yang sesuai seperti `POST` untuk membuat data dan `GET` untuk membaca data.

3. **Format JSON**:
   - Anda mengonversi data PHP menjadi format JSON untuk dikirim sebagai respons HTTP dan menerima data dalam format JSON dari permintaan HTTP, yang merupakan praktik umum dalam RESTful API.

4. **Endpoint yang Jelas**:
   - Anda memiliki endpoint yang jelas untuk berbagai entitas seperti

pesan_obat

, `regis_poli`,

dokter

,

pasien

, dan `user`.

5. **Penanganan Kesalahan**:
   - Anda menangani kesalahan yang terjadi selama operasi database dan memberikan pesan kesalahan yang sesuai dalam format JSON.

6. **Koneksi Database dengan PDO**:
   - Anda menghubungkan aplikasi PHP dengan database MySQL menggunakan PDO dan menangani kesalahan koneksi database dengan pengecualian (exception handling).

7. **Pengaturan Header HTTP**:
   - Anda menetapkan header HTTP untuk menentukan tipe konten respons sebagai JSON.

### Kesimpulan
Dengan semua poin di atas, dapat dikatakan bahwa project ini sedang membangun REST Server. Anda menyediakan layanan web yang memungkinkan klien untuk berinteraksi dengan server melalui operasi CRUD menggunakan metode HTTP standar dan mengembalikan data dalam format JSON.




Ya, berdasarkan kode yang ada dalam project ini, kita dapat menentukan beberapa relasi antar entitas. Berikut adalah analisis relasi antar entitas berdasarkan kode yang diberikan:

### 1. **Entitas

pesan_obat

**
- **Relasi dengan

pasien

**:
  - Setiap entri dalam tabel

pesan_obat

 memiliki kolom `id_pasien` yang merupakan foreign key yang merujuk ke kolom `id_pasien` dalam tabel

pasien

.
  - Relasi: Banyak ke Satu (Many-to-One) dari

pesan_obat

 ke

pasien

.

### 2. **Entitas `regis_poli`**
- **Relasi dengan

pasien

**:
  - Setiap entri dalam tabel `regis_poli` memiliki kolom `id_pasien` yang merupakan foreign key yang merujuk ke kolom `id_pasien` dalam tabel

pasien

.
  - Relasi: Banyak ke Satu (Many-to-One) dari `regis_poli` ke

pasien

.
- **Relasi dengan

dokter

**:
  - Setiap entri dalam tabel `regis_poli` memiliki kolom `id_dokter` yang merupakan foreign key yang merujuk ke kolom `id_dokter` dalam tabel

dokter

.
  - Relasi: Banyak ke Satu (Many-to-One) dari `regis_poli` ke

dokter

.

### 3. **Entitas `user`**
- **Relasi dengan

pasien

**:
  - Setiap entri dalam tabel `user` memiliki kolom `id_pasien` yang merupakan foreign key yang merujuk ke kolom `id_pasien` dalam tabel

pasien

.
  - Relasi: Satu ke Satu (One-to-One) dari `user` ke

pasien

.

### 4. **Entitas

dokter

**
- **Relasi dengan `regis_poli`**:
  - Setiap entri dalam tabel

dokter

 dapat memiliki banyak entri terkait dalam tabel `regis_poli` melalui kolom `id_dokter`.
  - Relasi: Satu ke Banyak (One-to-Many) dari

dokter

 ke `regis_poli`.

### 5. **Entitas

pasien

**
- **Relasi dengan

pesan_obat

**:
  - Setiap entri dalam tabel

pasien

 dapat memiliki banyak entri terkait dalam tabel

pesan_obat

 melalui kolom `id_pasien`.
  - Relasi: Satu ke Banyak (One-to-Many) dari

pasien

 ke

pesan_obat

.
- **Relasi dengan `regis_poli`**:
  - Setiap entri dalam tabel

pasien

 dapat memiliki banyak entri terkait dalam tabel `regis_poli` melalui kolom `id_pasien`.
  - Relasi: Satu ke Banyak (One-to-Many) dari

pasien

 ke `regis_poli`.
- **Relasi dengan `user`**:
  - Setiap entri dalam tabel

pasien

 memiliki satu entri terkait dalam tabel `user` melalui kolom `id_pasien`.
  - Relasi: Satu ke Satu (One-to-One) dari

pasien

 ke `user`.

### Diagram Relasi Antar Entitas
```


pas

ien (1) <---- (M) pesan_obat
pasien (1) <---- (M) regis_poli ----> (M) dokter (1)
pasien (1) <---- (1) user
```

### Kesimpulan
Dengan menganalisis kode dan struktur database yang ada, kita dapat menentukan bahwa project ini memiliki beberapa relasi antar entitas yang mencerminkan hubungan antara pasien, pesan_obat, regis_poli, dokter, dan user. Relasi-relasi ini penting untuk memastikan integritas data dan memudahkan pengelolaan data dalam aplikasi.