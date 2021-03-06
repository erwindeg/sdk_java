package com.bunq.sdk.model.generated.endpoint;

import com.bunq.sdk.http.ApiClient;
import com.bunq.sdk.http.BunqResponse;
import com.bunq.sdk.http.BunqResponseRaw;
import com.bunq.sdk.model.core.BunqModel;
import com.bunq.sdk.model.generated.object.Amount;
import com.bunq.sdk.model.generated.object.CardCountryPermission;
import com.bunq.sdk.model.generated.object.CardLimit;
import com.bunq.sdk.model.generated.object.CardMagStripePermission;
import com.bunq.sdk.model.generated.object.CardPinAssignment;
import com.bunq.sdk.model.generated.object.LabelMonetaryAccount;
import com.bunq.sdk.security.SecurityUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Endpoint for retrieving details for the cards the user has access to.
 */
public class Card extends BunqModel {

  /**
   * Endpoint constants.
   */
  protected static final String ENDPOINT_URL_UPDATE = "user/%s/card/%s";
  protected static final String ENDPOINT_URL_READ = "user/%s/card/%s";
  protected static final String ENDPOINT_URL_LISTING = "user/%s/card";

  /**
   * Field constants.
   */
  public static final String FIELD_PIN_CODE = "pin_code";
  public static final String FIELD_ACTIVATION_CODE = "activation_code";
  public static final String FIELD_STATUS = "status";
  public static final String FIELD_CARD_LIMIT = "card_limit";
  public static final String FIELD_LIMIT = "limit";
  public static final String FIELD_MAG_STRIPE_PERMISSION = "mag_stripe_permission";
  public static final String FIELD_COUNTRY_PERMISSION = "country_permission";
  public static final String FIELD_PIN_CODE_ASSIGNMENT = "pin_code_assignment";
  public static final String FIELD_MONETARY_ACCOUNT_ID_FALLBACK = "monetary_account_id_fallback";

  /**
   * Object type.
   */
  protected static final String OBJECT_TYPE_PUT = "CardDebit";
  protected static final String OBJECT_TYPE_GET = "CardDebit";

  /**
   * The id of the card.
   */
  @Expose
  @SerializedName("id")
  private Integer id;

  /**
   * The timestamp of the card's creation.
   */
  @Expose
  @SerializedName("created")
  private String created;

  /**
   * The timestamp of the card's last update.
   */
  @Expose
  @SerializedName("updated")
  private String updated;

  /**
   * The public UUID of the card.
   */
  @Expose
  @SerializedName("public_uuid")
  private String publicUuid;

  /**
   * The type of the card. Can be MAESTRO, MASTERCARD.
   */
  @Expose
  @SerializedName("type")
  private String type;

  /**
   * The sub-type of the card.
   */
  @Expose
  @SerializedName("sub_type")
  private String subType;

  /**
   * The second line of text on the card
   */
  @Expose
  @SerializedName("second_line")
  private String secondLine;

  /**
   * The status to set for the card. Can be ACTIVE, DEACTIVATED, LOST, STOLEN, CANCELLED, EXPIRED
   * or PIN_TRIES_EXCEEDED.
   */
  @Expose
  @SerializedName("status")
  private String status;

  /**
   * The sub-status of the card. Can be NONE or REPLACED.
   */
  @Expose
  @SerializedName("sub_status")
  private String subStatus;

  /**
   * The order status of the card. Can be CARD_UPDATE_REQUESTED, CARD_UPDATE_SENT,
   * CARD_UPDATE_ACCEPTED, ACCEPTED_FOR_PRODUCTION or DELIVERED_TO_CUSTOMER.
   */
  @Expose
  @SerializedName("order_status")
  private String orderStatus;

  /**
   * Expiry date of the card.
   */
  @Expose
  @SerializedName("expiry_date")
  private String expiryDate;

  /**
   * The user's name on the card.
   */
  @Expose
  @SerializedName("name_on_card")
  private String nameOnCard;

  /**
   * The last 4 digits of the PAN of the card.
   */
  @Expose
  @SerializedName("primary_account_number_four_digit")
  private String primaryAccountNumberFourDigit;

  /**
   * The spending limit for the cards
   */
  @Expose
  @SerializedName("card_limit")
  private Amount cardLimit;

