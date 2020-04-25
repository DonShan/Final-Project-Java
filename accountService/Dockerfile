FROM java:8
EXPOSE 6868:6868
ADD /target/accountService.jar accountService.jar
ENTRYPOINT ["java", "-jar","accountService.jar"]
