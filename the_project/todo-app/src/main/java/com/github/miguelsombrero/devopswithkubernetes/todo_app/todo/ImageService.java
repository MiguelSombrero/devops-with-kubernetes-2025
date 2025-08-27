package com.github.miguelsombrero.devopswithkubernetes.todo_app.todo;

import com.github.miguelsombrero.devopswithkubernetes.todo_app.util.ImageUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URI;

@Service
public class ImageService {

    private final RestClient imageClient;
    private final ImageUtil image;

    public ImageService(RestClient imageClient, ImageUtil image) {
        this.imageClient = imageClient;
        this.image = image;
    }

    public byte[] fetchImage() {
        if (image.exists() && !image.isExpired()) {
            return image.read();
        }

        byte[] imageBytes = fetch();

        if (imageBytes != null) {
            image.write(imageBytes);
            image.updateTimestamp();
        }

        return imageBytes;
    }

    private byte[] fetch() {
        // Ensimmäinen pyyntö (voi palauttaa 302 Redirectin)
        ResponseEntity<byte[]> response = imageClient.get()
                .retrieve()
                .toEntity(byte[].class);

        // Jos palvelu palauttaa redirectin (302), seurataan sitä manuaalisesti
        if (response.getStatusCode().is3xxRedirection()) {
            String location = response.getHeaders().getFirst(HttpHeaders.LOCATION);
            if (location != null) {
                response = imageClient.get()
                        .uri(URI.create(location))
                        .retrieve()
                        .toEntity(byte[].class);
            }
        }
        return response.getBody();
    }
}
