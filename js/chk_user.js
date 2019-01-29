$('#emailId').keyup(function()
{
    
    var emailId = $('#emailId').val();
    $('#status').html('<span><div><img src="loading.gif"></div></span>');
    if (emailId!=''){
        $.post('CheckUserServlet',{emailId:emailId},
        function(data){
            $('#status').html(data);
        });
    }
    else{
        $('#status').html('');
    }
});
