FROM tomcat:9.0-jre11

ADD build/libs/unyleya.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
