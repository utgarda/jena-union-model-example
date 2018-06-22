# jena-union-model-example
Union model usage example

##### Output

    'alignment rules loaded' 
    'alignment rules loaded' 
     >>>>>>>>>>>>>>>>>>>>> referred
    @prefix schema: <http://schema.org/> .
    @prefix :      <http://example.org/> .
    @prefix foaf:  <http://xmlns.com/foaf/0.1/> .
    
    :alice  a                  foaf:Person ;
            schema:identifier  "1" ;
            foaf:name          "Alice" .
    
    :bob    a                  foaf:Person ;
            schema:identifier  "2" ;
            foaf:name          "Bob" .
    
    
     >>>>>>>>>>>>>>>>>>>>> aligned
    <http://example.org/claire>
            a                               <http://xmlns.com/foaf/0.1/Person> ;
            <http://example.org/friend_id>  "1" ;
            <http://schema.org/identifier>  "3" ;
            <http://xmlns.com/foaf/0.1/name>
                    "Claire" .
    
    
     >>>>>>>>>>>>>>>>>>>>> union
    @prefix schema: <http://schema.org/> .
    @prefix :      <http://example.org/> .
    @prefix foaf:  <http://xmlns.com/foaf/0.1/> .
    
    :claire  a                 foaf:Person ;
            :friend_id         "1" ;
            schema:identifier  "3" ;
            foaf:name          "Claire" .
    
    :alice  a                  foaf:Person ;
            schema:identifier  "1" ;
            foaf:name          "Alice" .
    
    :bob    a                  foaf:Person ;
            schema:identifier  "2" ;
            foaf:name          "Bob" .
    
    
     >>>>>>>>>>>>>>>>>>>>> inference
    'alignment rules loaded' 
    'rule matched: ' <http://example.org/claire> ' knows ' <http://example.org/alice> 
    @prefix schema: <http://schema.org/> .
    @prefix :      <http://example.org/> .
    @prefix foaf:  <http://xmlns.com/foaf/0.1/> .
    
    :claire  a                 foaf:Person ;
            schema:identifier  "3" ;
            foaf:knows         :alice ;
            foaf:name          "Claire" .
    
    :alice  a                  foaf:Person ;
            schema:identifier  "1" ;
            foaf:name          "Alice" .
    
    :bob    a                  foaf:Person ;
            schema:identifier  "2" ;
            foaf:name          "Bob" .
