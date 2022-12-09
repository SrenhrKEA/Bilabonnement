$(document).ready(function () {
    $('#accordion').find('.accordion-toggle').click(function () {
        if ($(this).hasClass('disable')) {
            alert("Please complete the above details");
        }else{
            $(this).next().slideToggle('fast');
            $(".accordion-content").not($(this).next()).slideUp('fast');
        }
    });
    $('input').keyup(function(){
        if($(this).val()!=""){
            $(this).parent().next('.accordion-toggle').removeClass('disable');
        }
        else{
            $(this).parent().nextAll('.accordion-toggle').addClass('disable');
        }
    });
});