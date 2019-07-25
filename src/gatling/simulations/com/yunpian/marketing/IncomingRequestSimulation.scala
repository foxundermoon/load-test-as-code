package com.yunpian.marketing

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class IncomingRequestSimulation extends Simulation {

  val httpProtocol = http // 4
    .baseUrl("http://computer-database.gatling.io") // 5
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("gatling")



  val scn = scenario("IncomingRequestSimulation") // 7
    .exec(http("request_1") // 8
      .get("/")) // 9
    .pause(5) // 10

  setUp( // 11
    scn.inject(atOnceUsers(1)) // 12
  ).protocols(httpProtocol) // 13

  /**
   * curl -v -X POST -H 'Content-Type:application/json' -d '{
   * "apikey": "aa36bf0ee9823fc5089e477bb3e73591",
   * "mobile": "18765864384",
   * "name": "lb---" ,
   * "order": "ffff'$i'" ,
   * "uid":"uidddddddddddddd",
   * "wxOpenid": ""
   * }' https://testapi.yunpian.com/v1/flow/FL900bd0271bd748ea90dcfb40dacce7b1.json
   */
}