  /**
   * DEPRECATED: The limits to define for the card, among CARD_LIMIT_CONTACTLESS, CARD_LIMIT_ATM,
   * CARD_LIMIT_DIPPING and CARD_LIMIT_POS_ICC (e.g. 25 EUR for CARD_LIMIT_CONTACTLESS)
   */
  @Expose
  @SerializedName("limit")
  private List<CardLimit> limit;

  /**
   * The countries for which to grant (temporary) permissions to use the card.
   */
  @Expose
  @SerializedName("mag_stripe_permission")
  private CardMagStripePermission magStripePermission;

  /**
   * The countries for which to grant (temporary) permissions to use the card.
   */
  @Expose
  @SerializedName("country_permission")
  private List<CardCountryPermission> countryPermission;

  /**
   * The monetary account this card was ordered on and the label user that owns the card.
   */
  @Expose
  @SerializedName("label_monetary_account_ordered")
  private LabelMonetaryAccount labelMonetaryAccountOrdered;

  /**
   * The monetary account that this card is currently linked to and the label user viewing it.
   */
  @Expose
  @SerializedName("label_monetary_account_current")
  private LabelMonetaryAccount labelMonetaryAccountCurrent;

  /**
   * Array of Types, PINs, account IDs assigned to the card.
   */
  @Expose
  @SerializedName("pin_code_assignment")
  private List<CardPinAssignment> pinCodeAssignment;

  /**
   * ID of the MA to be used as fallback for this card if insufficient balance. Fallback account
   * is removed if not supplied.
   */
  @Expose
  @SerializedName("monetary_account_id_fallback")
  private Integer monetaryAccountIdFallback;

  /**
   * The country that is domestic to the card. Defaults to country of residence of user.
   */
  @Expose
  @SerializedName("country")
  private String country;

  /**
   * The plaintext pin code. Requests require encryption to be enabled.
   */
  @Expose
  @SerializedName("pin_code_field_for_request")
  private String pinCodeFieldForRequest;

  /**
   * The activation code required to set status to ACTIVE initially. Can only set status to ACTIVE
   * using activation code when order_status is ACCEPTED_FOR_PRODUCTION and status is DEACTIVATED.
   */
  @Expose
  @SerializedName("activation_code_field_for_request")
  private String activationCodeFieldForRequest;

  /**
   * The status to set for the card. Can be ACTIVE, DEACTIVATED, LOST, STOLEN or CANCELLED, and
   * can only be set to LOST/STOLEN/CANCELLED when order status is
   * ACCEPTED_FOR_PRODUCTION/DELIVERED_TO_CUSTOMER/CARD_UPDATE_REQUESTED/CARD_UPDATE_SENT/CARD_UPDATE_ACCEPTED.
   * Can only be set to DEACTIVATED after initial activation, i.e. order_status is
   * DELIVERED_TO_CUSTOMER/CARD_UPDATE_REQUESTED/CARD_UPDATE_SENT/CARD_UPDATE_ACCEPTED. Mind that
   * all the possible choices (apart from ACTIVE and DEACTIVATED) are permanent and cannot be
   * changed after.
   */
  @Expose
  @SerializedName("status_field_for_request")
  private String statusFieldForRequest;

  /**
   * The spending limit for the card.
   */
  @Expose
  @SerializedName("card_limit_field_for_request")
  private Amount cardLimitFieldForRequest;

  /**
   * DEPRECATED: The limits to define for the card, among CARD_LIMIT_CONTACTLESS, CARD_LIMIT_ATM,
   * CARD_LIMIT_DIPPING and CARD_LIMIT_POS_ICC (e.g. 25 EUR for CARD_LIMIT_CONTACTLESS). All the
   * limits must be provided on update.
   */
  @Expose
  @SerializedName("limit_field_for_request")
  private List<CardLimit> limitFieldForRequest;

  /**
   * Whether or not it is allowed to use the mag stripe for the card.
   */
  @Expose
  @SerializedName("mag_stripe_permission_field_for_request")
  private CardMagStripePermission magStripePermissionFieldForRequest;

  /**
   * The countries for which to grant (temporary) permissions to use the card.
   */
  @Expose
  @SerializedName("country_permission_field_for_request")
  private List<CardCountryPermission> countryPermissionFieldForRequest;

