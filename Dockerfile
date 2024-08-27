FROM openjdk:17-jdk
WORKDIR /app
COPY ./build/libs/file-storage-service-0.0.1-SNAPSHOT.jar /build/libs/file-storage-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/build/libs/file-storage-service-0.0.1-SNAPSHOT.jar"]
