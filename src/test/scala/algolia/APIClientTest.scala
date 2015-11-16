package algolia

import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

class APIClientTest extends FunSpec with BeforeAndAfter with Matchers {

  describe("init") {

    val apiClient = new APIClient("APP_ID", "API_KEY")

    it("should set user agent") {
      apiClient.userAgent should be("Algolia Scala 2.11.7")
    }

    it("should set indexing hosts") {
      apiClient.indexingHosts should equal (Seq(
        "APP_ID-1.algolianet.com",
        "APP_ID-2.algolianet.com",
        "APP_ID-3.algolianet.com",
        "APP_ID.algolia.net"
      ))
    }

    it("should set query hosts") {
      apiClient.queryHosts should equal (Seq(
        "APP_ID-1.algolianet.com",
        "APP_ID-2.algolianet.com",
        "APP_ID-3.algolianet.com",
        "APP_ID-dsn.algolia.net"
      ))
    }

  }

}