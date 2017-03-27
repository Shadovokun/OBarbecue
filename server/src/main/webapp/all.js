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
 if($("#userlogin").val() != "") {
     $.ajax
     ({
       type: "GET",
       url: url,
       dataType: 'json',
       beforeSend : function(req) {
        req.setRequestHeader("Authorization", "Basic " + btoa($("#userlogin").val() + ":" + $("#passwdlogin").val()));
       },
       success: function (data) {
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
			$("#page-accueil").hide();
	        $("#page-menu").hide();
	        $("#page-contact").hide();
	        $("#page-admin").hide();
	        $("#page-add").show();
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
	var code2 = "";
	var code3 = "";
	var code = "<tr>";
	for(var i = 0 ; i < data.length ; i++){
		code+="<td>"+data[i].nom+"</td>";
		code+="<td>"+data[i].description+"</td>";
		code+="<td>"+data[i].prix+"</td>";
		code+="</tr>";
	}
	
	for(var i = 0 ; i < data.length ; i++){
		if(data[i].type === "assiette"){
			code2+= "<h4> Assiette </h4> <div class=\"prix\">" + data[i].prix + "</div> <p>" + data[i].description + "</p>" ;
		} if(data[i].type === "aEmporter"){
			code3+= "<h4> Emporter </h4> <div class=\"prix\">" + data[i].prix + "</div> <p>" + data[i].description + "</p>" ;
		}
	}
	

	$('#table').append(code);
	$('#menu-assiette').append(code2);
}