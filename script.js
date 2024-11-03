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
//
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


document.addEventListener("DOMContentLoaded", function () {
    const languageSelector = document.getElementById("language-selector");
    const languageOptions = document.getElementById("language-options");

    // Carregar idioma do localStorage, se disponível
    const savedLanguage = localStorage.getItem("selectedLanguage");
    if (savedLanguage) {
        setLanguage(savedLanguage);
    }

    // Função para definir o idioma
    function setLanguage(lang) {
        languageSelector.textContent = lang.toUpperCase();
        localStorage.setItem("selectedLanguage", lang);
        
        // Aqui você pode adicionar lógica para carregar o conteúdo no idioma selecionado
        // Exemplo: carregar traduções específicas, alterar textos, etc.
    }

    // Evento para alterar o idioma ao clicar em uma opção
    languageOptions.addEventListener("click", function (e) {
        if (e.target.tagName === "A") {
            const selectedLang = e.target.getAttribute("data-lang");
            setLanguage(selectedLang);
            e.preventDefault();
        }
    });
});

