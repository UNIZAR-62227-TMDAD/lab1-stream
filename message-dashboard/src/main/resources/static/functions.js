let template = $("#template").html();

function registerTemplate() {
    Mustache.parse(template);
}

function registerSearch() {
    $("#search").submit(function(event){
        event.preventDefault();
        const target = $(this).attr('action');
        const query = $("#q").val();
        $.get(target, { q: query } )
            .done( function(data) {
                $("#resultsBlock").empty().append(Mustache.render(template, data));
            }).fail(function() {
            $("#resultsBlock").empty();
        });
    });
}

$(document).ready(function() {
    registerTemplate()
    registerSearch();
});