# Docker Hub käyttäjänimi ja repo
IMAGE_NAME = miguelsombrero/log-output-app
TAG = latest
BUILDER_NAME = multiarch-builder
K8S_DEPLOYMENT = deployment.yaml
DEPLOYMENT_NAME = log-output-dep

# Luo builder jos ei ole olemassa
ensure-builder:
	@if ! docker buildx inspect $(BUILDER_NAME) >/dev/null 2>&1; then \
		echo ">> Builder '$(BUILDER_NAME)' ei löytynyt, luodaan..."; \
		docker buildx create --name $(BUILDER_NAME) --driver docker-container --use; \
		docker buildx inspect --bootstrap; \
	else \
		echo ">> Käytetään olemassa olevaa builderia '$(BUILDER_NAME)'"; \
		docker buildx use $(BUILDER_NAME); \
	fi

# Buildaa ja pushaa multi-arch image
build: ensure-builder
	docker buildx build --platform linux/amd64,linux/arm64 \
		-t $(IMAGE_NAME):$(TAG) \
		--push .

# Buildaa amd64 image (vain x86_64)
build-amd64: ensure-builder
	docker buildx build --platform linux/amd64 \
		-t $(IMAGE_NAME):$(TAG) \
		--push .

# Buildaa, pushaa ja päivittää deploymentin
deploy: build
	@if ! kubectl get deployment $(DEPLOYMENT_NAME) >/dev/null 2>&1; then \
		echo ">> Deploymentia ei löytynyt, luodaan uusi"; \
		kubectl apply -f $(K8S_DEPLOYMENT); \
	else \
		echo ">> Päivitetään olemassa oleva deployment latest-versioon"; \
		kubectl rollout restart deployment $(DEPLOYMENT_NAME); \
	fi
