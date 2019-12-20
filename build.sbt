name := "ILoS"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
    //  "io.netty" % "netty-all" % "5.0.0.Alpha2",
    // "com.typesafe.play" %% "anorm" % "2.6.2",
    "org.slf4j" % "slf4j-api" % "1.7.25",
    "ch.qos.logback" % "logback-classic" % "1.2.3",


    "mysql" % "mysql-connector-java" % "5.1.41",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.2.2",
    "org.scalikejdbc" %% "scalikejdbc"       % "3.3.0",
    // "org.apache.logging.log4j" % "log4j-core" % "2.8.2",
    // "org.apache.logging.log4j" % "log4j-api" % "2.8.2",
    "com.corundumstudio.socketio" % "netty-socketio" % "1.7.17",
    "org.playframework.anorm" %% "anorm" % "2.6.2"
)
