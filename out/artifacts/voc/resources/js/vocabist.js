/**
 * Created with IntelliJ IDEA.
 * User: jn
 * Date: 6/15/13
 * Time: 11:11 PM
 * To change this template use File | Settings | File Templates.
 */

$(function(){
    /**
     * When the 'Flag' button is clicked, we change color to yellow and set the value to 'Flagged'
     */
    $('#flagbtn').click(function(){
        //change color
        $(this).toggleClass('yellow-background');

        //change text
        toggleText('#flagbtn > .ui-button-text', 'Flag', 'Flagged');
    });
});

/**
 * Toggle text. 'nuf said
 * @param selector
 * @param val1
 * @param val2
 */
function toggleText(selector,val1, val2){
    var text = $(selector).text();
    text == val1 ? $(selector).text(val2) : $(selector).text(val1);
}