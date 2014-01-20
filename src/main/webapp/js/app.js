window.App = Ember.Application.create({
    LOG_STACKTRACE_ON_DEPRECATION : true,
    LOG_BINDINGS                  : true,
    LOG_TRANSITIONS               : true,
    LOG_TRANSITIONS_INTERNAL      : true,
    LOG_VIEW_LOOKUPS              : true,
    LOG_ACTIVE_GENERATION         : true,
    ready: function() {
        console.log("Ember.TEMPLATES: ", Ember.TEMPLATES);
      }
});


var homeTemplate = Ember.Handlebars.precompile('<a href="#" {{action "selectPage" orden}}>Titulo</a>');
Ember.TEMPLATES['components/order-data'] = Ember.Handlebars.template(homeTemplate);


Ember.Handlebars.helper('enlace', function(value, options) {
	  var escaped = Handlebars.Utils.escapeExpression(value);
	  return escaped;
});


