plugins {}

version = "0.0.1"

dependencies {
    // Kafka
    implementation("org.springframework.kafka:spring-kafka:2.8.0")

    //암복호화때문에 사용
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.+")
}
