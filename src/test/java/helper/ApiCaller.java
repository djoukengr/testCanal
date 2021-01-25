package helper;

import java.util.ArrayList;
import com.testcanal.pojo.*;
import org.json.*;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;


public class ApiCaller {
	private static String hostname ="localhost";
	private static String port="8080";
 public static String createSubscriber(String nom,String prenom, String address,String pays) {
	 String jsonString = "{\"nom\":\""+nom+"\",\"prenom\":\""+prenom+"\",\"adressePrincipale\":\""+address+"\",\"pays\":\""+pays+"\"}";
	 
	 HttpResponse<String> response = Unirest.post("http://"+hostname+":"+port+"/subscriber/create")
		      .header("Content-Type", "application/json")
		      .body(jsonString)
		      .asString();
	 return response.getBody();
 }
 public static String SubscribeToContract(String subscriber_id, String address) {
	 String jsonString = "{\"idSubscriber\":\""+subscriber_id+"\",\"contractAddress\":\""+address+"\"}";
	 HttpResponse<String> response = Unirest.post("http://"+hostname+":"+port+"/contract/subscription")
		      .header("Content-Type", "application/json")
		      .body(jsonString)
		      .asString();
	 return response.getBody();
	 
 }
 public static ArrayList<String[]> updateSubscriberAddress(String subscriber_id,String newAdress) {
	 //retourne une liste de String[], le tableau consitue du modification_id et du contract_id
	 ArrayList<String[]> list =  new ArrayList<String[]>();
	 String jsonString = "{\"idSubscriber\":\""+subscriber_id+"\",\"newAddress\":\""+newAdress+"\"}";
	 HttpResponse<String> response = Unirest.post("http://"+hostname+":"+port+"/subscriber/updateAddress")
		      .header("Content-Type", "application/json")
		      .body(jsonString)
		      .asString();
	 try {
		JSONArray obj = new JSONArray(response.getBody());
		for(int i=0;i<obj.length();i++) {
			 JSONObject elt = obj.getJSONObject(i);
			 String[] tab = new String[2];
			 tab[0]=elt.getString("modificationId");
			 tab[1]= elt.getString("contractId");
			 list.add(tab);
		 }
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 
	 return list;
 }
 
 public static String getContractAddress(String contract_id) {
	 HttpResponse<String> response = Unirest.get("http://"+hostname+":"+port+"/contract/getAddress?contractId="+contract_id)
		      .header("Content-Type", "application/json")
		      .asString();
	 return response.getBody();
 }
 public static ArrayList<String> getMouvementHistory(String mouvement_id) {
	 //rerourne une liste constitue dans l'ordre de 
	 ArrayList<String> list = new ArrayList<String>();
	 HttpResponse<String> response = Unirest.get("http://"+hostname+":"+port+"/history/get?modificationId="+mouvement_id)
		      .header("Content-Type", "application/json")
		      .asString();
	 try {
		JSONObject obj = new JSONObject(response.getBody());
		list.add(obj.getString("idMouvement"));
		list.add(obj.getString("idSubscriber"));
		list.add(obj.getString("idContract"));
		list.add(obj.getString("typeModification"));
		list.add(obj.getString("dateModification"));
		list.add(obj.getString("newValue"));
		list.add(obj.getString("oldValue"));
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return list;
	 
 }
}
