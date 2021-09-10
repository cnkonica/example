# From java image, version : 8
FROM java:8

# 挂载test-docker目录
VOLUME /tmp

# COPY or ADD to image
COPY example-app-1.0.0-SNAPSHOT.jar example-app-1.0.0-SNAPSHOT.jar
#指定项目暴露的端口号，与项目配置一样,即容器配置的暴露端口
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "example-app-1.0.0-SNAPSHOT.jar"]
