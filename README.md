# exampleSpringDataJpa

### **1. Description**
* **Spring Data JPA**를 사용하여 간단한 CRUD 메서드를 구현한 프로젝트 


### **2. Environment**
* **IDE**
  + Intellij IDEA
* **Database**
  + MySQL
* **Server**
  + Tomcat
  
  
### **3. Packages & Class**
* **controller package**
  + ProductService의 객체를 사용하여 사용자 요청(request)을 처리하는 Class
  + **ProductController**
* **entity package**
  + Entity 정보를 저장하는 Class
  + **Product**
* **repository package**
  + Spring Data JPA를 사용하여 CRUD 기능을 구현한 Class
  + **ProductRepository**
* **service package**
  + ProductRepository의 객체를 사용하는 Service Class
  + **ProductService**
* **ExampleSpringDataJpaApplication Class**
  + 애플리케이션이 시작(run)되는 Class
  + **@SpringBootApplication**


### **4. 주요 Files**
* **pom.xml**
  + 프로젝트 기본 정보 및 Dependency 관리
  + 사용한 Dependency
    - lombok
    - spring-boot-configuration-processor
    - spring-boot-starter-thymeleaf
    - spring-boot-starter-web
    - spring-boot-starter-devtools
    - spring-boot-starter-data-jpa
    - mysql-connector-java
* **Templates**
  + **Thymeleaf**를 사용한 웹 페이지
  + **index.html**: 애플리케이션 실행 시 나타나는 메인 페이지
  + **edit_product.html**: 기존 product 정보를 수정하는 페이지
  + **new_product.html**: 새로운 product 정보를 작성하는 페이지
* **application.properties**
  + 애플리케이션 속성(Property) 정보를 작성하는 파일
    - **Data Source, JPA & Hibernate, Logging** 관련 설정
* **data.sql**
  + 테이블에 저장될 데이터 파일
* **schema1.sql**
  + 테이블 관련 정보
  + Hibernate를 사용하여 테이블 스키마를 자동 생성하기 때문에 없어도 무관(파일명은 schema.sql이면 안됨)
  + Hibernate를 사용하지 않는 경우 파일명을 schema.sql로 수정하면, 애플리케이션 실행 시 파일을 기반으로 테이블 생성
