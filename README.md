1. Framework Automation Testing
Framework komprehensif untuk testing automation Web UI dan API menggunakan Selenium, RestAssured, dan Cucumber dengan Gradle.

2. Fitur
   * Web Testing: Testing browser otomatis dengan Selenium WebDriver
   * API Testing: Testing REST API dengan RestAssured
   * Pendekatan BDD: Cucumber dengan sintaks Gherkin
   * Cross-Browser: Dukungan browser Chrome
   * Siap CI/CD: Integrasi GitHub Actions
   * Laporan Detail: Laporan HTML, JSON, dan JUnit 

3. Tech Stack & Tools
     Framework Testing
      * Selenium WebDriver 4.20.0 - Automasi web
      * RestAssured 5.4.0 - Testing API
      * Cucumber 7.15.0 - Framework BDD
      * JUnit 5 - Test runner dan assertions
     Build Tools
      * Gradle 8.10 - Automasi build
      * Java 11 - Bahasa pemrograman
     Manajemen Browser
      * WebDriverManager 5.9.2 - Manajemen driver otomatis
      * ChromeDriver - Automasi browser
     CI/CD
      * GitHub Actions - Continuous Integration
      * HTML Reports - Laporan eksekusi test

4. Cara Menjalankan Test
     Prerequisites
      * Java 11 atau lebih tinggi
      * Gradle 8.10
     Jalankan Semua Test 
      * ./gradlew testAll
     Jalankan Web Tests Saja
      * ./gradlew testWeb
     Jalankan API Tests Saja
      * ./gradlew testApi

5. Laporan Test
     Setelah eksekusi test, laporan di-generate di:
      * HTML Reports: build/reports/cucumber/index.html
      * JSON Reports: build/reports/cucumber/cucumber.json
      * JUnit Reports: build/reports/cucumber/junit.xml

6. GitHub Actions
     Trigger Manual
      * Buka tab Actions di GitHub
      * Pilih workflow "Run Automation Tests"
      * Klik "Run workflow"
     Pada Pull Request
      * Test berjalan otomatis pada setiap PR ke branch main atau develop
      * Hasil terlihat di checks PR
      * Laporan tersedia sebagai artifacts
     Fitur Workflow
      * Eksekusi test paralel
      * Laporan test otomatis
      * Upload artifact untuk hasil test
      * Caching untuk build lebih cepat

7. Skenario Test
     Web Tests (@web) 
      * Tambahkan produk ke keranjang: Navigasi ke situs e-commerce demo dan menambahkan produk ke keranjang
     API Tests (@api)
      * Dapatkan user by id: Mengambil informasi user dari JSONPlaceholder API
      * Buat dan hapus user: Test workflow pembuatan dan penghapusan user

8. Konfigurasi
     Konfigurasi Browser
      * Browser default: Chrome 
      * Manajemen driver otomatis via WebDriverManager 
      * Mode headless tersedia via system properties
     Konfigurasi API
      * Base URL: JSONPlaceholder 
      * Tidak perlu authentication 
      * Dapat disesuaikan via system properties