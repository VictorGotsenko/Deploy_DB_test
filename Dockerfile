FROM gradle:8.5-jdk21

WORKDIR /app

COPY /app .

RUN ./gradlew --no-daemon build

CMD java -jar build/libs/Deploy_DB_test-1.0-SNAPSHOT-all.jar
