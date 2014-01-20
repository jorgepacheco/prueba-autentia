App.Router.map(function() {
  this.route("index", { path: "/" });
  this.route("course", { path: "/course" });
  this.route("newcourse", { path: "/newcourse" });
});


App.CourseRoute = Ember.Route.extend({  
	model: function() {
		return App.Consulta.findAll(1,'asc');
	}
});


App.NewcourseRoute = Ember.Route.extend({
  
	  setupController: function(controller, model) {
		var nuevoCurso = App.Curso.create();
		controller.set('content', nuevoCurso);
		controller.set('errorMsg', null);
	 }
});
