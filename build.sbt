
name := "ILoS"
description := "ILoS using Dotty"
version := "0.1.0"

scalaVersion := "2.13.2"//"0.24.0-RC1"

libraryDependencies ++= Seq(
    //  "io.netty" % "netty-all" % "5.0.0.Alpha2",
    "org.slf4j" % "slf4j-api" % "1.7.25",
    "ch.qos.logback" % "logback-classic" % "1.2.3",


    "mysql" % "mysql-connector-java" % "8.0.17",
    // "org.scalikejdbc" %% "scalikejdbc"       % "3.3.0",
    // "org.apache.logging.log4j" % "log4j-core" % "2.8.2",
    // "org.apache.logging.log4j" % "log4j-api" % "2.8.2",
    "com.corundumstudio.socketio" % "netty-socketio" % "1.7.17",
    //"org.playframework.anorm" %% "anorm" % "2.6.2",
    "io.getquill" %% "quill-jdbc" % "3.5.1"
  // ( "io.getquill" %% "quill-jdbc" % "3.5.1").withDottyCompat(scalaVersion.value)
)


//
//lazy val root = project
//        .in(file("."))
//        .settings(
//            name := "ILoS",
//            description := "ILoS using Dotty",
//            version := "0.1.0",
//
//            scalaVersion :="2.13.1",// "0.23.0-RC1",
//            libraryDependencies ++= Seq(
//                //  "io.netty" % "netty-all" % "5.0.0.Alpha2",
//                // "com.typesafe.play" %% "anorm" % "2.6.2",
//                "org.slf4j" % "slf4j-api" % "1.7.25",
//                "ch.qos.logback" % "logback-classic" % "1.2.3",
//
//
//                "mysql" % "mysql-connector-java" % "5.1.41",
//               // "org.scalikejdbc" %% "scalikejdbc"       % "3.3.0",
//                // "org.apache.logging.log4j" % "log4j-core" % "2.8.2",
//                // "org.apache.logging.log4j" % "log4j-api" % "2.8.2",
//                "com.corundumstudio.socketio" % "netty-socketio" % "1.7.17",
//                //"org.playframework.anorm" %% "anorm" % "2.6.2",
//                "io.getquill" %% "quill-async" % "3.5.1"
//            )
//
//        )
