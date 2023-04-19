ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "FIFA23",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-sql" % "3.3.2",
      "org.apache.spark" %% "spark-hive" % "3.3.2",
      "com.alibaba" % "fastjson" % "2.0.25",
      "org.apache.spark" %% "spark-mllib" % "3.3.2",
      "org.scalatra" %% "scalatra" % "2.8.4" excludeAll (
        ExclusionRule("org.scala-lang.modules", "scala-parser-combinators_2.13")
        ),
      "org.apache.spark" %% "spark-mllib" % "3.3.2" excludeAll (
        ExclusionRule("org.scala-lang.modules", "scala-parser-combinators_2.13")
        ),
      "org.apache.spark" %% "spark-catalyst" % "3.3.2" excludeAll (
        ExclusionRule("org.scala-lang.modules", "scala-parser-combinators_2.13")
        ),
      "org.scalatra" %% "scalatra-scalate" % "2.8.4",
      "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
    )
  )



