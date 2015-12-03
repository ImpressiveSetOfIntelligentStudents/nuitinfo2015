FROM tomcat:7.0
MAINTAINER Benoît Sauvère <benoit.sauvere@gmail.com>

WORKDIR /usr/local/tomcat/webapps

RUN rm -rf ROOT
RUN wget https://s3-eu-west-1.amazonaws.com/com.celcatea.roomfinder.releases/CelcaTea-RoomFinder-2105-06-25-22-50.war -O ROOT.war

WORKDIR /usr/local/tomcat/bin

RUN chmod +x setenv.sh

EXPOSE 8080