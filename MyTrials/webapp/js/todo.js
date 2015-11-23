angular.module('todoApp', ['ngRoute'])
	.config(['$routeProvider',
		function($routeProvider) {
			$routeProvider.
			  when('/trials', {
				templateUrl: 'html/knockoutJsTrials.html'
			  }).
			  when('/phones/:phoneId', {
				templateUrl: 'partials/phone-detail.html',
				controller: 'PhoneDetailCtrl'
			  }).
			  otherwise({
				redirectTo: '/trials'
			  });
		}
	])
	.controller('TodoListController', ['$scope', '$http', 'archive', function($scope, $http, archive) {
		var todoList = this;		
		$http.get('data/tasks.json')
			.success(function(data) {
				todoList.todos = data.tasks;				
			})
			.error(function() {
				console.log('Failure');
			});

		todoList.addTodo = function() {
			todoList.todos.push({text:todoList.todoText, done:false});
			todoList.todoText = '';
		};

		todoList.remaining = function() {
			var count = 0;
			angular.forEach(todoList.todos, function(todo) {
				count += todo.done ? 0 : 1;
			});
			return count;
		};

		todoList.archive = function() {	
			todoList.todos = archive(todoList.todos);
		};

		todoList.todoType = 'all';
	}])
	.factory('archive', function() {	
		return function(todos) {			
			angular.forEach(todos, function(todo) {
				if (todo.done) todo.archived = true; 		
			});     
			return todos;
		};
	}) 
	.filter('archiveFilter', function() {
		return function(todos, todoFilterType) {
			var tempTodos = [];
			if ('all' == todoFilterType) {
				tempTodos = todos;
			} else {
				angular.forEach(todos, function(todo) {
					if ('archived' == todoFilterType && todo.archived) {
						tempTodos.push(todo);
					} else if ('nonarchived' == todoFilterType && !todo.archived) {
						tempTodos.push(todo);
					}
				});
			}			     
			return tempTodos;
		}
	})
  ;