  /**
   * Array of Types, PINs, account IDs assigned to the card.
   */
  @Expose
  @SerializedName("pin_code_assignment_field_for_request")
  private List<CardPinAssignment> pinCodeAssignmentFieldForRequest;

  /**
   * ID of the MA to be used as fallback for this card if insufficient balance. Fallback account
   * is removed if not supplied.
   */
  @Expose
  @SerializedName("monetary_account_id_fallback_field_for_request")
  private Integer monetaryAccountIdFallbackFieldForRequest;

  public Card() {
    this(null, null, null, null, null, null, null, null, null);
  }

  public Card(String pinCode) {
    this(pinCode, null, null, null, null, null, null, null, null);
  }

  public Card(String pinCode, String activationCode) {
    this(pinCode, activationCode, null, null, null, null, null, null, null);
  }

  public Card(String pinCode, String activationCode, String status) {
    this(pinCode, activationCode, status, null, null, null, null, null, null);
  }

  public Card(String pinCode, String activationCode, String status, Amount cardLimit) {
    this(pinCode, activationCode, status, cardLimit, null, null, null, null, null);
  }

  public Card(String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit) {
    this(pinCode, activationCode, status, cardLimit, limit, null, null, null, null);
  }

  public Card(String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit, CardMagStripePermission magStripePermission) {
    this(pinCode, activationCode, status, cardLimit, limit, magStripePermission, null, null, null);
  }

  public Card(String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit, CardMagStripePermission magStripePermission, List<CardCountryPermission> countryPermission) {
    this(pinCode, activationCode, status, cardLimit, limit, magStripePermission, countryPermission, null, null);
  }

  public Card(String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit, CardMagStripePermission magStripePermission, List<CardCountryPermission> countryPermission, List<CardPinAssignment> pinCodeAssignment) {
    this(pinCode, activationCode, status, cardLimit, limit, magStripePermission, countryPermission, pinCodeAssignment, null);
  }

  public Card(String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit, CardMagStripePermission magStripePermission, List<CardCountryPermission> countryPermission, List<CardPinAssignment> pinCodeAssignment, Integer monetaryAccountIdFallback) {
    this.pinCodeFieldForRequest = pinCode;
    this.activationCodeFieldForRequest = activationCode;
    this.statusFieldForRequest = status;
    this.cardLimitFieldForRequest = cardLimit;
    this.limitFieldForRequest = limit;
    this.magStripePermissionFieldForRequest = magStripePermission;
    this.countryPermissionFieldForRequest = countryPermission;
    this.pinCodeAssignmentFieldForRequest = pinCodeAssignment;
    this.monetaryAccountIdFallbackFieldForRequest = monetaryAccountIdFallback;
  }

