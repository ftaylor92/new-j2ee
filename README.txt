svn co --username=ftaylor92 https://svn-fmtmac.forge.cloudbees.com/new-j2ee-features/

to deploy to CloudBees:
mvn clean compile package
bees app:deploy -a new-j2ee -t tomcat8 -R java_version=1.8 target/new-j2EE.war

http://localhost:8080/new-j2EE/rest/slow?id=5&seconds=1
http://localhost:8080/new-j2EE/rest/fast?id=5&seconds=1

JSP fails because lambda must be in java 1.8
Servlet works

http//new-j2EE.fmtmac2.cloudbees.net/upload

http://new-j2EE.fmtmac2.cloudbees.net

http://new-j2EE.fmtmac2.cloudbees.net/rest/people - errors
http://new-j2EE.fmtmac2.cloudbees.net/rest/people/ee@yahoo.com - errors

http://new-j2EE.fmtmac2.cloudbees.net/rest/db - cannot use java8 -> stuff

http://new-j2EE.fmtmac2.cloudbees.net/hello
http://new-j2EE.fmtmac2.cloudbees.net/rest/hello - uses testCBDB URL
http://new-j2EE.fmtmac2.cloudbees.net/rest/sundial - Az/El values
http://localhost:8080/full-j2EE/rest/sundial
http://new-j2EE.fmtmac2.cloudbees.net/rest/httpcache?url=<encodedUrl>
http://localhost:8080/full-j2EE/HttpCache.jsp

# = Not valid in fmtmac2 account

/db.jsp - uses jdbc URL
#/cbdb.jsp - uses testCBDB URL and JSF

/upload-form.jsp - file upload to /var/lib/tomcat7/webapps/full-j2EE/tmp/, which is relative to tomcat and unk if supported by cloudBees

#bees app:bind -db fmt-test -a new-j2EE -as testCBDB

#To deploy WAR directly (or just check in code and wait (if build-automatically on check-in is set in cloudBees repository)
#mvn clean compile package
#bees app:deploy target/full-j2EE.war -a fmtmac/new-j2EE

in META-INF/context.xml -> (see name, url, username, password

for fmtmac2 cloudbees account:
http://new-j2EE.fmtmac2.cloudbees.net
mvn clean compile package
#fails: bees app:deploy target/full-j2EE.war - fmtmac2/new-j2EE
goto: cloudbees site, then hit Apps, new-j2EE, upload WAR file, select target/full-j2EE.war
