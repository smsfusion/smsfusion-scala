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

package io.swagger.client.api

import io.swagger.client.model.HLRError
import io.swagger.client.model.OutOfCredit
import io.swagger.client.model.SMSResult
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class SMSApi(val defBasePath: String = "https://api.smsfusion.com.au/",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  /**
   * Send an SMS
   * Send one or more SMS
   * @param key API Key as generated from the &lt;a href&#x3D;&#39;https://www.smsfusion.com.au/admin/api/&#39;&gt;admin panel&lt;/a&gt; 
   * @param num Comma separated list of phone numbers or &lt;a href&#x3D;&#39;https://www.smsfusion.com.au/help/msisdn/&#39;&gt;MSDISDN&lt;/a&gt;&#39;s 
   * @param msg Message content to send 
   * @param from MSISDN or vanity alphanumeric source number (optional)
   * @param deliverby UTC encoded time to send the SMS (optional)
   * @param dlrcb HTTP or HTTPS callback URL for delivery reports. Timeout for callbacks is set to 30 seconds (optional)
   * @param replycb HTTP or HTTPS callback URL for replies. Timeout for callbacks is set to 30 seconds (optional)
   * @param replyemail Email address to send replies to (optional)
   * @param validity Time in minutes to keep the SMS valid for (optional)
   * @param cc 2 character country code &lt;a href&#x3D;&#39;https://en.wikipedia.org/wiki/ISO_3166-2&#39;&gt;ISO 3166-2&lt;/a&gt; for formatting local numbers internationally (optional)
   * @return SMSResult
   */
  def sendSMS(key: String, num: List[String], msg: String, from: Option[String] = None, deliverby: Option[String] = None, dlrcb: Option[String] = None, replycb: Option[String] = None, replyemail: Option[String] = None, validity: Option[Integer] = None, cc: Option[String] = None): Option[SMSResult] = {
    // create path and map variables
    val path = "/sms/".replaceAll("\\{format\\}", "json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if (key == null) throw new Exception("Missing required parameter 'key' when calling SMSApi->sendSMS")

    if (num == null) throw new Exception("Missing required parameter 'num' when calling SMSApi->sendSMS")

    if (msg == null) throw new Exception("Missing required parameter 'msg' when calling SMSApi->sendSMS")

    queryParams += "key" -> key.toString
    queryParams += "num" -> num.toString
    queryParams += "msg" -> msg.toString
    from.map(paramVal => queryParams += "from" -> paramVal.toString)
    deliverby.map(paramVal => queryParams += "deliverby" -> paramVal.toString)
    dlrcb.map(paramVal => queryParams += "dlrcb" -> paramVal.toString)
    replycb.map(paramVal => queryParams += "replycb" -> paramVal.toString)
    replyemail.map(paramVal => queryParams += "replyemail" -> paramVal.toString)
    validity.map(paramVal => queryParams += "validity" -> paramVal.toString)
    cc.map(paramVal => queryParams += "cc" -> paramVal.toString)
    

    var postBody: AnyRef = null

    if (contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart
      postBody = mp
    } else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(apiInvoker.deserialize(s, "", classOf[SMSResult]).asInstanceOf[SMSResult])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

}