#!/bin/sh  
#defined   
echo "/data/apache-tomcat-9.0.39/bin"
cd /data/apache-tomcat-9.0.39/bin  
./shutdown.sh
echo "remover war file"  
cd /data/apache-tomcat-9.0.39/webapps
rm -rf pubcen.war 
rm -rf pubcen
echo "copy war to webapps"
cp /data/pubcen/warfile/product/pubcen-web.war /data/apache-tomcat-9.0.39/webapps/pubcen.war 
echo "start tomcat" 
cd /data/apache-tomcat-9.0.39/bin  
./startup.sh




