FROM lpicanco/java11-alpine
ADD target/bons-0.0.1-SNAPSHOT.jar /tmp/bons.jar
ENV DB_JDBC_URL=jdbc:postgresql://meinedb:5432/bondb
ENV DB_USERNAME=richard
ENV DB_PASSWORD=test123
WORKDIR /tmp
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,address=8010,server=y,suspend=n"
ENTRYPOINT ["java", "-jar", "/tmp/bons.jar"]
