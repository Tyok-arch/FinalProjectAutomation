Feature: Employee

  @Smoke
  Scenario: Membuka Form Add Employee
    Given User membuka halaman login
    When User login menggunakan akun valid
    And User membuka menu Employee
    And User klik Add Employee
    Then Form Add Employee tampil


  @Positive
  @Positive
  Scenario: Mengisi seluruh data Employee
    Given User membuka halaman login
    When User login menggunakan akun valid
    And User membuka menu Employee
    And User klik Add Employee
    And User mengisi nama
    And User mengisi email
    And User mengisi nomor hp
    Then Form Add Employee tampil


  @Negative
  Scenario: Mengisi form tanpa nama
    Given User membuka halaman login
    When User login menggunakan akun valid
    And User membuka menu Employee
    And User klik Add Employee
    And User mengisi email
    And User mengisi nomor hp
    Then Form Add Employee tampil


  @Negative
  Scenario: Mengisi form tanpa email
    Given User membuka halaman login
    When User login menggunakan akun valid
    And User membuka menu Employee
    And User klik Add Employee
    And User mengisi nama
    And User mengisi nomor hp
    Then Form Add Employee tampil


  @Positive
  Scenario: Membuka Menu Employee
    Given User membuka halaman login
    When User login menggunakan akun valid
    And User membuka menu Employee
    Then Employee List tampil