  /**
   * Update the card details. Allow to change pin code, status, limits, country permissions and
   * the monetary account connected to the card. When the card has been received, it can be also
   * activated through this endpoint.
   *
   * @param pinCode                   The plaintext pin code. Requests require encryption to be enabled.
   * @param activationCode            The activation code required to set status to ACTIVE initially. Can
   *                                  only set status to ACTIVE using activation code when order_status is ACCEPTED_FOR_PRODUCTION
   *                                  and status is DEACTIVATED.
   * @param status                    The status to set for the card. Can be ACTIVE, DEACTIVATED, LOST, STOLEN or
   *                                  CANCELLED, and can only be set to LOST/STOLEN/CANCELLED when order status is
   *                                  ACCEPTED_FOR_PRODUCTION/DELIVERED_TO_CUSTOMER/CARD_UPDATE_REQUESTED/CARD_UPDATE_SENT/CARD_UPDATE_ACCEPTED.
   *                                  Can only be set to DEACTIVATED after initial activation, i.e. order_status is
   *                                  DELIVERED_TO_CUSTOMER/CARD_UPDATE_REQUESTED/CARD_UPDATE_SENT/CARD_UPDATE_ACCEPTED. Mind that
   *                                  all the possible choices (apart from ACTIVE and DEACTIVATED) are permanent and cannot be
   *                                  changed after.
   * @param cardLimit                 The spending limit for the card.
   * @param limit                     DEPRECATED: The limits to define for the card, among CARD_LIMIT_CONTACTLESS,
   *                                  CARD_LIMIT_ATM, CARD_LIMIT_DIPPING and CARD_LIMIT_POS_ICC (e.g. 25 EUR for
   *                                  CARD_LIMIT_CONTACTLESS). All the limits must be provided on update.
   * @param magStripePermission       Whether or not it is allowed to use the mag stripe for the card.
   * @param countryPermission         The countries for which to grant (temporary) permissions to use the
   *                                  card.
   * @param pinCodeAssignment         Array of Types, PINs, account IDs assigned to the card.
   * @param monetaryAccountIdFallback ID of the MA to be used as fallback for this card if
   *                                  insufficient balance. Fallback account is removed if not supplied.
   */
  public static BunqResponse<Card> update(Integer cardId, String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit, CardMagStripePermission magStripePermission, List<CardCountryPermission> countryPermission, List<CardPinAssignment> pinCodeAssignment, Integer monetaryAccountIdFallback, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(getApiContext());

    if (customHeaders == null) {
      customHeaders = new HashMap<>();
    }

    HashMap<String, Object> requestMap = new HashMap<>();
    requestMap.put(FIELD_PIN_CODE, pinCode);
    requestMap.put(FIELD_ACTIVATION_CODE, activationCode);
    requestMap.put(FIELD_STATUS, status);
    requestMap.put(FIELD_CARD_LIMIT, cardLimit);
    requestMap.put(FIELD_LIMIT, limit);
    requestMap.put(FIELD_MAG_STRIPE_PERMISSION, magStripePermission);
    requestMap.put(FIELD_COUNTRY_PERMISSION, countryPermission);
    requestMap.put(FIELD_PIN_CODE_ASSIGNMENT, pinCodeAssignment);
    requestMap.put(FIELD_MONETARY_ACCOUNT_ID_FALLBACK, monetaryAccountIdFallback);

    byte[] requestBytes = determineAllRequestByte(requestMap);
    requestBytes = SecurityUtils.encrypt(getApiContext(), requestBytes, customHeaders);
    BunqResponseRaw responseRaw = apiClient.put(String.format(ENDPOINT_URL_UPDATE, determineUserId(), cardId), requestBytes, customHeaders);

    return fromJson(Card.class, responseRaw, OBJECT_TYPE_PUT);
  }

  public static BunqResponse<Card> update(Integer cardId) {
    return update(cardId, null, null, null, null, null, null, null, null, null, null);
  }

  public static BunqResponse<Card> update(Integer cardId, String pinCode) {
    return update(cardId, pinCode, null, null, null, null, null, null, null, null, null);
  }

  public static BunqResponse<Card> update(Integer cardId, String pinCode, String activationCode) {
    return update(cardId, pinCode, activationCode, null, null, null, null, null, null, null, null);
  }

  public static BunqResponse<Card> update(Integer cardId, String pinCode, String activationCode, String status) {
    return update(cardId, pinCode, activationCode, status, null, null, null, null, null, null, null);
  }

  public static BunqResponse<Card> update(Integer cardId, String pinCode, String activationCode, String status, Amount cardLimit) {
    return update(cardId, pinCode, activationCode, status, cardLimit, null, null, null, null, null, null);
  }

  public static BunqResponse<Card> update(Integer cardId, String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit) {
    return update(cardId, pinCode, activationCode, status, cardLimit, limit, null, null, null, null, null);
  }

  public static BunqResponse<Card> update(Integer cardId, String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit, CardMagStripePermission magStripePermission) {
    return update(cardId, pinCode, activationCode, status, cardLimit, limit, magStripePermission, null, null, null, null);
  }

  public static BunqResponse<Card> update(Integer cardId, String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit, CardMagStripePermission magStripePermission, List<CardCountryPermission> countryPermission) {
    return update(cardId, pinCode, activationCode, status, cardLimit, limit, magStripePermission, countryPermission, null, null, null);
  }

  public static BunqResponse<Card> update(Integer cardId, String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit, CardMagStripePermission magStripePermission, List<CardCountryPermission> countryPermission, List<CardPinAssignment> pinCodeAssignment) {
    return update(cardId, pinCode, activationCode, status, cardLimit, limit, magStripePermission, countryPermission, pinCodeAssignment, null, null);
  }

