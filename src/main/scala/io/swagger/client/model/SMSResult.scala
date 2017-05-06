/**
 * SMS Fusion API
 * This is the SMS Fusion API
 *
 * OpenAPI spec version: 1.0.0
 * Contact: support@smsfusion.com.au
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model


case class SMSResult (
  /* Unique ID for response */
  id: String,
  /* Count of queued SMS */
  success: Integer,
  /* Cost of the SMS */
  cost: Float,
  /* Total count of SMS queued */
  count: Integer,
  /* List of failed numbers */
  failure: List[String]
)