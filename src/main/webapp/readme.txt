/Users/vincenttuan/Documents/apache-tomee-webprofile-8.0.0/conf/tomee.xml

<?xml version="1.0" encoding="UTF-8"?>
<tomee>
  <Resource id="demo_datasource" type="DataSource">
        JdbcDriver org.apache.derby.jdbc.ClientDriver
        JdbcUrl jdbc:derby://localhost:1527/sample
        UserName app
        Password app
  </Resource>
</tomee>
