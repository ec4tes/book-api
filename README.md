# Book API (Spring Boot + PostgreSQL)

Bu proje, Spring Boot kullanılarak geliştirilmiş basit bir RESTful API uygulamasıdır.  
Uygulama, kitaplar üzerinde temel CRUD işlemlerini gerçekleştirmeyi sağlar.

##  Proje Amacı

Bu projenin amacı:

- Spring Boot ile REST API geliştirmeyi öğrenmek
- Katmanlı mimariyi (Controller - Service - Repository) anlamak
- PostgreSQL ile veritabanı bağlantısını kurmak
- JPA (Hibernate) kullanarak veri işlemlerini gerçekleştirmek
- DTO (Data Transfer Object) yapısını öğrenmek

---

## 🛠 Kullanılan Teknolojiler

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

---

##  Proje Yapısı

- com.ecates.bookapi
- ┣ controller → HTTP isteklerini karşılar
- ┣ service → İş mantığını tanımlar
- ┣ service.impl → İş mantığını uygular
- ┣ repository → Veritabanı işlemleri
- ┣ entity → Veritabanı tabloları
- ┗ dto → Veri taşıma objeleri
