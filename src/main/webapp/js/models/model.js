App.profesores = Ember.ArrayProxy.create({
    content: [],

    load: function(){
		  
  		  	var that = this;
			var eventos = [];
			$.getJSON('/prueba-autentia/api/profesor' , 					
				function(data){    
				 	that.set("content", []);
			      	data.forEach( function (evento) {
			      		that.pushObject(Ember.Object.create(evento));
				});	
				
			});	
		 	  
		  
	  }
    	
    	
    	
});

App.profesores.load();

App.Consulta = Ember.Object.extend({

});

App.Curso = Ember.Object.extend({
	activo: false,
	titulo: null,
	nivel: null,
	horas: 0,
	profesor: {
		id:0,
		nombre: null
	},
	fileUpload: null,
	fileName: null,
    validate: function(){
    	if(this.titulo == null || this.titulo == '')
    		return "Debe rellenar el campo titulo";
    	else if (this.profesor == null)
    		return "Debe seleccionar un Autor";
    	else
    		return null;
    }
	
});


App.Consulta.reopenClass({
	  findAll: function(page, order) {
			var result = Ember.ObjectProxy.create({content: []});
			var data = [];
			$.getJSON('/prueba-autentia/api/curso?page=' + page + '&order=' + order , 
					function(resultado){      	
						data = resultado;
				
					}).then(function(){
						result.set('content', data);  
					});	
	 	  return result;
	  }

	});