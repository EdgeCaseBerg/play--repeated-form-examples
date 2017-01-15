import java.util.UUID

/** Package for the example models
 */
package object models {
	type UUID = java.util.UUID

	def randomUUID() = UUID.randomUUID()
}