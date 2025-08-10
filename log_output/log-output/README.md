# log-output-app

## Deploy to Kubernetes

Run command in root directory.

```bash
    kubectl apply -f manifests/deployment.yaml
```

## For developer (me)

There was some mystical problems when running the app in a k3d cluster, so I had to use `docker buildx` to build the
image.

It might have something to do with Mac M2 (ARM-architecture) machine which I use for building the image, so I made
multi-arch image.

### Build and push multi-arch image

Requires login to Docker Hub. Run command in todo-app directory.

```bash
docker buildx build --platform linux/amd64,linux/arm64 -t miguelsombrero/log-output-app:latest --push .
```

If you (I) got error "Multi-platform build is not supported for the docker driver", you need to switch `buildx` driver
to `docker-container`:

```bash
docker buildx create --name multiarch-builder --driver docker-container --use
```

In the root directory there is also AI (ChatGPT) generated `Makefile` for building and pushing the image and updating
deployment:

```bash
make deploy
```