#!/bin/sh
echo
echo
echo CLEANING CODE WITH MVN Clean 
echo
echo
mvn clean
echo
echo
echo STOPPING TOMCAT SERVICE 
echo
echo
service tomcat stop
echo
echo
echo REMOVING LOG FILE AT /mnt/tomcat6/logs/hits_UI.log
echo
echo
rm -rf /mnt/tomcat6/logs/hits_UI.log
echo
echo
echo REMOVING PUBLISH FOLDER AT /mnt/tomcat6/webapps/HITS-UI/
echo
echo
rm -rf /mnt/tomcat6/webapps/HITS-UI/
echo
echo
echo REMOVING WAR FOLDER AT /mnt/tomcat6/webapps/HITS-UI.war
echo
echo
rm -rf /mnt/tomcat6/webapps/HITS-UI.war
echo
echo
echo UPDATING CODEBASE WITH SVN UP
echo
echo
svn up
echo
echo
echo BUILDING CODEBASE WITH MVN INSTALL
echo
echo
mvn install
echo
echo
echo STARTING TOMCAT SERVICE
echo
echo
service tomcat start
echo
echo
