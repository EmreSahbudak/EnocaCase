### Proje Yapım Aşamaları
***
#### Boş bir projede Spring ve diğer bağımlılıkları eklemek.
- SpringDataJpa
```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```
- SpringWeb
```
implementation 'org.springframework.boot:spring-boot-starter-web'
```
- PostgreSQL Driver
```
runtimeOnly 'org.postgresql:postgresql'
```
- Validation
```
implementation 'org.springframework.boot:spring-boot-starter-validation'
```
- Lombok
```
compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok'
```
- Mapstruct
```
implementation group: 'org.mapstruct', name: 'mapstruct', version: '1.5.3.Final'
annotationProcessor group: 'org.mapstruct', name: 'mapstruct-processor', version: '1.5.3.Final'
```
- Swagger
```
implementation group: 'org.springdoc', name: 'springdoc-openapi-ui', version: '1.6.15'
```
bağımlılıkları projeye eklenmiştir.
#### Bağımlılık işlemlerinden sonra yapılandırma dosyası içim application.yml dosyası hazırlanmıştır.
```
server:
  port: 9090
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/enocasoru6
    username: postgres
    password: 1234bilgeADAM
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```
#### Katmanlı mimari
Katmanlı mimariye uygun olarak entity,repository,service, controller ve diğer yardımcı katmanlar oluşturulmuştur.\
#### ServiceManager
Singleton Design Pattern yaklaşımıyla Utility paketi altında kalıplaşmış metotlar ServiceManager sınıfında yazılmıştır. Tüm Service katmanlarında extend edilip kullanılabilir.\
Utility paketi altında ServiceManager sınıfında kalıplaşmış (save,findall) metotlar SingletonDesign Pattern yaklaşımıyla yazılmıştır. Tüm service katmanlarında extend edilip kullanılabilir.\
#### Save metodu
Save metodu için SaveEmployeeRequestDto ve SaveCompanyRequestDto classları kuruldu. \
Dto'dan Entity sınıfına dönüşüm için mapper katmanlarında mapstruct metotları yazıldı.\
Aralarında ki ilişki ortak bir entity tablosunda tutulduğu için çalışan kaydı yapılırken aynı zamanda ara tabloyada kaydolması gerekir.\
Bunun için ara tablonun service katmanında da save metodu yazıldı ve employeeService katmanına enjekte edildi. Bu sayede çalışan kaydedilirken ara tabloyada bu bilgiler kaydolucak.\
#### FindAll metodu
ServiceManager'a yazdığımız repository.findAll() metodu entity sınıflarının service katmanlarında extend edilip kullanılmıştır. Bu metot sayesinde listeleme işlemi yapılmıştır.
#### Delete metodu
Delete işlemi içinde ServiceManager'da yazdığımız deleteById metodu kullanılarak silme işlemi yapılmıştır.\
Çalışan silindiği takdirde ara tablodanda o verisinin silinmesi gerekir. Bunun için ara tablosunun repository katmanında employeeId ile o çalışanın verisi çekilip ara tablodanda silinmiştir.\
Benzer şekilde Şirket silindiğinde de ara tabloda ki verilerin silinmesi gerekir. Bunun içinde ara tablonun repository katmanında componyId ile şirketin verisi çekilip tüm çalışanlar forEach döngüsünün içinde silinmiştir.
























