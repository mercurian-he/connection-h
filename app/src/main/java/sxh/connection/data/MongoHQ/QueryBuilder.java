package sxh.connection.data.MongoHQ;

import sxh.connection.data.MyContact;

public class QueryBuilder {
	
	public String getDatabaseName() {
		return "hci_connection";
	}

	public String getApiKey() {
		return "gaxTO-7B0dmSkEV3wtNsqFWGB1jVjnhi";
	}
	
	/**
	 * This constructs the URL that allows you to manage your database, 
	 * collections and documents
	 * @return
	 */
	public String getBaseUrl()
	{
		return "https://api.mongolab.com/api/1/databases/"+getDatabaseName()+"/collections/";
	}
	
	/**
	 * Completes the formating of your URL and adds your API key at the end
	 * @return
	 */
	public String docApiKeyUrl()
	{
		return "?apiKey="+getApiKey();
	}
	
	/**
	 * Returns the docs101 collection
	 * @return
	 */
	public String documentRequest()
	{
		return "docs101";
	}
	
	/**
	 * Builds a complete URL using the methods specified above
	 * @return
	 */
	public String buildContactsSaveURL()
	{
		return getBaseUrl()+documentRequest()+docApiKeyUrl();
	}
	
	/**
	 * Formats the contact details for MongoHQ Posting
	 * @param contact: Details of the person 
	 * @return
	 */
	public String createContact(MyContact contact)
	{
		return String
		.format("{\"document\"  : {\"first_name\": \"%s\", "
				+ "\"last_name\": \"%s\", \"email\": \"%s\", "
				+ "\"phone\": \"%s\"}, \"safe\" : true}",
				contact.first_name, contact.last_name, contact.email, contact.phone);
	}
	
	

}
