//carrosel imagens
function moveCarousel(carouselId, direction) {
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




//clientes carrosel
let currentIndex = {
    clientes1: 0,
    clientes2: 0,
};

function moveCarousel(direction, carouselId) {
    const carousel = document.getElementById(carouselId);
    const clientes = carousel.getElementsByClassName("cliente");
    const totalClientes = clientes.length;

    // Atualiza o índice atual com base na direção do movimento
    currentIndex[carouselId] += direction;

    // Verifica se o índice está fora dos limites e ajusta
    if (currentIndex[carouselId] < 0) {
        currentIndex[carouselId] = totalClientes - 1; // Vai para o último
    } else if (currentIndex[carouselId] >= totalClientes) {
        currentIndex[carouselId] = 0; // Volta para o primeiro
    }

    // Esconde todos os clientes
    for (let i = 0; i < totalClientes; i++) {
        clientes[i].classList.remove("active");
    }

    // Mostra o cliente atual
    clientes[currentIndex[carouselId]].classList.add("active");
}
