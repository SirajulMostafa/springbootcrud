$('document').ready(function(){	
	
    $('#tableEmployee').DataTable();

	$('.table #updateButton').on('click',function(event){	
		
		event.preventDefault();
		
		var href =$(this).attr('href');
		$.get(href,function(employee,status){
			$('#emailUpdate').val(employee.email);
			$('#firstNameUpdate').val(employee.firstName);
			$('#lastNameUpdate').val(employee.lastName);
			$('#ageUpdate').val(employee.age);
		
		});
		
		$('#updateModal').modal('show');				
	});	
	
	$('.table #deleteButton').on('click',function(event){	
		
		event.preventDefault();
		var href = $(this).attr('href');
		
	$('#deleteModal #delRef').attr('href', href);	
		
		$('#deleteModal').modal('show');				
	});	
	
	
});

