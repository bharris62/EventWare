/**
 * Created by BHarris on 3/17/17.
 */
$(document).ready(function(){

    $('ul.switcher li').click(function(){
        var tab_id = $(this).attr('data-tab');

        $('li').removeClass('active');
        $('div.tab-pane').removeClass('active');

        $(this).addClass('active');
        $("#"+tab_id).addClass('active');
    })

})