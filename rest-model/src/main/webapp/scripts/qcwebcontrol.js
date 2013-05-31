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
	var jqXHR=$.ajax(aggregatBaseURL,{
		  contentType : "application/json",
		  type :"GET",
		  data : JSON.stringify([]) });
	jqXHR.done(function(data, textStatus, jqXHR){
		var jsonResponse = JSON.parse(jqXHR.responseText);
		$(jsonResponse.content).each(function(){
			for(var i=0;i<this.links.length;i++){
				if(this.links[i]['rel']=="self"){
					this.url = this.links[i]['href'];
					break;
				}
			}
			this.id = /[0-9]*$/.exec(this.url)[0];	
		}
		);
		handleAggregats(jsonResponse.content);
		});
	
	//TODO faire les page suivantes s'il y en a
};


