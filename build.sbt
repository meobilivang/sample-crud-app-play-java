name := "samplecrudappjava"
 
version := "1.0" 
      
lazy val `samplecrudappjava` = (project in file(".")).enablePlugins(PlayJava)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"


libraryDependencies ++= Seq(
  javaJdbc ,
  cache ,
  javaWs ,
  jdbc,
  "org.mariadb.jdbc" % "mariadb-java-client" % "1.4.4"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      