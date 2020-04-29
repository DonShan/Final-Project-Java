FROM java : 8
EXPOSE 6868:6868
ADD /target/account-service.jar account-service.jar
ENTRYPOINT ["java", "-jar","account-service.jar"]
