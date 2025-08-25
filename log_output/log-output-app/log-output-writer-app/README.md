# log-output-writer-app

## Deploy to Kubernetes

Run command in root directory.

```bash
    kubectl apply -f manifests
```

## For developer (me)

Build image and push it to Docker Hub:

```bash
  docker build -t miguelsombrero/log-output-writer-app:latest .
```

```bash
  docker push miguelsombrero/log-output-writer-app:latest
```

There was some mystical problems when running the app in a k3d cluster, so I had to use `docker buildx` to build the
image.

It might have something to do with Mac M2 (ARM-architecture) machine which I use for building the image, so I made
multi-arch image.

EDIT: maybe it was something else since images seems to be working now with basic `docker build` command too.
Anyway, here are the commands for multi-arch image just in case:

### Build and push multi-arch image

Requires login to Docker Hub.

```bash
docker buildx build --platform linux/amd64,linux/arm64 -t miguelsombrero/log-output-writer-app:latest --push .
```

If you (I) got error "Multi-platform build is not supported for the docker driver", you need to switch `buildx` driver
to `docker-container`:

```bash
docker buildx create --name multiarch-builder --driver docker-container --use
```
