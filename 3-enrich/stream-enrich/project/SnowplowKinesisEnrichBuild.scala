/* 
 * Copyright (c) 2013-2014 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
import sbt._
import Keys._

object SnowplowStreamEnrichBuild extends Build {

  import Dependencies._
  import BuildSettings._

  // Configure prompt to show current project
  override lazy val settings = super.settings :+ {
    shellPrompt := { s => Project.extract(s).currentProject.id + " > " }
  }

  // Define our project, with basic project information and library dependencies
  lazy val project = Project("snowplow-stream-enrich", file("."))
    .settings(buildSettings: _*)
    .settings(
      libraryDependencies ++= Seq(
        Libraries.kinesisSdk,
        Libraries.dynamodbSdk,
        Libraries.s3Sdk,
        Libraries.kinesisClient,
        Libraries.kafkaClients,
        Libraries.commonsCodec,
        Libraries.config,
        Libraries.slf4j,
        Libraries.log4jOverSlf4j,
        Libraries.scopt,
        Libraries.scalazon,
        Libraries.scalaz7,
        Libraries.json4s,
        Libraries.json4sJackson,
        Libraries.snowplowRawEvent,
        Libraries.snowplowCommonEnrich,
        Libraries.igluClient,
        Libraries.snowplowTracker,
        Libraries.specs2,
        Libraries.scalacheck
      )
    )
}