  public static BunqResponse<Card> update(Integer cardId, String pinCode, String activationCode, String status, Amount cardLimit, List<CardLimit> limit, CardMagStripePermission magStripePermission, List<CardCountryPermission> countryPermission, List<CardPinAssignment> pinCodeAssignment, Integer monetaryAccountIdFallback) {
    return update(cardId, pinCode, activationCode, status, cardLimit, limit, magStripePermission, countryPermission, pinCodeAssignment, monetaryAccountIdFallback, null);
  }

  /**
   * Return the details of a specific card.
   */
  public static BunqResponse<Card> get(Integer cardId, Map<String, String> params, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(getApiContext());
    BunqResponseRaw responseRaw = apiClient.get(String.format(ENDPOINT_URL_READ, determineUserId(), cardId), params, customHeaders);

    return fromJson(Card.class, responseRaw, OBJECT_TYPE_GET);
  }

  public static BunqResponse<Card> get() {
    return get(null, null, null);
  }

  public static BunqResponse<Card> get(Integer cardId) {
    return get(cardId, null, null);
  }

  public static BunqResponse<Card> get(Integer cardId, Map<String, String> params) {
    return get(cardId, params, null);
  }

  /**
   * Return all the cards available to the user.
   */
  public static BunqResponse<List<Card>> list(Map<String, String> params, Map<String, String> customHeaders) {
    ApiClient apiClient = new ApiClient(getApiContext());
    BunqResponseRaw responseRaw = apiClient.get(String.format(ENDPOINT_URL_LISTING, determineUserId()), params, customHeaders);

    return fromJsonList(Card.class, responseRaw, OBJECT_TYPE_GET);
  }

  public static BunqResponse<List<Card>> list() {
    return list(null, null);
  }

  public static BunqResponse<List<Card>> list(Map<String, String> params) {
    return list(params, null);
  }

