plugins {
	java
	id("org.springframework.boot") version "3.0.4"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n02"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_19

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.github.ravichaturvedi.exceptionhandler:exceptionhandler:0.1")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("javax.validation:validation-api:2.0.1.Final")
	implementation("org.json:json:20171018")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
