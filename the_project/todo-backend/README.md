# Todo-backend

## Use

NOTICE: paths below is for localhost. In k3d cluster, port is 8081.

GET `/todos` - get all todos

```bash
curl -X GET http://localhost:8083/todos
```

POST `/todos` - create new todo

```bash
curl -X POST http://localhost:8083/todos -H "Content-Type: application/json" -d '{"content": "Learning DevOps"}'
```

Request with extra long content for testing:

```bash
curl -X POST http://localhost:8083/todos -H "Content-Type: application/json" -d '{"content": "LoremipsumdolorsitametconsecteturadipiscingelitSeddoeiusmodtemporincididuntutlaboreetdoloremagnaaliquautenimadminimveniamsasdfsdfasdfasdsdfsf"}'
```

## For developer (me)

Build image and push it to Docker Hub:

```bash
  docker build -t miguelsombrero/todo-backend:latest .
```

```bash
  docker push miguelsombrero/todo-backend:latest
```

There was some mystical problems when running the app in a k3d cluster, so I had to use `docker buildx` to build the
image.

It might have something to do with Mac M2 (ARM-architecture) machine which I use for building the image, so I made
multi-arch image.

So if `docker build`fails, try `docker buildx` command below:

### Build and push multi-arch image

Requires login to Docker Hub. Run command in todo-app directory.

```bash
docker buildx build --platform linux/amd64,linux/arm64 -t miguelsombrero/todo-backend:latest --push .
```

If you (I) got error "Multi-platform build is not supported for the docker driver", you need to switch `buildx` driver
to `docker-container`:

```bash
docker buildx create --name multiarch-builder --driver docker-container --use
```