  /**
   * The id of the card.
   */
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The timestamp of the card's creation.
   */
  public String getCreated() {
    return this.created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  /**
   * The timestamp of the card's last update.
   */
  public String getUpdated() {
    return this.updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  /**
   * The public UUID of the card.
   */
  public String getPublicUuid() {
    return this.publicUuid;
  }

  public void setPublicUuid(String publicUuid) {
    this.publicUuid = publicUuid;
  }

  /**
   * The type of the card. Can be MAESTRO, MASTERCARD.
   */
  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  /**
   * The sub-type of the card.
   */
  public String getSubType() {
    return this.subType;
  }

  public void setSubType(String subType) {
    this.subType = subType;
  }

  /**
   * The second line of text on the card
   */
  public String getSecondLine() {
    return this.secondLine;
  }

  public void setSecondLine(String secondLine) {
    this.secondLine = secondLine;
  }

  /**
   * The status to set for the card. Can be ACTIVE, DEACTIVATED, LOST, STOLEN, CANCELLED, EXPIRED
   * or PIN_TRIES_EXCEEDED.
   */
  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * The sub-status of the card. Can be NONE or REPLACED.
   */
  public String getSubStatus() {
    return this.subStatus;
  }

  public void setSubStatus(String subStatus) {
    this.subStatus = subStatus;
  }

  /**
   * The order status of the card. Can be CARD_UPDATE_REQUESTED, CARD_UPDATE_SENT,
   * CARD_UPDATE_ACCEPTED, ACCEPTED_FOR_PRODUCTION or DELIVERED_TO_CUSTOMER.
   */
  public String getOrderStatus() {
    return this.orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  /**
   * Expiry date of the card.
   */
  public String getExpiryDate() {
    return this.expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  /**
   * The user's name on the card.
   */
  public String getNameOnCard() {
    return this.nameOnCard;
  }

  public void setNameOnCard(String nameOnCard) {
    this.nameOnCard = nameOnCard;
  }

  /**
   * The last 4 digits of the PAN of the card.
   */
  public String getPrimaryAccountNumberFourDigit() {
    return this.primaryAccountNumberFourDigit;
  }

  public void setPrimaryAccountNumberFourDigit(String primaryAccountNumberFourDigit) {
    this.primaryAccountNumberFourDigit = primaryAccountNumberFourDigit;
  }

  /**
   * The spending limit for the cards
   */
  public Amount getCardLimit() {
    return this.cardLimit;
  }

  public void setCardLimit(Amount cardLimit) {
    this.cardLimit = cardLimit;
  }

  /**
   * DEPRECATED: The limits to define for the card, among CARD_LIMIT_CONTACTLESS, CARD_LIMIT_ATM,
   * CARD_LIMIT_DIPPING and CARD_LIMIT_POS_ICC (e.g. 25 EUR for CARD_LIMIT_CONTACTLESS)
   */
  public List<CardLimit> getLimit() {
    return this.limit;
  }

  public void setLimit(List<CardLimit> limit) {
    this.limit = limit;
  }

  /**
   * The countries for which to grant (temporary) permissions to use the card.
   */
  public CardMagStripePermission getMagStripePermission() {
    return this.magStripePermission;
  }

  public void setMagStripePermission(CardMagStripePermission magStripePermission) {
    this.magStripePermission = magStripePermission;
  }

  /**
   * The countries for which to grant (temporary) permissions to use the card.
   */
  public List<CardCountryPermission> getCountryPermission() {
    return this.countryPermission;
  }

  public void setCountryPermission(List<CardCountryPermission> countryPermission) {
    this.countryPermission = countryPermission;
  }

  /**
   * The monetary account this card was ordered on and the label user that owns the card.
   */
  public LabelMonetaryAccount getLabelMonetaryAccountOrdered() {
    return this.labelMonetaryAccountOrdered;
  }

  public void setLabelMonetaryAccountOrdered(LabelMonetaryAccount labelMonetaryAccountOrdered) {
    this.labelMonetaryAccountOrdered = labelMonetaryAccountOrdered;
  }

  /**
   * The monetary account that this card is currently linked to and the label user viewing it.
   */
  public LabelMonetaryAccount getLabelMonetaryAccountCurrent() {
    return this.labelMonetaryAccountCurrent;
  }

  public void setLabelMonetaryAccountCurrent(LabelMonetaryAccount labelMonetaryAccountCurrent) {
    this.labelMonetaryAccountCurrent = labelMonetaryAccountCurrent;
  }

  /**
   * Array of Types, PINs, account IDs assigned to the card.
   */
  public List<CardPinAssignment> getPinCodeAssignment() {
    return this.pinCodeAssignment;
  }

  public void setPinCodeAssignment(List<CardPinAssignment> pinCodeAssignment) {
    this.pinCodeAssignment = pinCodeAssignment;
  }

  /**
   * ID of the MA to be used as fallback for this card if insufficient balance. Fallback account
   * is removed if not supplied.
   */
  public Integer getMonetaryAccountIdFallback() {
    return this.monetaryAccountIdFallback;
  }

  public void setMonetaryAccountIdFallback(Integer monetaryAccountIdFallback) {
    this.monetaryAccountIdFallback = monetaryAccountIdFallback;
  }

  /**
   * The country that is domestic to the card. Defaults to country of residence of user.
   */
  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  /**
   */
  public boolean isAllFieldNull() {
    if (this.id != null) {
      return false;
    }

    if (this.created != null) {
      return false;
    }

    if (this.updated != null) {
      return false;
    }

    if (this.publicUuid != null) {
      return false;
    }

    if (this.type != null) {
      return false;
    }

    if (this.subType != null) {
      return false;
    }

    if (this.secondLine != null) {
      return false;
    }

    if (this.status != null) {
      return false;
    }

    if (this.subStatus != null) {
      return false;
    }

    if (this.orderStatus != null) {
      return false;
    }

    if (this.expiryDate != null) {
      return false;
    }

    if (this.nameOnCard != null) {
      return false;
    }

    if (this.primaryAccountNumberFourDigit != null) {
      return false;
    }

    if (this.cardLimit != null) {
      return false;
    }

    if (this.limit != null) {
      return false;
    }

    if (this.magStripePermission != null) {
      return false;
    }

    if (this.countryPermission != null) {
      return false;
    }

    if (this.labelMonetaryAccountOrdered != null) {
      return false;
    }

    if (this.labelMonetaryAccountCurrent != null) {
      return false;
    }

    if (this.pinCodeAssignment != null) {
      return false;
    }

    if (this.monetaryAccountIdFallback != null) {
      return false;
    }

    if (this.country != null) {
      return false;
    }

    return true;
  }

  /**
   */
  public static Card fromJsonReader(JsonReader reader) {
    return fromJsonReader(Card.class, reader);
  }

}
