$('#btnShowAlbums').click(() => {
    loadAlbums()
})

function loadAlbums() {
    $('#albumsContainer').empty();

    fetch("http://localhost:8080/artists/manage/albums")
        .then(response => response.json())
        .then(data => data.forEach(album => {
            let tableRow = '<tr>' +
                '<td class="rowNum">' + album.id + '</td>' +
                '<td>' + album.name + '</td>' +
                '<td>' + album.released + '</td>' +
                '<td>' + album.price + '</td>' +
                '<td>' + album.genre + '</td>' +
                '<td>' + album.musician.name + '</td>' +
                // '<td>' + '<button type="button" class="btn btn-primary btn-link btn-sm btn-txt-white edit-btn" data-album-id="' + album.id + '">Edit</button>' + '</td>' +
                // '<td>' + '<button type="button" class="btn btn-primary btn-link btn-sm btn-txt-white delete-btn" data-album-id="' + album.id + '">Delete</button>' + '</td>' +
                '<td>' + '<a type="button" class="btn btn-primary btn-link btn-sm btn-txt-white" href="/artists/manage/albums/' + album.id + '/edit">Details</a>' + '</td>' +
                '</tr>'

            $('#albumsContainer').append(tableRow)
        }))
}

// $('body').on('click', 'button.delete-btn', function () {
//     let albumId = $(this).data('album-id');
//
//     fetch('http://localhost:8080/artists/manage/albums/' + albumId, {
//         method: 'DELETE'
//     }).then(_ => loadAlbums())
// })