# The Project

## Deploy to Kubernetes

### Deploy persistent volumes

```bash
kubectl apply -f manifests/infra
```

### Deploy todo-app

```bash
kubectl apply -f manifests
```

## Use

Call API when running in k3d cluster:

```bash
    curl http://localhost:8081
```