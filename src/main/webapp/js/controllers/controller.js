App.NewcourseController = Ember.ObjectController.extend({
	
	  niveles: ["Basico", "Medio", 'Avanzado'],
	  errorMsg: null,
	  actions: {
		    save: function() {
		    	console.log('Pasamos por la pagina del Controller:');
		        var mimodel = this.get('model');
		        var errorMsg = mimodel.validate();
		        var self = this;
		        if(errorMsg == null){
			        var modelJson = JSON.stringify(mimodel);
					console.log(modelJson);
					$.postJSON('/prueba-autentia/api/curso', modelJson, function(response) {
					 	console.log(response);
					 }).then(function(){
						 self.set('errorMsg', null);
						 self.transitionToRoute('course'); 
						});
					//this.set('errorMsg', null);
					//this.transitionToRoute('course');
		        } else {
		        	this.set('errorMsg', errorMsg);
		        }
		    	 
		    }

	  }
});






App.CourseController = Ember.ObjectController.extend({
	
		content: [],
	  
		  actions: {
			    find: function(param,order) {
			    	console.log('Pasamos por la pagina del Controller:' + param + ' ' + order);
			    	var data = App.Consulta.findAll(param,order);
			    	this.set('content', data);
			    	 
			    },
				gotoNewCourse: function(param,order) {

					this.transitionToRoute('newcourse');
			    } 
			  }
	  
});