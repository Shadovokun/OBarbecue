var listeProduits = new Array(); 
var somme = 0;
var prix = 0;

function viderListeProduits() {
	listeProduits = new Array();
}


function getUserBdd(name) {
	getUserGeneric(name, "v1/user/");
}

function getUserGeneric(name, url) {
	$.getJSON(url + name, function(data) {
		afficheUser(data);
	});
}


function getProduitBdd(name) {
	getProduitGeneric(name, "v1/produit/");
}

function getProduitGeneric(name, url) {
	$.getJSON(url + name, function(data) {
		afficherPrixProduit(data);
	});
}

function afficherPrixProduit(data) {
	somme= somme + data.prix;
	prix = data.prix;
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
					$("#page-panier").show();
					$("#page-supp").hide();
					$("#page-commandes").hide();
					listProduitsBdd();
	    		   //Afficher trucs pour user et cacher le reste
	    		} else if (data.role == "admin") {
	    			$("#commandes").show();
	    			$("#page-accueil").hide();
	    			$("#page-menu").hide();
	    			$("#page-contact").hide();
	    			$("#page-admin").hide();
	    			$("#page-add").hide();
	    			$("#page-connexion").hide();
	    			$("#page-inscription").hide();
	    			$("#page-mentions-legales").hide();
	    			$("#page-panier").hide();
	    			$("#page-supp").hide();
	    			$("#page-commandes").show();
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


function ajouterPrix(produit){
	getProduitBdd(produit);
}


function ajouterProduit(produit){
	prix = ajouterPrix(produit);
	listeProduits.push(produit);
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
			assiette+= "<div id=" + data[i].nom +" class=\"titre-menu ajoutable\">" + data[i].nom + "</div> <div class=\"prix\">" + data[i].prix + "</div> <p>" + data[i].description + "</p>" ;
		} if(data[i].type === "aEmporter"){
			aEmporter+= "<div id=" + data[i].nom +" class=\"titre-menu ajoutable\">" + data[i].nom + "</div> <div class=\"prix\">" + data[i].prix + "</div> <p>" + data[i].description + "</p>" ;
		} if(data[i].type === "sandwich"){
			sandwich+= "<div id=" + data[i].nom +" class=\"titre-menu ajoutable\"> Sandwich </div> <div class=\"prix \">" + data[i].prix + "</div> <p>" + data[i].description + "</p>" ;
		} if(data[i].type === "accompagnement"){
			accompagnement+= "<p>" + data[i].nom + "</p>" ;
		} if(data[i].type === "boisson"){
			boisson+= "<p id=" + data[i].nom +" class=\"ajoutable petit-nom\">" + data[i].nom + " </p> <p class=\"petit-prix\"> " + data[i].prix + "</p>" ;
		} if(data[i].type === "salade"){
			salade+= "<h4 id=" + data[i].nom +" class=\"ajoutable\"> Salade </h4> <div class=\"prix\">" + data[i].prix + "</div> <p>" + data[i].description + "</p>" ;
		} if(data[i].type === "dessert"){
			dessert+= "<p id=" + data[i].nom +" class=\"ajoutable petit-nom\">" + data[i].nom + " </p> <p class=\"petit-prix\"> " + data[i].prix + "</p>" ;
		}
	}
	

	$('#menu-assiette').append(assiette);
	$('#menu-emporter').append(aEmporter);
	$('#menu-sandwich').append(sandwich);
	$('#menu-accompagnement').append(accompagnement);
	$('#menu-boisson').append(boisson);
	$('#menu-salade').append(salade);
	$('#menu-dessert').append(dessert);
	
	$('.ajoutable').click(function(event) {
		alert("Produit ajouté au panier.");
		ajouterProduit(event.target.id);
		
	});
	
}

function afficherPanier(data){
	var pan = "";
	if(listeProduits.length == 0){
		$('#page-panier').html("Votre panier est vide");
	}	else {
		for(var i = 0; i < listeProduits.length ; i++){
			pan+= "<div>" + listeProduits[i].toString() + "</div>";
		}
	}
	
	pan += "<div id=\"total\"> TOTAL : " + somme + "</div>";
	
	$('#page-panier').html(pan);
}


function listProduitsBddMenuDeroulant() {
	listProduitsGenericMenuDeroulant("v1/produit/");
}

function listProduitsGenericMenuDeroulant(url) {
	$.getJSON(url, function(data) {
		afficheListProduitsMenuDeroulant(data)
	});
}

function afficheListProduitsMenuDeroulant(data) {
	var selecteur = $('#selecteurSuppMenu');

	var test;

	for(var i = 0 ; i < data.length ; i++){
		test+="<option id="+data[i].nom+"value="+data[i].nom+">"+data[i].nom+"</option>";
	}
	
	selecteur.append(test);
}

function deleteProduitBdd(nom) {
	deleteProduitGeneric("v1/produit/"+nom);
}

function deleteProduitGeneric(url) {
	$.ajax({
		type : 'DELETE',
		url : url,
		success : function(data, textStatus, jqXHR) {
			alert("produit supprimer");
			//afficheProduit(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postProduitDelete error: ' + textStatus);
		}
	});
}

function postCommentaire(mail, com, note) {
	postCommentaireGeneric(mail, com, note, "v1/Commentaire");
}

function postCommentaireGeneric(mail, com, note, url) {
	var aujd = new Date();
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"contenu" : com,
			"dat" : aujd.getDate().toString() + "/" + parseInt(aujd.getMonth()+1).toString() + "/" + aujd.getFullYear().toString(),
			"mail" : mail,
			"valide" : 1,
			"note" : parseInt(note)
		}),
		success : function(data, textStatus, jqXHR) {
			alert("Commentaire envoyé");
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postCom error: ' + textStatus);
		}
	});
}

function listCommentaire() {
	listCommentaireGeneric("v1/Commentaire/");
}

function listCommentaireGeneric(url) {
	$.getJSON(url, function(data) {
		afficheListCommentaire(data)
	});
}

function afficheListCommentaire(data) {
	var selecteur = $('#affCom');

	var test;

	for(var i = 0 ; i < data.length ; i++){
		test+="<fieldset><p> Identifiant : "+ data[i].mail +" - Note : " + data[i].prix + "</p><br/><p>" + data[i].contenu + "</p></fieldset>";
	}
	
	selecteur.append(test);
}
