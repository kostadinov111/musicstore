$('#btnShowAlbums').click(() => {
    loadAlbums()
})

function loadAlbums() {
    $('#albumsContainer').empty();

    fetch("http://localhost:8080/api/albums")
        .then(response => response.json())
        .then(data => data._embedded.albumsDTOList.forEach(album => {
            let tableRow = '<tr>' +
                '<td class="rowNum">' + album.id + '</td>' +
                '<td>' + album.name + '</td>' +
                '<td>' + album.released + '</td>' +
                '<td>' + album.price + '</td>' +
                '<td>' + album.genre + '</td>' +
                '<td>' + album.musician.name + '</td>' +
                '<td>' + '<a type="button" class="btn btn-primary btn-link btn-sm btn-txt-white" href="/artists/manage/albums/' + album.id + '/edit">Edit</a>' + '</td>' +
                '<td>' + '<button type="button" class="btn btn-primary btn-link btn-sm btn-txt-white delete-btn" data-album-id="' + album.id + '">Delete</button>' + '</td>' +
                '</tr>'

            $('#albumsContainer').append(tableRow)
        }))
}

$('body').on('click', 'button.delete-btn', function () {
    let albumId = $(this).data('album-id');

    fetch('http://localhost:8080/api/albums/' + albumId, {
        method: 'DELETE'
    }).then(_ => loadAlbums())
})