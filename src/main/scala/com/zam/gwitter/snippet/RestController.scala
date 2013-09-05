package zazzercode

import net.liftweb._
import common._
import http._
import rest._
import json._
import scala.xml._

/**
  * author : Prayag
  */
object RestController extends RestHelper {

  /*
   * Serve the URL 
   * "/api/validate"
   * add a *.xml or *.json (depending in what you have implemented) at the end of the URL 
   * eg http://localhost:8080/XXX/api/validate/call.json
   */
 serve { 
   case XmlGet("api" :: "validate" :: _, _) => <xrsi:mobile-pickup-validation-reply xsi:schemaLocation='http://www.westernunion.com/schema/xrsi ../schema/xrsi/XRSISchema.xsd' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xrsi='http://www.westernunion.com/schema/xrsi'>
    <mobile_partner>
        <id>NABILNPT</id>
        <system>
            <id>TESTTEST</id>
            <name>WU-MMT-PILOT-SVR</name>
            <version>9101</version>
            <ip_address>192.168.1.1</ip_address>
            <connector>
                <id>NABNP002</id>
            </connector>
        </system>
    </mobile_partner>
    <mobile_wallet>
        <id>MWS1</id>
    </mobile_wallet>
    <external_reference_no>2e4d9ccc-a3e4-4168-b43c-299e58c346f3</external_reference_no>
    <mobile_sender>
        <name>
            <first_name>ALOKA</first_name>
            <last_name>KOLA</last_name>
        </name>
        <address>
            <addr_line1>PARIS</addr_line1>
            <city>PARIS</city>
            <postal_code>6898</postal_code>
            <country_iso_code>FR</country_iso_code>
        </address>
    </mobile_sender>
    <mobile_receiver>
        <name>
            <first_name>PRAYAG</first_name>
            <last_name>UPADHYAY</last_name>
        </name>
        <address>
            <addr_line1>KATHMANDU</addr_line1>
            <city>KATHMANDU</city>
            <state>KATHMANDU</state>
            <postal_code>44600</postal_code>
            <country_iso_code>NP</country_iso_code>
        </address>
        <compliance_details>
            <id_documents>
                <id_document>
                    <type>NATIONAL_ID</type>
                    <data>5722</data>
                    <issue_place>NEPAL</issue_place>
                    <issue_country>
                        <iso_code>
                            <country_code>NP</country_code>
                        </iso_code>
                    </issue_country>
                </id_document>
            </id_documents>
            <country_of_residence>NP</country_of_residence>
            <purpose_of_transaction>Professional Service</purpose_of_transaction>
            <relationship_with_sender>Husband</relationship_with_sender>

        </compliance_details>
        <mobile_phone>
            <phone_number>
                <country_code>977</country_code>
                <national_number>9843533810</national_number>
            </phone_number>
            <identity>
                <type>MSISDN</type>
                <data>9843533810</data>
            </identity>
        </mobile_phone>
        <gender>M</gender>
        <date_of_birth>01/05/1988</date_of_birth>
        <occupation>PROGRAMMER</occupation>
        <queue_allowed>false</queue_allowed>
    </mobile_receiver>

    <payment_details>
        <origination>
            <principal_amount>88</principal_amount>
            <gross_amount>578</gross_amount>
            <currency_iso_code>EUR</currency_iso_code>
            <country_iso_code>FR</country_iso_code>
        </origination>
        <destination>
            <expected_payout_amount>10431</expected_payout_amount>
            <currency_iso_code>NPR</currency_iso_code>
            <country_iso_code>NP</country_iso_code>
        </destination>
    </payment_details>
    <transaction_id>1320687773513052</transaction_id>
    <money_transfer_control>
        <date>2013-07-25-04:00</date>
        <mtcn>7773513052</mtcn>
    </money_transfer_control>
    <pickup_reference_number>217808896</pickup_reference_number>
    <transaction_digest>A8177092009B7BF2C5DE1629E3D3685F2587EA60</transaction_digest>
    <status>
        <code>0</code>
        <message>LIKELY TO BE SUCCESSFUL</message>
        <reference_no>217808896</reference_no>
    </status>
</xrsi:mobile-pickup-validation-reply>
 
   case JsonGet("api" :: "validate" :: _, _) => JString("Validated") 
 }   
}
