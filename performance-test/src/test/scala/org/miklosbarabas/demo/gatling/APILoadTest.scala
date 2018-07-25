package org.miklosbarabas.demo.gatling

import java.util.concurrent.TimeUnit

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

import scala.concurrent.duration.FiniteDuration

class APILoadTest extends Simulation {

  val scnGetAllAccounts = scenario("GetAllAccounts")
    .repeat(500, "n") {
      //    pace(FiniteDuration.apply(1, TimeUnit.MILLISECONDS))
      exec(
        http("GetDummy-API")
          .get("http://dummyservice:8080/dummy")
          .check(status.is(200))
      )
    }

  setUp(
    scnGetAllAccounts.inject(
      constantUsersPerSec(10000).during(FiniteDuration.apply(5, TimeUnit.MINUTES)),
      constantUsersPerSec(1000).during(FiniteDuration.apply(1, TimeUnit.HOURS)),
    )
  ).throttle(
    reachRps(5000).in(FiniteDuration.apply(5, TimeUnit.MINUTES)),
    holdFor(FiniteDuration.apply(1, TimeUnit.HOURS)),
    reachRps(200).in(FiniteDuration.apply(1, TimeUnit.MINUTES)),
    holdFor(FiniteDuration.apply(1, TimeUnit.HOURS)),
  ).maxDuration(FiniteDuration.apply(1, TimeUnit.HOURS))

}