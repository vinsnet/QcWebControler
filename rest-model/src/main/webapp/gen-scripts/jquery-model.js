
var aggregatURL = "model/aggregat";

var messageURL = "model/message";







var getModerationAllowed = function(){
	return JSON.parse('{"id" : 1,"shortName" : "allowed"}');
};
	

var getModerationRejected = function(){
	return JSON.parse('{"id" : 2,"shortName" : "rejected"}');
};
	





	//POST Aggregat
	var createAggregat = function(content,doneFunction){
		genericPostPut(aggregatURL,'POST',JSON.stringify(content),doneFunction);
	};

	//PUT Aggregat
	var updateAggregat = function(content,doneFunction){
		genericPostPut(aggregatURL+"/"+content.id+"/",'PUT',serializeRestContent(content),doneFunction);
	};

	//GET  Aggregat
	var getAllAggregats = function ( handleRestObjects){
		genericGet(aggregatURL,handleRestObjects);
	};

	var getAggregat = function (id, doneFunction){
		error('not yet done');
	};


	//POST Message
	var createMessage = function(content,doneFunction){
		genericPostPut(messageURL,'POST',JSON.stringify(content),doneFunction);
	};

	//PUT Message
	var updateMessage = function(content,doneFunction){
		genericPostPut(messageURL+"/"+content.id+"/",'PUT',serializeRestContent(content),doneFunction);
	};

	//GET  Message
	var getAllMessages = function ( handleRestObjects){
		genericGet(messageURL,handleRestObjects);
	};

	var getMessage = function (id, doneFunction){
		error('not yet done');
	};




var serializeRestContent= function(restObject){
	var url = restObject.url;
	var links = restObject.links;
	
	delete restObject.url;
	delete restObject.links;
	
	var serializedContent = JSON.stringify(restObject);

	restObject.url = url;
	restObject.links = links;
	return serializedContent;

};

var genericPostPut= function(url,method,serializedContent,doneFunction){
	 
	  /* Send the data using post */
	 jqXHR=$.ajax(url,{
		  contentType : "application/json",
		  type : method,
		  data : serializedContent });
	 if(doneFunction){jqXHR.done(doneFunction);}	
};

var genericGet = function (url, handleRestObjects){
	return genericGetWithParams(url,handleRestObjects,{p : 1,l:30});
};

var genericGetWithParams = function (url, handleRestObjects,params){
	var jqXHR=$.ajax(url,{
		  contentType : "application/json",
		  type :"GET",
		  data : params });
	jqXHR.done(function(data, textStatus, jqXHR){

		var pageLinks= [];
		var loadNextPage = null;
		var jsonResponse = JSON.parse(jqXHR.responseText);
		for(var i=0;i<jsonResponse.links.length;i++){
			pageLinks[jsonResponse.links[i]['rel']]=jsonResponse.links[i]['href'];
		}
		$(jsonResponse.content).each(function(){
			var links=[];
			for(var i=0;i<this.links.length;i++){
				links[this.links[i]['rel']]=this.links[i]['href'];
			}
			this.url = links["self"];
			this.id = /[0-9]*$/.exec(this.url)[0];	
		});

		if(pageLinks["page.next"]){
			loadNextPage=function(){
				params.p+=1;
				genericGetWithParams(url,handleRestObjects,params);
			};
		}
		handleRestObjects(jsonResponse.content,loadNextPage);
		});
	
};








