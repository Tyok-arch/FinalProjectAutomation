Feature: Login

  @Smoke
  Scenario: Login menggunakan akun valid
    Given User membuka halaman login
    When User login menggunakan akun valid
    Then User berhasil masuk dashboard

  @Negative
  Scenario: Login tanpa email
    Given User membuka halaman login
    When User login tanpa email
    Then Login gagal

  @Negative
  Scenario: Login tanpa password
    Given User membuka halaman login
    When User login tanpa password
    Then Login gagal

  @Negative
  Scenario: Login email salah
    Given User membuka halaman login
    When User login dengan email salah
    Then Login gagal

  @Negative
  Scenario: Login password salah
    Given User membuka halaman login
    When User login dengan password salah
    Then Login gagal

  @Negative
  Scenario: Login email dan password kosong
    Given User membuka halaman login
    When User login tanpa email dan password
    Then Login gagal