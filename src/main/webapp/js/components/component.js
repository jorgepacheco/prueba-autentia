App.OrderDataComponent = Ember.Component.extend({
	
	tagName: 'span',
	orden: function(){
		
		var orden = this.get('ordenp');
		if(orden === 'undefined'){
			 return '';
		} else if(orden == 'asc'){
			return 'desc';
		} else {
			return 'asc';
		}
		
	}.property('ordenp'),
	
	  actions: {
		  selectPage: function(param) {
			  this.sendAction('action',1,param);
		  }
	  }
});

App.PaginaDataComponent = Ember.Component.extend({

	  template: Ember.Handlebars.compile('pagination.hbs'),
	  init: function(){
		    this._super();
		   
	  },
	  tagName: 'div',
	  classNameBindings: ['isDone'],

	  actions: {
		  selectPage: function(param, order) {
			  this.sendAction('action',param,order);
		  }
	  },
	  paginas: function(){
		  
		  var pagination = this.get('paginationparam');
		  console.log(pagination);
		  if(pagination === undefined){
			  return [];
		  }
		  var numero_paginas = Math.ceil(pagination.total / pagination.page);
		  
		  var collection = Ember.A();
		  for (var i=1; i <= numero_paginas; i++){
			  collection.pushObject(Ember.Object.create({number: i  , orden: pagination.order, activo:(i == pagination.numberPage)}));  
		  }
	      return collection;		  
		  
	  }.property('paginationparam'),
	  
	  prevPage: (function() {
		    var page = this.get('paginationparam.numberPage');
		    var totalPages = this.get('paginationparam.page');
		    
		    if(page > 1 && totalPages > 1) {
		      return page - 1;
		    } else {
		      return null;
		    }
		  }).property('paginationparam.page', 'paginationparam.total'),
		  
	  nextPage: (function() {
			    var page = this.get('paginationparam.numberPage');
			    var totalPages =  this.get('totalPages');
			    if(page < totalPages && totalPages > 1) {
			      return page + 1;
			    } else {
			      return null;
			    }
		}).property('paginationparam.numberPage','totalPages'),
		
		first: (function() {
		    var numero_pagina = this.get('paginationparam.numberPage');
		    if(numero_pagina ==  1) {
		      return true;
		    } else {
		      return false;
		    }
		  }).property('paginationparam.numberPage'),
		
		  last: (function() {
			    var numero_pagina = this.get('paginationparam.numberPage');
			    var totalPages =  this.get('totalPages');			    
			    if(totalPages ==  numero_pagina) {
			      return true;
			    } else {
			      return false;
			    }
			  }).property('paginationparam.numberPage','totalPages'),
			  
			totalPages:(function() {
			    var pageMax = this.get('paginationparam.page');
			    var  total = this.get('paginationparam.total');
			    
			    var totalPages = Math.ceil(total / pageMax);
			    return totalPages;
			    
			  }).property('paginationparam.page','paginationparam.total')

	});


App.NumberField = Ember.TextField.extend({
	  type: 'number',
	  attributeBindings: ['min', 'max', 'step']
	});


App.UploadFileView = Ember.TextField.extend({
    type: 'file',
    attributeBindings: ['name'],
    classNames: ['filestyle'],
    attributeBindings: ['customHref:data-classInput'],
    customHref: "input-small",    
    change: function(evt) {
      var self = this;
      var input = evt.target;
      if (input.files && input.files[0]) {
        var reader = new FileReader();
        var that = this;
        reader.onload = function(e) {
          var fileToUpload = e.srcElement.result;
          var controller = self.get('controller');
          controller.get('content').fileUpload = fileToUpload;
          controller.get('content').fileName = input.files[0].name;
        };
        reader.readAsDataURL(input.files[0]);
      }

    }
});


App.EnlaceItemComponent = Ember.Component.extend({
	  tagName: 'a',
	  attributeBindings: ['customHref:href'],
	 // classNames: ['btn', 'btn-primary'],
	  customHref: (function() {
		    var id = this.get('enlaceid');
		    return "/prueba-autentia/api/download.html?id=" + id;
		  }).property('enlaceid'),
	  
	  
});