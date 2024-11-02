// Carrossel de imagens
function moveImageCarousel(carouselId, direction) {
    const carousel = document.getElementById(carouselId);
    const images = carousel.getElementsByClassName('carrosel-imagem');
    let currentIndex = Array.from(images).findIndex(img => img.classList.contains('active'));

    // Remove a classe 'active' da imagem atual
    images[currentIndex].classList.remove('active');

    // Atualiza o índice
    if (direction === 1) {
        currentIndex = (currentIndex + 1) % images.length; // Move para a próxima imagem
    } else {
        currentIndex = (currentIndex - 1 + images.length) % images.length; // Move para a imagem anterior
    }

    // Adiciona a classe 'active' à nova imagem
    images[currentIndex].classList.add('active');
}

//carrosel clientes

function moveComentarioCarousel(carouselId, direction) {
    const carousel = document.getElementById(carouselId);
    const comentarios = carousel.getElementsByClassName('comentario');
    let currentIndex = Array.from(comentarios).findIndex(comment => comment.classList.contains('active'));

    // Remove a classe 'active' do comentário atual
    comentarios[currentIndex].classList.remove('active');

    // Atualiza o índice com base na direção
    if (direction === 1) {
        currentIndex = (currentIndex + 1) % comentarios.length; // Próximo comentário
    } else {
        currentIndex = (currentIndex - 1 + comentarios.length) % comentarios.length; // Comentário anterior
    }

    // Adiciona a classe 'active' ao novo comentário
    comentarios[currentIndex].classList.add('active');
}

 // Abre o modal e exibe a imagem em tela cheia
 function openModal(imageSrc) {
    const modal = document.getElementById("modal");
    const modalImage = document.getElementById("modal-image");
    modalImage.src = imageSrc; // Define a imagem no modal
    modal.classList.add("active"); // Exibe o modal
}

// Fecha o modal
function closeModal() {
    const modal = document.getElementById("modal");
    modal.classList.remove("active"); // Oculta o modal
}

