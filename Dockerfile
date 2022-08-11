FROM tomcat:9.0-jre11

RUN rm -rf /usr/local/tomcat/webapps/ROOT

ADD build/libs/ROOT.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
