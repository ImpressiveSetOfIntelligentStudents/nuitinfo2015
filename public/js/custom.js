$(document).ready(function() {


});

/*
    Permet de créer une notification de la meme façon qu'avec les flash.success/error
    type = success ou error
    message = le contenu de la notification
 */
function ajouterNotification(type, message) {
    notification = '' +
        '<div class="alert alert-'+type+' alert-dismissible" role="alert" style="margin-top: 20px;"> ' +
        '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
        message +
        '</div>';
    $('#notifications').append(notification);
}

