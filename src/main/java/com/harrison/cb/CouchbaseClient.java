package com.harrison.cb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;

@Service
public class CouchbaseClient {
	
	
	public List<String> doCbStuff() {
		Cluster cluster = CouchbaseCluster.create("localhost");
		Bucket bucket = cluster.openBucket("default");
		
	    // Create a JSON Document
	    JsonObject arthur = JsonObject.create()
	        .put("name", "Arthur")
	        .put("email", "kingarthur@couchbase.com")
	        .put("interests", JsonArray.from("Holy Grail", "African Swallows"));
	    
	    System.out.println(bucket.get("u:king_arthur"));

	    // Store the Document
	    bucket.upsert(JsonDocument.create("u:king_arthur", arthur));	
	    
	    // Create a JSON Document
	    JsonObject harrison = JsonObject.create()
	        .put("name", "Harrison")
	        .put("email", "kingarthur@couchbase.com")
	        .put("interests", JsonArray.from("Holy Grail", "African Swallows"));
	    
	    System.out.println(bucket.get("u:king_arthur"));

	    // Store the Document
	    bucket.upsert(JsonDocument.create("u:king_arthur", arthur));
	    bucket.upsert(JsonDocument.create("u:king_harrison", harrison));	
	    
	    
	    bucket.bucketManager().createN1qlPrimaryIndex(true, false);
	    
        // Perform a N1QL Query
        N1qlQueryResult result = bucket.query(
            N1qlQuery.parameterized(
            		"SELECT name FROM default WHERE $1 IN interests", JsonArray.from("African Swallows")
            )
        );

        List<String> results = new ArrayList<>(result.allRows().size());
        // Print each found Row
        for (N1qlQueryRow row : result) {
            results.add(row.toString());
        }
        
        N1qlQueryResult res = bucket.query(
        	N1qlQuery.simple(
        			"select meta(default).*, * from default "
        			+ "where any interest in default.interests satisfies "
        			+ "interest like 'Holy%' END")
        );
        
        for (N1qlQueryRow row : res) {
            results.add(row.toString());
        }
        
	    return results;
	}
	
}
