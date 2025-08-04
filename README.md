# API Test Layihəsi | API Test Project

###  Layihə haqqında | About the Project

Bu layihə REST API-lərin test olunması üçün hazırlanmışdır. Layihə `Java` proqramlaşdırma dili ilə yazılıb və əsasən aşağıdakı test alətlərindən istifadə edir:  
**JUnit 5**, **TestNG** və **RestAssured**.

> **Diqqət:** Bu layihədə **BDD (Behavior-Driven Development)** yanaşması istifadə olunmur. Yəni, burada `Cucumber` və ya `Gherkin` formatı yoxdur. Test ssenariləri **təmiz və sadə Java kodu** ilə yazılıb.

---

### 🔧 İstifadə olunan texnologiyalar | Technologies Used

- Java 17+
- JUnit 5
- TestNG
- RestAssured
- Maven

---

###  Məqsəd | Purpose

- REST API-ləri avtomatlaşdırılmış şəkildə test etmək
- Status kodları və header-ları yoxlamaq
- JSON cavabların strukturunu və datalarını test etmək
- Pozitiv və neqativ ssenariləri əhatə etmək
- Authorization və authentication sınaqları aparmaq

---

###  Əhatə olunan testlər | Test Coverage

- `GET`, `POST`, `PUT`, `PATCH`, `DELETE` əməliyyatları
- JSON body validasiyası
- Header və content-type yoxlaması
- Negative testlər
- Token ilə qorunan endpoint-lərin testi

---

### ▶ Necə işlətmək olar | How to Run

1. Dependentləri yükləmək üçün terminalda yaz:
   ```bash
   mvn clean install
