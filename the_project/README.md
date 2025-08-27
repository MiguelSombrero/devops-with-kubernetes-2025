# The Project

## Deploy to Kubernetes

Deploy recursively all resources (pvc, todo-app, todo-backend)

```bash
kubectl apply -R -f manifests/
```

## Use

Call API when running in k3d cluster:

```bash
    curl http://localhost:8081
```