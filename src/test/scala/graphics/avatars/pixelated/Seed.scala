import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalatest._

import graphics.avatars.pixelated._

class SeedSpec extends FlatSpec with Matchers {

  "Seed" should "be able to be generated from a string" in {
    val seedString = "Hello"
    val seed = new Seed(seedString)
    seed.seedString should be (seedString)
    seed.seedHash should be (Md5Hash("8b1a9953c4611296a827abf8c47804d7"))
  }

}

class SeedCheck extends Properties("Seed") {

  property("retains seed string") = forAll {(s: String) =>
    val seed = new Seed(s)
    seed.seedString == s
  }

}

object Md5HashCheck extends Properties("Md5Hash") {

  def onlyContains (string: String, chars: List[Char]) = {
    string.filter(c => ! chars.contains(c)).length() == 0
  }

  property("32 characters") = forAll { (s: String) =>
    val seed = new Seed(s)
    seed.seedHash.hash.length() == 32
  }

  property("lowercase hexadecimal") = forAll { (s: String) =>
    val seed = new Seed(s)
    val hashString = seed.seedHash.hash
    val hexadecimalChars = List('0', '1', '2', '3', '4', '5', '6', '7', '8',
      '9', 'a', 'b', 'c', 'd', 'e', 'f')
    onlyContains(hashString, hexadecimalChars)
  }

}
