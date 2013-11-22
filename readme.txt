Deploy Spring Restful Test Demo:
1.  Build WAR via "gradle build" Gradle command.  WAR file will be generated in the /target/libs/ directory.
2.  Deploy WAR to your application server.

Spring Restful URLs for demo:
1.  http://localhost:8080/ws-spring-restful-demo/service/pricingLabelCount

Test Spring Restful Demo Using Command Line CURL Client:
1.  curl -HAccept:text/xml http://localhost:8080/ws-spring-restful-demo/service/pricingLabelCount
2.  curl -HAccept:application/json http://localhost:8080/ws-spring-restful-demo/service/pricingLabelCount

Test Spring Restful Demo Using JUnit Client Manually:
1.  Deploy Spring Restful Test Demo as described above.
1.  Run JUnit Test via "gradle manualIntegrationTest" Gradle command.

Test Spring Restful Demo Using JUnit Client Dynamically:
1.  Run JUnit Test via "gradle integrationTest" Gradle command.