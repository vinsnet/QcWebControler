var messageURL = "model/message";
var aggregatBaseURL = "model/aggregat";
var aggregatEtatModerationIsNullURL = "model/aggregat/search/findByEtatModerationIsNull";



var sleep  = function (milliseconds) {
	//TODO  use setTimeout
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
};


var postMessage = function(content,doneFunction){
	var message = new Object();
	message.contenu = content;
	 
	  /* Send the data using post */
	 jqXHR=$.ajax(messageURL,{
		  contentType : "application/json",
		  type :"POST",
		  data : JSON.stringify(message) });
	 if(doneFunction){jqXHR.done(doneFunction);}	
};







var getModificationAllowed = function(){
	return JSON.parse('{"id" : 1,"shortName" : "allowed"}');
};
var getModificationRejected = function(){
	return JSON.parse('{"id" : 2,"shortName" : "rejected"}');
};


var putAggregat = function(aggregat){
	
	var url = aggregat.url;
	var links = aggregat.links;
	
	delete aggregat.url;
	delete aggregat.links;
	
	var dataSend = JSON.stringify(aggregat);
	
	aggregat.url = url;
	aggregat.links = links;
	
	var jqXHR=$.ajax(aggregatBaseURL+"/"+aggregat.id+"/",{
		  contentType : "application/json",
		  type :"PUT",
		  data : dataSend });
};

var getAggregats = function ( handleAggregats){
return getAggregatsWithParams(handleAggregats,{p : 1,l:30});
};

var getAggregatsWithParams = function ( handleAggregats,params){
	var jqXHR=$.ajax(aggregatBaseURL,{
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
				getAggregatsWithParams(handleAggregats,params);
			};
		}
		handleAggregats(jsonResponse.content,loadNextPage);
		});
	
};


