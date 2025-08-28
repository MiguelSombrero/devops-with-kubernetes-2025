# The Project

## Deploy to Kubernetes

Deploy recursively all resources (namespace, pvc, todo-app, todo-backend)

```bash
kubectl apply -R -f manifests/
```

NOTICE: If there is also "exercises" deployed, it's ingress may clash with the project. You can delete ingress defore deploying by:

```bash
kubectl delete ing log-output-ing -n exercises
```

## Use

Call API when running in k3d cluster:

```bash
    curl http://localhost:8081
```