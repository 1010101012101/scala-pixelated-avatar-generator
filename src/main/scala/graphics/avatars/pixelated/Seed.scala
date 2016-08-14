package graphics.avatars.pixelated;

import com.roundeights.hasher.Implicits._
import scala.language.postfixOps

/**
  * A 32 digit hexcidecimal md5 hash of a String value.
  */
case class Md5Hash(val hash: String)

/**
 * A Seed value used for generating Avatars.
 */
case class Seed private (val seedHash: Md5Hash) {
  /**
   * Generates a Seed from the given String value.
   */
  def this(seedString: String) = {
    this(Seed.hashSeedString(seedString))
  }
}

object Seed {
  /**
   * Generates a md5 hash from the given seed String.
   */
  def hashSeedString(seedString: String) : Md5Hash = {
    Md5Hash(seedString.md5)
  }
}
