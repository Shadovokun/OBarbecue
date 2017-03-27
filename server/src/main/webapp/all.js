function getUserBdd(name) {
	getUserGeneric(name, "v1/user/");
}

function getUserGeneric(name, url) {
	$.getJSON(url + name, function(data) {
		afficheUser(data);
	});
}

function getForAll() {
	getSecure("v1/secure/who");
}

function getByAnnotation() {
	getSecure("v1/secure/byannotation");
}

function getSecure(url) {
	 if($("#pseudo").val() != "") {
		 console.log("#pseudo n'était pas vide");
	     $.ajax
	     ({
	       type: "GET",
	       url: url,
	       dataType: 'json',
	       beforeSend : function(req) {
	        req.setRequestHeader("Authorization", "Basic " + btoa($("#pseudo").val() + ":" + $("#password").val()));
	       },
	       success: function (data) {
	    	   console.log("success : function");
	    	   console.log(data);
	    	   $("#connexion").hide();
	    	   $("#inscription").hide();
	    	   $("#deconnexion").show();
    		   alert("Bonjour " + data.nom + " " + data.prenom);
	    	   if (data.role =="user") {
	    		   $("#panier").show();
	    		   $("#page-accueil").hide();
	               $("#page-menu").show();
	               $("#page-contact").hide();
	               $("#page-admin").hide();
	               $("#page-add").hide();
	               $("#page-connexion").hide();
	               $("#page-inscription").hide();
	               $("#page-mentions-legales").hide();
	               listProduitsBdd();
	    		   //Afficher trucs pour user et cacher le reste
	    	   } else if (data.role == "admin") {
	    		   $("#page-accueil").hide();
	               $("#page-menu").hide();
	               $("#page-contact").hide();
	               $("#page-admin").show();
	               $("#page-add").hide();
	               $("#page-connexion").hide();
	               $("#page-inscription").hide();
	               $("#page-mentions-legales").hide();
	    		 //Afficher trucs pour admin et cacher le reste
	    	   }
	        afficheUser(data);
	       },
	       error : function(jqXHR, textStatus, errorThrown) {
	       			alert('error: ' + textStatus);
	       		}
	     });
	     } else {
	     $.getJSON(url, function(data) {
	     	    afficheUser(data);
	        });
	     }
	 }

function postUserBdd(nom, prenom, mail, role, pwd, adresse, num) {
    postUserGeneric(nom, prenom, mail, role, pwd, adresse, num, 0, "v1/user/");
}

function postUserGeneric(nom, prenom, mail, role, pwd, adresse, numTel, nbrCmd, url) {
	console.log("postUserGeneric " + url)
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"nom" : nom,
			"prenom" : prenom,
			"mail" : mail,
			"role" : role,
			"mdp" : pwd,
			"adresse" : adresse,
			"numTel" : numTel,
			"nbrCmd" : nbrCmd
		}),
		success : function(data, textStatus, jqXHR) {
			alert("Vous êtes enregistré.");
			$("#page-accueil").show();
	        $("#page-menu").hide();
	        $("#page-contact").hide();
	        $("#page-admin").hide();
	        $("#page-add").hide();
	        $("#page-connexion").hide();
	        $("#page-inscription").hide();
	        $("#page-mentions-legales").hide();
	        $("#panier").hide();
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Informations manquantes");
			console.log('postUser error: ' + textStatus);
		}
	});
}

function postProduitBdd(nom, desc, prix, img, type) {
    postProduitGeneric(nom, desc, img, prix, type, "v1/produit/");
}

function postProduitGeneric(nom, desc, img, prix, type, url) {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"nom" : nom,
			"description" : desc,
			"cheminImg" : img,
			"prix" : prix,
			"type" : type
			
		}),
		success : function(data, textStatus, jqXHR) {
			afficheProduit(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postProduit error: ' + textStatus);
		}
	});
}

function afficheProduit(data) {
	console.log(data);
	$("#reponse").html(data.nom + " - " + data.description + " - " + data.prix);
}

function listUsersBdd() {
    listUsersGeneric("v1/user/");
}

function listProduitsBdd() {
    listProduitsGeneric("v1/produit/");
}

function listUsersGeneric(url) {
	$.getJSON(url, function(data) {
		afficheListUsers(data)
	});
}

function listProduitsGeneric(url) {
	$.getJSON(url, function(data) {
		afficheListProduits(data)
	});
}

function afficheUser(data) {
	console.log(data);
	$("#reponse").html(data.nom + " : <b>" + data.prenom + "</b> (" + data.mail + ")");
}

function afficheListUsers(data) {
	var html = '<ul>';
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		html = html + "<li>"+ data[index].nom + "</li>";
	}
	html = html + "</ul>";
	$("#reponse").html(html);
}


function afficheListProduits(data) {
	$('#menu-assiette').empty();
	$('#menu-emporter').empty();
	$('#menu-sandwich').empty();
	$('#menu-accompagnement').empty();
	$('#menu-boisson').empty();
	$('#menu-salade').empty();
	$('#menu-dessert').empty();
	
	var sandwich = "<h2>Sandwich</h2>";
	var accompagnement = "<h2>Accompagnement</h2>";
	var boisson = "<h2>Boissons</h2>";
	var salade = "<h2>Salades</h2>";
	var dessert = "<h2>Desserts</h2>";
	var aEmporter = "<h2>A Emporter</h2>";
	var assiette = "<h2>Sur place</h2>";
	
	for(var i = 0 ; i < data.length ; i++){
		if(data[i].type === "assiette"){
			assiette+= "<h4> Assiette </h4> <div class=\"prix\">" + data[i].prix + "</div> <p>" + data[i].description + "</p>" ;
		} if(data[i].type === "aEmporter"){
			aEmporter+= "<h4> Emporter </h4> <div class=\"prix\">" + data[i].prix + "</div> <p>" + data[i].description + "</p>" ;
		} if(data[i].type === "sandwich"){
			sandwich+= "<h4> Sandwich </h4> <div class=\"prix\">" + data[i].prix + "</div> <p>" + data[i].description + "</p>" ;
		} if(data[i].type === "accompagnement"){
			accompagnement+= "<p>" + data[i].description + "</p>" ;
		} if(data[i].type === "boisson"){
			boisson+= "<p class=\"petit-nom\">" + data[i].nom + " </p> <p class=\"petit-prix\"> " + data[i].prix + "</p>" ;
		} if(data[i].type === "salade"){
			salade+= "<h4> Salade </h4> <div class=\"prix\">" + data[i].prix + "</div> <p>" + data[i].description + "</p>" ;
		} if(data[i].type === "dessert"){
			dessert+= "<p class=\"petit-nom\">" + data[i].nom + " </p> <p class=\"petit-prix\"> " + data[i].prix + "</p>" ;
		}
	}
	

	$('#menu-assiette').append(assiette);
	$('#menu-emporter').append(aEmporter);
	$('#menu-sandwich').append(sandwich);
	$('#menu-accompagnement').append(accompagnement);
	$('#menu-boisson').append(boisson);
	$('#menu-salade').append(salade);
	$('#menu-dessert').append(dessert);
}